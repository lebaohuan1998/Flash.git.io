package nhom1.ultility;

public interface ScheduleBusyQuery {

	public static final String CREATEDATEBUSY = "INSERT INTO capstone2.schedule_available (schedule_available.scheduleDate, schedule_available.servicePackageId) VALUES (?,?)";
	public static final String GETDATEBYID = "SELECT * FROM capstone2.schedule_available WHERE schedule_available.servicePackageId=?";
	public static final String DELETEDATEBYID = "DELETE FROM capstone2.schedule_available  WHERE schedule_available.id=?";
	public static final String DELETEALLDATE = "DELETE FROM capstone2.schedule_available  WHERE schedule_available.servicePackageId=?";
}
