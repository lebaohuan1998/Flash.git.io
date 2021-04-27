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

import nhom1.dao.HomePageDAO;
import nhom1.dao.LocationDAO;
import nhom1.model.Location;

/**
 * Servlet implementation class HomePageServlet
 */
@WebServlet("/HomePageServlet")
public class HomepageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HomePageDAO hpd= new HomePageDAO();
	private LocationDAO ld = new LocationDAO();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomepageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Location> listL = new ArrayList<>();
		listL = ld.listLocation();
		request.setAttribute("listLocation", listL);
		request.setAttribute("listPhotoView", hpd.get10Photo());
		request.setAttribute("listArticleView", hpd.get8Article());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/home-page.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/home-page.jsp");
	}

}
