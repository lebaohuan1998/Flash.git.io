package nhom1.servlet_controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom1.dao.AccountDAO;
import nhom1.dao.UserProfileInfoDAO;
import nhom1.dao.UserRegisterDAO;
import nhom1.md5.MD5Library;
import nhom1.model.User;
import nhom1.sendemail.SendEmailRegister;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class UserRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserRegisterDAO unr = new UserRegisterDAO();
	private MD5Library md = new MD5Library();
	private SendEmailRegister sm = new SendEmailRegister();
	// Random number
	private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static final int RANDOM_STRING_LENGTH = 15;
	private UserProfileInfoDAO und = new UserProfileInfoDAO();
	private AccountDAO acc = new AccountDAO();
	/*
	 * Use the below String to random chars, numbers or both. private static final
	 * String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	 * private static final String CHAR_LIST = "1234567890"; private static final
	 * String CHAR_LIST =
	 * "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	 */

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegisterController() {
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
		try {
			int role = (Integer) session.getAttribute("role");
			if (role == 3) {
				response.sendRedirect(request.getContextPath() + "/HomePageServlet");
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}

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
		String token = generateRandomString();
		System.out.println(token);

		String fullName = request.getParameter("fullName");
		String pwd = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		if (unr.checkEmailDupplicate(email)) {
			response.sendRedirect(request.getContextPath() + "/RegisterServlet?err=false");
		} else {
			User nu = new User(fullName, md.md5(pwd), phone, email, "3");
			nu.setTokenEmail(token);
			if (unr.Register(nu)) {
				response.sendRedirect(request.getContextPath() + "/LoginServlet?Register=success");
				// gui mail
				int id = Integer.parseInt(acc.getActiveEmailUser(email, token).getId());
				und.updateActive("2", id);
				sm.sendEmail(request, response, email, token);
			} else {
				response.sendRedirect(request.getContextPath() + "/RegisterServlet?Register=false");
			}
		}

	}

	public String generateRandomString() {
		StringBuffer randStr = new StringBuffer();
		for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
			int number = getRandomNumber();
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}

	private int getRandomNumber() {
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}
	}
}
