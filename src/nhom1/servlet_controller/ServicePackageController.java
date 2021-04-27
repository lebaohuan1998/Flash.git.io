package nhom1.servlet_controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

import nhom1.dao.ServicePackageDAO;
import nhom1.dao.LocationDAO;
import nhom1.model.ServicePackage;
import nhom1.model.Images;

/**
 * Servlet implementation class Tao_Sua_GoiDichVu
 */
@WebServlet("/TaoSuaGoiDichVu")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 50, // 50MB
		maxRequestSize = 1024 * 1024 * 50)
public class ServicePackageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicePackageDAO coa = new ServicePackageDAO();
	private LocationDAO ld = new LocationDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServicePackageController() {
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
		request.setAttribute("listLocation", ld.listLocation());

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			System.out.println(theCommand);

			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "SHOW";
			}
			// route to the appropriate method
			switch (theCommand) {
			case "CREATE":
				createAlbum(request, response);
				break;
			case "SHOW":
				showAlbum(request, response);
				break;
			case "DELETE":
				deleteImage(request, response);
				break;
			case "COVERIMAGE":
				addCoverImage(request, response);
				break;
			default:
				showAlbum(request, response);
			}
		} catch (Exception exc) {
			throw new ServletException(exc);
		}

	}

	private void updateAlbumP(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		String email = (String) session.getAttribute("email");
		int role = (Integer) session.getAttribute("role");
		String idAlbum = (String) session.getAttribute("idAlbum");

		ServicePackage a = coa.getOneServicePackageById(Integer.parseInt(idAlbum));

		String name = request.getParameter("tengoi");
		if (name.equals(a.getServicepackageName()) || coa.getOneServicePackageByName(name) == null) {
			String mota = request.getParameter("mota");
			String theLoai = request.getParameter("theloaichup");
			String diaDiemChup = request.getParameter("diadiem");
			String price = request.getParameter("price");
			String datCoc = request.getParameter("datcoc");
			String ar[] = price.split("\\.");
			price = "";
			for (int i = 0; i < ar.length; i++) {
				price = price + ar[i];
			}
			int tiencoc = (int) (Integer.parseInt(price) * Double.parseDouble(datCoc)*1000);

			List<Part> parts = (List<Part>) request.getParts();
			int sizeEmpty = parts.size() - 6;
			if (sizeEmpty < 21) {
				String oldFile = request.getServletContext()
						.getRealPath("/images/" + id + role + "/albums/" + a.getServicepackageName());
				String newFile = request.getServletContext().getRealPath("/images/" + id + role + "/albums/" + name);
				File oldfile = new File(oldFile);
				File newfile = new File(newFile);
				if (oldfile.renameTo(newfile)) {
					a = new ServicePackage(name, mota, theLoai, diaDiemChup, Integer.parseInt(price)*1000, tiencoc,
							String.valueOf(id));
					coa.updateServicePackageById(a, idAlbum);
					response.sendRedirect(request.getContextPath() + "/TaoSuaGoiDichVu?flag=4&updatealbum1=true");
				} else {
					response.sendRedirect(request.getContextPath() + "/TaoSuaGoiDichVu?flag=4&duplicateName=true");
				}

				Images i = null;
				for (Part part : parts) {
					if (part.getName().equalsIgnoreCase("file")) {
						if (part != null) {
							String realPath = request.getServletContext()
									.getRealPath("/images/" + id + role + "/albums/" + name);
							String filename = getFileName(part);
							if (!Files.exists(Path.of(realPath))) {
								Files.createDirectories(Path.of(realPath));
							}
							if (!filename.equals("")) {
								part.write(realPath + "/" + filename);
								i = new Images(filename, idAlbum, "0");
								coa.addImage(i);
							}
						}
					}
				}
			}

		} else {
			response.sendRedirect(request.getContextPath() + "/TaoSuaGoiDichVu?flag=4&duplicateName=true");
		}

		// tính giá tiền cọc

	}

	private void createAlbum(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/tho-chup-anh.jsp");
		dispatcher.forward(request, response);

	}

	private void showAlbum(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();

		String idA = request.getParameter("arr");
		String idAlbum = "";

		if (idA != null) {
			idAlbum = idA.substring(2, idA.length() - 2);
			System.out.println("id:" + idAlbum);
			session.setAttribute("idAlbum", idAlbum);
		} else {
			idAlbum = (String) session.getAttribute("idAlbum");
			System.out.println("id:" + idAlbum);
		}
		System.out.println("id:" + idAlbum);
		List<Images> listI = new ArrayList<>();
		listI = coa.listImages(Integer.parseInt(idAlbum));
		request.setAttribute("listImages", listI);
		// lấy ảnh bìa
		int countImage = coa.countImage(Integer.parseInt(idAlbum));
		session.setAttribute("countImage", countImage);

		ServicePackage a = coa.getOneServicePackageById(Integer.parseInt(idAlbum));
		request.setAttribute("albumName", a.getServicepackageName());
		request.setAttribute("mota", a.getDescription());
		request.setAttribute("theloai", a.getCategoryId());
		request.setAttribute("locationId", ld.getLocationByCode(a.getShootingLocation()).getLocationId());

		request.setAttribute("shootLocation", ld.getLocationByCode(a.getShootingLocation()).getLocationName());

		request.setAttribute("price", (a.getPrice()/1000));
		request.setAttribute("deposite", a.getDeposit());
		request.setAttribute("coverimage", coa.getCoverImage("1", idAlbum).getImageName());
		request.setAttribute("hide", session.getAttribute("hide"));
		request.setAttribute("countImage", session.getAttribute("countImage"));
		session.setAttribute("hide", null);
		session.setAttribute("countImage", null);
		request.setAttribute(idAlbum, null);

		RequestDispatcher dispatcher = request.getRequestDispatcher("form/tho-chup-anh.jsp");
		dispatcher.forward(request, response);
	}

//delete
	private void deleteImage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		int id = (Integer) session.getAttribute("id");
		String email = (String) session.getAttribute("email");
		int role = (Integer) session.getAttribute("role");

		String imgId = request.getParameter("imgId");
		String c = request.getParameter("case");
		System.out.println("img id :" + imgId);
		String fileName = coa.getImageById(imgId).getImageName();
		String AlbumName = coa.getOneServicePackageById(Integer.parseInt(coa.getImageById(imgId).getAlbumId()))
				.getServicepackageName();
		System.out.println("album name :" + AlbumName);
		System.out.println("file name :" + fileName);
		String linkImg = request.getServletContext()
				.getRealPath("/images/" + id + role + "/albums/" + AlbumName + "/" + fileName);
		if (coa.deleteImage(Integer.parseInt(imgId))) {

			System.out.println("link ảnh :" + linkImg);
			try {
				File file = new File(linkImg);

				if (file.delete()) {
					if (c == null) {
						response.sendRedirect(request.getContextPath() + "/TaoSuaGoiDichVu?flag=2&messdelete=true");
					} else {
						response.sendRedirect(request.getContextPath() + "/TaoSuaGoiDichVu?flag=4&messdelete=true");
					}

				} else {
					response.sendRedirect(request.getContextPath() + "/TaoSuaGoiDichVu?flag=2&messdelete=false");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			response.sendRedirect(request.getContextPath() + "/TaoSuaGoiDichVu?flag=2&messdelete=false");
		}

	}

	// ảnh bìa
	private void addCoverImage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String idAlbum = (String) session.getAttribute("idAlbum");
		System.out.println("anh bia : idalbum:" + idAlbum);
		String imgId = request.getParameter("imgId");
		String c = request.getParameter("case");
		coa.updateCoverImage1("0", idAlbum);
		System.out.println("img id :" + imgId);
		if (coa.updateCoverImage2("1", imgId)) {
			if (c == null) {
				response.sendRedirect(request.getContextPath() + "/TaoSuaGoiDichVu?flag=2&messupdatecoverimage=true");
			} else {
				response.sendRedirect(request.getContextPath() + "/TaoSuaGoiDichVu?flag=4&messupdatecoverimage=true");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/TaoSuaGoiDichVu?flag=2&messupdatecoverimage=false");
		}

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

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("cmd");
			System.out.println(theCommand);
			// route to the appropriate method
			switch (theCommand) {
			case "CREATE":
				createAlbumP(request, response);
				break;
			case "UPDATE":
				updateAlbumP(request, response);
				break;
			}
		} catch (Exception exc) {
			throw new ServletException(exc);
		}

	}

	private void createAlbumP(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();

		int id = (Integer) session.getAttribute("id");
		String email = (String) session.getAttribute("email");
		int role = (Integer) session.getAttribute("role");
		String name = request.getParameter("tengoi");
		String mota = request.getParameter("mota");
		String theLoai = request.getParameter("theloaichup");
		String diaDiemChup = request.getParameter("diadiem");
		String price = request.getParameter("price");
		String datCoc = request.getParameter("datcoc");
		ServicePackage a = new ServicePackage();
		a = coa.getOneServicePackageByName(name);
		// tính giá tiền cọc
		if (a == null) {
			String ar[] = price.split("\\.");
			price ="";
			for (int i = 0; i < ar.length; i++) {
				price = price + ar[i];
			}
			
			int tiencoc = (int) (Integer.parseInt(price) * Double.parseDouble(datCoc)*1000);
			List<Part> parts = (List<Part>) request.getParts();
			int sizeEmpty = parts.size() - 6;
			if (sizeEmpty < 21) {

				System.out.println("size hiện tại :" + sizeEmpty);
				a = new ServicePackage(name, mota, theLoai, diaDiemChup, Integer.parseInt(price)*1000, tiencoc,
						String.valueOf(id));
				coa.createOneServicePackage(a);
				String idAlbum = coa.getOneServicePackageByName(name).getId();
				session.setAttribute("idAlbum", idAlbum);
				System.out.println(coa.getOneServicePackageByName(name).getId());
				// System.out.println(session.getAttribute("idAlbum"));;
				Images i = null;
				int count = 0;
				for (Part part : parts) {
					if (part.getName().equalsIgnoreCase("file")) {
						if (part != null) {
							String realPath = request.getServletContext()
									.getRealPath("/images/" + id + role + "/albums/" + name);
							String filename = getFileName(part);
							if (!Files.exists(Path.of(realPath))) {
								Files.createDirectories(Path.of(realPath));
							}
							if (!filename.equals("")) {
								part.write(realPath + "/" + filename);
								if (count == 0) {
									System.out.println("count:" + count);
									i = new Images(filename, idAlbum, "1");
									coa.addImage(i);
								} else {
									i = new Images(filename, idAlbum, "0");
									coa.addImage(i);
								}
								count++;
							}
						}
					}
				}
				session.setAttribute("hide", "yes");
				response.sendRedirect(request.getContextPath() + "/TaoSuaGoiDichVu?flag=2&updatealbum=true");
			} else {
				response.sendRedirect(
						request.getContextPath() + "/TaoSuaGoiDichVu?command=CREATE&flag=2&maxsizeimage=false");
			}

		} else {
			response.sendRedirect(
					request.getContextPath() + "/TaoSuaGoiDichVu?command=CREATE&flag=2&duplicateName=true");
		}

	}

	private static String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
}
