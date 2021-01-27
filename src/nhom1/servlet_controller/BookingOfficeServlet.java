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

import nhom1.dao.BookingOfficeDAO;
import nhom1.dao.CarDAO;
import nhom1.dao.TripDAO;
import nhom1.model.BookingOffice;
import nhom1.model.Trip;


/**
 * Servlet implementation class Controller
 */
@WebServlet("/BookingOfficeServlet")
public class BookingOfficeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookingOfficeDAO daoBookOffice;
	private TripDAO daoTrip;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void init() {
		daoBookOffice = new BookingOfficeDAO();
//		daoCar = new CarDAO();
		daoTrip = new TripDAO();
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
				listBookingOffice(request, response);
				break;
			case "ADD":
				addBookingOffice(request, response);
				break;
			case "LOAD_ADD":
				loadBookingOffice(request, response);
				break;
			case "UPDATE":
				updateBookingOffice(request, response);
				break;
			case "DELETE":
				deleteBookingOffice(request, response);
				break;
			case "SEARCH":
				searchBookingOffice(request, response);
				break;
			default:
				listBookingOffice(request, response);
			}
		} catch (Exception exc) {
			throw new ServletException(exc);
		}

	}

	private void searchBookingOffice(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("nameSearch");
		List<BookingOffice> list = daoBookOffice.getBookingOfficeByOfficeName(name);
		List<Trip> listT = daoTrip.getAllTrip();
		request.setAttribute("LIST_BOOKINGOFFICE", list);
		request.setAttribute("LIST_TRIP", listT);
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/table-booking-office.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteBookingOffice(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException {
		// TODO Auto-generated method stub
		int officeId = Integer.parseInt(request.getParameter("officeId"));
		daoBookOffice.deleteBookingOffice(officeId);
		response.sendRedirect(request.getContextPath() + "/BookingOfficeServlet?success="
				+ URLEncoder.encode("Delete successfuly", "UTF-8"));

	}

	private void updateBookingOffice(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void loadBookingOffice(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Trip> list = daoTrip.getAllTrip();
		request.setAttribute("LIST_TRIP", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/form-add-office.jsp");
		dispatcher.forward(request, response);

	}

	private void addBookingOffice(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, ServletException, IOException {
		// TODO Auto-generated method stub
		String endContractDeadline = request.getParameter("contractdeadlineTo");
		String officeName = request.getParameter("bookingofficename");
		String officePhone = request.getParameter("phonenumber");
		String officePlace = request.getParameter("place");
		double officePrice = Double.parseDouble(request.getParameter("price"));
		String startContractDeadline = request.getParameter("contractdeadlineFrom");
//		System.out.println(startContractDeadline + " ** " + endContractDeadline);

		int tripId = Integer.parseInt(request.getParameter("trip"));
		BookingOffice b = new BookingOffice(endContractDeadline, officeName, officePhone, officePlace, officePrice,
				startContractDeadline, tripId);
		if (daoBookOffice.addBookingOffice(b)) {
			response.sendRedirect(request.getContextPath() + "/BookingOfficeServlet?success="
					+ URLEncoder.encode("Add successfuly", "UTF-8"));
		} else {
			request.getRequestDispatcher(
					"/BookingOfficeServlet?command=LOAD_ADD&message=" + URLEncoder.encode("Something wrong", "UTF-8"))
					.forward(request, response);
		}

	}

	private void listBookingOffice(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			List<BookingOffice> list = daoBookOffice.getAllBookingOffice();
			List<Trip> listT = daoTrip.getAllTrip();
			request.setAttribute("LIST_BOOKINGOFFICE", list);
			request.setAttribute("LIST_TRIP", listT);
			// DIEN FILE JSP
			RequestDispatcher dispatcher = request.getRequestDispatcher("form/table-booking-office.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
