package nhom1.servlet_controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import nhom1.dao.UserNorInfoDAO;
import nhom1.md5.MD5Library;
import nhom1.model.NormalUser;

/**
 * Servlet implementation class ProfileUser
 */
@WebServlet("/ProfileUser")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 50, // 50MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class ProfileUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserNorInfoDAO und = new UserNorInfoDAO();
	MD5Library md = new MD5Library();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileUser() {
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
		int id = (Integer) session.getAttribute("id");

		NormalUser nu = und.getInfo(id);
		if (nu != null) {
			session.setAttribute("user", nu.getFullName());
		}
		request.setAttribute("phone", nu.getNumberPhone());
		request.setAttribute("email", nu.getEmail());
		request.setAttribute("bod", nu.getBod());
		request.setAttribute("address", nu.getAddress());
		request.setAttribute("gender", nu.getGender());
		session.setAttribute("imgname", nu.getAvata());
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/profile-user.jsp");
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
		try {
			// read the "command" parameter
			String theCommand = request.getParameter("cmd");
			switch (theCommand) {
			case "ChangeInfo":
				updateInfo(request, response);
				break;
			case "ChangePassword":
				updatePass(request, response);
				break;
			}
		} catch (Exception exc) {
			throw new ServletException(exc);
		}

	}

	private void updateInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		String email= (String) session.getAttribute("email");
		String name = request.getParameter("user");
		String dob = request.getParameter("dob");
		if(dob.equals("")) {
			dob=null;
		}
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		NormalUser nu = new NormalUser();
		nu.setFullName(name);
		nu.setAddress(address);
		nu.setBod(dob);
		nu.setGender(gender);
		nu.setNumberPhone(phone);

		// image
		File folderUpload = new File(System.getProperty("user.home") + "\\Desktop\\WEB\\Flash\\WebContent\\form\\pic\\imageuser\\"+email);
		if(!folderUpload.exists()) {
			folderUpload.mkdirs();
		}
		for (Part part : request.getParts()) {
			String fileName = extractFileName(part);
			fileName = new File(fileName).getName();
			if(fileName.isEmpty()) {
				break;
			}else {
				part.write(folderUpload.getAbsolutePath()  +"\\"+ fileName);
				session.setAttribute("imgname", fileName);
				break;
			}
		}
		nu.setAvata((String)session.getAttribute("imgname"));
		und.updateInfo(nu, id);
		System.out.println(session.getAttribute("email"));
		System.out.println(session.getAttribute("imgname"));
		response.sendRedirect(request.getContextPath() + "/ProfileUser?update=true");
	}

	private void updatePass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		String oldPass = (String) session.getAttribute("pass");
		String pass = request.getParameter("oldpass");

		if (md.md5(pass).equals(oldPass)) {
			String newPass = request.getParameter("newpass");
			if (md.md5(newPass).equals(oldPass)) {
				response.sendRedirect(request.getContextPath() + "/ProfileUser?errdupplicate=true");
			} else {
				und.updatePass(md.md5(newPass), id);
				session.setAttribute("pass", md.md5(newPass));
				response.sendRedirect(request.getContextPath() + "/ProfileUser?err=true");
			}

		} else {
			response.sendRedirect(request.getContextPath() + "/ProfileUser?err=false");
		}

	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

}
