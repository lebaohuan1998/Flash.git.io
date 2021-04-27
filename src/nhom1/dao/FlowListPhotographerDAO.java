package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nhom1.connection.ConnectionClass;
import nhom1.model.Photographer;


import nhom1.ultility.FollowQuery;

public class FlowListPhotographerDAO {
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;

	public List<Photographer> listPhotographer(int userID, int paging) {
		try {
			List<Photographer> la = new ArrayList<>();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(FollowQuery.GETFOLLOW_PAGING);
			preparedStmt.setInt(1, userID);
			preparedStmt.setInt(2, paging);
			//preparedStmt.setInt(3, paging+3);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String photographerId = String.valueOf(rs.getInt("follow_photographer.photographerId"));
				
				String nickName= rs.getString("photographers.nickName");
				String provinceId= rs.getString("provinces.provinceName");
				String roleId = rs.getString("photographers.roleId");
				String avatar = rs.getString("photographers.avatar");
				String organize= rs.getString ("photographers.organize");
				String countFollower= rs.getString("photographers.countFollower");
			
				Photographer a = new Photographer(photographerId,nickName,provinceId,organize,roleId,avatar,countFollower);
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

	public int sizeOfListFollow(int id) {
		try {
			int count = 0;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(FollowQuery.GET_SIZE_FOLLOW);
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

	public List<Photographer> getListFlowPhotographerById(int userId) {
		try {
			List<Photographer> la = new ArrayList<>();
			connection = ConnectionClass.createConnect().getConnection();
			//preparedStmt = connection.prepareStatement(FollowQuery.GET_LIST_PHOTOGRAPHER);
			preparedStmt.setInt(1, userId);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				
				int photographerId = rs.getInt("follow_photographer.photographerID");
				String photographerIDx= String.valueOf(photographerId) ;
				String nghedanh= rs.getString("photographerormodel.ngheDanh");
				String avatar = rs.getString("photographerormodel.avatar");
				String email = rs.getString("photographerormodel.email");
				String workAddress= rs.getString("photographerormodel.noilamviec");
				int countFollower= rs.getInt("photographerormodel.countFollower");
			
	//			PhotographerOrModel a = new PhotographerOrModel(photographerIDx,email,nghedanh,avatar,workAddress,countFollower);

//				la.add(a);
				
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
	
	
	public boolean unFollow(String idPhoto, String idUser) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(FollowQuery.UNFOLLOW);
			preparedStmt.setString(1, idPhoto);
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
	
	
	
	

	
}
