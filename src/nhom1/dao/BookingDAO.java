package nhom1.dao;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import nhom1.connection.ConnectionClass;
import nhom1.model.Booking;
import nhom1.model.ServicePackage;
import nhom1.model.User;
import nhom1.ultility.BookingQuery;


public class BookingDAO {
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;

	DecimalFormat formatter = new DecimalFormat("###,###.###"); 
	ComplaintDAO cd= new ComplaintDAO();
	
	
	public boolean createBooking(Booking b) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(BookingQuery.INSERT_BOOKING);
		
			preparedStmt.setString(1, b.getUserId());
			preparedStmt.setString(2, b.getServicePackageId());
			preparedStmt.setInt(3, b.getPrice());
			preparedStmt.setInt(4, b.getDeposit());
			preparedStmt.setString(5, b.getDescription());
			preparedStmt.setString(6, b.getShootingLocationId());
			preparedStmt.setString(7, b.getCategoryId());
			preparedStmt.setString(8, b.getPhoneUser());
			preparedStmt.setString(9, b.getNote());
			preparedStmt.setDate(10, b.getTakeDate());
			
			
		
			
		
			//preparedStmt.setTimestamp(8, b.getCreateDate());
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
	
	

	public List<Booking>  getListBookingByIdUser(int userId, int paging) {
		try {
			List<Booking> listBooking = new ArrayList<>();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(BookingQuery.GET_BOOKING_BY_USER);
			preparedStmt.setInt(1, userId);
			preparedStmt.setInt(2, paging);
			
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("bookings.id");
				
				int price= rs.getInt("bookings.price");
				Date takeDate= rs.getDate("bookings.takeDate");
				int deposit= rs.getInt("bookings.deposit");
				String statusBooking= rs.getString("status_booking.statusBookingName");
				int statusBookingId=  rs.getInt("bookings.statusBookingId");
				String convertPrice= formatter.format(price);
				String convertDeposit= formatter.format(deposit);
				
				Date createdDate= rs.getDate("bookings.createdDate");
				String modifyBy= rs.getString("bookings.modifiedBy");
				Timestamp modify= rs.getTimestamp("bookings.modifiedDate");
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				String modifyDate= dateFormat.format(modify);
				ServicePackage servicePackage = new ServicePackage();
				servicePackage.setConvertPrice(convertPrice);
				servicePackage.setServicepackageName(rs.getString("ServicePackages.servicePackageName"));
				servicePackage.setPhotographerID(rs.getString("ServicePackages.photographerID"));
				servicePackage.setAvatar(rs.getString("Photographers.avatar"));
				servicePackage.setPointRating(rs.getFloat("ServicePackages.pointRating"));
				servicePackage.setNickName(rs.getString("Photographers.nickName"));
				servicePackage.setCoverImage(rs.getString("images.imageName"));
				servicePackage.setProvinceName(rs.getString("provinces.provinceName"));
				servicePackage.setId(rs.getString("ServicePackages.id"));
				String phoneUser= rs.getString("bookings.phoneUser");
				String productLink = rs.getString("bookings.productLink");
				String statusBeforeCancel = rs.getString("bookings.statusBeforeCancel");
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
				String convertCreateDate=sdf.format(createdDate);
				String convertTakeDate= sdf.format(takeDate);
				
				
				
				//System.out.println("getServicepackageName: "+servicePackage.getServicepackageName());
				 Booking booking= new Booking( id,convertPrice,convertDeposit,convertTakeDate,convertCreateDate, statusBookingId,statusBooking,modifyDate,modifyBy,servicePackage,phoneUser,productLink,statusBeforeCancel);
				 listBooking.add(booking);
			
				
			}

			for (Booking s : listBooking) {
				int checkComplaint= cd.getStatusComplaint(userId, s.getId());
				s.setCheckComplaint(checkComplaint);
	        }		
			return listBooking;
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
	
	
	
	
	
	
	
	
	
	
	
	
	


	public int getConditionBooking(int userId, int servicePackageId, int statusBokingId) {
		try {
			int count = 0;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(BookingQuery.GET_COUNT_BOOKING_NOW);
			preparedStmt.setInt(1, userId);
			preparedStmt.setInt(2, servicePackageId);
			preparedStmt.setInt(3, statusBokingId);
			
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("COUNT(*)");
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public int sizeOfListBooking(int userId) {
		try {
			int count = 0;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(BookingQuery.GET_SIZE_BOOKING);
			preparedStmt.setInt(1, userId);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("COUNT(*)");
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
	
	
	public int getID(int userId,int servicePackageId) {
		try {
			int id = 0;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(BookingQuery.GET_ID_BOOKING);
			preparedStmt.setInt(1, userId);
			preparedStmt.setInt(2, servicePackageId);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt("id");
			}
			return id;
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
	
	public int getStatusBooking(int userId,int servicePackageId) {
		try {
			int statusId = 0;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(BookingQuery.GET_STATUS_BOOKING);
			preparedStmt.setInt(1, userId);
			preparedStmt.setInt(2, servicePackageId);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				statusId = rs.getInt("statusBookingId");
			}
			return statusId;
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
	
	
	
	
	
	public int sizeOfListBookingByStatusId(int userId, int statusId) {
		try {
			int count = 0;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(BookingQuery.GET_SIZE_BOOKING_BY_STATUSID);
			preparedStmt.setInt(1, userId);
			preparedStmt.setInt(2, statusId);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("COUNT(*)");
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



	public List<Booking> getListBookingByStatus(int userId, int statusId, int paging) {
		try {
			List<Booking> listBooking = new ArrayList<>();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(BookingQuery.GET_BOOKING_BY_STATUS);
			preparedStmt.setInt(1, userId);
			preparedStmt.setInt(2, statusId);
			preparedStmt.setInt(3, paging);
			
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("bookings.id");
				int price= rs.getInt("bookings.price");
				Date takeDate= rs.getDate("bookings.takeDate");
				int deposit= rs.getInt("bookings.deposit");
				String statusBooking= rs.getString("status_booking.statusBookingName");
				int statusBookingId=  rs.getInt("bookings.statusBookingId");
				String convertPrice= formatter.format(price);
				String convertDeposit= formatter.format(deposit);
				Date createdDate= rs.getDate("bookings.createdDate");
				String modifyBy= rs.getString("bookings.modifiedBy");
				Timestamp modify= rs.getTimestamp("bookings.modifiedDate");
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				String modifyDate= dateFormat.format(modify);
				ServicePackage servicePackage = new ServicePackage();
				servicePackage.setConvertPrice(convertPrice);
				servicePackage.setServicepackageName(rs.getString("ServicePackages.servicePackageName"));
				servicePackage.setPhotographerID(rs.getString("ServicePackages.photographerID"));
				servicePackage.setAvatar(rs.getString("Photographers.avatar"));
				servicePackage.setPointRating(rs.getFloat("ServicePackages.pointRating"));
				servicePackage.setNickName(rs.getString("Photographers.nickName"));
				servicePackage.setCoverImage(rs.getString("images.imageName"));
				servicePackage.setProvinceName(rs.getString("provinces.provinceName"));
				servicePackage.setId(rs.getString("ServicePackages.id"));
				String phoneUser= rs.getString("bookings.phoneUser");
				String productLink = rs.getString("bookings.productLink");
				String statusBeforeCancel = rs.getString("bookings.statusBeforeCancel");
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
				String convertCreateDate=sdf.format(createdDate);
				String convertTakeDate= sdf.format(takeDate);
				//System.out.println("getServicepackageName: "+servicePackage.getServicepackageName());
				
				 Booking booking= new Booking( id,convertPrice,convertDeposit,convertTakeDate,convertCreateDate, statusBookingId,statusBooking,modifyDate,modifyBy,servicePackage,phoneUser,productLink,statusBeforeCancel);
				 listBooking.add(booking);
			
				
			}

			for (Booking s : listBooking) {
				int checkComplaint= cd.getStatusComplaint(userId, s.getId());
				s.setCheckComplaint(checkComplaint);
	        }		
			return listBooking;
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



	public List<Booking> getListBookingSortDate(int userId, int paging) {
		try {
			List<Booking> listBooking = new ArrayList<>();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(BookingQuery.GET_BOOKING_BY_USER_SORT_TAKEDATE);
			preparedStmt.setInt(1, userId);
			preparedStmt.setInt(2, paging);
			
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("bookings.id");
				int price= rs.getInt("bookings.price");
				Date takeDate= rs.getDate("bookings.takeDate");
				int deposit= rs.getInt("bookings.deposit");
				String statusBooking= rs.getString("status_booking.statusBookingName");
				int statusBookingId=  rs.getInt("bookings.statusBookingId");
				String convertPrice= formatter.format(price);
				String convertDeposit= formatter.format(deposit);
				Date createdDate= rs.getDate("bookings.createdDate");
				String modifyBy= rs.getString("bookings.modifiedBy");
				Timestamp modify= rs.getTimestamp("bookings.modifiedDate");
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				String modifyDate= dateFormat.format(modify);
				ServicePackage servicePackage = new ServicePackage();
				servicePackage.setConvertPrice(convertPrice);
				servicePackage.setServicepackageName(rs.getString("ServicePackages.servicePackageName"));
				servicePackage.setPhotographerID(rs.getString("ServicePackages.photographerID"));
				servicePackage.setAvatar(rs.getString("Photographers.avatar"));
				servicePackage.setPointRating(rs.getFloat("ServicePackages.pointRating"));
				servicePackage.setNickName(rs.getString("Photographers.nickName"));
				servicePackage.setCoverImage(rs.getString("images.imageName"));
				servicePackage.setProvinceName(rs.getString("provinces.provinceName"));
				servicePackage.setId(rs.getString("ServicePackages.id"));
				String phoneUser= rs.getString("bookings.phoneUser");
				String productLink = rs.getString("bookings.productLink");
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
				String convertCreateDate=sdf.format(createdDate);
				String convertTakeDate= sdf.format(takeDate);
				//System.out.println("getServicepackageName: "+servicePackage.getServicepackageName());
				String statusBeforeCancel = rs.getString("bookings.statusBeforeCancel");
				 Booking booking= new Booking( id,convertPrice,convertDeposit,convertTakeDate,convertCreateDate, statusBookingId,statusBooking,modifyDate,modifyBy,servicePackage,phoneUser,productLink,statusBeforeCancel);
				 listBooking.add(booking);
				
			}

			for (Booking s : listBooking) {
				int checkComplaint= cd.getStatusComplaint(userId, s.getId());
				s.setCheckComplaint(checkComplaint);
	        }		
			return listBooking;
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
	
	

	public List<Booking> getListBookingByStatusSortTakeDate(int userId, int statusId, int paging) {
		try {
			List<Booking> listBooking = new ArrayList<>();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(BookingQuery.GET_BOOKING_BY_STATUS_SORT_TAKEDATE);
			preparedStmt.setInt(1, userId);
			preparedStmt.setInt(2, statusId);
			preparedStmt.setInt(3, paging);
			
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("bookings.id");
				int price= rs.getInt("bookings.price");
				Date takeDate= rs.getDate("bookings.takeDate");
				int deposit= rs.getInt("bookings.deposit");
				String statusBooking= rs.getString("status_booking.statusBookingName");
				int statusBookingId=  rs.getInt("bookings.statusBookingId");
				String convertPrice= formatter.format(price);
				String convertDeposit= formatter.format(deposit);
				Date createdDate= rs.getDate("bookings.createdDate");
				String modifyBy= rs.getString("bookings.modifiedBy");
				Timestamp modify= rs.getTimestamp("bookings.modifiedDate");
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				String modifyDate= dateFormat.format(modify);
				ServicePackage servicePackage = new ServicePackage();
				servicePackage.setConvertPrice(convertPrice);
				servicePackage.setServicepackageName(rs.getString("ServicePackages.servicePackageName"));
				servicePackage.setPhotographerID(rs.getString("ServicePackages.photographerID"));
				servicePackage.setAvatar(rs.getString("Photographers.avatar"));
				servicePackage.setPointRating(rs.getFloat("ServicePackages.pointRating"));
				servicePackage.setNickName(rs.getString("Photographers.nickName"));
				servicePackage.setCoverImage(rs.getString("images.imageName"));
				servicePackage.setProvinceName(rs.getString("provinces.provinceName"));
				servicePackage.setId(rs.getString("ServicePackages.id"));
				String phoneUser= rs.getString("bookings.phoneUser");
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
				String convertCreateDate=sdf.format(createdDate);
				String convertTakeDate= sdf.format(takeDate);
				//System.out.println("getServicepackageName: "+servicePackage.getServicepackageName());
				String productLink = rs.getString("bookings.productLink");
				String statusBeforeCancel = rs.getString("bookings.statusBeforeCancel");
				 Booking booking= new Booking( id,convertPrice,convertDeposit,convertTakeDate,convertCreateDate, statusBookingId,statusBooking,modifyDate,modifyBy,servicePackage,phoneUser,productLink,statusBeforeCancel);
				 listBooking.add(booking);
			
				
			}
			
			
					for (Booking s : listBooking) {
						int checkComplaint= cd.getStatusComplaint(userId, s.getId());
						s.setCheckComplaint(checkComplaint);
			        }		
					
					
					
			return listBooking;
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


	public boolean updateStatusBooking(String name,int bookingId, int statusBooking) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(BookingQuery.UPDATE_BOOKING);
			preparedStmt.setString(2, name);
			preparedStmt.setInt(3, bookingId);
			preparedStmt.setInt(1, statusBooking);
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
	
	
	
	

	public List<Booking>  getListBookingByIdPhotographer(int photographerId, int paging) {
		try {
			List<Booking> listBooking = new ArrayList<>();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(BookingQuery.GET_BOOKING_BY_PHOTOGRAPHER);
			preparedStmt.setInt(1, photographerId);
			preparedStmt.setInt(2, paging);
			
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("bookings.id");
				int price= rs.getInt("bookings.price");
				Date takeDate= rs.getDate("bookings.takeDate");
				int deposit= rs.getInt("bookings.deposit");
				String statusBooking= rs.getString("status_booking.statusBookingName");
				int statusBookingId=  rs.getInt("bookings.statusBookingId");
				String convertPrice= formatter.format(price);
				String convertDeposit= formatter.format(deposit);
				Date createdDate= rs.getDate("bookings.createdDate");
				String modifyBy= rs.getString("bookings.modifiedBy");
				Timestamp modify= rs.getTimestamp("bookings.modifiedDate");
				String productLink = rs.getString("bookings.productLink");
				
				//String shootingLocation = rs.getString("provices.id");
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				String modifyDate= dateFormat.format(modify);
				String userId= rs.getString("bookings.userId");
				ServicePackage servicePackage = new ServicePackage();
				User user= new User();
				servicePackage.setConvertPrice(convertPrice);
				String describe= rs.getString("bookings.description");
				
				servicePackage.setServicepackageName(rs.getString("ServicePackages.servicePackageName"));
				servicePackage.setPhotographerID(rs.getString("ServicePackages.photographerID"));
				//servicePackage.setPointRating(rs.getFloat("ServicePackages.pointRating"));
				user.setAvata(rs.getString("users.avatar"));
				user.setFullName(rs.getString("users.fullName"));
				user.setId(userId);
				servicePackage.setCoverImage(rs.getString("images.imageName"));
				servicePackage.setProvinceName(rs.getString("provinces.provinceName"));
				servicePackage.setId(rs.getString("ServicePackages.id"));
				
				
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
				String convertCreateDate=sdf.format(createdDate);
				String convertTakeDate= sdf.format(takeDate);
				//System.out.println("getServicepackageName: "+servicePackage.getServicepackageName());
				 Booking booking= new Booking( id,convertPrice,convertDeposit,convertTakeDate,convertCreateDate, statusBookingId,statusBooking,modifyDate,modifyBy,servicePackage, user,describe,productLink);
				 listBooking.add(booking);
			
				
			}
			return listBooking;
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
	


	public int sizeOfListBookingByPhotographer(int photographerId) {
		try {
			int count = 0;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(BookingQuery.GET_SIZE_BOOKING_PHOTOGRAPHER);
			preparedStmt.setInt(1, photographerId);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("COUNT(*)");
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


	public List<Booking>  getListBookingPhotographerSortDate(int photographerId, int paging) {
		try {
			List<Booking> listBooking = new ArrayList<>();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(BookingQuery.GET_BOOKING_BY_PHOTOGRAPHER);
			preparedStmt.setInt(1, photographerId);
			preparedStmt.setInt(2, paging);
			
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("bookings.id");
				int price= rs.getInt("bookings.price");
				Date takeDate= rs.getDate("bookings.takeDate");
				int deposit= rs.getInt("bookings.deposit");
				String statusBooking= rs.getString("status_booking.statusBookingName");
				int statusBookingId=  rs.getInt("bookings.statusBookingId");
				String convertPrice= formatter.format(price);
				String convertDeposit= formatter.format(deposit);
				Date createdDate= rs.getDate("bookings.createdDate");
				String modifyBy= rs.getString("bookings.modifiedBy");
				Timestamp modify= rs.getTimestamp("bookings.modifiedDate");
				//String shootingLocation = rs.getString("provices.id");
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				String modifyDate= dateFormat.format(modify);
				String userId= rs.getString("bookings.userId");
				ServicePackage servicePackage = new ServicePackage();
				User user= new User();
				servicePackage.setConvertPrice(convertPrice);
				String productLink = rs.getString("bookings.productLink");
				
				servicePackage.setServicepackageName(rs.getString("ServicePackages.servicePackageName"));
				servicePackage.setPhotographerID(rs.getString("ServicePackages.photographerID"));
				//servicePackage.setPointRating(rs.getFloat("ServicePackages.pointRating"));
				user.setAvata(rs.getString("users.avatar"));
				user.setFullName(rs.getString("users.fullName"));
				user.setId(userId);
				servicePackage.setCoverImage(rs.getString("images.imageName"));
				servicePackage.setProvinceName(rs.getString("provinces.provinceName"));
				servicePackage.setId(rs.getString("ServicePackages.id"));
				String describe= rs.getString("bookings.description");
				
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
				String convertCreateDate=sdf.format(createdDate);
				String convertTakeDate= sdf.format(takeDate);
				//System.out.println("getServicepackageName: "+servicePackage.getServicepackageName());
				 Booking booking= new Booking( id,convertPrice,convertDeposit,convertTakeDate,convertCreateDate, statusBookingId,statusBooking,modifyDate,modifyBy,servicePackage, user,describe,productLink);
				 listBooking.add(booking);
			
				
			}
			return listBooking;
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

	
	

	public List<Booking> getListBookingPhotographerSortTakeDate( int photographerId,  int paging) {
		try {
			List<Booking> listBooking = new ArrayList<>();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(BookingQuery.GET_BOOKING__PHOTOGRAPHER_TAKEDATE);
			preparedStmt.setInt(1, photographerId);
			preparedStmt.setInt(2, paging);
			
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("bookings.id");
				int price= rs.getInt("bookings.price");
				Date takeDate= rs.getDate("bookings.takeDate");
				int deposit= rs.getInt("bookings.deposit");
				String statusBooking= rs.getString("status_booking.statusBookingName");
				int statusBookingId=  rs.getInt("bookings.statusBookingId");
				String convertPrice= formatter.format(price);
				String convertDeposit= formatter.format(deposit);
				Date createdDate= rs.getDate("bookings.createdDate");
				String modifyBy= rs.getString("bookings.modifiedBy");
				Timestamp modify= rs.getTimestamp("bookings.modifiedDate");
				//String shootingLocation = rs.getString("provices.id");
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				String modifyDate= dateFormat.format(modify);
				String userId= rs.getString("bookings.userId");
				ServicePackage servicePackage = new ServicePackage();
				User user= new User();
				servicePackage.setConvertPrice(convertPrice);
				user.setId(userId);
				String describe= rs.getString("bookings.description");
				servicePackage.setServicepackageName(rs.getString("ServicePackages.servicePackageName"));
				servicePackage.setPhotographerID(rs.getString("ServicePackages.photographerID"));
				//servicePackage.setPointRating(rs.getFloat("ServicePackages.pointRating"));
				user.setAvata(rs.getString("users.avatar"));
				user.setFullName(rs.getString("users.fullName"));
				servicePackage.setCoverImage(rs.getString("images.imageName"));
				servicePackage.setProvinceName(rs.getString("provinces.provinceName"));
				servicePackage.setId(rs.getString("ServicePackages.id"));
				String productLink = rs.getString("bookings.productLink");
				
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
				String convertCreateDate=sdf.format(createdDate);
				String convertTakeDate= sdf.format(takeDate);
				//System.out.println("getServicepackageName: "+servicePackage.getServicepackageName());
				 Booking booking= new Booking( id,convertPrice,convertDeposit,convertTakeDate,convertCreateDate, statusBookingId,statusBooking,modifyDate,modifyBy,servicePackage, user,describe,productLink);
				 listBooking.add(booking);
			
				
			}
			return listBooking;
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
	

	public int sizeOfListBookingByStatusId_Photographer(int photographerID, int statusId) {
		try {
			int count = 0;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(BookingQuery.GET_SIZE_BOOKING_BY_STATUSID_PHOTOGRAPHER);
			preparedStmt.setInt(1, photographerID);
			preparedStmt.setInt(2, statusId);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("COUNT(*)");
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


	public List<Booking> getListBookingByStatus_Photographer(int photographerId, int statusId, int paging) {
		try {
			List<Booking> listBooking = new ArrayList<>();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(BookingQuery.GET_BOOKING_BY_STATUS_FROM_PHOTOGRAPHER);
			preparedStmt.setInt(1, photographerId);
			preparedStmt.setInt(2, statusId);
			preparedStmt.setInt(3, paging);
			
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("bookings.id");
				int price= rs.getInt("bookings.price");
				Date takeDate= rs.getDate("bookings.takeDate");
				int deposit= rs.getInt("bookings.deposit");
				String statusBooking= rs.getString("status_booking.statusBookingName");
				int statusBookingId=  rs.getInt("bookings.statusBookingId");
				String convertPrice= formatter.format(price);
				String convertDeposit= formatter.format(deposit);
				Date createdDate= rs.getDate("bookings.createdDate");
				String modifyBy= rs.getString("bookings.modifiedBy");
				Timestamp modify= rs.getTimestamp("bookings.modifiedDate");
				//String shootingLocation = rs.getString("provices.id");
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				String modifyDate= dateFormat.format(modify);
				String userId= rs.getString("bookings.userId");
				ServicePackage servicePackage = new ServicePackage();
				User user= new User();
				servicePackage.setConvertPrice(convertPrice);
				user.setId(userId);
				
				servicePackage.setServicepackageName(rs.getString("ServicePackages.servicePackageName"));
				servicePackage.setPhotographerID(rs.getString("ServicePackages.photographerID"));
				//servicePackage.setPointRating(rs.getFloat("ServicePackages.pointRating"));
				user.setAvata(rs.getString("users.avatar"));
				user.setFullName(rs.getString("users.fullName"));
				servicePackage.setCoverImage(rs.getString("images.imageName"));
				servicePackage.setProvinceName(rs.getString("provinces.provinceName"));
				servicePackage.setId(rs.getString("ServicePackages.id"));
				String productLink = rs.getString("bookings.productLink");
				
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
				String convertCreateDate=sdf.format(createdDate);
				String convertTakeDate= sdf.format(takeDate);
				String describe= rs.getString("bookings.description");
				//System.out.println("getServicepackageName: "+servicePackage.getServicepackageName());
				 Booking booking= new Booking( id,convertPrice,convertDeposit,convertTakeDate,convertCreateDate, statusBookingId,statusBooking,modifyDate,modifyBy,servicePackage, user,describe,productLink);
				 listBooking.add(booking);
			
				
			}
			return listBooking;
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
	

	public List<Booking> getListBookingByStatusSortTakeDate_Photographer(int photographerId, int statusId, int paging) {
		try {
			List<Booking> listBooking = new ArrayList<>();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(BookingQuery.GET_BOOKING_BY_STATUS_FROM_PHOTOGRAPHER_SORT_TAKEDATE);
			preparedStmt.setInt(1, photographerId);
			preparedStmt.setInt(2, statusId);
			preparedStmt.setInt(3, paging);
			
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("bookings.id");
				int price= rs.getInt("bookings.price");
				Date takeDate= rs.getDate("bookings.takeDate");
				int deposit= rs.getInt("bookings.deposit");
				String statusBooking= rs.getString("status_booking.statusBookingName");
				int statusBookingId=  rs.getInt("bookings.statusBookingId");
				String convertPrice= formatter.format(price);
				String convertDeposit= formatter.format(deposit);
				Date createdDate= rs.getDate("bookings.createdDate");
				String modifyBy= rs.getString("bookings.modifiedBy");
				Timestamp modify= rs.getTimestamp("bookings.modifiedDate");
				//String shootingLocation = rs.getString("provices.id");
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				String modifyDate= dateFormat.format(modify);
				String userId= rs.getString("bookings.userId");
				ServicePackage servicePackage = new ServicePackage();
				User user= new User();
				servicePackage.setConvertPrice(convertPrice);
				user.setId(userId);
				String describe= rs.getString("bookings.description");
				servicePackage.setServicepackageName(rs.getString("ServicePackages.servicePackageName"));
				servicePackage.setPhotographerID(rs.getString("ServicePackages.photographerID"));
				//servicePackage.setPointRating(rs.getFloat("ServicePackages.pointRating"));
				user.setAvata(rs.getString("users.avatar"));
				user.setFullName(rs.getString("users.fullName"));
				servicePackage.setCoverImage(rs.getString("images.imageName"));
				servicePackage.setProvinceName(rs.getString("provinces.provinceName"));
				servicePackage.setId(rs.getString("ServicePackages.id"));
				String productLink = rs.getString("bookings.productLink");
				
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
				String convertCreateDate=sdf.format(createdDate);
				String convertTakeDate= sdf.format(takeDate);
				//System.out.println("getServicepackageName: "+servicePackage.getServicepackageName());
				 Booking booking= new Booking( id,convertPrice,convertDeposit,convertTakeDate,convertCreateDate, statusBookingId,statusBooking,modifyDate,modifyBy,servicePackage, user,describe,productLink);
				 listBooking.add(booking);
			
				
			}
			return listBooking;
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



	public boolean updateStatusBookingByPhotographer(int statusId,String nickName, int bookingId) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(BookingQuery.UPDATE_BOOKING_PHOTOGRAPHER);
			preparedStmt.setInt(1, statusId);
			preparedStmt.setString(2, nickName);
			preparedStmt.setInt(3, bookingId);
			
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



	public int getStatusBookingbyId(int bookingId)
	{
		try {
			int statusId = 0;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(BookingQuery.GET_STATUS_BOOKING_BY_ID);
			preparedStmt.setInt(1, bookingId);
		
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				statusId = rs.getInt("statusBookingId");
			}
			return statusId;
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

	
	

	public boolean updateProductLink( String productLink,String nickName, int bookingId) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(BookingQuery.UPDATE_BOOKING_BY_PRODUCTLINK);
			preparedStmt.setString(1, productLink);
			preparedStmt.setString(2, nickName);
			preparedStmt.setInt(3, bookingId);
			
			
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

