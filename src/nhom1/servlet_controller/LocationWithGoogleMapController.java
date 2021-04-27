package nhom1.servlet_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom1.dao.LocationDAO;
import nhom1.dao.MapPhotographerDAO;
import nhom1.dao.PhotographerInfoDAO;
import nhom1.model.MapPhoto;

/**
 * Servlet implementation class LocationGGMap
 */
@WebServlet("/LocationGGMap")
public class LocationWithGoogleMapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LocationDAO ld =new LocationDAO();
	private PhotographerInfoDAO pid = new PhotographerInfoDAO();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationWithGoogleMapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("cmd");
			if(theCommand==null) {
				theCommand ="SHOW";
			}
			switch (theCommand) {
			case "SHOW":
				show(request, response);
				break;
			case "ADDCURRENTLOCATION":
				addCurrentLocation(request, response);
				break;
			
			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setAttribute("listLocation", ld.listLocation());
		RequestDispatcher dispatcher = request.getRequestDispatcher("googlemapaddress.jsp");
		dispatcher.forward(request, response);
	}

	private void addCurrentLocation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		
		String location = request.getParameter("arr");
		if(location!=null) {
			location = location.substring(11, location.length() - 2);
			String xy[] = location.split(",\n"
					+ "  \"lng\": ");
				System.out.println(xy[0]);
				System.out.println(xy[1]);
				String lat= xy[0];
				String lng= xy[1];
				pid.updateMapLocation(lat, lng, id);
		}else {
			System.out.println("bạn chưa chọn  địa điểm");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
