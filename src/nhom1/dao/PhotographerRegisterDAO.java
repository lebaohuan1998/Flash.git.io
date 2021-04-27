package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import nhom1.connection.ConnectionClass;
import nhom1.model.Photographer;
import nhom1.ultility.PhotoOrModelQuery;

public class PhotographerRegisterDAO {

	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;

	public boolean RegisterPhotographer(Photographer p) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.INSERTPHOTHOGRAPHER);
			preparedStmt.setString(1, p.getEmail());
			preparedStmt.setString(2, p.getFullName());
			preparedStmt.setString(3, p.getNickName());
			preparedStmt.setString(4, p.getPassword());
			preparedStmt.setString(5, p.getPhone());
			preparedStmt.setString(6, p.getRoleId());
			preparedStmt.setString(7, p.getTokenEmail());
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
	public String getIdPhotographer(String email) {
		try {
			String idP=null;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.GETEMAIL);
			preparedStmt.setString(1, email);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				idP= rs.getString("id");
			}
			return idP;
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
	public boolean addIdentityPhotographers(Photographer p) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.ADDIDENTITYPHOTOGRAPHERS);
			preparedStmt.setString(1, p.getId());
			preparedStmt.setString(2, p.getIdentityCardNumber());
			preparedStmt.setString(3, p.getAddressOfId());
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
	public boolean AddMapLocation(String id) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.ADDMAPLOCATION);
			preparedStmt.setString(1, id);
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
	public boolean addIdentityPhotographer(String id) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.AddIdentityPhotographer);
			preparedStmt.setString(1, id);
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
