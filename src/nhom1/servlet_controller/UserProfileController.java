package nhom1.servlet_controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import nhom1.dao.UserProfileInfoDAO;
import nhom1.md5.MD5Library;
import nhom1.model.User;

/**
 * Servlet implementation class ProfileUser
 */
@WebServlet("/ProfileUser")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 50, // 50MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UserProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserProfileInfoDAO und = new UserProfileInfoDAO();
	MD5Library md = new MD5Library();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserProfileController() {
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

		User nu = und.getInfo(id);
		if (nu != null) {
			session.setAttribute("user", nu.getFullName());
		}
		request.setAttribute("phone", nu.getNumberPhone());
		request.setAttribute("email", nu.getEmail());
		request.setAttribute("bod", nu.getBod());
		request.setAttribute("address", nu.getAddress());
		request.setAttribute("gender", nu.getGender());
		session.setAttribute("imgname", nu.getAvata());
		System.out.println("name :"+nu.getAvata());
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/nguoidung.jsp");
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
		String email = (String) session.getAttribute("email");
		
		int role = (Integer) session.getAttribute("role");
		String name = request.getParameter("user");
		String dob = request.getParameter("dob");
		if (dob.equals("")) {
			dob = null;
		}
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		User nu = new User();
		nu.setFullName(name);
		nu.setAddress(address);
		nu.setBod(dob);
		nu.setGender(gender);
		nu.setNumberPhone(phone);

		// image

		Part part = request.getPart("file");
		System.out.println("name1:"+request.getPart("file"));
		if (part != null) {
			String realPath = request.getServletContext().getRealPath("/images/" + id+role);
			String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
			if (!Files.exists(Path.of(realPath))) {
				Files.createDirectories(Path.of(realPath));
			}
			if (!filename.equals("")) {
				part.write(realPath + "/" + "avata.jpg");
				session.setAttribute("imgname", "avata.jpg");
			}

			System.out.println("name2:"+filename);
		}
		nu.setAvata((String) session.getAttribute("imgname"));
		und.updateInfo(nu, id);
		response.sendRedirect(request.getContextPath() + "/ProfileUser?flag=1&update=true");
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
				response.sendRedirect(request.getContextPath() + "/ProfileUser?flag=1&errdupplicate=true");
			} else {
				und.updatePass(md.md5(newPass), id);
				session.setAttribute("pass", md.md5(newPass));
				response.sendRedirect(request.getContextPath() + "/ProfileUser?flag=1&err=true");
			}

		} else {
			response.sendRedirect(request.getContextPath() + "/ProfileUser?flag=1&err=false");
		}

	}

}
