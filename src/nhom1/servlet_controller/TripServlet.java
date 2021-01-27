package nhom1.servlet_controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nhom1.dao.CarDAO;
import nhom1.dao.TripDAO;
import nhom1.model.Car;
import nhom1.model.Trip;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/TripServlet")
public class TripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TripDAO daoTrip;
	private CarDAO daoCar;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void init() {
		daoTrip = new TripDAO();
		daoCar = new CarDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			// route to the appropriate method
			switch (theCommand) {
			case "LIST":
				listTrip(request, response);
				break;
			case "ADD":
				addTrip(request, response);
				break;
			case "LOAD_ADD":
				loadTrip(request, response);
				break;
			case "UPDATE":
				updateTrip(request, response);
				break;
			case "DELETE":
				deleteTrip(request, response);
				break;
			case "SEARCH":
				searchTrip(request, response);
				break;
			default:
				listTrip(request, response);
			}
		} catch (Exception exc) {
			throw new ServletException(exc);
		}

	}

	private void searchTrip(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("nameSearch");
		List<Trip> list = daoTrip.getTripByDriver(name);
		request.setAttribute("LIST_TRIP", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/table-trip.jsp");
		dispatcher.forward(request, response);
		
	}

	private void deleteTrip(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int tripId = Integer.parseInt(request.getParameter("tripID"));
		daoTrip.deleteTrip(tripId);
		listTrip(request, response);
	}

	private void updateTrip(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void loadTrip(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		List<Car> listCar = daoCar.getAllCar();
		request.setAttribute("LIST_CAR", listCar);
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/form-add-trip.jsp");
		dispatcher.forward(request, response);
	}

	private void addTrip(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, ServletException, IOException {
		// TODO Auto-generated method stub
		String carType = request.getParameter("carType");
		String departureDate = request.getParameter("departureDate");
		String departureTime = request.getParameter("departureTime");
		String destination = request.getParameter("destination");
		String driver = request.getParameter("driver");
		int maximumOnlineTicketNumber = Integer.parseInt(request.getParameter("maximumOnlineTicketNumber"));
		Trip t = new Trip(carType, departureDate, departureTime, destination, driver, maximumOnlineTicketNumber);
		if (daoTrip.addTrip(t)) {
			listTrip(request, response);
		} else {
			request.getRequestDispatcher("/TripServlet?command=LOAD_ADD&message="  + URLEncoder.encode("Something wrong", "UTF-8")).forward(request, response);	
		}
		
	}

	private void listTrip(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			List<Trip> list = daoTrip.getAllTrip();			
			request.setAttribute("LIST_TRIP", list);
			// DIEN FILE JSP
			RequestDispatcher dispatcher = request.getRequestDispatcher("form/table-trip.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
