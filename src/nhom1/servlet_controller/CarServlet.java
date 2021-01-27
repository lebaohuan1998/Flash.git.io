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
import nhom1.dao.ParkingLotDAO;
import nhom1.model.BookingOffice;
import nhom1.model.Car;
import nhom1.model.ParkingLot;


/**
 * Servlet implementation class Controller
 */
@WebServlet("/CarServlet")
public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarDAO carDao;
	private ParkingLotDAO parkinglotDao;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void init() {
		 carDao = new CarDAO();
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
				listCar(request, response);
				break;
			case "ADD":
				addCar(request, response);
				break;
			case "LOAD_ADD":
				loadCar(request, response);
				break;
			case "UPDATE":
				updateCar(request, response);
				break;
			case "LOAD_UPDATE":
				updateLoad(request, response);
				break;
			case "DELETE":
				deleteCar(request, response);
				break;
			case "SEARCH":
				searchCar(request, response);
				break;
			default:
				listCar(request, response);
			}
		} catch (Exception exc) {
			throw new ServletException(exc);
		}

	}

	private void searchCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("nameSearch");
		List<Car> list = carDao.getCarByLicense(name);
		request.setAttribute("LIST_CAR", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/table-car.jsp");
		dispatcher.forward(request, response);	
	}

	private void updateLoad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lisencePlate = request.getParameter("licensePlate");
		Car car = carDao.getCarById(lisencePlate);
		List<ParkingLot> parkingLot = parkinglotDao.getAllParkingLot();	
		request.setAttribute("CAR", car);			
		request.setAttribute("LIST_PARKING_LOT", parkingLot);		
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/form-add-car.jsp");
		dispatcher.forward(request, response);
		
	}

	private void deleteCar(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException {
		// TODO Auto-generated method stub
		String licensePlate = request.getParameter("licensePlate");	
//		System.out.println(carDao.deleteCar(licensePlate));
		if(carDao.deleteCar(licensePlate)) {
			response.sendRedirect(request.getContextPath() + "/CarServlet?success=" + URLEncoder.encode("Delete successfuly", "UTF-8"));
			
		} else {
			response.sendRedirect(request.getContextPath() + "/CarServlet?message=" + URLEncoder.encode("Can't delete", "UTF-8"));	
		}
		
	}

	private void updateCar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String licensePlate = request.getParameter("licensePlate");
		String carType = request.getParameter("carType");
		String carColor = request.getParameter("carColor");
		String carCompany = request.getParameter("company");
		Integer parkingLotId = Integer.parseInt(request.getParameter("parkingLot")) ;
		
//		Car car = new Car(licensePlate, carColor, carType, carCompany, parkinglotDao.getParkingLotById(parkingLotId));
		Car car = new Car(licensePlate, carColor, carType, carCompany, parkingLotId);
		if (carDao.updateCar(car, licensePlate)) {
			response.sendRedirect(request.getContextPath() + "/CarServlet");
		} else {				
			response.sendRedirect(request.getContextPath() + "/CarServlet?command=LOAD_UPDATE&licensePlate="+licensePlate+"&message="  + URLEncoder.encode("Something wrong", "UTF-8"));
		}	
		
	}

	private void loadCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		List<ParkingLot> parkingLot = parkinglotDao.getAllParkingLot();		
		request.setAttribute("LIST_PARKING_LOT", parkingLot);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/form-add-car.jsp");
		dispatcher.forward(request, response);
		
	}

	private void addCar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String licensePlate = request.getParameter("licensePlate");
		String carType = request.getParameter("carType");
		String carColor = request.getParameter("carColor");
		String carCompany = request.getParameter("company");
		Integer parkingLotId = Integer.parseInt(request.getParameter("parkingLot")) ;
		
//		Car car = new Car(licensePlate, carColor, carType, carCompany, parkinglotDao.getParkingLotById(parkingLotId));
		Car car = new Car(licensePlate, carColor, carType, carCompany, parkingLotId);
		if (carDao.addCar(car)) {
				response.sendRedirect(request.getContextPath() + "/CarServlet");
		} else {				
				request.getRequestDispatcher("/CarServlet?command=LOAD_ADD&message="  + URLEncoder.encode("Duplicate plate", "UTF-8")).forward(request, response);
		}			
	}

	private void listCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Car> list = carDao.getAllCar();
		List<ParkingLot> listP = parkinglotDao.getAllParkingLot();
		request.setAttribute("LIST_PARKING_LOT", listP);
		request.setAttribute("LIST_CAR", list);	
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/table-car.jsp");
		dispatcher.forward(request, response);		
	}
}
