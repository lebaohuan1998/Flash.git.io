package nhom1.ultility;

public interface ComplaintQuery {
	public static final String INSERT_COMPLAINT ="INSERT INTO capstone2.complaints(complaints.userId,complaints.bookingId,complaints.title,complaints.content,complaints.numberPhone)	 VALUES (?,?,?,?,?)";
	public static final String CHECK_STATUS_COMPLAINT ="SELECT flagComplaint FROM capstone2.complaints where userId=? and bookingId=? ORDER BY createdDate DESC LIMIT 1 ";
}
