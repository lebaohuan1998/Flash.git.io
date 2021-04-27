package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nhom1.connection.ConnectionClass;
import nhom1.model.Location;
import nhom1.ultility.LocationQuery;

public class LocationDAO {
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;

	public List<Location> listLocation() {
		try {
			List<Location> ll = new ArrayList<>();
			;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(LocationQuery.GETLOCATION);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String locationId = rs.getString("id");
				String locationName = rs.getString("provinceName");
				String province_coordinatesx = rs.getString("province_coordinatesx");
				String province_coordinatesy = rs.getString("province_coordinatesy");
				Location l = new Location(locationId, locationName, province_coordinatesx, province_coordinatesy);
				ll.add(l);
			}
			return ll;
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

	public Location getLocationByCode(String code) {
		try {
			Location l = new Location();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(LocationQuery.GETLOCATIONNAME);
			preparedStmt.setString(1, code);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String locationId = rs.getString("provinces.id");
				String locationName = rs.getString("provinces.provinceName");
				l = new Location(locationId, locationName);
			}
			return l;
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
