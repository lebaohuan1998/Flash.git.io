package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nhom1.connection.ConnectionClass;
import nhom1.model.Trip;
import nhom1.ultility.TripQuery;

public class TripDAO {
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;

	public boolean addTrip(Trip trip) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(TripQuery.INSERT_TRIP);
			preparedStmt.setInt(1, trip.getBookedTicketNumber());
			preparedStmt.setString(2, trip.getCarType());
			preparedStmt.setString(3, trip.getDepartureDate());
			preparedStmt.setString(4, trip.getDepartureTime());
			preparedStmt.setString(5, trip.getDestination());
			preparedStmt.setString(6, trip.getDriver());
			preparedStmt.setInt(7, trip.getMaximumOnlineTicketNumber());
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
	public List<Trip> getAllTrip() {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			List<Trip> list = new ArrayList<>();
			preparedStmt = connection.prepareStatement(TripQuery.GETALL_TRIP);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				int tripId = rs.getInt("trip_id");
				int bookedTicketNumber = rs.getInt("trip_booked_ticket_number");
				String carType = rs.getString("trip_car_type");
				String departureDate = rs.getString("trip_departure_date");
				String departureTime = rs.getString("trip_departure_time");
				String destination = rs.getString("trip_destination");
				String driver = rs.getString("trip_driver");
				int maximumOnlineTicketNumber = rs.getInt("trip_maximum_online_ticket_number");
				Trip trip = new Trip(tripId, bookedTicketNumber, carType, departureDate, departureTime, destination, driver, maximumOnlineTicketNumber);
				list.add(trip);
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
	public boolean deleteTrip(int id) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(TripQuery.DELETE_TRIP);
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
	public List<Trip> getTripByDriver(String name) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			List<Trip> list = new ArrayList<>();
			preparedStmt = connection.prepareStatement(TripQuery.SEARCH_TRIP);
			preparedStmt.setString(1, "%" + name + "%");
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				int tripId = rs.getInt("trip_id");
				int bookedTicketNumber = rs.getInt("trip_booked_ticket_number");
				String carType = rs.getString("trip_car_type");
				String departureDate = rs.getString("trip_departure_date");
				String departureTime = rs.getString("trip_departure_time");
				String destination = rs.getString("trip_destination");
				String driver = rs.getString("trip_driver");
				int maximumOnlineTicketNumber = rs.getInt("trip_maximum_online_ticket_number");
				Trip trip = new Trip(tripId, bookedTicketNumber, carType, departureDate, departureTime, destination, driver, maximumOnlineTicketNumber);
				list.add(trip);
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
	public Trip getTripById(int id) {
		try {
			Trip trip = null;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(TripQuery.GET_TRIP_BY_ID);
			preparedStmt.setInt(1, id);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				int tripId = rs.getInt("trip_id");
				int bookedTicketNumber = rs.getInt("trip_booked_ticket_number");
				String carType = rs.getString("trip_car_type");
				String departureDate = rs.getString("trip_departure_date");
				String departureTime = rs.getString("trip_departure_time");
				String destination = rs.getString("trip_destination");
				String driver = rs.getString("trip_driver");
				int maximumOnlineTicketNumber = rs.getInt("trip_maximum_online_ticket_number");
				trip = new Trip(tripId, bookedTicketNumber, carType, departureDate, departureTime, destination, driver, maximumOnlineTicketNumber);
			}
			
			return trip;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
