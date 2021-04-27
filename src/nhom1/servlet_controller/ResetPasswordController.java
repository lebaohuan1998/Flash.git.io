package nhom1.servlet_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom1.dao.PhotographerInfoDAO;
import nhom1.dao.UserProfileInfoDAO;
import nhom1.dao.UserRegisterDAO;
import nhom1.md5.MD5Library;

/**
 * Servlet implementation class UpdatePass
 */
@WebServlet("/UpdatePass")
public class ResetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MD5Library md = new MD5Library();
	private PhotographerInfoDAO upd = new PhotographerInfoDAO();
	private UserRegisterDAO und= new  UserRegisterDAO();
	private UserProfileInfoDAO unid= new UserProfileInfoDAO();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResetPasswordController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String token = request.getParameter("token");
		String emailReset = (String) session.getAttribute("emailReset");
		String tokenReset = (String) session.getAttribute("tokenReset");
		if (email.equals(emailReset) && token.equals(tokenReset)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("thaydoimatkhau.jsp");
			dispatcher.forward(request, response);
		} else {
			System.out.println("not oke");
			response.sendRedirect(request.getContextPath() + "/PageNotFound");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String pwd = request.getParameter("repassword");
		String email = (String) session.getAttribute("emailReset");
		String r = (String) session.getAttribute("roleRest");
		if(email==null&&r==null) {
			response.sendRedirect(request.getContextPath() + "/ResetPass?noti=timeout");
		}else {
			if(r.equals("2")) {
				upd.updatePassByeEmail(md.md5(pwd), email);
				response.sendRedirect(request.getContextPath() + "/LoginServlet?noti=success");
			}else if(r.equals("1")) {
				unid.updatePassByEmail(md.md5(pwd), email);
				response.sendRedirect(request.getContextPath() + "/LoginServlet?noti=success");
			}
			
		}
		

	}

}
