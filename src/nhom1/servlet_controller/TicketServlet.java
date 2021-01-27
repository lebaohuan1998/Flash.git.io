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
import nhom1.dao.TicketDAO;
import nhom1.dao.TripDAO;
import nhom1.model.Car;
import nhom1.model.ParkingLot;
import nhom1.model.Ticket;
import nhom1.model.Trip;

/**
 * Servlet implementation class TicketServlet
 */
@WebServlet("/TicketServlet")
public class TicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TicketDAO dao;
	private CarDAO carDao;
	private TripDAO tripDao;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void init() {
		dao = new TicketDAO();
		carDao = new CarDAO();
		tripDao = new TripDAO();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
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
				listTicket(request, response);
				break;
			case "ADD":
				addTicket(request, response);
				break;
			case "LOAD":
				loadTicket(request, response);				
				break;
			case "DELETE":
				deleteTicket(request, response);
				break;
			case "SEARCH":
				searchTicket(request, response);
				break;
			default:
				listTicket(request, response);
			}
		} catch (Exception exc) {
			throw new ServletException(exc);
		}

	}

	private void searchTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("nameSearch");
		List<Ticket> list = dao.getTicketByCustomerName(name);
		List<Trip> listT = tripDao.getAllTrip();
//		System.out.println(list);
		request.setAttribute("LIST_TICKET", list);
		request.setAttribute("LIST_TRIP", listT);
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/table-ticket.jsp");
		dispatcher.forward(request, response);
	}


	private void deleteTicket(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int ticketId = Integer.parseInt(request.getParameter("ticketId"));
		dao.deleteTicket(ticketId);
		listTicket(request, response);
	}


	private void loadTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Trip> listTrip = tripDao.getAllTrip();
//		System.out.println(listTrip);
		List<Car> listCar = carDao.getAllCar();
		
		request.setAttribute("LIST_TRIP", listTrip);
		request.setAttribute("LIST_CAR", listCar);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/form-add-ticket.jsp");
		dispatcher.forward(request, response);
		
	}

	private void addTicket(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException {
		// TODO Auto-generated method stub
		String customerName = request.getParameter("customerName");
		String licensePlate = request.getParameter("licensePlate");
		try {
			int tripId = Integer.parseInt(request.getParameter("trip"));
//			Ticket t = new Ticket(customerName, licensePlate, tripId);
			Ticket t = new Ticket(customerName, licensePlate, tripId);
			dao.addTicket(t);
			listTicket(request, response);
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/TicketServlet?command=LOAD&message="  + URLEncoder.encode("Something wrong, Try again", "UTF-8"));
		}
		
		
	}

	private void listTicket(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			List<Ticket> list = dao.getAllTicket();
			List<Trip> listT = tripDao.getAllTrip();
//			System.out.println(list);
			request.setAttribute("LIST_TICKET", list);
			request.setAttribute("LIST_TRIP", listT);
			// DIEN FILE JSP
			RequestDispatcher dispatcher = request.getRequestDispatcher("form/table-ticket.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
