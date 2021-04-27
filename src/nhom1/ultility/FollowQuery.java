package nhom1.ultility;

public interface FollowQuery {

	public static final String ADDFOLLOW = "INSERT INTO capstone2.follow_photographer(follow_photographer.photographerId,follow_photographer.userId) VALUES(?,?)";
	public static final String UNFOLLOW = "DELETE FROM capstone2.follow_photographer WHERE follow_photographer.photographerId=? and follow_photographer.userId=? ";
	public static final String GETNUMBER = "SELECT COUNT(*) FROM  capstone2.follow_photographer where follow_photographer.photographerId=?";
	public static final String CHECKFOLLOW = "SELECT COUNT(*) FROM  capstone2.follow_photographer WHERE follow_photographer.photographerId=? and follow_photographer.userId=?";
	public static final String GETFOLLOW_PAGING ="SELECT * FROM (( capstone2.follow_photographer inner join  capstone2.photographers  on follow_photographer.photographerId=photographers.Id ) inner join capstone2.provinces  on photographers.provinceId=provinces.id)where userId=? order by follow_photographer.photographerid  LIMIT ?,8";
	public static final String GET_SIZE_FOLLOW = "SELECT COUNT(*) FROM ( capstone2.follow_photographer inner join  capstone2.photographers  on follow_photographer.photographerId=photographers.id) where userID=?";
	public static final String  GET_LIST_SERVICEPACKET_PAGING="SELECT * FROM (((((capstone2.servicepackages INNER JOIN provinces ON servicepackages.shootingLocationID = provinces.id) INNER JOIN categories ON servicepackages.categoryId = categories.id)	INNER JOIN capstone2.photographers ON photographers.id = servicepackages.photographerId)	\r\n"
			+ "			      INNER JOIN capstone2.images ON servicepackages.id = images.servicePackageId and images.coverImage='1')\r\n"
			+ "			       INNER JOIN capstone2.follow_servicepackage ON servicepackages.id = follow_servicepackage.servicePackageId)\r\n"
			+ "			where follow_servicepackage.userId=? ORDER BY servicepackages.id desc LIMIT ?,9";
	public static final String GET_SIZE_FOLLOW_SERVICEPACKAGE ="SELECT COUNT(*) FROM  capstone2.follow_servicepackage  where userId=?";
	public static final String FOLLOW_SERVICEPACKAGE= " INSERT INTO capstone2.follow_servicepackage(follow_servicepackage.servicePackageId,follow_servicepackage.userId) VALUES(?,?)";
	public static final String UNFOLLOW_SERVICEPACKAGE = "DELETE FROM capstone2.follow_servicepackage WHERE follow_servicepackage.servicePackageId=? and follow_servicepackage.userId=?";
	public static final String CHECK_FOLLOW_SERVICEPACKAGE = "SELECT COUNT(*) FROM  capstone2.follow_servicepackage WHERE follow_servicepackage.servicePackageId=? and follow_servicepackage.userId=?";

}
