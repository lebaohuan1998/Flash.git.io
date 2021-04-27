package nhom1.model;

import java.sql.Date;


public class RatingServicePackage {
	int id;
	int servicePackageID;
	int userID;
	String content;
	int pointStar;
	java.sql.Date ratingDate;
	boolean flagRating;
	String fullName;
	String avata;
	String convertDate;
	String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAvata() {
		return avata;
	}
	public void setAvata(String avata) {
		this.avata = avata;
	}
	
	
	public String getConvertDate() {
		return convertDate;
	}
	public void setConvertDate(String convertDate) {
		this.convertDate = convertDate;
	}
	public boolean isFlagRating() {
		return flagRating;
	}
	public void setFlagRating(boolean flagRating) {
		this.flagRating = flagRating;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getServicePackageID() {
		return servicePackageID;
	}
	public void setServicePackageID(int servicePackageID) {
		this.servicePackageID = servicePackageID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPointStar() {
		return pointStar;
	}
	public void setPointStar(int pointStar) {
		this.pointStar = pointStar;
	}
	public Date getRatingDate() {
		return ratingDate;
	}
	public void setRatingDate(Date ratingDate) {
		this.ratingDate = ratingDate;
	}
	public RatingServicePackage(int id, int servicePackageID, int userID, String content, int pointStar,java.sql.Date ratingDate,String fullName,String  avata,String email,String convertDate) {
		super();
		this.id = id;
		this.servicePackageID = servicePackageID;
		this.userID = userID;
		this.content = content;
		this.pointStar = pointStar;
		this.ratingDate = ratingDate;
		this.avata= avata;
		this.fullName= fullName;
		this.convertDate= convertDate;
		this.email= email;
	}
	
	public RatingServicePackage( int servicePackageID, int userID, String content, int pointStar,boolean flagRating,
			Date ratingDate) {
		super();
		
		this.servicePackageID = servicePackageID;
		this.userID = userID;
		this.content = content;
		this.pointStar = pointStar;
		this.flagRating = flagRating;
		this.ratingDate = ratingDate;
	}
	
	
	
	
	
		
	
	

}
