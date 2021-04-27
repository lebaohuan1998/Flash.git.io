package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import nhom1.connection.ConnectionClass;

import nhom1.model.RatingServicePackage;
import nhom1.model.ServicePackage;
import nhom1.ultility.RatingServicePackageQuery;


public class RatingServicePackageDAO {
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;

	DecimalFormat formatter = new DecimalFormat("###,###.###"); 
	

	public boolean insertRating(RatingServicePackage r) {
		// TODO Auto-generated method stub
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(RatingServicePackageQuery.Insert_Rating);
			preparedStmt.setInt(1,r.getServicePackageID());
			preparedStmt.setInt(2,r.getUserID());
			preparedStmt.setString(3,r.getContent());
			preparedStmt.setInt(4,r.getPointStar());
			preparedStmt.setBoolean(5,r.isFlagRating());
			preparedStmt.setDate(6,r.getRatingDate());
			
			
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
	
	
	
	public int sizeofListComment(int servicePackageID) {
		try {
			int count = 0;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(RatingServicePackageQuery.GET_SIZE_COMMENT);
			preparedStmt.setInt(1, servicePackageID);
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

	
	
	
	
	
	
	
	
	


	public boolean getAllComment(int servicePacketID) {
		// TODO Auto-generated method stub
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(RatingServicePackageQuery.GET_ALL_COMMENT);
			preparedStmt.setInt(1,servicePacketID);
			
			
			
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
	

	public List<RatingServicePackage> listCommmentServicePackage(int servicePackageID, int paging) {
		
		try {
			List<RatingServicePackage> listComment = new ArrayList<>();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(RatingServicePackageQuery.GET_ALL_COMMENT);
			preparedStmt.setInt(1, servicePackageID);
			preparedStmt.setInt(2, paging);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("rating_servicepackage.id");
				
				int  userID = rs.getInt("rating_servicepackage.userID");
				String contentCommment = rs.getString("rating_servicepackage.contentComment");
				int pointStar = rs.getInt("rating_servicepackage.pointStar");
				Date ratingDate = rs.getDate("rating_servicepackage.ratingDate");
				Boolean flagRating= rs.getBoolean("rating_servicepackage.flagRating");
				String fullName = rs.getString("users.fullName");
				String avatar=rs.getString("users.avatar");
				String email= rs.getString("users.email");
			
				System.out.println("pointStar="+pointStar);
				
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				
				 long millis=System.currentTimeMillis();  	
				 java.sql.Date dateNow=new java.sql.Date(millis);  
				 
			 String convertDate;
//				 LocalDateTime dateNowConvert=Instant.ofEpochMilli(dateNow.getTime())
//			      .atZone(ZoneId.systemDefault())
//			      .toLocalDateTime();
//				 LocalDateTime ratingDateConvert=Instant.ofEpochMilli(dateNow.getTime())
//					      .atZone(ZoneId.systemDefault())
//					      .toLocalDateTime();
				 
				 //Duration diff = Duration.between(dateNowConvert.atStartOfDay(), ratingDateConvert.atStartOfDay());
								 
				
				 //String dayOfWeek=DayOfWeek(ratingDate);
				 if(formatter.format(ratingDate).equalsIgnoreCase(formatter.format(dateNow)))
				 {
					 convertDate ="H�m nay";
					
				 }
				 else
				 {
					 convertDate = "Ng�y " + formatter.format(ratingDate);
				 }
				 
				if(!flagRating)
				{
				RatingServicePackage r =new RatingServicePackage(id,servicePackageID,userID,contentCommment,pointStar,ratingDate,fullName, avatar,email,convertDate);
				listComment.add(r);
				
				}
				
			}
			return listComment;
			
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
	

	public ServicePackage getInfoAlbum(int serivePackageID) {
		try {
			
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(RatingServicePackageQuery.GET_ALBUM);
			preparedStmt.setInt(1, serivePackageID);
			rs = preparedStmt.executeQuery();
			ServicePackage a= new ServicePackage();
			while (rs.next()) {
				String photographerID=  rs.getString("servicepackages.photographerID");
				String name = rs.getString("servicepackages.servicepackageName");
				String description = rs.getString("servicepackages.description");
				int price = rs.getInt("servicepackages.price");
				int deposit = rs.getInt("servicepackages.deposit");
				String priceConvert = formatter.format(price);
				String depositConvert = formatter.format(deposit);
				
				String categoryName = rs.getString("categories.categoryName");
				String province = rs.getString("provinces.provinceName");
				//String coverImage = rs.getString("images.imageName");
				float pointRating = rs.getFloat("servicepackages.pointRating");
				String convertPoint= String.format("%.2f", pointRating);
				//System.out.println("xemnay"+convertPoint);
				
				a = new ServicePackage(photographerID,name,description,categoryName,province,priceConvert,depositConvert,pointRating,convertPoint);
				
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

	
	
	
	
	

	
	
	
	
	
}
