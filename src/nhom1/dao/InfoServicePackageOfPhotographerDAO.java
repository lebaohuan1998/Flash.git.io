package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nhom1.connection.ConnectionClass;
import nhom1.model.ServicePackage;
import nhom1.model.DecribePhotographer;
import nhom1.model.Photographer;
import nhom1.ultility.ServicePackageQuery;
import nhom1.ultility.FollowQuery;
import nhom1.ultility.PhotoOrModelQuery;

public class InfoServicePackageOfPhotographerDAO {
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;

	public List<ServicePackage> listAlbumByCategory(String idPhoto, String categoryId) {
		try {
			List<ServicePackage> la = new ArrayList<>();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ServicePackageQuery.GETALBUMSBYCATEGORYANDIDPHOTO);
			preparedStmt.setString(1, idPhoto);
			preparedStmt.setString(2, categoryId);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("servicepackages.id");
				String nghedanh = rs.getString("photographers.nickName");
				String price = rs.getString("servicepackages.price");
				String deposit = rs.getString("servicepackages.deposit");
				String categoryName = rs.getString("categories.categoryName");
				String province = rs.getString("provinces.provinceName");
				String coverImage = rs.getString("images.imageName");
				String name = rs.getString("servicepackages.servicepackageName");
				String idPhotographer = rs.getString("servicepackages.photographerId");
				float pointRating=rs.getFloat("servicepackages.pointRating");
				ServicePackage a = new ServicePackage();
				a.setId(id);
				a.setNickName(nghedanh);
				a.setPrice(Integer.parseInt(price));
				a.setDeposit(Integer.parseInt(deposit));
				a.setCategoryName(categoryName);
				a.setProvinceName(province);
				a.setCoverImage(coverImage);
				a.setServicepackageName(name);
				a.setPhotographerID(idPhotographer);
				a.setPointRating(pointRating);
				la.add(a);
			}
			return la;
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

	public Photographer getInfo(String id) {
		try {
			Photographer pom = new Photographer();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.GET_ALLINFOPHOTO);
			preparedStmt.setString(1, id);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String idPhoto = rs.getString("id");
				String email = rs.getString("email");
				String name = rs.getString("fullName");
				String bod = rs.getString("dateOfBirth");
				String phone = rs.getString("phone");
				String gender = rs.getString("gender");
				String avata = rs.getString("avatar");
				String noilamviec = rs.getString("provinceId");
				String quymo = rs.getString("organize");
				String role = rs.getString("roleId");
				pom.setId(idPhoto);
				pom.setEmail(email);
				pom.setFullName(name);
				pom.setDateOfBirth(bod);
				pom.setPhone(phone);
				pom.setGender(gender);
				pom.setAvata(avata);
				pom.setProvinceId(noilamviec);
				pom.setOrganize(quymo);
				pom.setRoleId(role);
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

	public boolean addFollow(String idPhoto, String idUser) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(FollowQuery.ADDFOLLOW);
			preparedStmt.setString(1, idPhoto);
			preparedStmt.setString(2, idUser);
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

	public boolean unFollow(String idPhoto, String idUser) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(FollowQuery.UNFOLLOW);
			preparedStmt.setString(1, idPhoto);
			preparedStmt.setString(2, idUser);
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

	public String numberOfFollow(String idPhoto) {
		try {
			String count = "";
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(FollowQuery.GETNUMBER);
			preparedStmt.setString(1, idPhoto);
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

	public boolean checkFollow(String idPhoto, String idUser) {
		try {
			int count =0;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(FollowQuery.CHECKFOLLOW);
			preparedStmt.setString(1, idPhoto);
			preparedStmt.setString(2, idUser);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("COUNT(*)");
			}
			if (count==0) {
				return true;
			} else {
				return false;
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
	public DecribePhotographer getDescribePhotographer(String idPhoto) {
		try {
			DecribePhotographer dp = new DecribePhotographer();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.GETDESCRIBEPHOTOGRAPHER);
			preparedStmt.setString(1, idPhoto);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("photographerId");
				String text = rs.getString("describeText");
				String name1 = rs.getString("imageFirst");
				String name2 = rs.getString("imageSecond");
				dp.setPhotographerID(Integer.parseInt(id));
				dp.setDescribe(text);
				dp.setImageFirst(name1);
				dp.setImageSecond(name2);
			}
			return dp;
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
}
