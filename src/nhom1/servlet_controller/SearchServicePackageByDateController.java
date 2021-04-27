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
import javax.servlet.http.HttpSession;

import nhom1.dao.LocationDAO;
import nhom1.dao.SearchServicePackageDAO;
import nhom1.model.Location;
import nhom1.model.ServicePackage;

/**
 * Servlet implementation class SearchServicePackageByDate
 */
@WebServlet("/SearchServicePackageByDate")
public class SearchServicePackageByDateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SearchServicePackageDAO sspd = new SearchServicePackageDAO();
	private LocationDAO ld = new LocationDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServicePackageByDateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			case "SearchByDate":
				searchServicePackageByDate(request, response);
				break;
			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	private void showSevicePackage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/loctheloaialbum.jsp");
		dispatcher.forward(request, response);
		session.setAttribute("dateSearch", "");
		session.setAttribute("listLocation", null);
		session.setAttribute("price", "0");
		session.setAttribute("textSearch", "");
		session.setAttribute("placeId", "0");
		session.setAttribute("categoryId", "0");
		session.setAttribute("dateSearch", "");
		session.setAttribute("sort", null);
	}

	private void searchServicePackageByDate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		String sort = request.getParameter("sort");
		String textSearch = request.getParameter("textSearch");
		String place = request.getParameter("place");
		String category = request.getParameter("category");
		String price = request.getParameter("price");
		String date = request.getParameter("dateSearch");
		String paging = request.getParameter("page");
		
		
		System.out.println(textSearch+"|"+place+"|"+category+"|"+price+"|"+date+"|"+sort);
		
		List<ServicePackage> listServicePackages = new ArrayList<>();
		int count = sspd.countServicePakage(Integer.parseInt(place), Integer.parseInt(category),
				Integer.parseInt(price),textSearch,date);
		List<Integer> listPage = new ArrayList<>();

		int numberPage = count / 9;
		if (count % 9 != 0) {
			numberPage = numberPage + 1;
		}
		for (int i = 0; i < numberPage; i++) {
			listPage.add(i);
		}
		if(paging==null) {
			paging="1";
			session.setAttribute("listPage", listPage);
			listServicePackages = sspd.searchPackage(Integer.parseInt(place), Integer.parseInt(category),
					Integer.parseInt(price), (Integer.parseInt(paging)-1)*9,textSearch,date,sort);
			session.setAttribute("result", listServicePackages);
			session.setAttribute("size", count);
			session.setAttribute("numberPage", numberPage);
			List<Location> listL = new ArrayList<>();
			listL = ld.listLocation();
			session.setAttribute("listLocation", listL);
			session.setAttribute("price", price);
			session.setAttribute("textSearch", textSearch);
			session.setAttribute("placeId", place);
			session.setAttribute("categoryId", category);
			session.setAttribute("dateSearch", date);
			session.setAttribute("sort", sort);
		}else {
			request.setAttribute("listPage", listPage);
			listServicePackages = sspd.searchPackage(Integer.parseInt(place), Integer.parseInt(category),
					Integer.parseInt(price), (Integer.parseInt(paging)-1)*9,textSearch,date,sort);
			request.setAttribute("result", listServicePackages);
			request.setAttribute("size", count);
			request.setAttribute("numberPage", numberPage);
			List<Location> listL = new ArrayList<>();
			listL = ld.listLocation();
			request.setAttribute("listLocation", listL);
			request.setAttribute("price", price);
			request.setAttribute("textSearch", textSearch);
			request.setAttribute("placeId", place);
			request.setAttribute("categoryId", category);
			request.setAttribute("dateSearch", date);
			request.setAttribute("sort", sort);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/loctheloaialbum.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
