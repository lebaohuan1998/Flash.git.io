package nhom1.ultility;

public interface NotificationQuery {
	public static final String COUNT_NEW_NOTIFICATION = "SELECT COUNT(*) FROM notifications_photographer WHERE notifications_photographer.photographerId=? and flaging=0";
	public static final String UPDATE_SEEN_NOTIFICATION="UPDATE notifications_photographer SET flaging = 1 where photographerId=?;";
	public static final String GET_NOTIFICATAION_BY_PHOTOGRAPHER ="SELECT * FROM capstone2.notifications_photographer where photographerId= ? order by id desc limit ?,8";
	public static final String GET_SIZE_NOTIFICATION_BY_PHOTOGRAHER ="SELECT COUNT(*) FROM capstone2.notifications_photographer where photographerId= ? ";
	public static final String DELETE_NOTIFICATION_BY_PHOTOGRAHER ="delete FROM capstone2.notifications_photographer where id=? ";
	public static final String GET_SIZE_NOTIFICATION_BY_USER ="SELECT COUNT(*) FROM capstone2.notifications_user where userId= ? ";
	public static final String GET_NOTIFICATAION_BY_USER ="SELECT * FROM capstone2.notifications_user where userId= ? order by id desc limit ?,8";
	public static final String DELETE_NOTIFICATION_BY_USER ="delete FROM capstone2.notifications_user where id=? ";
	public static final String COUNT_NEW_NOTIFICATION_USER = "SELECT COUNT(*) FROM notifications_user WHERE notifications_user.userId=? and flaging=0";
	public static final String UPDATE_SEEN_NOTIFICATION_BY_USER ="UPDATE notifications_USER SET flaging = 1 where userId=?;";
}
