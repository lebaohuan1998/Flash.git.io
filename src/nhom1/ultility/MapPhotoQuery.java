package nhom1.ultility;

public interface MapPhotoQuery {
	public static final String GETINFOMAPPHOTO="SELECT * FROM location_photographer WHERE location_photographer.photographerId=?";
	public static final String GETALLINFO="SELECT * FROM location_photographer";
	public static final String GETALLINFOBYID="SELECT * FROM location_photographer where photographerId=?";
}
