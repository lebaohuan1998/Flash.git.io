package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nhom1.connection.ConnectionClass;
import nhom1.model.Photographer;
import nhom1.ultility.PhotoOrModelQuery;

public class SeacrchPhotographerDAO {
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;

	public List<Photographer> getListPhotographer(int paging) {

		try {
			List<Photographer> listp = new ArrayList<>();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.SEARCHALLINFOPHOTO);
			preparedStmt.setInt(1, paging);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String idPhotographer = rs.getString("id");
				String name = rs.getString("fullName");
				String avata = rs.getString("avatar");
				String ngheDanh = rs.getString("nickName");
				String ProvinceId = String.valueOf(rs.getInt("provinceId"));
				String workPlace = rs.getString("workPlace");
				String quymo = rs.getString("organize");
				String statusXm = rs.getString("identity_photographers.identityVerifyId");
				String status = rs.getString("statusAccountId");
				String countFollower = rs.getString("countFollower");
				String provinceName = rs.getString("provinces.provinceName");
				Photographer p = new Photographer();
				p.setId(idPhotographer);
				p.setFullName(name);
				p.setNickName(ngheDanh);
				p.setWorkPlace(workPlace);
				p.setProvinceId(ProvinceId);
				p.setOrganize(quymo);
				p.setStatusAccountId(status);
				p.setIdentityVerifyId(statusXm);
				p.setCountFollower(countFollower);
				p.setAvata(avata);
				p.setProvinceName(provinceName);
				listp.add(p);
			}
			return listp;
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

	public List<Photographer> searchBy(String place, String category, String text, int paging, String care) {
		try {
			List<Photographer> listp = new ArrayList<>();
			connection = ConnectionClass.createConnect().getConnection();
			if (care == null || care.equals("2")) {
				if (text.equals("")) {
					if (place.equals("0") && category.equals("0")) {
						System.out.println("1");
						preparedStmt = connection.prepareStatement(PhotoOrModelQuery.SEARCHALLINFOPHOTO);
						preparedStmt.setInt(1, paging);
					} else if (place.equals("0") && !category.equals("0")) {
						System.out.println("2");
						preparedStmt = connection.prepareStatement(PhotoOrModelQuery.SEARCHALLINFOPHOTO2);
						preparedStmt.setString(1, category);
						preparedStmt.setInt(2, paging);
					} else if (!place.equals("0") && category.equals("0")) {
						System.out.println("3");
						preparedStmt = connection.prepareStatement(PhotoOrModelQuery.SEARCHALLINFOPHOTO1);
						preparedStmt.setString(1, place);
						preparedStmt.setInt(2, paging);
					} else if (!place.equals("0") && !category.equals("0")) {
						System.out.println("4");
						preparedStmt = connection.prepareStatement(PhotoOrModelQuery.SEARCHALLINFOPHOTO12);
						preparedStmt.setString(1, category);
						preparedStmt.setString(2, place);
						preparedStmt.setInt(3, paging);
					}

				} else {
					if (place.equals("0") && category.equals("0")) {
						System.out.println("5");
						preparedStmt = connection.prepareStatement(PhotoOrModelQuery.SEARCHALLINFOPHOTO3);
						preparedStmt.setString(1, text);
						preparedStmt.setInt(2, paging);
					} else if (place.equals("0") && !category.equals("0")) {
						System.out.println("6");
						preparedStmt = connection.prepareStatement(PhotoOrModelQuery.SEARCHALLINFOPHOTO23);
						preparedStmt.setString(1, category);
						preparedStmt.setString(2, text);
						preparedStmt.setInt(3, paging);
					} else if (!place.equals("0") && category.equals("0")) {
						System.out.println("7");
						preparedStmt = connection.prepareStatement(PhotoOrModelQuery.SEARCHALLINFOPHOTO13);
						preparedStmt.setString(1, place);
						preparedStmt.setString(2, text);
						preparedStmt.setInt(3, paging);
					} else if (!place.equals("0") && !category.equals("0")) {
						System.out.println("8");
						preparedStmt = connection.prepareStatement(PhotoOrModelQuery.SEARCHALLINFOPHOTO123);
						preparedStmt.setString(1, category);
						preparedStmt.setString(2, place);
						preparedStmt.setString(3, text);
						preparedStmt.setInt(4, paging);
					}
				}

			} else if (care.equals("1")) {
				if (text.equals("")) {
					if (place.equals("0") && category.equals("0")) {
						System.out.println("9");
						preparedStmt = connection.prepareStatement(PhotoOrModelQuery.SEARCHALLINFOPHOTOCARE);
						preparedStmt.setInt(1, paging);
					} else if (place.equals("0") && !category.equals("0")) {
						System.out.println("10");
						preparedStmt = connection.prepareStatement(PhotoOrModelQuery.SEARCHALLINFOPHOTO2CARE);
						preparedStmt.setString(1, category);
						preparedStmt.setInt(2, paging);
					} else if (!place.equals("0") && category.equals("0")) {
						System.out.println("11");
						preparedStmt = connection.prepareStatement(PhotoOrModelQuery.SEARCHALLINFOPHOTO1CARE);
						preparedStmt.setString(1, place);
						preparedStmt.setInt(2, paging);
					} else if (!place.equals("0") && !category.equals("0")) {
						System.out.println("12");
						preparedStmt = connection.prepareStatement(PhotoOrModelQuery.SEARCHALLINFOPHOTO12CARE);
						preparedStmt.setString(1, category);
						preparedStmt.setString(2, place);
						preparedStmt.setInt(3, paging);
					}

				} else {
					if (place.equals("0") && category.equals("0")) {
						System.out.println("13");
						preparedStmt = connection.prepareStatement(PhotoOrModelQuery.SEARCHALLINFOPHOTO3CARE);
						preparedStmt.setString(1, text);
						preparedStmt.setInt(2, paging);
					} else if (place.equals("0") && !category.equals("0")) {
						System.out.println("14");
						preparedStmt = connection.prepareStatement(PhotoOrModelQuery.SEARCHALLINFOPHOTO23CARE);
						preparedStmt.setString(1, category);
						preparedStmt.setString(2, text);
						preparedStmt.setInt(3, paging);
					} else if (!place.equals("0") && category.equals("0")) {
						System.out.println("15");
						preparedStmt = connection.prepareStatement(PhotoOrModelQuery.SEARCHALLINFOPHOTO13CARE);
						preparedStmt.setString(1, place);
						preparedStmt.setString(2, text);
						preparedStmt.setInt(3, paging);
					} else if (!place.equals("0") && !category.equals("0")) {
						System.out.println("16");
						preparedStmt = connection.prepareStatement(PhotoOrModelQuery.SEARCHALLINFOPHOTO123CARE);
						preparedStmt.setString(1, category);
						preparedStmt.setString(2, place);
						preparedStmt.setString(3, text);
						preparedStmt.setInt(4, paging);
					}
				}
			}

			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String idPhotographer = rs.getString("id");
				String name = rs.getString("fullName");
				String avata = rs.getString("avatar");
				String ngheDanh = rs.getString("nickName");
				String ProvinceId = String.valueOf(rs.getInt("provinceId"));
				String workPlace = rs.getString("workPlace");
				String quymo = rs.getString("organize");
				String statusXm = rs.getString("identity_photographers.identityVerifyId");
				String status = rs.getString("statusAccountId");
				String countFollower = rs.getString("countFollower");
				String provinceName = rs.getString("provinces.provinceName");
				Photographer p = new Photographer();
				p.setId(idPhotographer);
				p.setFullName(name);
				p.setNickName(ngheDanh);
				p.setWorkPlace(workPlace);
				p.setProvinceId(ProvinceId);
				p.setOrganize(quymo);
				p.setStatusAccountId(status);
				p.setIdentityVerifyId(statusXm);
				p.setCountFollower(countFollower);
				p.setAvata(avata);
				p.setProvinceName(provinceName);
				listp.add(p);
			}
			return listp;
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

	public List<Photographer> searchByLocation(String place, String category, String text) {
		try {
			List<Photographer> listp = new ArrayList<>();
			connection = ConnectionClass.createConnect().getConnection();
			if (text.equals("")) {
				if (place.equals("0") && category.equals("0")) {
					System.out.println("1");
					preparedStmt = connection.prepareStatement(PhotoOrModelQuery.SEARCHALLINFOPHOTOBYLOCATION);
				} else if (place.equals("0") && !category.equals("0")) {
					System.out.println("2");
					preparedStmt = connection.prepareStatement(PhotoOrModelQuery.SEARCHALLINFOPHOTO2BYLOCATION);
					preparedStmt.setString(1, category);
				} else if (!place.equals("0") && category.equals("0")) {
					System.out.println("3");
					preparedStmt = connection.prepareStatement(PhotoOrModelQuery.SEARCHALLINFOPHOTO1BYLOCATION);
					preparedStmt.setString(1, place);
				} else if (!place.equals("0") && !category.equals("0")) {
					System.out.println("4");
					preparedStmt = connection.prepareStatement(PhotoOrModelQuery.SEARCHALLINFOPHOTO12BYLOCATION);
					preparedStmt.setString(1, category);
					preparedStmt.setString(2, place);
				}
			} else {
				if (place.equals("0") && category.equals("0")) {
					System.out.println("5");
					preparedStmt = connection.prepareStatement(PhotoOrModelQuery.SEARCHALLINFOPHOTO3BYLOCATION);
					preparedStmt.setString(1, text);
				} else if (place.equals("0") && !category.equals("0")) {
					System.out.println("6");
					preparedStmt = connection.prepareStatement(PhotoOrModelQuery.SEARCHALLINFOPHOTO23BYLOCATION);
					preparedStmt.setString(1, category);
					preparedStmt.setString(2, text);
				} else if (!place.equals("0") && category.equals("0")) {
					System.out.println("7");
					preparedStmt = connection.prepareStatement(PhotoOrModelQuery.SEARCHALLINFOPHOTO13BYLOCATION);
					preparedStmt.setString(1, place);
					preparedStmt.setString(2, text);
				} else if (!place.equals("0") && !category.equals("0")) {
					System.out.println("8");
					preparedStmt = connection.prepareStatement(PhotoOrModelQuery.SEARCHALLINFOPHOTO123BYLOCATION);
					preparedStmt.setString(1, category);
					preparedStmt.setString(2, place);
					preparedStmt.setString(3, text);
				}
			}
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String idPhotographer = rs.getString("id");
				String name = rs.getString("fullName");
				String avata = rs.getString("avatar");
				String ngheDanh = rs.getString("nickName");
				String ProvinceId = String.valueOf(rs.getInt("provinceId"));
				String workPlace = rs.getString("workPlace");
				String quymo = rs.getString("organize");
				String statusXm = rs.getString("identity_photographers.identityVerifyId");
				String status = rs.getString("statusAccountId");
				String countFollower = rs.getString("countFollower");
				String provinceName = rs.getString("provinces.provinceName");
				Photographer p = new Photographer();
				p.setId(idPhotographer);
				p.setFullName(name);
				p.setNickName(ngheDanh);
				p.setWorkPlace(workPlace);
				p.setProvinceId(ProvinceId);
				p.setOrganize(quymo);
				p.setStatusAccountId(status);
				p.setIdentityVerifyId(statusXm);
				p.setCountFollower(countFollower);
				p.setAvata(avata);
				p.setProvinceName(provinceName);
				listp.add(p);
			}
			return listp;
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

	public int countPhotographerBy(String place, String category, String text) {

		try {
			int count = 0;
			connection = ConnectionClass.createConnect().getConnection();
			if (text.equals("")) {
				if (place.equals("0") && category.equals("0")) {
					preparedStmt = connection.prepareStatement(PhotoOrModelQuery.COUNTPHOTO);
				} else if (place.equals("0") && !category.equals("0")) {
					preparedStmt = connection.prepareStatement(PhotoOrModelQuery.COUNTALLINFOPHOTO2);
					preparedStmt.setString(1, category);
				} else if (!place.equals("0") && category.equals("0")) {
					preparedStmt = connection.prepareStatement(PhotoOrModelQuery.COUNTALLINFOPHOTO1);
					preparedStmt.setString(1, place);
				} else if (!place.equals("0") && !category.equals("0")) {
					preparedStmt = connection.prepareStatement(PhotoOrModelQuery.COUNTALLINFOPHOTO12);
					preparedStmt.setString(1, category);
					preparedStmt.setString(2, place);
				}

			} else {
				if (place.equals("0") && category.equals("0")) {
					preparedStmt = connection.prepareStatement(PhotoOrModelQuery.COUNTALLINFOPHOTO3);
					preparedStmt.setString(1, text);
				} else if (place.equals("0") && !category.equals("0")) {
					preparedStmt = connection.prepareStatement(PhotoOrModelQuery.COUNTALLINFOPHOTO23);
					preparedStmt.setString(1, category);
					preparedStmt.setString(2, text);
				} else if (!place.equals("0") && category.equals("0")) {
					preparedStmt = connection.prepareStatement(PhotoOrModelQuery.COUNTALLINFOPHOTO13);
					preparedStmt.setString(1, place);
					preparedStmt.setString(2, text);
				} else if (!place.equals("0") && !category.equals("0")) {
					preparedStmt = connection.prepareStatement(PhotoOrModelQuery.COUNTALLINFOPHOTO123);
					preparedStmt.setString(1, category);
					preparedStmt.setString(2, place);
					preparedStmt.setString(3, text);
				}
			}

			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("COUNT(distinct photographerId)");
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
		return 0;
	}

	public int countPhotographer() {
		try {
			int count = 0;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.COUNTPHOTO);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count(distinct photographerId)");
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
		return 0;
	}

	public Photographer searchPhotographerById(String id) {
		try {
			Photographer p = new Photographer();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(PhotoOrModelQuery.SEARCHPHOTOGRAPHERBYID);
			preparedStmt.setString(1, id);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String idPhotographer = rs.getString("id");
				String name = rs.getString("fullName");
				String avata = rs.getString("avatar");
				String ngheDanh = rs.getString("nickName");
				String ProvinceId = String.valueOf(rs.getInt("provinceId"));
				String workPlace = rs.getString("workPlace");
				String quymo = rs.getString("organize");
				String statusXm = rs.getString("identity_photographers.identityVerifyId");
				String status = rs.getString("statusAccountId");
				String countFollower = rs.getString("countFollower");
				String provinceName = rs.getString("provinces.provinceName");
				
				p.setId(idPhotographer);
				p.setFullName(name);
				p.setNickName(ngheDanh);
				p.setWorkPlace(workPlace);
				p.setProvinceId(ProvinceId);
				p.setOrganize(quymo);
				p.setStatusAccountId(status);
				p.setIdentityVerifyId(statusXm);
				p.setCountFollower(countFollower);
				p.setAvata(avata);
				p.setProvinceName(provinceName);
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
}
