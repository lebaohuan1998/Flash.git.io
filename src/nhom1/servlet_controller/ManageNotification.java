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

/**
 * Servlet implementation class ManageNotification
 */
@WebServlet("/ManageNotification")
public class ManageNotification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	  private NotificationDAO nd= new NotificationDAO();
	
    public ManageNotification() {
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

	private void deleteNotification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException {

		HttpSession session = request.getSession();
		String notificationId= request.getParameter("notificationId");
		System.out.println("notificationId"+notificationId);
		
		if(nd.deleteNotificationByUserId(notificationId))
				{				
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/nguoidung.jsp");
		dispatcher.forward(request, response);
				}
		
	}

	private void reloadNotification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		HttpSession session = request.getSession();
		int userId=  (Integer) session.getAttribute("id");
		int count=0;
			count=nd.countNewNotificationByUser(userId);
			System.out.println("so luong tin nhan moi cua user la: "+count);
			//if(count!=0)
			request.setAttribute("newNotification", count);
			
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("NewFile1.jsp");
		dispatcher.forward(request, response);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	private void seenNotification(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void showView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userId=  (Integer) session.getAttribute("id");
		List<Notification> listNotification= new ArrayList<Notification>() ;
		if(nd.seenNotificationByUser(userId))
		{
			System.out.println("updateDone");
		}
		
		int count= nd.sizeOfListNotificationOfUser(userId);
		if (count == 0) {
			request.setAttribute("hidePageBooking", "yes");

		}
		else {			
				request.setAttribute("hidePageBooking", "no");
				request.setAttribute("page", pagingStatus(userId));
				String page = request.getParameter("page");
				if (page == null) {
					listNotification = nd.getListNotificationOfUser(userId, 0);
					request.setAttribute("listAll", listNotification);
				} else {
					int paging = (Integer.parseInt(page) - 1) * 8;
					listNotification = nd.getListNotificationOfUser(userId, paging);
				}
				request.setAttribute("listAll", listNotification);
		
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/nguoidung.jsp");
		dispatcher.forward(request, response);
		
	}


	public List<Integer> pagingStatus(int id) {
		int size = nd.sizeOfListNotificationOfUser(id);
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
