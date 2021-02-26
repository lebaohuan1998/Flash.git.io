package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import nhom1.connection.ConnectionClass;
import nhom1.model.Account;
import nhom1.model.NormalUser;
import nhom1.model.PhotographerOrModel;
import nhom1.ultility.AccountQuery;
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
				String status= rs.getString("users.status");
				a = new Account(id, username, password,fullName, role);
				a.setStatus(status);
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
				String status= rs.getString("photographerormodel.status");
				a = new Account(id, username, password,fullName, role);
				a.setStatus(status);
			}
			return a;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	public NormalUser getActiveEmailUser(String name, String token){
		NormalUser a=null ;
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(AccountQuery.GETACTIVEEMAILUSER);
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, token);
			ResultSet rs = preparedStmt.executeQuery();
			if(rs.next()) {
				String id = rs.getString("users.id");
				String email = rs.getString("users.email");
				String fullName = rs.getString("users.fullName");	
				
				a =new NormalUser(fullName, email, token);
				a.setId(id);
			}
			return a;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	public PhotographerOrModel getActiveEmailPhoto(String name, String token){
		PhotographerOrModel a = null;
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(AccountQuery.GETACTIVEEMAILPHOTO);
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, token);
			ResultSet rs = preparedStmt.executeQuery();
			if(rs.next()) {
				String id = rs.getString("photographerormodel.id");
				String email = rs.getString("photographerormodel.email");
				String fullName = rs.getString("photographerormodel.fullName");
				a = new PhotographerOrModel(email,fullName,token);
				a.setId(id);
			}
			return a;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
}
