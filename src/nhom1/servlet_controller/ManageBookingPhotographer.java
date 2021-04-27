package nhom1.servlet_controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom1.dao.BookingDAO;
import nhom1.dao.PhotographerInfoDAO;
import nhom1.model.Booking;
import nhom1.model.Photographer;
import nhom1.model.User;

/**
 * Servlet implementation class ManageBooking
 */
@WebServlet("/ManageBookingPhotographer")
public class ManageBookingPhotographer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookingDAO bd = new BookingDAO();
	PhotographerInfoDAO pif= new PhotographerInfoDAO();
			

	public ManageBookingPhotographer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			request.setAttribute("hidePageBooking", "no");
			String checkRadio = request.getParameter("checkRadio");
			String returnValue = request.getParameter("returnValue");
			if (checkRadio == null) {
				checkRadio = "0";
			}
			//request.setAttribute("checkRadioReturn", checkRadio);
			//System.out.println("returnvalue bang cai nay nay"+returnValue);
			
			
			String command = request.getParameter("command");
			if (command == null) {
				command = "SHOW";
			}
			switch (command) {
			case "SHOW":
				showView(request, response, checkRadio, returnValue);
				break;

			case "SEARCH":
				searchBooking(request, response, checkRadio);
				break;

			case "CANCEL":
				cancelBooking(request, response);
				break;
				
			case "ACCEPT":
				acceptBooking(request, response);	
				
				break;
			case "Notification":
				notificationBooking(request,response);
				break;
				
			case "TAKEN":
			 takenBooking (request,response);
			 break;
			 
				
			case "AddFolder":
				addProductLink(request,response);
				break;
				
			case "UpdateFolder":
				addProductLink(request,response);
				break;
			 
//			default:
//				showView(request, response);
			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}

	}

	private void addProductLink(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		int photographerId= (Integer) session.getAttribute("id");
		String bookingString= request.getParameter("bookingId");
		
		String productLink=request.getParameter("folderImage");
		System.out.println("bookingId="+bookingString);
		System.out.println("productlink="+productLink);
		Photographer p= new Photographer();
		p=pif.getInfo(photographerId);
		int bookingId= Integer.parseInt(bookingString);
		
		if(bd.updateProductLink(productLink,p.getNickName(),bookingId))
		 {
			 response.sendRedirect(request.getContextPath() + "/ManageBookingPhotographer?flag=6&AddFolder=true&returnValue=5");
		 }
		 else
		 {
			 response.sendRedirect(request.getContextPath() + "/ManageBookingPhotographer?flag=6&AddFolder=false");
		 }
		
	}

	private void takenBooking(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		int photographerId= (Integer) session.getAttribute("id");
		String bookingString= request.getParameter("bookingId");
		Photographer p= new Photographer();
		p=pif.getInfo(photographerId);
		int bookingId= Integer.parseInt(bookingString);
		 if(bd.getStatusBookingbyId(bookingId)==3)
		 { 
			 if(bd.updateStatusBookingByPhotographer(4,p.getNickName(),bookingId))
			 {
				 response.sendRedirect(request.getContextPath() + "/ManageBookingPhotographer?flag=6&Taken=true&returnValue=4");
			 }
			 else
			 {
				 response.sendRedirect(request.getContextPath() + "/ManageBookingPhotographer?flag=6&Taken=false");
			 }
		 }
		 else
		 {
			 response.sendRedirect(request.getContextPath() + "/ManageBookingPhotographer?flag=6&Taken=false");
		 }
		
	}

	private void notificationBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("hideAll", "yes");
		request.setAttribute("notificationNoBooking", "Đơn đặt chụp đã cập nhập trước đó.Vui lòng tải lại trang");
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/tho-chup-anh.jsp");
		dispatcher.forward(request, response);
		
	}

	private void autoCancelBooking(HttpServletRequest request, HttpServletResponse response) throws InterruptedException, ExecutionException {
		String bookingString= request.getParameter("bookingId");
		int bookingId= Integer.parseInt(bookingString);
		String name="tính năng tự động hủy của Flash";
		 ScheduledExecutorService executor = Executors.newScheduledThreadPool(6);
		   ScheduledFuture<String> scheduledFuture = executor.schedule(new Callable<String>() {
		      @Override
		      public String call() throws Exception {
		    	  System.out.println("tao vao den day roi");
		    	  if(bd.getStatusBookingbyId(bookingId)==2)
		    	  { 
		    		  bd.updateStatusBooking(name,bookingId,2);
		    	  }
		    	  
		        
		        return "Called!";
		      }
		    }, 10, TimeUnit.MINUTES);

		    System.out.println("result = " + scheduledFuture.get());
		    executor.shutdown();
	}

	private void acceptBooking(HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException, ExecutionException {
		HttpSession session = request.getSession();
		int photographerId= (Integer) session.getAttribute("id");
		String bookingString= request.getParameter("bookingId");
		System.out.println("get ra dc booking:"+bookingString);
		int bookingId= Integer.parseInt(bookingString);
		Photographer p= new Photographer();
		p=pif.getInfo(photographerId);
		
		
		if(bd.getStatusBookingbyId(bookingId)==1)
		{
		
			if(bd.updateStatusBookingByPhotographer(2,p.getNickName(),bookingId))
			{
		//request.setAttribute("showCancel","yes");
//			long millis=System.currentTimeMillis();  
//			 java.sql.Date ratingDate=new java.sql.Date(millis);
//			 System.out.println("date huy nay:"+ratingDate);
		response.sendRedirect(request.getContextPath() + "/ManageBookingPhotographer?flag=6&Accept=true&returnValue=2");
		autoCancelBooking(request, response);	
			}
		else {
			response.sendRedirect(request.getContextPath() + "/ManageBookingPhotographer?flag=6&Accept=false");
			}
		}
		else
		{
			response.sendRedirect(request.getContextPath() + "/ManageBookingPhotographer?flag=6&Accept=false");
		}
	}

	private void showView(HttpServletRequest request, HttpServletResponse response, String checkRadio,
			String returnValue) throws ServletException, IOException {

		HttpSession session = request.getSession();
		int photographerId = (Integer) session.getAttribute("id");
		List<Booking> listBooking = new ArrayList<>();
		// listBooking= bd.getListBookingByIdUser(userId);
		if (returnValue == null)
			returnValue = "0";
		request.setAttribute("returnValue", returnValue);
		request.setAttribute("checkRadioReturn", checkRadio);
		int statusId= Integer.parseInt(returnValue);
		
				

		if (returnValue.equalsIgnoreCase("0")) {

			request.setAttribute("returnValue", "0");
			request.setAttribute("rolePhotographer", "4");
			int countv = bd.sizeOfListBookingByPhotographer(photographerId);
			request.setAttribute("hideAll", "no");

			if (countv == 0) {

				request.setAttribute("notificationNoBooking", "Bạn chưa có lịch đặt chụp ");
				request.setAttribute("hideAll", "yes");
			} else

			{
				if (checkRadio.equalsIgnoreCase("0")) {
					request.setAttribute("page", paging(photographerId));
					String page = request.getParameter("page");

					if (page == null) {

						listBooking = bd.getListBookingByIdPhotographer(photographerId, 0);
						request.setAttribute("listAll", listBooking);
					} else {
						int paging = (Integer.parseInt(page) - 1) * 5;
						listBooking = bd.getListBookingByIdPhotographer(photographerId, paging);
					}
					request.setAttribute("listAll", listBooking);
				}

				if (checkRadio.equalsIgnoreCase("1")) {
					request.setAttribute("page", paging(photographerId));
					String page = request.getParameter("page");

					if (page == null) {

						listBooking = bd.getListBookingPhotographerSortTakeDate(photographerId, 0);
						request.setAttribute("listAll", listBooking);
					} else {
						int paging = (Integer.parseInt(page) - 1) * 5;
						listBooking = bd.getListBookingPhotographerSortTakeDate(photographerId, paging);
					}
					request.setAttribute("listAll", listBooking);
				}

			}
		} 
		
		else 
		{
			
			request.setAttribute("rolePhotographer", "4");
			//int statusId= Integer.parseInt(returnValue);
			int countv = bd.sizeOfListBookingByStatusId_Photographer(photographerId,statusId);
			request.setAttribute("hideAll", "no");
			request.setAttribute("checkRadioReturn", checkRadio);
			if(countv==0)
			{

//			request.setAttribute("notificationNoBooking", "Bạn chưa đặt chụp gói nhiếp ảnh ");
//			request.setAttribute("hideAll", "yes");
			}
			else
			{
			
			if (checkRadio.equalsIgnoreCase("0")) {
				request.setAttribute("page", pagingStatus(photographerId, statusId));
				String page = request.getParameter("page");

				if (page == null) {

					listBooking = bd.getListBookingByStatus_Photographer(photographerId, statusId, 0);
					request.setAttribute("listAll", listBooking);
				} else {
					int paging = (Integer.parseInt(page) - 1) * 5;
					listBooking = bd.getListBookingByStatus_Photographer(photographerId, statusId, paging);
				}
				request.setAttribute("listAll", listBooking);
			}

			if (checkRadio.equalsIgnoreCase("1")) {
				request.setAttribute("page", pagingStatus(photographerId, statusId));
				String page = request.getParameter("page");

				if (page == null) {

					listBooking = bd.getListBookingByStatusSortTakeDate_Photographer(photographerId, statusId, 0);
					request.setAttribute("listAll", listBooking);
				} else {
					int paging = (Integer.parseInt(page) - 1) * 5;
					listBooking = bd.getListBookingByStatusSortTakeDate_Photographer(photographerId, statusId, paging);
				}
				request.setAttribute("listAll", listBooking);
			}

		}
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("form/tho-chup-anh.jsp");
		dispatcher.forward(request, response);

	}

	public List<Integer> paging(int id) {
		int sizev = bd.sizeOfListBookingByPhotographer(id);
		// System.out.println("size:" + size);
		List<Integer> listPage = new ArrayList<>();
		int m = sizev / 5;
		int n = sizev % 5;
		if (n != 0) {
			m = m + 1;
		}
		for (int i = 0; i < m; i++) {
			listPage.add(i + 1);
		}
		return listPage;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			// read the "command" parameter
			String checkRadio = request.getParameter("checkRadio");

			// System.out.println("getparameter lan 1"+checkRadio);
			String command = request.getParameter("command");
			String returnValue = request.getParameter("returnValue");
			if (command == null) {
				command = "SHOW";
			}
			switch (command) {
			case "SHOW":
				showView(request, response, checkRadio, returnValue);
				break;

			case "SEARCH":
				searchBooking(request, response, checkRadio);
				break;
				
				
			case "ACCEPT":
				//acceptBooking(request, response);	
					
			case "AddFolder":
				addProductLink(request,response);
			 break;	
				
//			
//			default:
//				showView(request, response);
			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}

	}

	private void cancelBooking(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		int photographerId= (Integer) session.getAttribute("id");
		String bookingString= request.getParameter("bookingId");
		int bookingId= Integer.parseInt(bookingString);
	//	String photographerId= request.getParameter("photographerId");
//		String checkRadio=request.getParameter("checkRadio");
//		String returnValue=request.getParameter("returnValue");
//		String getPage = request.getParameter("param.page");
		
//		User u= new User();
//		u=uif.getInfo(photographerId);
		Photographer p= new Photographer();
		p= pif.getInfo(photographerId);
		if	(bd.getStatusBookingbyId(bookingId)==1)	
			{
			if(bd.updateStatusBooking(p.getNickName(),bookingId,1))
			{
		//request.setAttribute("showCancel","yes");
//			long millis=System.currentTimeMillis();  
//			 java.sql.Date ratingDate=new java.sql.Date(millis);
//			 System.out.println("date huy nay:"+ratingDate);
		response.sendRedirect(request.getContextPath() + "/ManageBookingPhotographer?flag=6&Cancel=true&returnValue=6");
		
		
		
		
			}
			}
		else {
			//response.sendRedirect(request.getContextPath() + "/ManageBookingPhotographer?flag=6&command=Notification");
		}
		

	}

	private void searchBooking(HttpServletRequest request, HttpServletResponse response, String checkRadio)
			throws ServletException, IOException {
		String status = (String) request.getParameter("itemCategory");

		if (status == null) {
			status = "0";
		}
		int statusId = Integer.parseInt(status);
		//System.out.println("status la:"+status);
		// checkRadio = request.getParameter("checkRadio");
		// System.out.println("xem no dang so may POst"+checkRadio);

		//request.setAttribute("returnValue", "0");
		if (status.equalsIgnoreCase("0")) {
			request.setAttribute("hidePageBooking", "no");
			showView(request, response, checkRadio, status);
		} else {
			// System.out.println("vao muc else:"+statusId);

			searchbyStatus(request, response, statusId, checkRadio);

		}

	}

	private void searchbyStatus(HttpServletRequest request, HttpServletResponse response, int statusId,
			String checkRadio) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int photographerId = (Integer) session.getAttribute("id");
		List<Booking> listBooking = new ArrayList<>();
		// listBooking= bd.getListBookingByIdUser(userId);

		request.setAttribute("rolePhotographer", "4");
		int count = bd.sizeOfListBookingByStatusId_Photographer(photographerId, statusId);
		request.setAttribute("hideAll", "no");
		request.setAttribute("returnValue", statusId);
		request.setAttribute("hidePageBooking", "no");
		request.setAttribute("checkRadioReturn", checkRadio);
		// checkRadio="0";

		if (count == 0) {
			request.setAttribute("hidePageBooking", "yes");
//
//			request.setAttribute("notificationNoBooking", "Bạn chưa có đặt chụp gói nhiếp ảnh ");
//			request.setAttribute("hideAll", "yes");
		} else {

			if (checkRadio.equalsIgnoreCase("0")) {
				request.setAttribute("hidePageBooking", "no");
				request.setAttribute("page", pagingStatus(photographerId, statusId));
				String page = request.getParameter("page");
				if (page == null) {
					listBooking = bd.getListBookingByStatus_Photographer(photographerId, statusId, 0);
					request.setAttribute("listAll", listBooking);
				} else {
					int paging = (Integer.parseInt(page) - 1) * 5;
					listBooking = bd.getListBookingByStatus_Photographer(photographerId, statusId, paging);
				}
				request.setAttribute("listAll", listBooking);

				request.setAttribute("checkRadioReturn", checkRadio);
			}

			if (checkRadio.equalsIgnoreCase("1")) {
				request.setAttribute("hidePageBooking", "no");
				request.setAttribute("page", pagingStatus(photographerId, statusId));
				String page = request.getParameter("page");
				if (page == null) {
					listBooking = bd.getListBookingByStatusSortTakeDate_Photographer(photographerId, statusId, 0);
					request.setAttribute("listAll", listBooking);
				} else {
					int paging = (Integer.parseInt(page) - 1) * 5;
					listBooking = bd.getListBookingByStatusSortTakeDate_Photographer(photographerId, statusId, paging);
				}
				request.setAttribute("listAll", listBooking);
				request.setAttribute("checkRadioReturn", checkRadio);
			}

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/tho-chup-anh.jsp");
		dispatcher.forward(request, response);

	}

	public List<Integer> pagingStatus(int id, int statusId) {
		int size = bd.sizeOfListBookingByStatusId_Photographer(id, statusId);
		// System.out.println("size:" + size);
		List<Integer> listPage = new ArrayList<>();
		int m = size / 5;
		int n = size % 5;
		if (n != 0) {
			m = m + 1;
		}
		for (int i = 0; i < m; i++) {
			listPage.add(i + 1);
		}
		return listPage;
	}

}
