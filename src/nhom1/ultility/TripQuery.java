package nhom1.ultility;

public interface TripQuery {
	public static final String INSERT_TRIP = "INSERT INTO trip (trip_booked_ticket_number, trip_car_type, trip_departure_date, trip_departure_time, trip_destination, trip_driver, trip_maximum_online_ticket_number) VALUE (?,?,?,?,?,?,?)";
	public static final String GETALL_TRIP = "SELECT * FROM trip";
	public static final String DELETE_TRIP = "DELETE FROM trip WHERE trip_id=?";
	public static final String SEARCH_TRIP = "SELECT * FROM trip WHERE trip_driver LIKE ?";
	public static final String GET_TRIP_BY_ID = "SELECT * FROM trip WHERE trip_id = ?";
}
