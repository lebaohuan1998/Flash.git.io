package nhom1.servlet_controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nhom1.dao.UserPOMRegisterDAO;
import nhom1.md5.MD5Library;
import nhom1.model.PhotographerOrModel;
import nhom1.sendemail.SendEmailRegister;

/**
 * Servlet implementation class RegisterPhotographerOrModel
 */
@WebServlet("/RegisterPhotographerOrModel")
public class RegisterPhotographerOrModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserPOMRegisterDAO upomr = new UserPOMRegisterDAO();
	private MD5Library md = new MD5Library();
	private SendEmailRegister sm = new SendEmailRegister();
	private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static final int RANDOM_STRING_LENGTH = 15;

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
	public RegisterPhotographerOrModel() {
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("registerphoto.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String token = generateRandomString();
		System.out.println(token);
		String fullName = request.getParameter("fullname");

		String pwd = request.getParameter("password");

		String email = request.getParameter("email");

		String phone = request.getParameter("phone");
		String ngheDanh = "";
		ngheDanh = request.getParameter("nghedanh");

		String tcc = request.getParameter("thecancuoc");
		String address = request.getParameter("address");


		if (upomr.checkEmailDupplicate(email)) {
			response.sendRedirect(request.getContextPath() + "/RegisterPhotographerOrModel?err=false");
		} else {
			PhotographerOrModel pom = new PhotographerOrModel(email, fullName, ngheDanh, md.md5(pwd), phone, tcc, "2");
			pom.setAddress(address);
			pom.setTokenEmail(token);
			if (upomr.RegisterPOM(pom)) {
				response.sendRedirect(request.getContextPath() + "/LoginServlet?Register=success");
				// gui mail
				sm.sendEmail(request, response, email, token);
			} else {
				response.sendRedirect(request.getContextPath() + "/RegisterPhotographerOrModel?Register=false");
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
