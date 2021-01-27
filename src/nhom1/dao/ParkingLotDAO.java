package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nhom1.connection.ConnectionClass;
import nhom1.model.ParkingLot;
import nhom1.ultility.ParkingLotQuery;

public class ParkingLotDAO {
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;
	
	public boolean addParkingLot(ParkingLot park) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ParkingLotQuery.INSERT_PARK);
			preparedStmt.setInt(1, park.getParkArea());
			preparedStmt.setString(2, park.getParkName());
			preparedStmt.setString(3, park.getParkPlace());
			preparedStmt.setDouble(4, park.getParkPrice());
			preparedStmt.setString(5, park.getParkStatus());
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
	public List<ParkingLot> getAllParkingLot() {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			List<ParkingLot> list = new ArrayList<>();
			preparedStmt = connection.prepareStatement(ParkingLotQuery.GETALL_PARK);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				int parkId = rs.getInt("park_id");
				int parkArea = rs.getInt("park_area");
				String parkName = rs.getString("park_name");
				String parkPlace = rs.getString("park_place");
				double parkPrice = rs.getInt("park_price");
				String parkStatus = rs.getString("park_status");
				ParkingLot park = new ParkingLot(parkId, parkArea, parkName, parkPlace, parkPrice, parkStatus);
				list.add(park);
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
	public boolean deleteParkingLot(int id) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ParkingLotQuery.DELETE_PARK);
			preparedStmt.setInt(1, id);
			preparedStmt.execute();			
			if (preparedStmt.getUpdateCount()<1) {
				return false;
			}
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
	public List<ParkingLot> getParkingByName(String name) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			List<ParkingLot> list = new ArrayList<>();
			preparedStmt = connection.prepareStatement(ParkingLotQuery.SEARCH_PARK);
			preparedStmt.setString(1, "%" + name + "%");
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				int parkId = rs.getInt("park_id");
				int parkArea = rs.getInt("park_area");
				String parkName = rs.getString("park_name");
				String parkPlace = rs.getString("park_place");
				double parkPrice = rs.getInt("park_price");
				String parkStatus = rs.getString("park_status");
				ParkingLot park = new ParkingLot(parkId, parkArea, parkName, parkPlace, parkPrice, parkStatus);
				list.add(park);
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
	public ParkingLot getParkingLotById(int id) {
		try {
			ParkingLot park = null;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ParkingLotQuery.GETBYID_PARK);
			preparedStmt.setInt(1, id);
			rs = preparedStmt.executeQuery();
			if (rs.next()) {
				int parkId = rs.getInt("park_id");
				int parkArea = rs.getInt("park_area");
				String parkName = rs.getString("park_name");
				String parkPlace = rs.getString("park_place");
				double parkPrice = rs.getInt("park_price");
				String parkStatus = rs.getString("park_status");
				park = new ParkingLot(parkId, parkArea, parkName, parkPlace, parkPrice, parkStatus);
			}
			return park;
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
	public boolean updateParkingLot(ParkingLot park) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ParkingLotQuery.UPDATE_PARK);
			preparedStmt.setInt(1, park.getParkArea());
			preparedStmt.setString(2, park.getParkName());
			preparedStmt.setString(3, park.getParkPlace());
			preparedStmt.setDouble(4, park.getParkPrice());
			preparedStmt.setString(5, park.getParkStatus());
			preparedStmt.setInt(6, park.getParkId());
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
}
