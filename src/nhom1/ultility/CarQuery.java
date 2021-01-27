package nhom1.ultility;

public interface CarQuery {
	public static final String INSERT_CAR = "INSERT INTO car VALUES (?,?,?,?,?)";
	public static final String DELETE_CAR = "DELETE FROM car WHERE car_license_plate=?";
	public static final String GETALL_CAR = "SELECT * FROM car";
	public static final String GETBYID_CAR = "SELECT * FROM car WHERE car_license_plate=?";
	public static final String SEARCH_CAR = "SELECT * FROM car WHERE car_license_plate LIKE ?";
//	public static final String GETALL_CAR = "SELECT * FROM car, parkinglot WHERE car.car_park_id = parkinglot.park_id";
//	public static final String SEARCH_CAR = "SELECT * FROM car INNER JOIN parkinglot ON car.car_park_id = parkinglot.park_id AND car_license_plate LIKE ?";
//	public static final String GETBYID_CAR = "SELECT * FROM car INNER JOIN parkinglot ON car.car_park_id = parkinglot.park_id AND car_license_plate = ?";
	public static final String UPDATE_CAR = "UPDATE car SET car_color=?, car_type=?, car_company=?, car_park_id=? WHERE car_license_plate=?";
}
