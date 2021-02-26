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

import nhom1.dao.UserPhotoDAO;
import nhom1.md5.MD5Library;
import nhom1.model.PhotographerOrModel;

/**
 * Servlet implementation class ProfilePhoto
 */
@WebServlet("/ProfilePhoto")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 50, // 50MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class ProfilePhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserPhotoDAO upd = new UserPhotoDAO();
	private MD5Library md = new MD5Library();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfilePhoto() {
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
		PhotographerOrModel pom = upd.getInfo(id);
		if (pom != null) {
			session.setAttribute("user", pom.getFullName());
		}
		request.setAttribute("phone", pom.getPhone());
		request.setAttribute("email", pom.getEmail());
		request.setAttribute("bod", pom.getBod());
		request.setAttribute("address", pom.getAddress());
		request.setAttribute("gender", pom.getGender());
		request.setAttribute("tcc", pom.getTcc());
		request.setAttribute("nghedanh", pom.getNgheDanh());
		request.setAttribute("address", pom.getAddress());
		request.setAttribute("workplace", pom.getNoilamviec());
		request.setAttribute("quymo", pom.getQuymo());
		session.setAttribute("imgname", pom.getAvata());
		if(pom.getXm1()==null) {
			request.setAttribute("hide", "no");
		}else {
			request.setAttribute("hide", "yes");
			session.setAttribute("xm1", pom.getXm1());
			session.setAttribute("xm2", pom.getXm2());
			session.setAttribute("xm3", pom.getXm3());
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/tho-chup-anh.jsp");
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
			case "show":
				show(request, response);
				break;
			case "updateinfo":
				updateInfo(request, response);
				break;
			case "updatecmt":
				updateCmt(request, response);
				break;
			case "updatepass":
				updatePass(request, response);
				break;
			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	private void updatePass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		String oldPass = (String) session.getAttribute("pass");
		String pwd = request.getParameter("oldpassword");
		if (md.md5(pwd).equals(oldPass)) {
			String newPass = request.getParameter("newpass");
			if (md.md5(newPass).equals(oldPass)) {
				response.sendRedirect(request.getContextPath() + "/ProfilePhoto?flag=1&errdupplicate=true");
			} else {
				upd.updatePass(md.md5(newPass), id);
				session.setAttribute("pass", md.md5(newPass));
				response.sendRedirect(request.getContextPath() + "/ProfilePhoto?flag=1&err=true");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/ProfilePhoto?flag=1&err=false");
		}

	}

	private void updateCmt(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		String email = (String) session.getAttribute("email");
		String role = (String) session.getAttribute("role");

		Part part1 = request.getPart("file1");
		Part part2 = request.getPart("file2");
		Part part3 = request.getPart("file3");
		System.out.println(request.getPart("file1") + "|" + request.getPart("file2") + "|" + request.getPart("file3"));
		if (part1 != null && part2 != null && part3 != null) {
			String realPath = request.getServletContext().getRealPath("/images/" + email + role);
			String filename1 = Path.of(part1.getSubmittedFileName()).getFileName().toString();
			String filename2 = Path.of(part2.getSubmittedFileName()).getFileName().toString();
			String filename3 = Path.of(part3.getSubmittedFileName()).getFileName().toString();
			if (!Files.exists(Path.of(realPath))) {
				Files.createDirectories(Path.of(realPath));
			}
			if (!filename1.equals("")&&!filename2.equals("")&&!filename3.equals("")) {
				part1.write(realPath + "/" + "xm1.jpg");
				part2.write(realPath + "/" + "xm2.jpg");
				part3.write(realPath + "/" + "xm3.jpg");
				session.setAttribute("xm1", "xm1.jpg");
				session.setAttribute("xm2", "xm2.jpg");
				session.setAttribute("xm3", "xm3.jpg");
				response.sendRedirect(request.getContextPath() + "/ProfilePhoto?flag=1&updatecmt=true");
				upd.updateXm((String) session.getAttribute("xm1"),(String) session.getAttribute("xm2"),(String) session.getAttribute("xm3"), id);
			}else {
				response.sendRedirect(request.getContextPath() + "/ProfilePhoto?flag=1&updatecmt=false");

			}
			
		}


	}

	private void updateInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		String email = (String) session.getAttribute("email");
		String name = request.getParameter("user");
		String address = request.getParameter("address");
		String dob = request.getParameter("dob");
		if (dob.equals("")) {
			dob = null;
		}
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String tcc = request.getParameter("tcc");
		PhotographerOrModel pom = new PhotographerOrModel();
		pom.setFullName(name);
		pom.setBod(dob);
		pom.setPhone(phone);
		pom.setGender(gender);
		pom.setTcc(tcc);
		pom.setAddress(address);

		upd.updateInfo(pom, id);
		response.sendRedirect(request.getContextPath() + "/ProfilePhoto?flag=1&updateInfo=true");

	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		String email = (String) session.getAttribute("email");
		String role = (String) session.getAttribute("role");

		String ngheDanh = request.getParameter("nghedanh");
		String quymo = request.getParameter("quymo");
		String workplace = request.getParameter("workplace");
		PhotographerOrModel pom = new PhotographerOrModel();
		pom.setNgheDanh(ngheDanh);
		pom.setQuymo(quymo);
		pom.setNoilamviec(workplace);
		// up ảnh avata
		Part part = request.getPart("file");
		if (part != null) {
			String realPath = request.getServletContext().getRealPath("/images/" + email + role);
			String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
			if (!Files.exists(Path.of(realPath))) {
				Files.createDirectories(Path.of(realPath));
			}
			if (!filename.equals("")) {
				part.write(realPath + "/" + "avata.jpg");
				session.setAttribute("imgname", "avata.jpg");
			}

			System.out.println("name2:" + filename);
		}
		pom.setAvata((String) session.getAttribute("imgname"));

		upd.updateView(pom, id);
		response.sendRedirect(request.getContextPath() + "/ProfilePhoto?flag=1&updateShow=true");

	}

}
