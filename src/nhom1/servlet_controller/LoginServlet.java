package nhom1.servlet_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Constants;

import nhom1.dao.AccountDAO;
import nhom1.md5.MD5Library;
import nhom1.model.GooglePojo;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MD5Library md = new MD5Library();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void init() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("log-in.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("username");
		String pwd = request.getParameter("password");
		String r = request.getParameter("user");
		HttpSession session = request.getSession();
		AccountDAO accDAO = new AccountDAO();
		if (r.equals("1")) {
			if (accDAO.getAccountUser(user, md.md5(pwd)) && user != "" && pwd != "") {
				// check email active
				if (accDAO.getRoleUser(user, md.md5(pwd)).getStatus() == null
						|| accDAO.getRoleUser(user, md.md5(pwd)).getStatus().equals("deactive")) {
					response.sendRedirect(request.getContextPath() + "/LoginServlet?acc=notactive");
				} else {
					session.setAttribute("user", accDAO.getRoleUser(user, md.md5(pwd)).getFullName());
					session.setAttribute("role", "1");// employee admin
					session.setAttribute("id", accDAO.getRoleUser(user, md.md5(pwd)).getId());
					session.setAttribute("pass", accDAO.getRoleUser(user, md.md5(pwd)).getPassword());
					session.setAttribute("email", user);
					response.sendRedirect(request.getContextPath() + "/HomePageServlet");
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/LoginServlet?login=false");

			}
		} else if (r.equals("2")) {
			if (accDAO.getAccountPhoto(user, md.md5(pwd)) && user != "" && pwd != "") {
				// check email active
				System.out.println(user+"|"+ pwd);
				if (accDAO.getRolePhoto(user, md.md5(pwd)).getStatus() == null
						|| accDAO.getRolePhoto(user, md.md5(pwd)).getStatus().equals("deactive")) {
					response.sendRedirect(request.getContextPath() + "/LoginServlet?acc=notactive");
				} else {
					session.setAttribute("user", accDAO.getRolePhoto(user, md.md5(pwd)).getFullName());
					session.setAttribute("role", "2");// employee admin
					session.setAttribute("id", accDAO.getRolePhoto(user, md.md5(pwd)).getId());
					session.setAttribute("pass", accDAO.getRolePhoto(user, md.md5(pwd)).getPassword());
					session.setAttribute("email", user);
					response.sendRedirect(request.getContextPath() + "/HomePageServlet");
				}

			} else {
				response.sendRedirect(request.getContextPath() + "/LoginServlet?login=false");
			}

		}

	}

}
