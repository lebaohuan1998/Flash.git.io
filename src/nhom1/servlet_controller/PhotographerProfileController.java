package nhom1.servlet_controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import nhom1.dao.LocationDAO;
import nhom1.dao.MapPhotographerDAO;
import nhom1.dao.PhotographerInfoDAO;
import nhom1.md5.MD5Library;
import nhom1.model.Location;
import nhom1.model.MapPhoto;
import nhom1.model.Photographer;

/**
 * Servlet implementation class ProfilePhoto
 */
@WebServlet("/ProfilePhoto")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 50, // 50MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class PhotographerProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhotographerInfoDAO upd = new PhotographerInfoDAO();
	private MD5Library md = new MD5Library();
	LocationDAO ld = new LocationDAO();
	private MapPhotographerDAO mpd = new MapPhotographerDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PhotographerProfileController() {
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
		Photographer pom = upd.getInfo(id);
		if (pom != null) {
			session.setAttribute("user", pom.getFullName());
		}
		MapPhoto m = new MapPhoto();
		m = mpd.getInfo(String.valueOf(id));
		if (m.getLocationx() != null && m.getLocationy() != null) {
			request.setAttribute("mapphoto", m);
		}
		List<Location> listL = new ArrayList<>();
		listL = ld.listLocation();
		request.setAttribute("listLocation", listL);
		request.setAttribute("phone", pom.getPhone());
		request.setAttribute("email", pom.getEmail());
		request.setAttribute("bod", pom.getDateOfBirth());
		request.setAttribute("address", pom.getAddressOfId());
		request.setAttribute("gender", pom.getGender());
		request.setAttribute("tcc", pom.getIdentityCardNumber());
		request.setAttribute("workPlace", pom.getWorkPlace());
		request.setAttribute("nghedanh", pom.getNickName());
		request.setAttribute("address", pom.getAddressOfId());
		request.setAttribute("locationId", pom.getProvinceId());
		request.setAttribute("quymo", pom.getOrganize());
		request.setAttribute("statusxm", pom.getIdentityVerifyId());
		session.setAttribute("imgname", pom.getAvata());
		if (pom.getFrontPhoto() == null) {
			request.setAttribute("hide", "no");
		} else {
			request.setAttribute("hide", "yes");
			session.setAttribute("xm1", pom.getFrontPhoto());
			session.setAttribute("xm2", pom.getBackPhoto());
			session.setAttribute("xm3", pom.getFullPhoto());
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
		int role = (Integer) session.getAttribute("role");

		Part part1 = request.getPart("file1");
		Part part2 = request.getPart("file2");
		Part part3 = request.getPart("file3");
		System.out.println(request.getPart("file1") + "|" + request.getPart("file2") + "|" + request.getPart("file3"));
		if (part1 != null && part2 != null && part3 != null) {
			String realPath = request.getServletContext().getRealPath("/images/" + id + role + "/idcard");
			String filename1 = Path.of(part1.getSubmittedFileName()).getFileName().toString();
			String filename2 = Path.of(part2.getSubmittedFileName()).getFileName().toString();
			String filename3 = Path.of(part3.getSubmittedFileName()).getFileName().toString();
			if (!Files.exists(Path.of(realPath))) {
				Files.createDirectories(Path.of(realPath));
			}
			if (!filename1.equals("") && !filename2.equals("") && !filename3.equals("")) {
				part1.write(realPath + "/" + "xm1.jpg");
				part2.write(realPath + "/" + "xm2.jpg");
				part3.write(realPath + "/" + "xm3.jpg");
				session.setAttribute("xm1", "xm1.jpg");
				session.setAttribute("xm2", "xm2.jpg");
				session.setAttribute("xm3", "xm3.jpg");
				response.sendRedirect(request.getContextPath() + "/ProfilePhoto?flag=1&updatecmt=true");
				upd.updateXm((String) session.getAttribute("xm1"), (String) session.getAttribute("xm2"),
						(String) session.getAttribute("xm3"), id);
			} else {
				response.sendRedirect(request.getContextPath() + "/ProfilePhoto?flag=1&updatecmt=false");
			}
		}
	}

	private void updateInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		String name = request.getParameter("user");
		String address = request.getParameter("address");
		String dob = request.getParameter("dob");
		if (dob.equals("")) {
			dob = null;
		}
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String tcc = request.getParameter("tcc");
		Photographer pom = new Photographer();
		pom.setFullName(name);
		pom.setDateOfBirth(dob);
		pom.setPhone(phone);
		pom.setGender(gender);
		pom.setIdentityCardNumber(tcc);
		pom.setAddressOfId(address);

		upd.updateInfo1(pom, id);
		upd.updateInfo2(pom, id);
		response.sendRedirect(request.getContextPath() + "/ProfilePhoto?flag=1&updateInfo=true");

	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		int role = (Integer) session.getAttribute("role");

		String ngheDanh = request.getParameter("nghedanh");
		String quymo = request.getParameter("quymo");
		String workPlace = request.getParameter("workplace");
		String provinceId = request.getParameter("diadiem");
		System.out.println(provinceId);
		String arr[] = provinceId.split(" ");
		
		String pId = arr[0];
		System.out.println("fhasgsafsjsafhgh"+pId);
		Photographer pom = new Photographer();
		pom.setWorkPlace(workPlace);
		pom.setNickName(ngheDanh);
		pom.setOrganize(quymo);
		pom.setProvinceId(pId);
		// up ảnh avata
		Part part = request.getPart("file");
		if (part != null) {
			String realPath = request.getServletContext().getRealPath("/images/" + id + role);
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
