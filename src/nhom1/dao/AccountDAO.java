package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nhom1.connection.ConnectionClass;
import nhom1.model.Account;
import nhom1.model.Car;
import nhom1.ultility.AccountQuery;
import nhom1.ultility.BookingOfficeQuery;
import nhom1.ultility.CarQuery;

public class AccountDAO {
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;
	public boolean getAccountUser(String name, String pass){
		boolean status = false;
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(AccountQuery.GETACCOUNTUSER);
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, pass);
			ResultSet rs = preparedStmt.executeQuery();
			status = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	public boolean getAccountPhoto(String email, String pass){
		boolean status = false;
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(AccountQuery.GETACCOUNTPHOTO);
			preparedStmt.setString(1, email);
			preparedStmt.setString(2, pass);
			ResultSet rs = preparedStmt.executeQuery();
			status = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public Account getRoleUser(String name, String pass) {
		Account a = null;
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(AccountQuery.GETACCOUNTUSER);
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, pass);
			ResultSet rs = preparedStmt.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("users.id");
				String username = rs.getString("users.email");
				String password = rs.getString("users.password");
				String fullName = rs.getString("users.fullName");
				int role = rs.getInt("users.role");
				a = new Account(id, username, password,fullName, role);
			}
			return a;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	public Account getRolePhoto(String name, String pass) {
		Account a = null;
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(AccountQuery.GETACCOUNTPHOTO);
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, pass);
			ResultSet rs = preparedStmt.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("photographerormodel.id");
				String username = rs.getString("photographerormodel.email");
				String fullName = rs.getString("photographerormodel.fullName");
				String password = rs.getString("photographerormodel.password");
				int role = rs.getInt("photographerormodel.role");
				a = new Account(id, username, password,fullName, role);
			}
			return a;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
}
