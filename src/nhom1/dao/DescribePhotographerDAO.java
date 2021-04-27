package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import nhom1.connection.ConnectionClass;
import nhom1.model.DecribePhotographer;
import nhom1.ultility.DescribePhotographerQuery;

public class DescribePhotographerDAO {
	
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;

	
	public DecribePhotographer getDescribe(int photographerID) {
		try {
			DecribePhotographer pom = null;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(DescribePhotographerQuery.GET_DESCRIBE);
			preparedStmt.setInt(1, photographerID);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
			
				String describe= rs.getString("describeText");
				String image1= rs.getString("imageFirst");
				String image2= rs.getString("imageSecond");
				
				pom= new DecribePhotographer( photographerID,describe,image1, image2);
			
				
			}
			return pom;
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
	
	
	
	
	
	
	public boolean updateDescribe(DecribePhotographer pom, int id) {
		// TODO Auto-generated method stub
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(DescribePhotographerQuery.UPDATE_DESCRIBE);
		
			
		
			preparedStmt.setInt(1,id);
			preparedStmt.setString(2, pom.getDescribe());
			preparedStmt.setString(3, pom.getImageFirst());
			preparedStmt.setString(4, pom.getImageSecond());
			preparedStmt.setInt(5, id);
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
	
	
	
	
	public int findPhotographerID(String email) {
		// TODO Auto-generated method stub
		try {
			int id=0;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(DescribePhotographerQuery.GET_ID);
			preparedStmt.setString(1, email);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
			
			 id= rs.getInt("id");
				
				
			}
			return id;
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
	
	
	
	
	
	
	
	

	public boolean insertFirstDescribe( int id) {
		// TODO Auto-generated method stub
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(DescribePhotographerQuery.Insert_Firt_Decribe);
		
			preparedStmt.setInt(1,id);
			preparedStmt.setString(2,null);
			preparedStmt.setString(3,null);
			preparedStmt.setString(4,null);
			
			
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
