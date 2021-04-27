package nhom1.servlet_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom1.dao.InfoServicePackageOfPhotographerDAO;
import nhom1.dao.LocationDAO;
import nhom1.model.ServicePackage;
import nhom1.model.DecribePhotographer;
import nhom1.model.Photographer;

/**
 * Servlet implementation class InfoAlbumOfPhoto
 */
@WebServlet("/photographer")
public class InfoServicePackageOfPhotographerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InfoServicePackageOfPhotographerDAO iaopd = new InfoServicePackageOfPhotographerDAO();
	LocationDAO ld = new LocationDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InfoServicePackageOfPhotographerController() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			if (theCommand == null) {
				theCommand = "VIEWALBUM";
			}
			switch (theCommand) {
			case "VIEWALBUM":
				viewsInfoAlbumOfPhoto(request, response);
				break;
			case "FOLLOW":
				addFollow(request, response);
				break;
			case "UNFOLLOW":
				unFollow(request, response);
				break;
			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}

	}

	private void unFollow(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			String idPhoto = request.getParameter("id1");
			String idUser = request.getParameter("id2");
			iaopd.unFollow(idPhoto, idUser);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void addFollow(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			String idPhoto = request.getParameter("id1");
			String idUser = request.getParameter("id2");
			iaopd.addFollow(idPhoto, idUser);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void viewsInfoAlbumOfPhoto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		String idPhoto = request.getParameter("photographerId");
		try {

			int id = (Integer) session.getAttribute("id");

			boolean check = iaopd.checkFollow(idPhoto, String.valueOf(id));
			if (check == true) {
				request.setAttribute("show", "on");
			} else {
				request.setAttribute("show", "off");
			}
			String follow = iaopd.numberOfFollow(idPhoto);
			Photographer photo = iaopd.getInfo(idPhoto);
			String name = photo.getFullName();
			String quymo = photo.getOrganize();
			String placeOfWork = photo.getProvinceId();
			String avata = photo.getAvata();
			String email = photo.getEmail();
			String role = photo.getRoleId();
			String idp = photo.getId();
			String provinceName = ld.getLocationByCode(placeOfWork).getLocationName();
			request.setAttribute("name", name);
			request.setAttribute("quymo", quymo);
			request.setAttribute("placeOfWork", provinceName);
			request.setAttribute("avata", avata);
			request.setAttribute("emailphoto", email);
			request.setAttribute("rolephoto", role);
			request.setAttribute("idPhoto", idp);
			request.setAttribute("follow", follow);
			DecribePhotographer dp = iaopd.getDescribePhotographer(idPhoto);
			List<ServicePackage> listA1 = iaopd.listAlbumByCategory(idPhoto, "1");
			List<ServicePackage> listA2 = iaopd.listAlbumByCategory(idPhoto, "2");
			List<ServicePackage> listA3 = iaopd.listAlbumByCategory(idPhoto, "3");
			List<ServicePackage> listA4 = iaopd.listAlbumByCategory(idPhoto, "4");
			List<ServicePackage> listA5 = iaopd.listAlbumByCategory(idPhoto, "5");
			List<ServicePackage> listA6 = iaopd.listAlbumByCategory(idPhoto, "6");
			List<ServicePackage> listA7 = iaopd.listAlbumByCategory(idPhoto, "7");
			if (listA1.size() != 0) {
				System.out.println("+");
				request.setAttribute("off1", "no");
			}
			if (listA2.size() != 0) {
				System.out.println("+");
				request.setAttribute("off2", "no");
			}
			if (listA3.size() != 0) {
				System.out.println("+");
				request.setAttribute("off3", "no");
			}
			if (listA4.size() != 0) {
				System.out.println("+");
				request.setAttribute("off4", "no");
			}
			if (listA5.size() != 0) {
				System.out.println("+");
				request.setAttribute("off5", "no");
			}
			if (listA6.size() != 0) {
				System.out.println("+");
				request.setAttribute("off6", "no");
			}
			if (listA7.size() != 0) {
				System.out.println("+");
				request.setAttribute("off7", "no");
			}

			request.setAttribute("listA1", listA1);
			request.setAttribute("listA2", listA2);
			request.setAttribute("listA3", listA3);
			request.setAttribute("listA4", listA4);
			request.setAttribute("listA5", listA5);
			request.setAttribute("listA6", listA6);
			request.setAttribute("listA7", listA7);
			request.setAttribute("decribePhotographer", dp);

			RequestDispatcher dispatcher = request.getRequestDispatcher("form/tongquanalbum.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {

			String follow = iaopd.numberOfFollow(idPhoto);
			Photographer photo = iaopd.getInfo(idPhoto);
			String name = photo.getFullName();
			String quymo = photo.getOrganize();
			String placeOfWork = photo.getWorkPlace();
			String avata = photo.getAvata();
			String email = photo.getEmail();
			String role = photo.getRoleId();
			String idp = photo.getId();
			String provinceName = ld.getLocationByCode(placeOfWork).getLocationName();
			System.out.println(provinceName);
			System.out.println("avata:"+avata);
			request.setAttribute("name", name);
			request.setAttribute("quymo", quymo);
			request.setAttribute("placeOfWork", provinceName);
			request.setAttribute("avata", avata);
			request.setAttribute("emailphoto", email);
			request.setAttribute("rolephoto", role);
			request.setAttribute("idPhoto", idp);
			request.setAttribute("follow", follow);
			DecribePhotographer dp = iaopd.getDescribePhotographer(idPhoto);
			List<ServicePackage> listA1 = iaopd.listAlbumByCategory(idPhoto, "1");
			List<ServicePackage> listA2 = iaopd.listAlbumByCategory(idPhoto, "2");
			List<ServicePackage> listA3 = iaopd.listAlbumByCategory(idPhoto, "3");
			List<ServicePackage> listA4 = iaopd.listAlbumByCategory(idPhoto, "4");
			List<ServicePackage> listA5 = iaopd.listAlbumByCategory(idPhoto, "5");
			List<ServicePackage> listA6 = iaopd.listAlbumByCategory(idPhoto, "6");
			List<ServicePackage> listA7 = iaopd.listAlbumByCategory(idPhoto, "7");
			if (listA1.size() != 0) {
				System.out.println("+");
				request.setAttribute("off1", "no");
			}
			if (listA2.size() != 0) {
				System.out.println("+");
				request.setAttribute("off2", "no");
			}
			if (listA3.size() != 0) {
				System.out.println("+");
				request.setAttribute("off3", "no");
			}
			if (listA4.size() != 0) {
				System.out.println("+");
				request.setAttribute("off4", "no");
			}
			if (listA5.size() != 0) {
				System.out.println("+");
				request.setAttribute("off5", "no");
			}
			if (listA6.size() != 0) {
				System.out.println("+");
				request.setAttribute("off6", "no");
			}
			if (listA7.size() != 0) {
				System.out.println("+");
				request.setAttribute("off7", "no");
			}
			request.setAttribute("listA1", listA1);
			request.setAttribute("listA2", listA2);
			request.setAttribute("listA3", listA3);
			request.setAttribute("listA4", listA4);
			request.setAttribute("listA5", listA5);
			request.setAttribute("listA6", listA6);
			request.setAttribute("listA7", listA7);
			request.setAttribute("decribePhotographer", dp);
			RequestDispatcher dispatcher = request.getRequestDispatcher("form/tongquanalbum.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
