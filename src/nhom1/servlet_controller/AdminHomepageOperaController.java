package nhom1.servlet_controller;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom1.dao.ManagermentAdminDAO;
import nhom1.dao.PhotographerVerifycationDAO;
import nhom1.dao.ServicePackageDAO;
import nhom1.model.Photographer;

/**
 * Servlet implementation class HomepageAdminServlet
 */
@WebServlet("/ManagermentAdminOperator")
public class AdminHomepageOperaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManagermentAdminDAO mad = new ManagermentAdminDAO();
	private PhotographerVerifycationDAO pvd = new PhotographerVerifycationDAO();
	private ServicePackageDAO spd = new ServicePackageDAO();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminHomepageOperaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			// read the "command" parameter
			String command = request.getParameter("cmd");
			if (command == null) {
				command = "Employee";
			}
			switch (command) {
			case "Employee":
				showAccount(request, response);
				break;
			case "Maintenance":
				updateMaintenance(request, response);
				break;
			case "Verification":
				verificationPhotographer(request, response);
				break;
			case "ServicePackage":
				viewAllServicePackage(request, response);
				break;
			case "Image":
				viewAllImageOfServicePackage(request, response);
				break;
			case "Article":
				viewAllArticles(request, response);
				break;
			case "Comment":
				viewAllComments(request, response);
				break;
			case "BookingStatus":
				viewAllBookingStatus(request, response);
				break;
			case "Booking":
				viewAllBooking(request, response);
				break;
			case "Feedback":
				viewAllFeedback(request, response);
				break;
			case "InsertArticle":
				insertArticle(request, response);
				break;
			case "YIDENTITY":
				yIdentity(request, response);
				break;
			case "NIDENTITY":
				nIdentity(request, response);
				break;
			}
		} catch (Exception exc) {
			throw new ServletException(exc);
		}

	}

	private void nIdentity(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String idPhotographer = request.getParameter("idPhotographer");
		String idAdmin = request.getParameter("idAdmin");
		System.out.println(idPhotographer + "|" + idAdmin);
		mad.rejectIdentity(idPhotographer);

	}

	private void yIdentity(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String idPhotographer = request.getParameter("idPhotographer");
		String idAdmin = request.getParameter("idAdmin");
		System.out.println(idPhotographer + "|" + idAdmin);
		mad.acceptIdentity(idPhotographer);
		mad.identityPhotographer(idPhotographer, idAdmin);
	}

	private void insertArticle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/homepageAdmin.jsp");
		dispatcher.forward(request, response);
	}

	private void viewAllFeedback(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/homepageAdmin.jsp");
		dispatcher.forward(request, response);
	}

	private void viewAllBooking(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/homepageAdmin.jsp");
		dispatcher.forward(request, response);
	}

	private void viewAllBookingStatus(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/homepageAdmin.jsp");
		dispatcher.forward(request, response);
	}

	private void viewAllComments(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/homepageAdmin.jsp");
		dispatcher.forward(request, response);
	}

	private void viewAllArticles(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/homepageAdmin.jsp");
		dispatcher.forward(request, response);
	}

	private void viewAllImageOfServicePackage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("listServicePackage", spd.listImg(0)); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/homepageAdmin.jsp");
		dispatcher.forward(request, response);
	}

	private void viewAllServicePackage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	   request.setAttribute("listServicePackage", spd.listServicePackage(0)); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/homepageAdmin.jsp");
		dispatcher.forward(request, response);
	}

	private void verificationPhotographer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String status = request.getParameter("status");
		String txtSearch = request.getParameter("textSearch");
		if (status == null) {
			status = (String) session.getAttribute("status");
		}
		if (txtSearch == null) {
			txtSearch = (String) session.getAttribute("textSearch");
		}
		String page = request.getParameter("page");
		System.out.println(page);
		List<Photographer> listpPhotographers = new ArrayList<>();
		if (page == null) {
			page = "1";
		}
		List<Integer> listPage = new ArrayList<>();
		System.out.println(Integer.parseInt(mad.countPhotographerIdentity(status)));
		int numberPage = Integer.parseInt(mad.countPhotographerIdentity(status)) / 10;
		if (Integer.parseInt(mad.countPhotographerIdentity(status)) % 10 != 0) {
			numberPage = numberPage + 1;
			for (int i = 0; i < numberPage; i++) {
				listPage.add(i);
			}
			request.setAttribute("listPage", listPage);
		}
		session.setAttribute("status", status);
		session.setAttribute("textSearch", txtSearch);
		listpPhotographers = pvd.getInfo(status, txtSearch, (Integer.parseInt(page) - 1) * 10);
		session.setAttribute("listPhoto1", listpPhotographers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/homepageAdmin.jsp");
		dispatcher.forward(request, response);
	}

	private void updateMaintenance(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/homepageAdmin.jsp");
		dispatcher.forward(request, response);

	}

	private void showAccount(HttpServletRequest request, HttpServletResponse response)
			throws NumberFormatException, ParseException, ServletException, IOException {
		String pagePhoto = request.getParameter("pagephoto");
		request.setAttribute("opera", "yes");
		if (pagePhoto == null) {
			request.setAttribute("listPhoto", mad.listPhoto(0));
		} else {
			request.setAttribute("show", "1");
			request.setAttribute("listPhoto", mad.listPhoto((Integer.parseInt(pagePhoto) - 1) * 10));
		}
		String pageAdmin = request.getParameter("pageadmin");
		if (pageAdmin == null) {
			request.setAttribute("listAdmin", mad.listUser(2, 0));
		} else {
			request.setAttribute("show", "2");
			request.setAttribute("listAdmin", mad.listUser(2, (Integer.parseInt(pageAdmin) - 1) * 10));
		}
		String pageUser = request.getParameter("pageuser");
		if (pageUser == null) {
			request.setAttribute("listUser", mad.listUser(3, 0));
		} else {
			request.setAttribute("show", "3");
			request.setAttribute("listUser", mad.listUser(3, (Integer.parseInt(pageUser) - 1) * 10));
		}

		//
		request.setAttribute("numberuser", mad.countUser(3));
		request.setAttribute("numberadmin", mad.countUser(2));
		request.setAttribute("numberphoto", mad.countPhoto());
		//
		List<Integer> listPageUser = new ArrayList<>();
		List<Integer> listPagePhoto = new ArrayList<>();
		List<Integer> listPageAdmin = new ArrayList<>();

		int numberPageUser = Integer.parseInt(mad.countUser(3)) / 10;
		if (Integer.parseInt(mad.countUser(3)) % 10 != 0) {
			numberPageUser = numberPageUser + 1;
			for (int i = 0; i < numberPageUser; i++) {
				listPageUser.add(i);
			}
			request.setAttribute("listPageUser", listPageUser);
		}
		int numberPagePhoto = Integer.parseInt(mad.countPhoto()) / 10;
		System.out.println(Integer.parseInt(mad.countPhoto()));
		if (Integer.parseInt(mad.countPhoto()) % 10 != 0) {
			numberPagePhoto = numberPagePhoto + 1;
		}
		for (int i = 0; i < numberPagePhoto; i++) {
			listPagePhoto.add(i);
		}
		request.setAttribute("listPagePhoto", listPagePhoto);

		int numberPageAdmin = Integer.parseInt(mad.countUser(2)) / 10;
		if (Integer.parseInt(mad.countUser(2)) % 10 != 0) {
			numberPageAdmin = numberPageAdmin + 1;
			for (int i = 0; i < numberPageAdmin; i++) {
				listPageAdmin.add(i);
			}
			request.setAttribute("listPageAdmin", listPageAdmin);
		}

		RequestDispatcher dis = request.getRequestDispatcher("/homepageAdmin.jsp");
		dis.forward(request, response);

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
			String command = request.getParameter("cmd");
			if (command == null) {
				command = "Search";
			}
			switch (command) {
			case "Search":
				search(request, response);
				break;

			}
		} catch (Exception exc) {
			throw new ServletException(exc);
		}

	}

	private void search(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String txt = request.getParameter("txtsearch");
		System.out.println(txt);

	}

}
