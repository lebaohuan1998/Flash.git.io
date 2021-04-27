package nhom1.servlet_controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nhom1.dao.ManagermentAdminDAO;
import nhom1.model.User;

/**
 * Servlet implementation class ManagermentEmployeeAdmin
 */
@WebServlet("/ManagermentAdminSystem")
public class AdminHomepageSystemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManagermentAdminDAO mad = new ManagermentAdminDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminHomepageSystemController() {
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
			case "LOCKUSER":
				updateLockUser(request, response);
				break;
			case "LOCKADMIN":
				updateLockAdmin(request, response);
				break;
			case "LOCKPHOTO":
				updateLockPhoto(request, response);
				break;
			case "ROLE":
				updateRole(request, response);
				break;
			}
		} catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	private void updateRole(HttpServletRequest request, HttpServletResponse response) {
		String role = request.getParameter("role");
		System.out.println("role:" + role);
		String arr = request.getParameter("arr");
		arr = arr.substring(2, arr.length() - 2);
		String id[] = arr.split("\",\"");
		for (int i = 0; i < id.length; i++) {
			mad.updateRole(role, id[i]);
		}
	}

	private void updateLockPhoto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		// TODO Auto-generated method stub
		String id = request.getParameter("idphoto");
		String statusId = request.getParameter("statusId");
		mad.updateStatusPhotographer(statusId, id);
		request.setAttribute("show", "1");
		showAccount(request, response);
	}

	private void updateLockAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		// TODO Auto-generated method stub
		String id = request.getParameter("idadmin");
		String statusId = request.getParameter("statusId");
		mad.updateStatusUser(statusId, id);
		request.setAttribute("show", "2");
		showAccount(request, response);
	}

	private void updateLockUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		// TODO Auto-generated method stub
		String id = request.getParameter("iduser");
		String statusId = request.getParameter("statusId");
		mad.updateStatusUser(statusId, id);
		request.setAttribute("show", "3");
		showAccount(request, response);

	}

	private void updateMaintenance(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dis = request.getRequestDispatcher("/homepageAdmin.jsp");
		dis.forward(request, response);
	}

	private void showAccount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {

		String pagePhoto = request.getParameter("pagephoto");
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
		}
		for (int i = 0; i < numberPageUser; i++) {
			listPageUser.add(i);
		}
		request.setAttribute("listPageUser", listPageUser);
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
		}
		for (int i = 0; i < numberPageAdmin; i++) {
			listPageAdmin.add(i);
		}
		request.setAttribute("listPageAdmin", listPageAdmin);

		RequestDispatcher dis = request.getRequestDispatcher("/homepageAdmin.jsp");
		dis.forward(request, response);
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
