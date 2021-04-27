package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import nhom1.connection.ConnectionClass;

import nhom1.model.ServicePackage;
import nhom1.ultility.FollowQuery;

public class FLowListServicePackageDAO {
	
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;
	DecimalFormat formatter = new DecimalFormat("###,###,###"); 
	
	public List<ServicePackage> listFollowServicePackage(int id, int paging) {
		try {
			List<ServicePackage> la = new ArrayList<>();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(FollowQuery.GET_LIST_SERVICEPACKET_PAGING);
			preparedStmt.setInt(1, id);
			preparedStmt.setInt(2, paging);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String servicePackageId = rs.getString("servicepackages.id");
				String nickName = rs.getString("photographers.nickName");
				int price = rs.getInt("servicepackages.price");
				String priceConvert= formatter.format(price);
				String deposit = rs.getString("servicepackages.deposit");
				String categoryName = rs.getString("categories.categoryName");
				String provinceName = rs.getString("provinces.provinceName");
				String coverImage = rs.getString("images.imageName");
				String servicePackageName = rs.getString("servicepackages.servicepackageName");
				String avatar = rs.getString("photographers.avatar");
				String roleId = rs.getString("photographers.roleId");
				String photographerId=rs.getString("photographers.id");
				float pointRating=rs.getFloat("servicepackages.pointRating");
				String numberRating = rs.getString("servicepackages.numberRating");
				ServicePackage a = new ServicePackage(servicePackageId,photographerId,roleId,provinceName, nickName,pointRating,numberRating,coverImage,avatar,servicePackageName,price,priceConvert);
			
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

	public int sizeOfListFollowServicePackage(int id) {
		try {
			int count = 0;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(FollowQuery.GET_SIZE_FOLLOW_SERVICEPACKAGE);
			preparedStmt.setInt(1, id);
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
	
	
	
	
	public boolean FollowServicePackage(String idServicePackage, String idUser) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(FollowQuery.FOLLOW_SERVICEPACKAGE);
			preparedStmt.setString(1, idServicePackage);
			preparedStmt.setString(2, idUser);
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
	
	
	

	
	public boolean UnfollowServicePackage(String idServicePackage, String idUser) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(FollowQuery.UNFOLLOW_SERVICEPACKAGE);
			preparedStmt.setString(1, idServicePackage);
			preparedStmt.setString(2, idUser);
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
	
	
	
	
	
	
	
	
	
	
	public boolean checkFollowSericePackage(String idServicePackage, String idUser) {
		try {
			int count =0;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(FollowQuery.CHECK_FOLLOW_SERVICEPACKAGE);
			preparedStmt.setString(1, idServicePackage);
			preparedStmt.setString(2, idUser);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("COUNT(*)");
			}
			if (count==0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
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
	}
	
	
}
