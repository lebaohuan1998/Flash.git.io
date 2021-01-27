package nhom1.ultility;

public interface TicketQuery {
	public static final String INSERT_TICKET = "INSERT INTO ticket (ticket_booking_time, ticket_customer_name, ticket_license_plate, ticket_trip_id) VALUES(now(),?,?,?)";
//	public static final String GETALL_TICKET = "SELECT * FROM car_park_management.ticket \r\n" + 
//			"	INNER JOIN car ON ticket_license_plate = car_license_plate\r\n" + 
//			"    INNER JOIN trip ON ticket_trip_id = trip_id";
	public static final String GETALL_TICKET = "SELECT * FROM ticket";
	public static final String DELETE_TICKET = "DELETE FROM ticket WHERE ticket_id=?";
//	public static final String SEARCH_TICKET = "SELECT * FROM car_park_management.ticket INNER JOIN car ON ticket_license_plate = car_license_plate INNER JOIN trip ON ticket_trip_id = trip_id WHERE ticket_customer_name LIKE ?";
	public static final String SEARCH_TICKET = "SELECT * FROM ticket WHERE ticket_customer_name LIKE ?";
}
