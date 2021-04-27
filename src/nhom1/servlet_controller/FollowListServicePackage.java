package nhom1.servlet_controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom1.dao.FLowListServicePackageDAO;

import nhom1.dao.FlowListPhotographerDAO;
import nhom1.dao.ListServicePackageDAO;
import nhom1.model.ServicePackage;
import nhom1.model.Photographer;
import nhom1.model.ServicePackage;

/**
 * Servlet implementation class FollowListServicePacket
 */
@WebServlet("/followServicePackage")
public class FollowListServicePackage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FLowListServicePackageDAO fls = new FLowListServicePackageDAO();
	
	
    public FollowListServicePackage() {
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
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			if (theCommand == null) {
				theCommand = "VIEW";
			}
			switch (theCommand) {
			case "VIEW":
				ViewListPhotographer(request, response);
				break;
			case "UNFOLLOW":
				unFollow(request, response);
				break;
			
			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}

	}

		
		
		
		
		
		
		
		
		
		
		
		
		private void unFollow(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
			try {
				String idServicePackage = request.getParameter("id1");
				HttpSession session = request.getSession();
				int userId = (Integer) session.getAttribute("id");
				
				
				fls.UnfollowServicePackage(idServicePackage, String.valueOf(userId));
				
				System.out.println(" get idservicepackage="+idServicePackage);
				//System.out.println(" get idUser="+idUser);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		
	}

		private void ViewListPhotographer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			HttpSession session = request.getSession();
			int id = (Integer) session.getAttribute("id");
			int count= fls.sizeOfListFollowServicePackage(id);
			List<ServicePackage> la = new ArrayList<>();
			request.setAttribute("rolePhotographer", 4);
			if(count==0)
			{

				request.setAttribute("notificationFollowSV", "Bạn chưa theo dõi gói chụp ");
				request.setAttribute("hide", "yes");
			}
			else
			{
				request.setAttribute("hide", "no");
				request.setAttribute("notificationFollowSV", null);
				request.setAttribute("page", paging(id));
				String page = request.getParameter("page");
				if (page == null)
				{
					la = fls.listFollowServicePackage(id, 0);
				}
				else {
				int paging = (Integer.parseInt(page) - 1) * 9;
				la = fls.listFollowServicePackage(id, paging);
				}
				request.setAttribute("listAll", la);
			}
			
			request.setAttribute("page", paging(id));
			RequestDispatcher dispatcher = request.getRequestDispatcher("form/nguoidung.jsp");
			dispatcher.forward(request, response);
		
	}



	public List<Integer> paging(int id) {
		int size = fls.sizeOfListFollowServicePackage(id);
		System.out.println("size:" + size);
		List<Integer> listPage = new ArrayList<>();
		int m = size / 9;
		int n = size % 9;
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
		
	}

}
