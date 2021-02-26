package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import nhom1.connection.ConnectionClass;
import nhom1.model.PhotographerOrModel;
import nhom1.ultility.PhotoOrModelQuery;

public class UserPhotoDAO {
	
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;

	//active tài khoản
	public boolean updateActive(String status, int id) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.UPDATE_ACTIVEMAIL);
			preparedStmt.setString(1,  status);
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
	//quên pass
	public boolean quenPass( String pass, String email) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.QUEN_PASSWORD );
			preparedStmt.setString(1, pass);
			preparedStmt.setString(2, email);
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
	//lấy ra thông tin
	public PhotographerOrModel getInfo(int id) {
		try {
			PhotographerOrModel pom = null;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.GET_ALLINFOPHOTO);
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
				String ngheDanh= rs.getString("nghedanh");
				String tcc= rs.getString("thecancuoc");
				String noilamviec= rs.getString("noilamviec");
				String quymo= rs.getString("quymo");
				String xm1= rs.getString("xm1");
				String xm2= rs.getString("xm2");
				String xm3= rs.getString("xm3");
				String statusXm = rs.getString("statusxm");
				String status = rs.getString("status");
				pom = new PhotographerOrModel(email, name, ngheDanh, pwd, phone, tcc, bod, address, gender, noilamviec, quymo, xm1, xm2, xm3, statusXm, avata, status);
				
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
	//update thông tin
	public boolean updateInfo(PhotographerOrModel pom, int id) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.UPDATE_PHOTO);
			preparedStmt.setString(1, pom.getFullName());
			preparedStmt.setString(2, pom.getAddress());
			preparedStmt.setString(3, pom.getBod());
			preparedStmt.setString(4, pom.getPhone());
			preparedStmt.setString(5, pom.getGender());
			preparedStmt.setString(6, pom.getTcc());
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
	// thay pass
	public boolean updatePass( String pass, int id) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.UPDATE_PASSWORD );
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
	public boolean updateView(PhotographerOrModel pom, int id) {
		// TODO Auto-generated method stub
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.UPDATE_VIEW);
			preparedStmt.setString(1, pom.getNgheDanh());
			preparedStmt.setString(2, pom.getQuymo());
			preparedStmt.setString(3, pom.getNoilamviec());
			preparedStmt.setString(4, pom.getAvata());
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
	//update xacminh
	public boolean updateXm(String attribute, String attribute2, String attribute3, int id) {
		// TODO Auto-generated method stub
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.UPDATE_XM);
			preparedStmt.setString(1, attribute);
			preparedStmt.setString(2, attribute2);
			preparedStmt.setString(3, attribute3);
			preparedStmt.setInt(4, id);
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
