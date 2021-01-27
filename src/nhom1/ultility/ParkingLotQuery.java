package nhom1.ultility;

public interface ParkingLotQuery {
	public static final String INSERT_PARK = "INSERT INTO parkinglot (park_area, park_name, park_place, park_price, park_status) VALUES (?,?,?,?,?)";
	public static final String DELETE_PARK = "DELETE FROM parkinglot WHERE park_id=?";
	public static final String GETALL_PARK = "SELECT * FROM parkinglot";
	public static final String SEARCH_PARK = "SELECT * FROM parkinglot WHERE park_name LIKE ?";
	public static final String GETBYID_PARK = "SELECT * FROM parkinglot WHERE park_id=?";
	public static final String UPDATE_PARK = "UPDATE parkinglot SET park_area=?, park_name=?, park_place=?, park_price=?, park_status=? WHERE park_id=?";
}
