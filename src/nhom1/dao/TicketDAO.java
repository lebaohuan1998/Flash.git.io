package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nhom1.connection.ConnectionClass;
import nhom1.model.Car;
import nhom1.model.Ticket;
import nhom1.model.Trip;
import nhom1.ultility.TicketQuery;

public class TicketDAO {
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;
	private CarDAO cardao = new CarDAO();
	private TripDAO tripdao = new TripDAO();

	public boolean addTicket(Ticket tk) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(TicketQuery.INSERT_TICKET);
			preparedStmt.setString(1, tk.getCustomerName());
			preparedStmt.setString(2, tk.getLicensePlate());
			preparedStmt.setInt(3, tk.getTripId());
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
	public List<Ticket> getAllTicket() {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			List<Ticket> list = new ArrayList<>();
			preparedStmt = connection.prepareStatement(TicketQuery.GETALL_TICKET);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				int ticketId = rs.getInt("ticket_id");
				String bookingTime = rs.getString("ticket_booking_time");
				String customerName = rs.getString("ticket_customer_name");
				String licensePlate = rs.getString("ticket_license_plate");
				int tripId = rs.getInt("ticket_trip_id");
//				String carColor = rs.getString("car_color");
//				String carType = rs.getString("car_type");
//				String carCompany = rs.getString("car_company");
//				String tripDate = rs.getString("trip_departure_date");
//				String tripDTime = rs.getString("trip_departure_time");
//				String destination = rs.getString("trip_destination");
//				String driver = rs.getString("trip_driver");
//				Ticket tk = new Ticket(ticketId, bookingTime, customerName, new Car(licensePlate, carColor, carType, carCompany, null), new Trip(tripId,carType, tripDate, tripDTime, destination, driver, 0));
				Ticket tk = new Ticket(ticketId, bookingTime, customerName, licensePlate, tripId);
				list.add(tk);
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
	public boolean deleteTicket(int id) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(TicketQuery.DELETE_TICKET);
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
	public List<Ticket> getTicketByCustomerName(String name) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			List<Ticket> list = new ArrayList<>();
			preparedStmt = connection.prepareStatement(TicketQuery.SEARCH_TICKET);
			preparedStmt.setString(1, "%" + name + "%");
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				int ticketId = rs.getInt("ticket_id");
				String bookingTime = rs.getString("ticket_booking_time");
				String customerName = rs.getString("ticket_customer_name");
				String licensePlate = rs.getString("ticket_license_plate");
				int tripId = rs.getInt("ticket_trip_id");
//				String carColor = rs.getString("car_color");
//				String carType = rs.getString("car_type");
//				String carCompany = rs.getString("car_company");
//				String tripDate = rs.getString("trip_departure_date");
//				String tripDTime = rs.getString("trip_departure_time");
//				String destination = rs.getString("trip_destination");
//				String driver = rs.getString("trip_driver");
//				Ticket tk = new Ticket(ticketId, bookingTime, customerName, new Car(licensePlate, carColor, carType, carCompany, null), new Trip(tripId,carType, tripDate, tripDTime, destination, driver, 0));
				Ticket tk = new Ticket(ticketId, bookingTime, customerName, licensePlate, tripId);
				list.add(tk);
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
