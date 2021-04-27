package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nhom1.connection.ConnectionClass;
import nhom1.model.MapPhoto;
import nhom1.ultility.MapPhotoQuery;

public class MapPhotographerDAO {
	
	
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;
	
	public MapPhoto getInfo(String idp) {
		try {
			MapPhoto mp= new MapPhoto();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(MapPhotoQuery.GETINFOMAPPHOTO);
			preparedStmt.setString(1, idp);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String id= rs.getString("photographerId");
				String locationx= rs.getString("locationx");
				String locationy= rs.getString("locationy");
				mp = new MapPhoto(id,locationx, locationy);
			}
			return mp;
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
	public List<MapPhoto> getAllInfo() {
		List<MapPhoto> listm =new ArrayList<>();
		try {
			MapPhoto mp= new MapPhoto();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(MapPhotoQuery.GETALLINFO);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String id= rs.getString("photographerId");
				String locationx= rs.getString("locationx");
				String locationy= rs.getString("locationy");
				mp = new MapPhoto(id,locationx, locationy);
				listm.add(mp);
			}
			return listm;
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
	public MapPhoto getLocationPhotographerById(String id) {
		List<MapPhoto> listm =new ArrayList<>();
		try {
			MapPhoto mp= new MapPhoto();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(MapPhotoQuery.GETALLINFOBYID);
			preparedStmt.setString(1, id);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String idPhoto= rs.getString("photographerId");
				String locationx= rs.getString("locationx");
				String locationy= rs.getString("locationy");
				mp = new MapPhoto(idPhoto,locationx, locationy);
			}
			return mp;
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
