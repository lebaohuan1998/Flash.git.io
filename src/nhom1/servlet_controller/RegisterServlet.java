package nhom1.servlet_controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom1.dao.UserNorRegisterDAO;
import nhom1.md5.MD5Library;
import nhom1.model.NormalUser;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserNorRegisterDAO unr = new UserNorRegisterDAO();
	private MD5Library md = new MD5Library();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
		dispatcher.forward(request, response);
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

		String fullName = request.getParameter("fullName");
		System.out.println(fullName);
		String pwd = request.getParameter("password");
		System.out.println(pwd);
		String email = request.getParameter("email");
		System.out.println(email);
		String phone = request.getParameter("phone");
		if (unr.checkEmailDupplicate(email)) {
			response.sendRedirect(request.getContextPath() + "/RegisterServlet?err=false");
		} else {
			NormalUser nu = new NormalUser(fullName, md.md5(pwd), phone, email, "1");
			if (unr.Register(nu)) {
				response.sendRedirect(request.getContextPath() + "/LoginServlet?Register=success");
			} else {
				response.sendRedirect(request.getContextPath() + "/RegisterServlet?Register=false");
			}
		}

	}
}
