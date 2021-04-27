package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nhom1.connection.ConnectionClass;
import nhom1.model.Images;
import nhom1.model.ServicePackage;
import nhom1.ultility.ServicePackageQuery;
import nhom1.ultility.ImageQuery;

public class ListImageDAO {
	
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;
	

	public List<Images> getListImages(String id) {
		
		try {
			 List<Images> listI= new ArrayList<>();;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ImageQuery.GET_IMAGE);
			preparedStmt.setString(1, id);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String idImage =rs.getString("images.id");
				String imageName = rs.getString("images.imageName");
				String idAlbum = rs.getString("images.servicePackageId");
				String coverImage = rs.getString("images.coverImage");
				Images i =new Images(imageName, idAlbum, coverImage);
				i.setId(idImage);
				listI.add(i);
			}
			return listI;
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
	
	

	public ServicePackage getOneServicePackageById(int id) {
		try {
			ServicePackage a = null;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ServicePackageQuery.GET_ONE_ALBUM_BYID);
			preparedStmt.setInt(1, id);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String serviceId = rs.getString("servicepackages.id");
				String servicepackageName = rs.getString("servicepackages.servicepackageName");
				String description = rs.getString("servicepackages.description");
				String category = rs.getString("servicepackages.categoryId");
				String shootingLocationID = rs.getString("servicepackages.shootingLocationId");
				String price = rs.getString("servicepackages.price");
				String deposit = rs.getString("servicepackages.deposit");
				String photographerID = rs.getString("servicepackages.photographerId");
				a = new ServicePackage(serviceId, servicepackageName, description, category, shootingLocationID, Integer.parseInt(price),Integer.parseInt(deposit) ,
						photographerID);
			}
			return a;
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
