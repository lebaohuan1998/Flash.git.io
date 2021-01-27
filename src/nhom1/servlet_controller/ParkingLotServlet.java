package nhom1.servlet_controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nhom1.dao.ParkingLotDAO;
import nhom1.model.Employee;
import nhom1.model.ParkingLot;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/ParkingLotServlet")
public class ParkingLotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ParkingLotDAO parkinglotDao;
	
	public void init() {
		 parkinglotDao = new ParkingLotDAO();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
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
				listParkingLot(request, response);
				break;
			case "ADD":
				addParkingLot(request, response);
				break;
			case "LOAD_ADD":
				loadParkingLot(request, response);
				break;
			case "UPDATE":
				updateParkingLot(request, response);
				break;
			case "LOAD_UPDATE":
				updateParkingLotLoad(request, response);
				break;
			case "DELETE":
				deleteParkingLot(request, response);
				break;
			case "SEARCH":
				searchParkingLot(request, response);
				break;
			default:
				listParkingLot(request, response);
			}
		} catch (Exception exc) {
			throw new ServletException(exc);
		}

	}

	private void searchParkingLot(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("nameSearch");
		List<ParkingLot> list = parkinglotDao.getParkingByName(name);
		request.setAttribute("LIST_PARKING_LOT", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/table-parking-lot.jsp");
		dispatcher.forward(request, response);
	}
	private void updateParkingLotLoad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("parkingLotID");		
		Integer parkingLotID = Integer.parseInt(id);
		if (parkingLotID == null | parkinglotDao.getParkingLotById(parkingLotID) == null) {
			response.sendRedirect(request.getContextPath() + "/ParkingLotServlet?message="  + URLEncoder.encode("Something wrong, Try again", "UTF-8"));
			System.out.println("not avaiabale");
		}else {
			ParkingLot parkingLot = parkinglotDao.getParkingLotById(parkingLotID);			
			request.setAttribute("PARKING_LOT", parkingLot);		
			RequestDispatcher dispatcher = request.getRequestDispatcher("form/form-add-parkinglot.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}


	private void deleteParkingLot(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("parkingLotID");		
		int parkingLotID = Integer.parseInt(id);
		if (parkinglotDao.deleteParkingLot(parkingLotID)) {
			response.sendRedirect(request.getContextPath() + "/ParkingLotServlet?success=" + URLEncoder.encode("Delete successfuly", "UTF-8"));
		} else {
			response.sendRedirect(request.getContextPath() + "/ParkingLotServlet?message=" + URLEncoder.encode("Can't delete", "UTF-8"));	
		}
		
	}

	private void updateParkingLot(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String parkingName = request.getParameter("parkingName");
		String place = request.getParameter("place");
		String parkingArea = request.getParameter("area");
		String parkingPrice = request.getParameter("price");
		String id = request.getParameter("parkingID");
		String status = request.getParameter("parkStatus");
		int parkingID = Integer.parseInt(id);
		ParkingLot parkingLot = new ParkingLot(parkingID,Integer.parseInt(parkingArea), parkingName, place, Double.parseDouble(parkingPrice),status);
		if (parkinglotDao.updateParkingLot(parkingLot)) {
			response.sendRedirect(request.getContextPath() + "/ParkingLotServlet");
		}else {
			request.getRequestDispatcher("/ParkingLotServlet?message="+ URLEncoder.encode("Something wrong", "UTF-8")).forward(request, response);
		}
		
	}

	private void loadParkingLot(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/form-add-parkinglot.jsp");
		dispatcher.forward(request, response);		
	}

	private void addParkingLot(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String parkingName = request.getParameter("parkingName");
		String place = request.getParameter("place");
		String parkingArea = request.getParameter("area");
		String parkingPrice = request.getParameter("price");
		ParkingLot parkingLot = new ParkingLot(Integer.parseInt(parkingArea), parkingName, place, Double.parseDouble(parkingPrice));
		if (parkinglotDao.addParkingLot(parkingLot)) {
			response.sendRedirect(request.getContextPath() + "/ParkingLotServlet");
		} else {
			request.getRequestDispatcher("/ParkingLotServlet?command=LOAD_ADD&message="  + URLEncoder.encode("Something wrong", "UTF-8")).forward(request, response);
		}
	}

	private void listParkingLot(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ParkingLot> list = parkinglotDao.getAllParkingLot();
		request.setAttribute("LIST_PARKING_LOT", list);		
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/table-parking-lot.jsp");
		dispatcher.forward(request, response);		
	}
}
