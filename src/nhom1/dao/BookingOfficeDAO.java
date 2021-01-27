package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nhom1.connection.ConnectionClass;
import nhom1.model.BookingOffice;
import nhom1.model.Trip;
import nhom1.ultility.BookingOfficeQuery;

public class BookingOfficeDAO {
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;
	

	public boolean addBookingOffice(BookingOffice office) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(BookingOfficeQuery.INSERT_BO);
			preparedStmt.setString(1, office.getEndContractDeadline());
			preparedStmt.setString(2, office.getOfficeName());
			preparedStmt.setString(3, office.getOfficePhone());
			preparedStmt.setString(4, office.getOfficePlace());
			preparedStmt.setDouble(5, office.getOfficePrice());
			preparedStmt.setString(6, office.getStartContractDeadline());
			preparedStmt.setInt(7, office.getTripId());
			preparedStmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStmt != null) {
					preparedStmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public List<BookingOffice> getAllBookingOffice() {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			List<BookingOffice> list = new ArrayList<>();
			preparedStmt = connection.prepareStatement(BookingOfficeQuery.GETALL_BO);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				int officeId = rs.getInt("office_id");
				String endContractDeadline = rs.getString("office_end_contract_deadline");
				String officeName = rs.getString("office_name");
				String officePhone = rs.getString("office_phone");
				String officePlace = rs.getString("office_place");
				double officePrice = rs.getDouble("office_price");
				String startContractDeadline = rs.getString("office_start_contact_deadline");
				int tripId = rs.getInt("office_trip_id");				
//				int bookedTicketNumber = rs.getInt("trip_booked_ticket_number");
//				String carType = rs.getString("trip_car_type");
//				String departureDate = rs.getString("trip_departure_date");
//				String departureTime = rs.getString("trip_departure_time");
//				String destination = rs.getString("trip_destination");
//				String driver = rs.getString("trip_driver");
//				int maximumOnlineTicketNumber = rs.getInt("trip_maximum_online_ticket_number");
//				Trip trip = new Trip(tripId, bookedTicketNumber, carType, departureDate, departureTime, destination, driver, maximumOnlineTicketNumber);
//				BookingOffice office = new BookingOffice(officeId, endContractDeadline, officeName, officePhone, officePlace, officePrice, startContractDeadline, trip);
				BookingOffice office = new BookingOffice(officeId, endContractDeadline, officeName, officePhone, officePlace, officePrice, startContractDeadline, tripId);
				list.add(office);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStmt != null) {
					preparedStmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public boolean deleteBookingOffice(int id) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(BookingOfficeQuery.DELETE_BO);
			preparedStmt.setInt(1, id);
			preparedStmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStmt != null) {
					preparedStmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public List<BookingOffice> getBookingOfficeByOfficeName(String name) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			List<BookingOffice> list = new ArrayList<>();
			preparedStmt = connection.prepareStatement(BookingOfficeQuery.SEARCH_BO);
			preparedStmt.setString(1, "%" + name + "%");
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				int officeId = rs.getInt("office_id");
				String endContractDeadline = rs.getString("office_end_contract_deadline");
				String officeName = rs.getString("office_name");
				String officePhone = rs.getString("office_phone");
				String officePlace = rs.getString("office_place");
				double officePrice = rs.getDouble("office_price");
				String startContractDeadline = rs.getString("office_start_contact_deadline");
				int tripId = rs.getInt("office_trip_id");
//				int bookedTicketNumber = rs.getInt("trip_booked_ticket_number");
//				String carType = rs.getString("trip_car_type");
//				String departureDate = rs.getString("trip_departure_date");
//				String departureTime = rs.getString("trip_departure_time");
//				String destination = rs.getString("trip_destination");
//				String driver = rs.getString("trip_driver");
//				int maximumOnlineTicketNumber = rs.getInt("trip_maximum_online_ticket_number");
//				Trip trip = new Trip(tripId, bookedTicketNumber, carType, departureDate, departureTime, destination, driver, maximumOnlineTicketNumber);
//				BookingOffice office = new BookingOffice(officeId, endContractDeadline, officeName, officePhone, officePlace, officePrice, startContractDeadline, trip);
				BookingOffice office = new BookingOffice(officeId, endContractDeadline, officeName, officePhone, officePlace, officePrice, startContractDeadline, tripId);
				list.add(office);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStmt != null) {
					preparedStmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}
}
