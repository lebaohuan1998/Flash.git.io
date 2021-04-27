package nhom1.servlet_controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nhom1.dao.LocationDAO;
import nhom1.dao.SearchServicePackageDAO;
import nhom1.model.Location;
import nhom1.model.ServicePackage;

/**
 * Servlet implementation class SearchPhotographer
 */
@WebServlet("/searchServicePackage")
public class SearchServicePakageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SearchServicePackageDAO sspd = new SearchServicePackageDAO();
	private LocationDAO ld = new LocationDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServicePakageController() {
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
			String command = request.getParameter("command");
			if (command == null) {
				command = "Show";
			}
			switch (command) {
			case "Show":
				showSevicePackage(request, response);
				break;
			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void searchPhotographer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String textSearch ="";
		String placeId = request.getParameter("place");
		String categoryId = request.getParameter("category");
		String price = request.getParameter("price");
		List<ServicePackage> listServicePackages = new ArrayList<>();
		int count = sspd.countServicePakage(Integer.parseInt(placeId), Integer.parseInt(categoryId),
				Integer.parseInt(price),textSearch,"");
		List<Integer> listPage = new ArrayList<>();

		int numberPage = count / 9;
		if (count % 9 != 0) {
			numberPage = numberPage + 1;
		}
		for (int i = 0; i < numberPage; i++) {
			listPage.add(i);
		}
		request.setAttribute("listPage", listPage);
		System.out.println("số trang :" + count);
		listServicePackages = sspd.searchPackage(Integer.parseInt(placeId), Integer.parseInt(categoryId),
				Integer.parseInt(price), 0,textSearch,"","");
		request.setAttribute("result", listServicePackages);
		request.setAttribute("size", count);
		request.setAttribute("numberPage", numberPage);
		List<Location> listL = new ArrayList<>();
		listL = ld.listLocation();
		request.setAttribute("listLocation", listL);
		request.setAttribute("price", price);
		request.setAttribute("placeId", placeId);
		request.setAttribute("categoryId", categoryId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/loctheloaialbum.jsp");
		dispatcher.forward(request, response);
	}

	private void showSevicePackage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String textSearch = request.getParameter("textSearch");
		if(textSearch==null) {
			textSearch="";
		}
		System.out.println("huan:"+textSearch);
		String placeId = request.getParameter("place");
		String categoryId = request.getParameter("category");
		String price = request.getParameter("price");
		String paging = request.getParameter("page");
		int count = sspd.countServicePakage(Integer.parseInt(placeId), Integer.parseInt(categoryId),
				Integer.parseInt(price),textSearch,"");
		List<Integer> listPage = new ArrayList<>();

		int numberPage = count / 9;
		if (count % 9 != 0) {
			numberPage = numberPage + 1;
		}
		for (int i = 0; i < numberPage; i++) {
			listPage.add(i);
		}
		request.setAttribute("listPage", listPage);
		List<ServicePackage> listServicePackages = new ArrayList<>();

		listServicePackages = sspd.searchPackage(Integer.parseInt(placeId), Integer.parseInt(categoryId),
				Integer.parseInt(price), (Integer.parseInt(paging) - 1) * 9,textSearch,"","");
		request.setAttribute("result", listServicePackages);
		request.setAttribute("size", count);
		request.setAttribute("numberPage", numberPage);
		List<Location> listL = new ArrayList<>();
		listL = ld.listLocation();
		request.setAttribute("listLocation", listL);
		request.setAttribute("price", price);
		request.setAttribute("placeId", placeId);
		request.setAttribute("textSearch", textSearch);
		request.setAttribute("categoryId", categoryId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/loctheloaialbum.jsp");
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
			String command = request.getParameter("command");
			if (command == null) {
				command = "Show";
			}
			switch (command) {
			case "Show":
				showSevicePackage(request, response);
				break;
			case "Search":
				searchPhotographer(request, response);
				break;
			case "SearchAdvanced":
				searchAdvancedPhotographer(request, response);
				break;
			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}

	}

	private void searchAdvancedPhotographer(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		    String textSearch = request.getParameter("textSearch");
		    System.out.println(textSearch);
			String placeId = request.getParameter("place");
			String categoryId = request.getParameter("category");
			String price = request.getParameter("price");
			List<ServicePackage> listServicePackages = new ArrayList<>();
			int count = sspd.countServicePakage(Integer.parseInt(placeId), Integer.parseInt(categoryId),
					Integer.parseInt(price),textSearch,"");
			List<Integer> listPage = new ArrayList<>();

			int numberPage = count / 9;
			if (count % 9 != 0) {
				numberPage = numberPage + 1;
			}
			for (int i = 0; i < numberPage; i++) {
				listPage.add(i);
			}
			request.setAttribute("listPage", listPage);
			System.out.println("số trang :" + count);
			listServicePackages = sspd.searchPackage(Integer.parseInt(placeId), Integer.parseInt(categoryId),
					Integer.parseInt(price), 0,textSearch,"","");
			request.setAttribute("result", listServicePackages);
			request.setAttribute("size", count);
			request.setAttribute("numberPage", numberPage);
			List<Location> listL = new ArrayList<>();
			listL = ld.listLocation();
			request.setAttribute("textSearch", textSearch);
			request.setAttribute("listLocation", listL);
			request.setAttribute("price", price);
			request.setAttribute("placeId", placeId);
			request.setAttribute("categoryId", categoryId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("form/loctheloaialbum.jsp");
			dispatcher.forward(request, response);
		
		
	}

}
