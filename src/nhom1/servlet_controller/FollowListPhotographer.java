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

import nhom1.dao.ListServicePackageDAO;
import nhom1.dao.UserProfileInfoDAO;

import nhom1.dao.FlowListPhotographerDAO;
import nhom1.dao.InfoServicePackageOfPhotographerDAO;
import nhom1.model.ServicePackage;
import nhom1.model.Photographer;



/**
 * Servlet implementation class FlowListPhotographer
 */
@WebServlet("/followPhotographer")
public class FollowListPhotographer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FlowListPhotographerDAO flp = new FlowListPhotographerDAO();
	private UserProfileInfoDAO upd = new UserProfileInfoDAO();
	private InfoServicePackageOfPhotographerDAO iaopd = new InfoServicePackageOfPhotographerDAO();
	
    public FollowListPhotographer() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		
		
		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			if (theCommand == null) {
				theCommand = "VIEWALBUM";
			}
			switch (theCommand) {
			case "VIEWALBUM":
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
			try {
				String idPhoto = request.getParameter("id1");
				System.out.println("get ra duoc idphoto"+idPhoto);
				HttpSession session = request.getSession();
				int id = (Integer) session.getAttribute("id");
				String idUser = String.valueOf(id);
				iaopd.unFollow(idPhoto, idUser);
			} catch (Exception e) {
				// TODO: handle exception
			}
		
	}











		private void ViewListPhotographer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			HttpSession session = request.getSession();
			int id = (Integer) session.getAttribute("id");
			int count=flp.sizeOfListFollow(id);
			System.out.println("gido"+count);
			List<Photographer> la = new ArrayList<>();
//			if( count!=0)
//			{
//			
//			la = flp.getFlowListPhotographerById(id);
//			request.setAttribute("listA",la);
//			request.setAttribute("rolePhotographer", 2);
//			request.setAttribute("countFollow", count);
//			}
			request.setAttribute("rolePhotographer", 4);
			//request.setAttribute("rolePhotographer", 2);
			//request.setAttribute("countFollow", count);
			//request.setAttribute("notification", "Báº¡n chÆ°a theo dĂµi thá»£ áº£nh");
			if( count==0)
			{
			
			request.setAttribute("notification", "Bạn chưa theo dõi thợ ảnh");
			request.setAttribute("hide", "yes");
			}
			if( count!=0)
			{	
				request.setAttribute("hide", "no");
				request.setAttribute("notification", null);
				request.setAttribute("page", paging(id));
				String page = request.getParameter("page");
				//request.setAttribute("currentPage", page);
				//System.out.println("page="+page);
				if (page == null)
				{
					la = flp.listPhotographer(id, 0);
				} else {
				int paging = (Integer.parseInt(page) - 1) * 8;
				la = flp.listPhotographer(id, paging);
				}

			
				request.setAttribute("listAll", la); 
				
			//	request.setAttribute("idUser", id);
				
		
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("form/nguoidung.jsp");
			dispatcher.forward(request, response);
			
				
		
	}









		
	
	
	
	public List<Integer> paging(int id) {
		int size = flp.sizeOfListFollow(id);
		System.out.println("size:" + size);
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
		
		
	}
	
	
	

}
