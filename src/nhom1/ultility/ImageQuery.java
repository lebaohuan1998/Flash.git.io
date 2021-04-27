package nhom1.ultility;

public interface ImageQuery {
	public static final String GET_IMAGE="SELECT * FROM capstone2.images where servicePackageId=? ORDER BY ID DESC";
	public static final String GET_SERVICEPACKAGE="SELECT * FROM capstone2.servicepackages WHERE servicepackages.id=?";
}
