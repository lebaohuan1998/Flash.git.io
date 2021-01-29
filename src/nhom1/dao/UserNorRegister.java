package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import nhom1.connection.ConnectionClass;
import nhom1.model.NormalUser;
import nhom1.ultility.NormalUserQuery;

public class UserNorRegister {

	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;

	public boolean Register(NormalUser u) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(NormalUserQuery.INSERT_NORMALUSER);
			preparedStmt.setString(1, u.getEmail());
			preparedStmt.setString(2, u.getPass());
			preparedStmt.setString(3, u.getFullName());
			preparedStmt.setString(4, u.getNumberPhone());
			preparedStmt.setString(5, u.getRole());
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