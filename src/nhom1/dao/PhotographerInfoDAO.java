package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import nhom1.connection.ConnectionClass;
import nhom1.model.Photographer;
import nhom1.ultility.PhotoOrModelQuery;

public class PhotographerInfoDAO {
	
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
	//quĂªn pass
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
	//láº¥y ra thĂ´ng tin
	public Photographer getInfo(int id) {
		try {
			Photographer p = null;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.GET_ALLINFOPHOTO);
			preparedStmt.setInt(1, id);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String email= rs.getString("email");
				String pwd= rs.getString("password");
				String name= rs.getString("fullName");
				String bod= rs.getString("dateOfBirth");
				String address= rs.getString("identity_photographers.addressOfId");
				String phone= rs.getString("phone");
				String gender= rs.getString("gender");
				String avata= rs.getString("avatar");
				String ngheDanh= rs.getString("nickName");
				String tcc= rs.getString("identityCardNumber");
				String workPlace= rs.getString("workPlace");
				
				String ProvinceId=String.valueOf(rs.getInt("provinceId"));
				String quymo= rs.getString("organize");
				String xm1= rs.getString("frontPhoto");
				String xm2= rs.getString("backPhoto");
				String xm3= rs.getString("fullPhoto");
				String statusXm = rs.getString("identityVerifyId");
				String status = rs.getString("statusAccountId");
				String countFollower= rs.getString("countFollower");
				p = new Photographer(email, name, ngheDanh, pwd, phone, tcc, bod, address, gender, ProvinceId, quymo, xm1, xm2, xm3, statusXm, avata, status,countFollower);
				p.setWorkPlace(workPlace);
			}
			return p;
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
	//update thĂ´ng tin
	public boolean updateInfo1(Photographer p, int id) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.UPDATE_PHOTO1);
			preparedStmt.setString(1, p.getFullName());
			preparedStmt.setString(2, p.getPhone());
			preparedStmt.setInt(3, id);
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
	public boolean updateInfo2(Photographer p, int id) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.UPDATE_PHOTO2);
			preparedStmt.setString(1, p.getAddressOfId());
			preparedStmt.setString(2, p.getDateOfBirth());
			preparedStmt.setString(3, p.getGender());
			preparedStmt.setString(4, p.getIdentityCardNumber());
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
	public boolean updatePassByeEmail( String pass, String email) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.UPDATE_PASSWORDBYEMAIL );
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
	public boolean updateView(Photographer pom, int id) {
		// TODO Auto-generated method stub
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.UPDATE_VIEW);
			preparedStmt.setString(1, pom.getNickName());
			preparedStmt.setString(2, pom.getOrganize());
			preparedStmt.setString(3, pom.getProvinceId());
			preparedStmt.setString(4, pom.getAvata());
			preparedStmt.setString(5, pom.getWorkPlace());
			preparedStmt.setInt(6, id);
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
	
	public boolean updateMapLocation( String locationx,String locationy,int id) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.UPDATEMAPLOCATION);
			preparedStmt.setString(1, locationx);
			preparedStmt.setString(2, locationy);
			preparedStmt.setInt(3,  id);
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
