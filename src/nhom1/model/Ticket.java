package nhom1.model;


public class Ticket {
	private int tickedId;
	private String bookingTime;
	private String customerName;
	private String licensePlate;
	private int tripId;
//	private Car car;
//	private Trip trip;
	public Ticket() {
		super();
	}
	public Ticket(int tickedId, String bookingTime, String customerName, String licensePlate, int tripId) {
		super();
		this.tickedId = tickedId;
		this.bookingTime = bookingTime;
		this.customerName = customerName;
		this.licensePlate = licensePlate;
		this.tripId = tripId;
	}
	public Ticket(String bookingTime, String customerName, String licensePlate, int tripId) {
		super();
		this.bookingTime = bookingTime;
		this.customerName = customerName;
		this.licensePlate = licensePlate;
		this.tripId = tripId;
	}
	public Ticket(String customerName2, String licensePlate2, int tripId2) {
		this.customerName = customerName2;
		this.licensePlate = licensePlate2;
		this.tripId = tripId2;
	}
	public int getTickedId() {
		return tickedId;
	}
	public void setTickedId(int tickedId) {
		this.tickedId = tickedId;
	}
	public String getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
//	public Car getCar() {
//		return car;
//	}
//	public void setCar(Car car) {
//		this.car = car;
//	}
//	public Trip getTrip() {
//		return trip;
//	}
//	public void setTrip(Trip trip) {
//		this.trip = trip;
//	}
//	@Override
//	public String toString() {
//		return "Ticket [tickedId=" + tickedId + ", bookingTime=" + bookingTime + ", customerName=" + customerName
//				+ ", licensePlate=" + licensePlate + ", tripId=" + tripId + ", car=" + car + ", trip=" + trip + "]";
//	}
//	public Ticket(int tickedId, String bookingTime, String customerName, Car car, Trip trip) {
//		super();
//		this.tickedId = tickedId;
//		this.bookingTime = bookingTime;
//		this.customerName = customerName;
//		this.car = car;
//		this.trip = trip;
//	}
//	
}
	
