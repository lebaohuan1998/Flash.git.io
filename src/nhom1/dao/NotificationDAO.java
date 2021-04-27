package nhom1.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import nhom1.connection.ConnectionClass;
import nhom1.model.Booking;
import nhom1.model.Notification;
import nhom1.model.ServicePackage;
import nhom1.model.User;
import nhom1.ultility.BookingQuery;
import nhom1.ultility.NotificationQuery;
import nhom1.ultility.ScheduleBusyQuery;

public class NotificationDAO {

	
		private Connection connection;
		private PreparedStatement preparedStmt;
		private ResultSet rs;
		
		
		public int countNewNotification(int photographerId) {
			try {
				int count = 0;
				connection = ConnectionClass.createConnect().getConnection();
				preparedStmt = connection.prepareStatement(NotificationQuery.COUNT_NEW_NOTIFICATION);
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
		
		public boolean updateSeenNotification(int photographerId) {
			try {
				connection = ConnectionClass.createConnect().getConnection();
				preparedStmt = connection.prepareStatement(NotificationQuery.UPDATE_SEEN_NOTIFICATION);
				preparedStmt.setInt(1, photographerId);
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
		
		
		
		public List<Notification>  getListNotificationByPhotographer(int photographerId, int paging) {
			try {
				List<Notification> listNotification= new ArrayList<>();
				connection = ConnectionClass.createConnect().getConnection();
				preparedStmt = connection.prepareStatement(NotificationQuery.GET_NOTIFICATAION_BY_PHOTOGRAPHER);
				preparedStmt.setInt(1, photographerId);
				preparedStmt.setInt(2, paging);
				
				rs = preparedStmt.executeQuery();
				while (rs.next()) {
					String id = rs.getString("notifications_photographer.id");
					String content= rs.getString("notifications_photographer.content");
					String detailLink= rs.getString("notifications_photographer.detailLink");
					Timestamp creatDate = rs.getTimestamp("notifications_photographer.createdDate");
					int flaging= rs.getInt("notifications_photographer.flaging");
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
					String convertCreateDate=sdf.format(creatDate);
					System.out.println("convertCreatedate"+convertCreateDate);
					//String shootingLocation = rs.getString("provices.id");
//					SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//					String modifyDate= dateFormat.format(modify);
//					String userId= rs.getString("bookings.userId");
					Notification noti = new Notification(id,String.valueOf(photographerId),content,detailLink,flaging,convertCreateDate);
				
					
			
					//String convertTakeDate= sdf.format(takeDate);
					//System.out.println("getServicepackageName: "+servicePackage.getServicepackageName());
					// Booking booking= new Booking( id,convertPrice,convertDeposit,convertTakeDate,convertCreateDate, statusBookingId,statusBooking,modifyDate,modifyBy,servicePackage, user,describe,productLink);
					listNotification.add(noti);
				
					
				}
				return listNotification;
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
		
		
		

		public int sizeOfListNotificationOfPhotographer(int photographerID) {
			try {
				int count = 0;
				connection = ConnectionClass.createConnect().getConnection();
				preparedStmt = connection.prepareStatement(NotificationQuery.GET_SIZE_NOTIFICATION_BY_PHOTOGRAHER);
				preparedStmt.setInt(1, photographerID);
				
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
		
		
		

		public int sizeOfListNotificationOfUser(int userId) {
			try {
				int count = 0;
				connection = ConnectionClass.createConnect().getConnection();
				preparedStmt = connection.prepareStatement(NotificationQuery.GET_SIZE_NOTIFICATION_BY_USER);
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public boolean deleteNotificationByPhotographerId(String id) {
			try {
				connection = ConnectionClass.createConnect().getConnection();
				preparedStmt = connection.prepareStatement(NotificationQuery.DELETE_NOTIFICATION_BY_PHOTOGRAHER);
				preparedStmt.setString(1, id);
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
		
		
		
		
		public List<Notification>  getListNotificationOfUser(int userId, int paging) {
			try {
				List<Notification> listNotification= new ArrayList<>();
				connection = ConnectionClass.createConnect().getConnection();
				preparedStmt = connection.prepareStatement(NotificationQuery.GET_NOTIFICATAION_BY_USER);
				preparedStmt.setInt(1, userId);
				preparedStmt.setInt(2, paging);
				
				rs = preparedStmt.executeQuery();
				while (rs.next()) {
					String id = rs.getString("notifications_user.id");
					String content= rs.getString("notifications_user.content");
					String detailLink= rs.getString("notifications_user.detailLink");
					Timestamp creatDate = rs.getTimestamp("notifications_user.createdDate");
					int flaging= rs.getInt("notifications_user.flaging");
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
					String convertCreateDate=sdf.format(creatDate);
					System.out.println("convertCreatedate"+convertCreateDate);
					
					Notification noti = new Notification(id,String.valueOf(userId),content,detailLink,convertCreateDate,flaging);
							
					listNotification.add(noti);
				
					
				}
				return listNotification;
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
		
		
		

		public boolean deleteNotificationByUserId(String id) {
			try {
				connection = ConnectionClass.createConnect().getConnection();
				preparedStmt = connection.prepareStatement(NotificationQuery.DELETE_NOTIFICATION_BY_USER);
				preparedStmt.setString(1, id);
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
		
		
		public int countNewNotificationByUser(int userId) {
			try {
				int count = 0;
				connection = ConnectionClass.createConnect().getConnection();
				preparedStmt = connection.prepareStatement(NotificationQuery.COUNT_NEW_NOTIFICATION_USER);
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
		
		public boolean seenNotificationByUser(int userId) {
			try {
				connection = ConnectionClass.createConnect().getConnection();
				preparedStmt = connection.prepareStatement(NotificationQuery.UPDATE_SEEN_NOTIFICATION_BY_USER);
				preparedStmt.setInt(1, userId);
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
