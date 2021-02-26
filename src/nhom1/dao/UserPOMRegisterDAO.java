package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import nhom1.connection.ConnectionClass;
import nhom1.model.PhotographerOrModel;
import nhom1.ultility.PhotoOrModelQuery;

public class UserPOMRegisterDAO {

	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;

	public boolean RegisterPOM(PhotographerOrModel pom) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.INSERT_USER);
			preparedStmt.setString(1, pom.getEmail());
			preparedStmt.setString(2, pom.getFullName());
			preparedStmt.setString(3, pom.getNgheDanh());
			preparedStmt.setString(4, pom.getPassword());
			preparedStmt.setString(5, pom.getPhone());
			preparedStmt.setString(6, pom.getTcc());
			preparedStmt.setString(7, pom.getAddress());
			preparedStmt.setString(8, pom.getRole());
			preparedStmt.setString(9, pom.getTokenEmail());
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
	
	//check mail duplicate
	public boolean checkEmailDupplicate(String email) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.GETEMAIL);
			preparedStmt.setString(1, email);
			rs=preparedStmt.executeQuery();
			String e="";
			while (rs.next()) {
				e = rs.getString("email");
			}
			if(e.isEmpty()) {
				return false;
			}else {
				return true;
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
