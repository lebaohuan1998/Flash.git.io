package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import nhom1.connection.ConnectionClass;
import nhom1.model.Booking;
import nhom1.model.Complaint;
import nhom1.ultility.BookingQuery;
import nhom1.ultility.ComplaintQuery;

public class ComplaintDAO {

	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;
	
	public boolean createComplaint(Complaint c) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ComplaintQuery.INSERT_COMPLAINT);
		
			preparedStmt.setString(1, c.getUserId());
			preparedStmt.setString(2, c.getBookingId());
			preparedStmt.setString(3, c.getTitle());
			preparedStmt.setString(4, c.getContent());
			preparedStmt.setString(5, c.getNumberPhone());
			
			
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
	
	

	public int getStatusComplaint(int userId,String bookingId) {
		try {
			int statusId = 0;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ComplaintQuery.CHECK_STATUS_COMPLAINT);
			preparedStmt.setInt(1, userId);
			preparedStmt.setString(2, bookingId);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				statusId = rs.getInt("flagComplaint");
			}
			return statusId;
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
		return 0;
	}
	
	
	
	
	
	
	
}
