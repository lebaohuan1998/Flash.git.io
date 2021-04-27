package nhom1.servlet_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom1.dao.AccountDAO;
import nhom1.md5.MD5Library;

/**
 * Servlet implementation class LoginAdminServlet
 */
@WebServlet("/admin")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MD5Library md5 = new MD5Library();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("login_admin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("username");
		String pwd = request.getParameter("password");
		HttpSession session = request.getSession();
		AccountDAO accDAO = new AccountDAO();
		if (accDAO.getAccountAdmin(user, pwd) && user != "" && pwd != "") {
			session.setAttribute("user", "ADMIN");
			session.setAttribute("role", 1);// car admin
			response.sendRedirect(request.getContextPath() + "/ManagermentAdminSystem");
		} else if (accDAO.getAccountUser(user,md5.md5(pwd)) && user != "" && pwd != "") {
			session.setAttribute("user",  accDAO.getRoleUser(user, md5.md5(pwd)).getFullName());
			session.setAttribute("role", 2);
			session.setAttribute("id", accDAO.getRoleUser(user, md5.md5(pwd)).getId());
			session.setAttribute("email", user);
			response.sendRedirect(request.getContextPath() + "/ManagermentAdminOperator");
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login_admin.jsp");
			rd.forward(request, response);
		}
	}

}
