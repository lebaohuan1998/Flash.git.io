package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nhom1.connection.ConnectionClass;
import nhom1.model.Photographer;
import nhom1.model.User;
import nhom1.ultility.NormalUserQuery;
import nhom1.ultility.PhotoOrModelQuery;

public class ManagermentAdminDAO {
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;
	 
	public List<User> listUser(int r,int paging) {
		try {
			List<User> lu = new ArrayList<>();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(NormalUserQuery.GETUSER);
			preparedStmt.setInt(1, r);
			preparedStmt.setInt(2, paging);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("users.id");
				String name = rs.getString("users.fullName");
				String email = rs.getString("users.email");
				String role = rs.getString("users.roleId");
				Date createDate= rs.getDate("users.createdDate");
				String statusId = rs.getString("users.statusAccountId");
				String statusName = rs.getString("status_account.statusName");
				User u = new User();
				u.setId(id);
				u.setFullName(name);
				u.setEmail(email);
				u.setRole(role);
				u.setCreatedDate(createDate);
				u.setStatus(statusId);
				u.setStatusName(statusName);
				lu.add(u);
			}
			return lu;
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
	public List<Photographer> listPhoto(int paging) throws ParseException {
		try {
			List<Photographer> lp = new ArrayList<>();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.GETPHOTO);
			preparedStmt.setInt(1, paging);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("fullName");
				String email = rs.getString("email");
				String role = rs.getString("roleId");
				Date creatDate = rs.getDate("createdDate");
				String statusId = rs.getString("photographers.statusAccountId");
				String statusName = rs.getString("status_account.statusName");
				Photographer p = new Photographer();
				p.setId(id);
				p.setFullName(name);
				p.setEmail(email);
				p.setRoleId(role);
				p.setCreatedDate(creatDate);
				p.setStatusAccountId(statusId);
				p.setStatusAccountName(statusName);
				lp.add(p);
			}
			return lp;
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
	public String countUser(int r) {
		try {
			String count="";
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(NormalUserQuery.COUNTUSER);
			preparedStmt.setInt(1, r);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				count = rs.getString("COUNT(*)");
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
		return null;
	}
	public String countPhoto() {
		try {
			String count="";
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.COUNTPHOTO2);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				count = rs.getString("COUNT(*)");
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
		return null;
	}
	
	public boolean updateStatusUser(String statusId,String id) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(NormalUserQuery.UPDATESTATUS);
			preparedStmt.setString(1, statusId);
			preparedStmt.setString(2, id);
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
	public boolean updateStatusPhotographer(String statusId,String id) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.UPDATESTATUS);
			preparedStmt.setString(1, statusId);
			preparedStmt.setString(2, id);
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
	public boolean updateRole(String role,String id) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(NormalUserQuery.UPDATEROLE);
			preparedStmt.setString(1, role);
			preparedStmt.setString(2, id);
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
	public String countPhotographerIdentity(String status) {
		if(status==null) {
			status="1";
		}
		try {
			String count="";
			connection = ConnectionClass.createConnect().getConnection();
			if(status.equals("1")) {
				preparedStmt = connection.prepareStatement(PhotoOrModelQuery.COUNTPHOTOIDENTITY);
			}else {
				preparedStmt = connection.prepareStatement(PhotoOrModelQuery.COUNTPHOTOIDENTITYBYSTATUS);
				preparedStmt.setString(1, status);
			}
			
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				count = rs.getString("COUNT(*)");
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
		return null;
	}
	//xác minh thợ ảnh
	public boolean identityPhotographer(String idphoto,String idadmin) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.IdentityPhotographer);
			preparedStmt.setString(1, idadmin);
//			preparedStmt.setString(2, date);
			preparedStmt.setString(2, idphoto);
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
	public boolean acceptIdentity(String idphoto) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.AcceptIdentity);
			preparedStmt.setString(1, idphoto);
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
	public boolean rejectIdentity(String idphoto) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.RejectIdentity);
			preparedStmt.setString(1, idphoto);
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
