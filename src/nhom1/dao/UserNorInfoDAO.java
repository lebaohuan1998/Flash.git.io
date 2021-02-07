package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nhom1.connection.ConnectionClass;
import nhom1.model.Car;
import nhom1.model.NormalUser;
import nhom1.ultility.CarQuery;
import nhom1.ultility.NormalUserQuery;

public class UserNorInfoDAO {
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;
	
	
	
	public NormalUser getInfo(int id) {
		try {
			NormalUser nu = null;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(NormalUserQuery.GET_ALLINFOUSER);
			preparedStmt.setInt(1, id);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String email= rs.getString("email");
				String pwd= rs.getString("password");
				String name= rs.getString("fullName");
				String bod= rs.getString("bod");
				String address= rs.getString("address");
				String phone= rs.getString("phone");
				String gender= rs.getString("gender");
				String avata= rs.getString("avatar");
				nu= new NormalUser(name, pwd, phone, email, address, bod,avata);
				nu.setGender(gender);
			}
			return nu;
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
	
	public boolean updateInfo(NormalUser nu, int id) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(NormalUserQuery.UPDATE_USERNORMAL);
			preparedStmt.setString(1, nu.getFullName());
			preparedStmt.setString(2, nu.getBod());
			preparedStmt.setString(3, nu.getAddress());
			preparedStmt.setString(4, nu.getNumberPhone());
			preparedStmt.setString(5, nu.getGender());
			preparedStmt.setString(6, nu.getAvata());
			preparedStmt.setInt(7, id);
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
	public boolean updatePass( String pass, int id) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(NormalUserQuery.UPDATE_PASSWORD );
			preparedStmt.setString(1, pass);
			preparedStmt.setInt(2, id);
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
