package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nhom1.connection.ConnectionClass;
import nhom1.model.ServicePackage;
import nhom1.ultility.ServicePackageQuery;

public class ListServicePackageDAO {
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;

	public List<ServicePackage> listAlbum(int idPhoto, int paging) {
		try {
			List<ServicePackage> la = new ArrayList<>();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ServicePackageQuery.GETALBUMS);
			preparedStmt.setInt(1, idPhoto);
			preparedStmt.setInt(2, paging);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("servicepackages.id");
				String price = rs.getString("servicepackages.price");
				String deposit = rs.getString("servicepackages.deposit");
				String categoryName = rs.getString("categories.categoryName");
				String province = rs.getString("provinces.provinceName");
				String coverImage = rs.getString("images.imageName");
				String name = rs.getString("servicepackages.servicePackageName");
				String servicePackStatus = rs.getString("servicepackages.servicePackStatus");
				ServicePackage a = new ServicePackage();
				a.setId(id);
				a.setPrice(Integer.parseInt(price));
				a.setDeposit(Integer.parseInt(deposit));
				a.setCategoryName(categoryName);
				a.setProvinceName(province);
				a.setCoverImage(coverImage);
				a.setServicepackageName(name);
				a.setServicePackStatus(servicePackStatus);
				la.add(a);
			}
			return la;
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

	public int sizeOfListAlbum(String idPhoto) {
		try {
			int count = 0;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ServicePackageQuery.GETSIZE);
			preparedStmt.setString(1, idPhoto);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("COUNT(*)");
			}
			return count;
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
	public int sizeOfListAlbumByCategory(String idPhoto,String category) {
		try {
			int count = 0;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ServicePackageQuery.GETSIZEBYCATEGORY);
			preparedStmt.setString(1, idPhoto);
			preparedStmt.setString(2, category);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("COUNT(*)");
			}
			return count;
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

	public List<ServicePackage> getListAlbumByCategoryId(String categoryId,int idPhotographer, int page) {
		try {
			List<ServicePackage> la = new ArrayList<>();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ServicePackageQuery.GETALBUMSBYCATEGORY);
			preparedStmt.setString(1, categoryId);
			preparedStmt.setInt(2, idPhotographer);
			preparedStmt.setInt(3, page);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("servicepackages.id");
				String nghedanh = rs.getString("photographers.nickName");
				String price = rs.getString("servicepackages.price");
				String deposit = rs.getString("servicepackages.deposit");
				String categoryName = rs.getString("categories.categoryName");
				String province = rs.getString("provinces.provinceName");
				String coverImage = rs.getString("images.imageName");
				String name = rs.getString("servicepackages.servicepackageName");
				String servicePackStatus = rs.getString("servicepackages.servicePackStatus");
				ServicePackage a = new ServicePackage();
				a.setId(id);
				a.setNickName(nghedanh);
				a.setPrice(Integer.parseInt(price));
				a.setDeposit(Integer.parseInt(deposit));
				a.setCategoryName(categoryName);
				a.setProvinceName(province);
				a.setCoverImage(coverImage);
				a.setServicepackageName(name);
				a.setServicePackStatus(servicePackStatus);
				la.add(a);
			}
			return la;
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

	public boolean deleteAlbum(String id) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ServicePackageQuery.DELETEALBUM);
			preparedStmt.setString(1, id);
			preparedStmt.execute();
			if (preparedStmt.getUpdateCount() < 1) {
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

}
