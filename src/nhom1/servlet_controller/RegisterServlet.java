package nhom1.servlet_controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nhom1.dao.UserNorRegister;
import nhom1.model.NormalUser;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserNorRegister unr =new UserNorRegister();

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

		String fullName = request.getParameter("fullName");
		System.out.println(fullName);
		String pwd = request.getParameter("password");
		System.out.println(pwd);
		String email = request.getParameter("email");
		System.out.println(email);
		String phone = request.getParameter("phone");

		NormalUser nu = new NormalUser(fullName, pwd, phone, email,"1");

		if (unr.Register(nu)) {
			System.out.println("success");
			response.sendRedirect(request.getContextPath() + "/LoginServlet");
		} else {
			System.out.println("false");
			response.sendRedirect(request.getContextPath() + "/RegisterServlet?command=LOAD_UPDATE&" + "&message="
					+ URLEncoder.encode("Something wrong", "UTF-8"));
		}

	}
}
