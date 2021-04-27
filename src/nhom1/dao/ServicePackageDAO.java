package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nhom1.connection.ConnectionClass;
import nhom1.model.ServicePackage;
import nhom1.model.Images;
import nhom1.ultility.ServicePackageQuery;

public class ServicePackageDAO {
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;

	public boolean createOneServicePackage(ServicePackage a) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ServicePackageQuery.CREATEONEALBUM);
			preparedStmt.setString(1, a.getServicepackageName());
			preparedStmt.setString(2, a.getDescription());
			preparedStmt.setString(3, a.getCategoryId());
			preparedStmt.setString(4, a.getShootingLocation());
			preparedStmt.setFloat(5, a.getPrice());
			preparedStmt.setFloat(6, a.getDeposit());
			preparedStmt.setString(7, a.getPhotographerID());
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

	public boolean updateServicePackageById(ServicePackage a, String id) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ServicePackageQuery.UPDATEALBUM);
			preparedStmt.setString(1, a.getServicepackageName());
			preparedStmt.setString(2, a.getDescription());
			preparedStmt.setString(3, a.getCategoryId());
			preparedStmt.setString(4, a.getShootingLocation());
			preparedStmt.setFloat(5, a.getPrice());
			preparedStmt.setFloat(6, a.getDeposit());
			preparedStmt.setString(7, a.getPhotographerID());
			preparedStmt.setString(8, id);
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

	public ServicePackage getOneServicePackageById(int id) {
		try {
			ServicePackage a = null;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ServicePackageQuery.GET_ONE_ALBUM_BYID);
			preparedStmt.setInt(1, id);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String serviceId = rs.getString("servicepackages.id");
				String servicepackageName = rs.getString("servicepackages.servicepackageName");
				String description = rs.getString("servicepackages.description");
				String category = rs.getString("servicepackages.categoryId");
				String shootingLocationID = rs.getString("servicepackages.shootingLocationId");
				String price = rs.getString("servicepackages.price");
				String deposit = rs.getString("servicepackages.deposit");
				String photographerID = rs.getString("servicepackages.photographerId");
				a = new ServicePackage(serviceId, servicepackageName, description, category, shootingLocationID,
						Integer.parseInt(price), Integer.parseInt(deposit), photographerID);
			}
			return a;
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

	public ServicePackage getOneServicePackageByName(String name) {
		try {
			ServicePackage a = null;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ServicePackageQuery.GET_ONE_ALBUM_BYNAME);
			preparedStmt.setString(1, name);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String serviceId = rs.getString("servicepackages.id");
				String servicepackageName = rs.getString("servicepackages.servicepackageName");
				String description = rs.getString("servicepackages.description");
				String category = rs.getString("servicepackages.categoryId");
				String shootingLocation = rs.getString("servicepackages.shootingLocationId");
				String price = rs.getString("servicepackages.price");
				String deposit = rs.getString("servicepackages.deposit");
				String photographerID = rs.getString("servicepackages.photographerId");
				a = new ServicePackage(serviceId, servicepackageName, description, category, shootingLocation,
						Integer.parseInt(price), Integer.parseInt(deposit), photographerID);
			}
			return a;
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

	public boolean addImage(Images i) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ServicePackageQuery.ADD_IMAGE);
			preparedStmt.setString(1, i.getImageName());
			preparedStmt.setString(2, i.getAlbumId());
			preparedStmt.setString(3, i.getCoverImage());
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

	public List<Images> listImages(int id) {

		try {
			List<Images> listI = new ArrayList<>();
			;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ServicePackageQuery.GET_IMAGES);
			preparedStmt.setInt(1, id);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String idImage = rs.getString("images.id");
				String imageName = rs.getString("images.imageName");
				String idAlbum = rs.getString("images.servicePackageId");
				String coverImage = rs.getString("images.coverImage");
				Images i = new Images(imageName, idAlbum, coverImage);
				i.setId(idImage);
				listI.add(i);
			}
			return listI;
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

	public boolean deleteImage(int id) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ServicePackageQuery.DELETE_IMAGE);
			preparedStmt.setInt(1, id);
			preparedStmt.execute();
			if (preparedStmt.getUpdateCount() < 1) {
				return false;
			}
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

	public Images getCoverImage(String id1, String id2) {
		Images i = new Images();
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ServicePackageQuery.GET_COVER_IMAGE);
			preparedStmt.setString(1, id1);
			preparedStmt.setString(2, id2);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String idImage = rs.getString("images.id");
				String imageName = rs.getString("images.imageName");
				String idAlbum = rs.getString("images.servicePackageId");
				String coverImage = rs.getString("images.coverImage");
				i = new Images(idImage, imageName, idAlbum, coverImage);
			}
			return i;
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

	public Images getImageById(String id) {
		Images i = new Images();
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ServicePackageQuery.GET_IMAGE_BY_ID);
			preparedStmt.setString(1, id);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String idImage = rs.getString("images.id");
				String imageName = rs.getString("images.imageName");
				String idAlbum = rs.getString("images.servicePackageId");
				String coverImage = rs.getString("images.coverImage");
				i = new Images(idImage, imageName, idAlbum, coverImage);
			}
			return i;
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

	public boolean updateCoverImage1(String coverid1, String idAlbum) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ServicePackageQuery.UPDATE_COVERID1);
			preparedStmt.setString(1, coverid1);
			preparedStmt.setString(2, idAlbum);
			preparedStmt.execute();
			if (preparedStmt.getUpdateCount() < 1) {
				return false;
			}
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

	public boolean updateCoverImage2(String coverid, String imgId) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ServicePackageQuery.UPDATE_COVERID2);
			preparedStmt.setString(1, coverid);
			preparedStmt.setString(2, imgId);
			preparedStmt.execute();
			if (preparedStmt.getUpdateCount() < 1) {
				return false;
			}
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

	public int countImage(int id) {

		try {
			int count = 0;
			List<Images> listI = new ArrayList<>();
			;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ServicePackageQuery.GET_IMAGES);
			preparedStmt.setInt(1, id);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String idImage = rs.getString("images.id");
				String imageName = rs.getString("images.imageName");
				String idAlbum = rs.getString("images.servicePackageId");
				String coverImage = rs.getString("images.coverImage");
				Images i = new Images(imageName, idAlbum, coverImage);
				i.setId(idImage);
				listI.add(i);
			}
			count = listI.size();
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

//ẩn hiển gói package.
	public boolean hideShow(String idServicePackage, String a) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ServicePackageQuery.HIDESHOW);
			preparedStmt.setString(1, a);
			preparedStmt.setString(2, idServicePackage);
			preparedStmt.execute();
			if (preparedStmt.getUpdateCount() < 1) {
				return false;
			}
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

	public int getStatusPackage(String id) {

		try {
			int count = 0;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ServicePackageQuery.GETSTATUSPACKAGE);
			preparedStmt.setString(1, id);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("servicepackages.servicePackStatus");
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

	public List<ServicePackage> listServicePackage(int page) {
		List<ServicePackage> listS = new ArrayList<>();
		
		try {

			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ServicePackageQuery.GETALLSERVICEPACKAGE);
			preparedStmt.setInt(1, page);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String serviceId = rs.getString("servicepackages.id");
				String nickName = rs.getString("photographers.nickName");
				String coverImage = rs.getString("images.imageName");
				String province = rs.getString("provinces.provinceName");
				String price = rs.getString("servicepackages.price");
				String photographerID = rs.getString("servicepackages.photographerId");
				String namePackage = rs.getString("servicepackages.servicePackageName");
				ServicePackage a = new ServicePackage();
				a.setId(serviceId);
				a.setNickName(nickName);
				a.setCoverImage(coverImage);
				a.setProvinceName(province);
				a.setPrice(Integer.parseInt(price));
				a.setPhotographerID(photographerID);
				a.setServicepackageName(namePackage);
				listS.add(a);
			}
			return listS;
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
	public List<Images> listImg(int page) {
		List<Images> listImg = new ArrayList<>();
		
		try {

			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ServicePackageQuery.GETALLSERVICEPACKAGE);
			preparedStmt.setInt(1, page);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
//				String serviceId = rs.getString("servicepackages.id");
//				String nickName = rs.getString("photographers.nickName");
//				String coverImage = rs.getString("images.imageName");
//				String province = rs.getString("provinces.provinceName");
//				String price = rs.getString("servicepackages.price");
//				String photographerID = rs.getString("servicepackages.photographerId");
//				String namePackage = rs.getString("servicepackages.servicePackageName");
//				ServicePackage a = new ServicePackage();
//				a.setId(serviceId);
//				a.setNickName(nickName);
//				a.setCoverImage(coverImage);
//				a.setProvinceName(province);
//				a.setPrice(Integer.parseInt(price));
//				a.setPhotographerID(photographerID);
//				a.setServicepackageName(namePackage);
//				listImg.add(a);
			}
			return listImg;
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
