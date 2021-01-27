package test;

import java.sql.SQLException;

import nhom1.connection.ConnectionClass;
import nhom1.dao.BookingOfficeDAO;
import nhom1.dao.CarDAO;
import nhom1.dao.ParkingLotDAO;
import nhom1.dao.TripDAO;
import nhom1.model.BookingOffice;
import nhom1.model.ParkingLot;
import nhom1.model.Trip;

public class Test {

	public static void main(String[] args) throws SQLException {
		ConnectionClass.createConnect();
		CarDAO testCar = new CarDAO();
		ParkingLotDAO testParking = new ParkingLotDAO();
		TripDAO testTrip = new TripDAO();
		BookingOfficeDAO bookingOffice = new BookingOfficeDAO();
		System.out.println(ConnectionClass.createConnect().toString());
		System.out.println(testCar.getAllCar().toString());	
		System.out.println(testTrip.getAllTrip().toString());
		System.out.println(bookingOffice.getAllBookingOffice().toString());
		
//		System.out.println(testParking.addParkingLot(new ParkingLot(200, "oof", "Binh", 2000.0, "he")));
//		System.out.println(testTrip.addTrip(new Trip(10,"sedam","2020","12:00","das","asd",332)));
//		System.out.println(testParking.deleteParkingLot(1111111));
//		System.out.println(bookingOffice.addBookingOffice(new BookingOffice("","")));
//		System.out.println(testCar.deleteCar("22b-30598"));
	}

}
