package nhom1.servlet_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom1.accsessgoogle.Constants;
import nhom1.dao.AccountDAO;
import nhom1.dao.PhotographerRegisterDAO;
import nhom1.dao.UserRegisterDAO;
import nhom1.model.GooglePojo;

/**
 * Servlet implementation class GoogleLogin
 */
@WebServlet("/GoogleLogin")
public class GoogleLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Constants constants = new Constants();
	private UserRegisterDAO unr = new UserRegisterDAO();
	private PhotographerRegisterDAO upomr = new PhotographerRegisterDAO();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoogleLoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String code = request.getParameter("code");
		String role = request.getParameter("role");
		if(role==null) {
			role =(String) session.getAttribute("roleGG");
		}else {
			session.setAttribute("roleGG", role);
		}
		if (code == null || code.isEmpty()) {
			RequestDispatcher dis = request.getRequestDispatcher("log-in.jsp");
			dis.forward(request, response);
		} else {
			String accessToken = constants.getToken(code);
			GooglePojo googlePojo = constants.getUserInfo(accessToken);
			request.setAttribute("id", googlePojo.getId());
			request.setAttribute("name", googlePojo.getName());
			request.setAttribute("email", googlePojo.getEmail());
			role =(String) session.getAttribute("roleGG");
			AccountDAO accDAO = new AccountDAO();
			if(role.equals("1")) {
				if(unr.checkEmailDupplicate(googlePojo.getEmail())) {
					session.setAttribute("user", accDAO.getAccountUser(googlePojo.getEmail()).getFullName());
					session.setAttribute("role", accDAO.getAccountUser(googlePojo.getEmail()).getRole() );// employee admin
					session.setAttribute("id", accDAO.getAccountUser(googlePojo.getEmail()).getId());
					session.setAttribute("pass", accDAO.getAccountUser(googlePojo.getEmail()).getPassword());
					session.setAttribute("email", googlePojo.getEmail());
					response.sendRedirect(request.getContextPath() + "/HomePageServlet");
				}else {
					RequestDispatcher dis = request.getRequestDispatcher("nguoidunglogingg.jsp");
					dis.forward(request, response);
				}
				
			}else if(role.equals("2")) {
				if(upomr.checkEmailDupplicate(googlePojo.getEmail())) {
					session.setAttribute("user", accDAO.getAccountPhotographer(googlePojo.getEmail()).getFullName());
					session.setAttribute("role", accDAO.getAccountPhotographer(googlePojo.getEmail()).getRole());// employee admin
					session.setAttribute("id", accDAO.getAccountPhotographer(googlePojo.getEmail()).getId());
					session.setAttribute("pass", accDAO.getAccountPhotographer(googlePojo.getEmail()).getPassword());
					session.setAttribute("email", googlePojo.getEmail());
					response.sendRedirect(request.getContextPath() + "/HomePageServlet");
				}else {
					RequestDispatcher dis = request.getRequestDispatcher("thoanhlogingg.jsp");
					dis.forward(request, response);
				}
				
			}
			
		}
	    



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("huan post");

	}

}
