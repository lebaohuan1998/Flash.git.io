package nhom1.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import nhom1.connection.ConnectionClass;
import nhom1.model.ScheduleAvailable;
import nhom1.model.ServicePackage;
import nhom1.ultility.ScheduleBusyQuery;

public class ScheduleAvailableDAO {
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;
	public boolean addDateBusy(String date, String idAlbum) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ScheduleBusyQuery.CREATEDATEBUSY);
			preparedStmt.setString(1, date);
			preparedStmt.setString(2, idAlbum);
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
	public List<ScheduleAvailable> getDateByAlbumId(String idAlbum) {
		try {
			List<ScheduleAvailable> lsb = new ArrayList<>();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ScheduleBusyQuery.GETDATEBYID);
			preparedStmt.setString(1, idAlbum);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("schedule_available.id");
				String date = rs.getString("schedule_available.scheduleDate");
				String albumId = rs.getString("schedule_available.servicePackageId");
				
				ScheduleAvailable sb = new ScheduleAvailable();
				sb.setId(id);
				sb.setDate(date);
				sb.setIdAlbum(albumId);
				lsb.add(sb);
			}
			return lsb;
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
	
	public boolean deleteDateById(String id) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ScheduleBusyQuery.DELETEDATEBYID);
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
	
	public boolean deleteAllDateById(String idAlbum) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ScheduleBusyQuery.DELETEALLDATE);
			preparedStmt.setString(1, idAlbum);
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
	
	
	
	
	
	
	
	
	public List<ScheduleAvailable> getDateServicePackage(int idAlbum) {
		try {
			List<ScheduleAvailable> list = new ArrayList<>();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ScheduleBusyQuery.GETDATEBYID);
			preparedStmt.setInt(1, idAlbum);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("schedule_available.id");
				Date date = rs.getDate("schedule_available.scheduleDate");
				String albumId = rs.getString("schedule_available.servicePackageId");
				long millis=System.currentTimeMillis();  
				java.sql.Date dateNow=new java.sql.Date(millis);  
				
				if(date!=null&&date.after(dateNow))
				{
					System.out.println("so sanh duoc roi");
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					String dateString= formatter.format(date);
					ScheduleAvailable sb= new ScheduleAvailable(id,dateString,albumId);
					list.add(sb);
			}
				
			}
			return list;
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
