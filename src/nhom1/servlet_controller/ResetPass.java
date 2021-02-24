package nhom1.servlet_controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nhom1.dao.UserNorInfoDAO;
import nhom1.dao.UserNorRegisterDAO;
import nhom1.dao.UserPOMRegisterDAO;
import nhom1.dao.UserPhotoDAO;
import nhom1.md5.MD5Library;
import nhom1.sendemail.SendEmailRegister;

/**
 * Servlet implementation class ResetPass
 */
@WebServlet("/ResetPass")
public class ResetPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MD5Library md = new MD5Library();
	private SendEmailRegister sm = new SendEmailRegister();
	// Random number
	private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static final int RANDOM_STRING_LENGTH = 10;
	private UserNorRegisterDAO und= new  UserNorRegisterDAO();
	private UserPOMRegisterDAO upomd = new UserPOMRegisterDAO();
	private UserNorInfoDAO unid= new UserNorInfoDAO();
	private UserPhotoDAO upd = new UserPhotoDAO();

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
	public ResetPass() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("quenpassword.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("username");
		String r = request.getParameter("user");
		System.out.println(r);
		if(r.equals("1")) {
			if(und.checkEmailDupplicate(email)) {
				String newPass= generateRandomString();
				sm.sendEmailPass(request, response, email, newPass);
				unid.quenPass(md.md5(newPass), email);
				response.sendRedirect(request.getContextPath() + "/ResetPass?find=true");
			}else {
				response.sendRedirect(request.getContextPath() + "/ResetPass?find=false");
			}
			
		}else if(r.equals("2")) {
			if(upomd.checkEmailDupplicate(email)) {
				String newPass= generateRandomString();
				sm.sendEmailPass(request, response, email, newPass);
				upd.quenPass(md.md5(newPass), email);
				response.sendRedirect(request.getContextPath() + "/ResetPass?find=true");
			}else {
				response.sendRedirect(request.getContextPath() + "/ResetPass?find=false");
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
