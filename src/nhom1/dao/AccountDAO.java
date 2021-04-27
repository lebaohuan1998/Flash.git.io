package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import nhom1.connection.ConnectionClass;
import nhom1.model.Account;
import nhom1.model.User;
import nhom1.model.Photographer;
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
	public boolean getAccountAdmin(String name, String pass){
		boolean status = false;
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(AccountQuery.GETACCOUNTADMIN);
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
				int role = rs.getInt("users.roleId");
				String status= rs.getString("users.statusAccountId");
				a = new Account(id, username, password, fullName, role, status);
			}
			return a;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	public Account getAccountUser(String email) {
		Account a = null;
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(AccountQuery.GETACCOUNTUSERBYEMAIl);
			preparedStmt.setString(1, email);
			ResultSet rs = preparedStmt.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("users.id");
				String username = rs.getString("users.email");
				String password = rs.getString("users.password");
				String fullName = rs.getString("users.fullName");
				int role = rs.getInt("users.roleId");
				String status= rs.getString("users.statusAccountId");
				a = new Account(id, username, password, fullName, role, status);
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
				int id = rs.getInt("id");
				String username = rs.getString("email");
				String fullName = rs.getString("fullName");
				String password = rs.getString("password");
				int role = rs.getInt("roleId");
				String status= rs.getString("statusAccountId");
				a = new Account(id, username, password, fullName, role, status);

			}
			return a;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	public Account getAccountPhotographer(String email) {
		Account a = null;
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(AccountQuery.GETACCOUNTPHOTOBYEMAIL);
			preparedStmt.setString(1, email);
			ResultSet rs = preparedStmt.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("email");
				String fullName = rs.getString("fullName");
				String password = rs.getString("password");
				int role = rs.getInt("roleId");
				String status= rs.getString("statusAccountId");
				a = new Account(id, username, password, fullName, role, status);

			}
			return a;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	public Account getRoleAmin(String name, String pass) {
		Account a = new Account();
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(AccountQuery.GETACCOUNTADMIN);
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, pass);
			ResultSet rs = preparedStmt.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("admin.id");
				String username = rs.getString("admin.username");
				String password = rs.getString("admin.password");
				int role = rs.getInt("admin.roleId");
				a.setId(id);
				a.setUsername(username);
				a.setPassword(password);
				a.setRole(role);
			}
			return a;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	public User getActiveEmailUser(String name, String token){
		User a=null ;
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
				
				a =new User(fullName, email, token);
				a.setId(id);
			}
			return a;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	public Photographer getActiveEmailPhoto(String name, String token){
		Photographer p = new Photographer();
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(AccountQuery.GETACTIVEEMAILPHOTO);
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, token);
			ResultSet rs = preparedStmt.executeQuery();
			if(rs.next()) {
				String id = rs.getString("id");
				String email = rs.getString("email");
				String fullName = rs.getString("fullName");
				p.setId(id);
				p.setEmail(email);
				p.setFullName(fullName);
				p.setTokenEmail(token);
			}
			return p;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
}
