package nhom1.ultility;

public interface BookingOfficeQuery {
	public static final String INSERT_BO = "INSERT INTO bookingoffice (office_end_contract_deadline, office_name, office_phone, office_place, office_price, office_start_contact_deadline, office_trip_id)  VALUE(?,?,?,?,?,?,?)";
	public static final String DELETE_BO = "DELETE FROM bookingoffice WHERE office_id=?";
//	public static final String GETALL_BO = "SELECT * FROM bookingoffice,trip WHERE trip.trip_id = bookingoffice.office_trip_id";
//	public static final String SEARCH_BO = "SELECT * FROM bookingoffice INNER JOIN trip ON trip.trip_id = bookingoffice.office_trip_id WHERE office_name LIKE ?";
	public static final String GETALL_BO = "SELECT * FROM bookingoffice";
	public static final String SEARCH_BO = "SELECT * FROM bookingoffice WHERE office_name LIKE ?";
}
