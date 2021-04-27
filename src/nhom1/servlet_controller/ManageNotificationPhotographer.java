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

import nhom1.dao.NotificationDAO;
import nhom1.model.Notification;
import nhom1.ultility.NotificationQuery;

/**
 * Servlet implementation class ManageNotification
 */
@WebServlet("/ManageNotificationPhotographer")
public class ManageNotificationPhotographer extends HttpServlet {
	private static final long serialVersionUID = 1L;
   NotificationDAO nd= new NotificationDAO();
	
	
    public ManageNotificationPhotographer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		try {
		
			String command = request.getParameter("command");
			//String returnValue = request.getParameter("returnValue");
			if (command == null) {
				command = "SHOW";
			}
			switch (command) {
			case "SHOW":
				showView(request, response);
				break;

			case "Seen":
				seenNotification(request, response);
				break;
			case "ReLoad":
				reloadNotification(request, response);
				break;	
				
			case "DELETE":
				deleteNotification(request, response);
				break;	
				
//			
//			default:
//				showView(request, response);
			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}
	
	}

	private void deleteNotification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String notificationId= request.getParameter("notificationId");
		String notificationId2= request.getParameter("idPhotox");
		System.out.println("notificationId"+notificationId);
		System.out.println("notificationId2"+notificationId2);
		if(nd.deleteNotificationByPhotographerId(notificationId))
				{				
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/tho-chup-anh.jsp");
		dispatcher.forward(request, response);
				}
	}

	private void reloadNotification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		HttpSession session = request.getSession();
		int role= (int) session.getAttribute("role");
		if(role==4) {
		int photographerid=  (Integer) session.getAttribute("id");
		
			int count=0;
			count=nd.countNewNotification(photographerid);
			System.out.println("So luong tin nhan moi cua Photographer: "+count);
			//if(count!=0)
			request.setAttribute("newNotification", count);
		}
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("NewFile1.jsp");
		dispatcher.forward(request, response);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
		

	private void seenNotification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count=0;
		HttpSession session = request.getSession();
		int photographerid=  (Integer) session.getAttribute("id");
		if(nd.updateSeenNotification(photographerid))
			count=nd.countNewNotification(photographerid);	
		request.setAttribute("newNotification", count);
		RequestDispatcher dispatcher = request.getRequestDispatcher("NewFile1.jsp");
		dispatcher.forward(request, response);
	}

	private void showView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int photographerId=  (Integer) session.getAttribute("id");
		List<Notification> listNotification= new ArrayList<Notification>() ;
		if(nd.updateSeenNotification(photographerId))
		{
			System.out.println("updateDone");
		}
		int count= nd.sizeOfListNotificationOfPhotographer(photographerId);
		//System.out.println("count:"+count);

		
		
		
		
		if (count == 0) {
			request.setAttribute("hidePageBooking", "yes");

		}
		else {			
				request.setAttribute("hidePageBooking", "no");
				request.setAttribute("page", pagingStatus(photographerId));
				String page = request.getParameter("page");
				if (page == null) {
					listNotification = nd.getListNotificationByPhotographer(photographerId, 0);
					request.setAttribute("listAll", listNotification);
				} else {
					int paging = (Integer.parseInt(page) - 1) * 8;
					listNotification = nd.getListNotificationByPhotographer(photographerId, paging);
				}
				request.setAttribute("listAll", listNotification);
		
		}
		
					
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/tho-chup-anh.jsp");
		dispatcher.forward(request, response);
		
	}

		

		public List<Integer> pagingStatus(int id) {
			int size = nd.sizeOfListNotificationOfPhotographer(id);
			// System.out.println("size:" + size);
			List<Integer> listPage = new ArrayList<>();
			int m = size / 8;
			int n = size % 8;
			if (n != 0) {
				m = m + 1;
			}
			for (int i = 0; i < m; i++) {
				listPage.add(i + 1);
			}
			return listPage;
		}	
		
		
		
		
		
		
		
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
