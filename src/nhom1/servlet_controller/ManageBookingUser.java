package nhom1.servlet_controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom1.dao.BookingDAO;
import nhom1.dao.ComplaintDAO;
import nhom1.dao.UserProfileInfoDAO;
import nhom1.model.Booking;
import nhom1.model.Complaint;
import nhom1.model.User;

/**
 * Servlet implementation class Booking
 */
@WebServlet("/manageBooking")
public class ManageBookingUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	   private BookingDAO bd= new BookingDAO();
	   private UserProfileInfoDAO uif= new UserProfileInfoDAO();
	   private ComplaintDAO cd= new ComplaintDAO();
    public ManageBookingUser() {
        super();
       
     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			request.setAttribute("hidePageBooking", "no");
			String checkRadio=request.getParameter("checkRadio");
			String returnValue=request.getParameter("returnValue");
			//String getPage= request.getParameter("page");
			
			if(checkRadio==null)
			{
			checkRadio="0";
			}
			
			String command = request.getParameter("command");
			if (command == null) {
				command = "SHOW";
			}
			switch (command) {
			case "SHOW":
				showView(request, response,checkRadio,returnValue);
				break;
			
			case "SEARCH":
				searchBooking(request, response,checkRadio);
				break;
				
			case "CANCEL":
			
				cancelBooking(request, response);
				break;
				
			case "Notification":
				
				notificationBooking(request, response);
				break;
				
				
				
//			
//			default:
//				showView(request, response);
			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}
			
		
	}	
		
		
		



	private void notificationBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("hideAll", "yes");
		request.setAttribute("notificationNoBooking", "Đơn đặt chụp đã cập nhập trước đó.Vui lòng tải lại trang<br>");
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/nguoidung.jsp");
		dispatcher.forward(request, response);
		
	}

	private void cancelBooking(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		int userId= (Integer) session.getAttribute("id");
		String bookingString= request.getParameter("bookingId");
		int bookingId= Integer.parseInt(bookingString);
//		String checkRadio=request.getParameter("checkRadio");
//		String returnValue=request.getParameter("returnValue");
//		String getPage = request.getParameter("param.page");
		
		User u= new User();
		u=uif.getInfo(userId);
		
		if	(bd.getStatusBookingbyId(bookingId)!=6&&bd.getStatusBookingbyId(bookingId)!=5&&bd.getStatusBookingbyId(bookingId)!=4)	
		{		
		if(bd.updateStatusBooking(u.getFullName(),bookingId,bd.getStatusBookingbyId(bookingId)))
		{
		//request.setAttribute("showCancel","yes");
//			long millis=System.currentTimeMillis();  
//			 java.sql.Date ratingDate=new java.sql.Date(millis);
//			 System.out.println("date huy nay:"+ratingDate);
		response.sendRedirect(request.getContextPath() + "/manageBooking?flag=4&Cancel=true");
		}
		else {
			response.sendRedirect(request.getContextPath() + "/manageBooking?flag=4&Cancel=false");
		}
		}
		else
		{
			response.sendRedirect(request.getContextPath() + "/manageBooking?flag=4&Cancel=false");
		}
	
	}

	private void showView(HttpServletRequest request, HttpServletResponse response,String checkRadio,String returnValue) throws ServletException, IOException {

		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("id");
		List<Booking> listBooking = new ArrayList<>();
		//listBooking= bd.getListBookingByIdUser(userId);
		if(returnValue==null)
			returnValue="0";
		request.setAttribute("returnValue", returnValue);
//		else
//		{
//		request.setAttribute("returnValue", returnValue);
//		}
		if(returnValue.equalsIgnoreCase("0"))
		{
			request.setAttribute("rolePhotographer", "4");
			int countv = bd.sizeOfListBooking(userId);
			request.setAttribute("hideAll", "no");
			request.setAttribute("checkRadioReturn", checkRadio);
			if(countv==0)
			{

			request.setAttribute("notificationNoBooking", "Bạn chưa đặt chụp gói nhiếp ảnh ");
			request.setAttribute("hideAll", "yes");
			}
			else
			
			{
			if(checkRadio.equalsIgnoreCase("0"))
				{
				request.setAttribute("page", paging(userId));
				String page = request.getParameter("page");
			
				if (page == null)
				{
				
					listBooking = bd.getListBookingByIdUser(userId, 0);
				request.setAttribute("listAll", listBooking);
				}
			else {
					int paging = (Integer.parseInt(page) - 1) * 5;
					listBooking = bd.getListBookingByIdUser(userId,paging);
				}
				request.setAttribute("listAll", listBooking);
				}
			

			if(checkRadio.equalsIgnoreCase("1"))
			{
				request.setAttribute("page", paging(userId));
				String page = request.getParameter("page");
			
				if (page == null)
				{
				
					listBooking = bd.getListBookingSortDate(userId, 0);
					request.setAttribute("listAll", listBooking);
				}
				else {
					int paging = (Integer.parseInt(page) - 1) * 5;
					listBooking = bd.getListBookingSortDate(userId,paging);
				}
				request.setAttribute("listAll", listBooking);
			}
			
			
			}
			
		}
		else
		{

			request.setAttribute("rolePhotographer", "4");
			int statusId= Integer.parseInt(returnValue);
			int countv = bd.sizeOfListBookingByStatusId(userId,statusId);
			request.setAttribute("hideAll", "no");
			request.setAttribute("checkRadioReturn", checkRadio);
			if(countv==0)
			{

//			request.setAttribute("notificationNoBooking", "Bạn chưa đặt chụp gói nhiếp ảnh ");
//			request.setAttribute("hideAll", "yes");
			}
			else
			
			{
			if(checkRadio.equalsIgnoreCase("0"))
				{
				request.setAttribute("page", pagingStatus(userId,statusId));
				String page = request.getParameter("page");
			
				if (page == null)
				{
				
					listBooking = bd.getListBookingByStatus(userId,statusId, 0);
				request.setAttribute("listAll", listBooking);
				}
			else {
					int paging = (Integer.parseInt(page) - 1) * 5;
					listBooking = bd.getListBookingByStatus(userId,statusId,paging);
				}
				request.setAttribute("listAll", listBooking);
				}
			

			if(checkRadio.equalsIgnoreCase("1"))
			{
				request.setAttribute("page", pagingStatus(userId,statusId));
				String page = request.getParameter("page");
			
				if (page == null)
				{
				
					listBooking = bd.getListBookingByStatusSortTakeDate(userId,statusId, 0);
				request.setAttribute("listAll", listBooking);
				}
				else {
					int paging = (Integer.parseInt(page) - 1) * 5;
					listBooking = bd.getListBookingByStatusSortTakeDate(userId,statusId,paging);
				}
				request.setAttribute("listAll", listBooking);
			}
			
			
		}
			
		
		}
		
		
		
		//System.out.println("lan cuoi cua getparam check: "+checkRadio);
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/nguoidung.jsp");
		dispatcher.forward(request, response);
	
		
	}

	public List<Integer> paging(int id) {
		int sizev = bd.sizeOfListBooking(id);
		//System.out.println("size:" + size);
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
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			// read the "command" parameter
			String checkRadio=request.getParameter("checkRadio");
			String returnValue=request.getParameter("returnValue");
			
			//System.out.println("getparameter lan 1"+checkRadio);
			String command = request.getParameter("command");
			if (command == null) {
				command = "SHOW";
			}
			switch (command) {
			case "SHOW":
				showView(request, response,checkRadio,returnValue);
				break;
			
			case "SEARCH":
				searchBooking(request, response,checkRadio);
				break;
				
			case "COMPLAINT":
				complaintBooking(request, response,checkRadio);
				break;	
				
				
				
//			
//			default:
//				showView(request, response);
			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}
		
		
	
	}
	

	private void complaintBooking(HttpServletRequest request, HttpServletResponse response, String checkRadio) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bookingId= request.getParameter("bookingId");
		String phoneNumber=(String) request.getParameter("phoneNumber");
		String title=(String) request.getParameter("titleM");
		String content=(String) request.getParameter("messageText");
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("id");
		System.out.println("phoneNumber la: "+phoneNumber);
		System.out.println("title la: "+title);
		
		Complaint c= new Complaint();
		c.setBookingId(bookingId);
		c.setNumberPhone(phoneNumber);
		c.setContent(content);
		c.setTitle(title);
		c.setUserId(String.valueOf(userId));
		if(cd.createComplaint(c))
		{
			request.setAttribute("checkFlag", "1");
			response.sendRedirect(request.getContextPath() + "/manageBooking?flag=4&sendComplaint=true");
		}
		else
		{
			response.sendRedirect(request.getContextPath() + "/manageBooking?flag=4&sendComplaint=false");
		}
	}

	private void searchBooking(HttpServletRequest request, HttpServletResponse response,String checkRadio) throws ServletException, IOException {
		
		//System.out.println("tao da vao roi");
		String status=(String)request.getParameter("itemCategory");
		//String returnValue=request.getParameter("returnValue");
		if(status==null)
		{
			status="0";
		}
		
		
		int statusId= Integer.parseInt(status);
		System.out.println("status la:"+status);
		//checkRadio = request.getParameter("checkRadio");
		//System.out.println("xem no dang so may POst"+checkRadio);
		
		request.setAttribute("returnValue", "0");
		if(status.equalsIgnoreCase("0"))
		{
			request.setAttribute("hidePageBooking", "no");
			showView(request, response,checkRadio,status);
		}
		else
		{
			//System.out.println("vao muc else:"+statusId);
			
			searchbyStatus(request, response,statusId,checkRadio);
			
		}
		
	
		
	}
	
	

	
	

	private void searchbyStatus(HttpServletRequest request, HttpServletResponse response, int statusId, String checkRadio) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("id");
		List<Booking> listBooking = new ArrayList<>();
		//listBooking= bd.getListBookingByIdUser(userId);
		
		request.setAttribute("rolePhotographer", "4");
		int count = bd.sizeOfListBookingByStatusId(userId,statusId);
		request.setAttribute("hideAll", "no");
		request.setAttribute("returnValue", statusId);
		request.setAttribute("hidePageBooking", "no");
		request.setAttribute("checkRadioReturn", checkRadio);
		//checkRadio="0";
		
		if(count==0)
		{		request.setAttribute("hidePageBooking", "yes");
//
//			request.setAttribute("notificationNoBooking", "Bạn chưa đặt chụp gói nhiếp ảnh ");
//			request.setAttribute("hideAll", "yes");
		}
		else
		{
			
			if(checkRadio.equalsIgnoreCase("0"))
			{
				request.setAttribute("hidePageBooking", "no");
				request.setAttribute("page", pagingStatus(userId,statusId));
				String page = request.getParameter("page");
				if (page == null)
				{
				listBooking = bd.getListBookingByStatus(userId,statusId, 0);
				request.setAttribute("listAll", listBooking);
				}
				else {
					int paging = (Integer.parseInt(page) - 1) * 5;
					listBooking = bd.getListBookingByStatus(userId,statusId,paging);
			}
				request.setAttribute("listAll", listBooking);
				
				request.setAttribute("checkRadioReturn", checkRadio);
			}
			
			if(checkRadio.equalsIgnoreCase("1"))
			{
				request.setAttribute("hidePageBooking", "no");
				request.setAttribute("page", pagingStatus(userId,statusId));
				String page = request.getParameter("page");
				if (page == null)
				{
				listBooking = bd.getListBookingByStatusSortTakeDate(userId,statusId, 0);
				request.setAttribute("listAll", listBooking);
				}
				else {
					int paging = (Integer.parseInt(page) - 1) * 5;
					listBooking = bd.getListBookingByStatusSortTakeDate(userId,statusId,paging);
			}
				request.setAttribute("listAll", listBooking);
				request.setAttribute("checkRadioReturn", checkRadio);
			}
			
			
			
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/nguoidung.jsp");
		dispatcher.forward(request, response);
		
	}

	public List<Integer> pagingStatus(int id, int statusId) {
		int size = bd.sizeOfListBookingByStatusId(id,statusId);
		//System.out.println("size:" + size);
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
