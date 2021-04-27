package nhom1.ultility;

public interface RatingServicePackageQuery {
	public static final String Insert_Rating= "INSERT INTO rating_servicepackage(rating_servicepackage.servicepackageID,rating_servicepackage.userID,rating_servicepackage.contentComment, rating_servicepackage.pointStar,rating_servicepackage.flagRating,rating_servicepackage.ratingDate) VALUES (?,?,?,?,?,?)";
	public static final String GET_ALL_COMMENT ="SELECT * FROM \r\n"
			+ "( rating_servicepackage INNER JOIN users ON users.id=rating_servicepackage.userID)  WHERE servicePackageID=? Order By rating_servicepackage.id DESC LIMIT ?,5\r\n"
			+ "";
	public static final String GET_SIZE_COMMENT="SELECT COUNT(*) FROM capstone2.rating_servicepackage WHERE servicePackageID=? and flagRating=0;";
	public static final String GET_ALBUM= "SELECT *	FROM "
			+ " (((servicepackages\r\n"
			+ "			INNER JOIN provinces ON servicepackages.shootingLocationID = provinces.id)\r\n"
			+ "			INNER JOIN categories ON servicepackages.categoryID = categories.id)\r\n"
			+ "			INNER JOIN photographers ON photographers.id = servicepackages.photographerID)\r\n"
			+ "			where servicepackages.id=? and servicepackages.servicePackStatus=1";
	public static final String GET_DATEWORK= "SELECT * FROM capstone1.schedule_busy where albumId=?";
}
