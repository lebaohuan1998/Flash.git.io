package nhom1.model;

public class Trip {
	private int tripId;
	private int bookedTicketNumber;
	private String carType;
	private String departureDate;
	private String departureTime;
	private String destination;
	private String driver;
	private int maximumOnlineTicketNumber;
	
	public Trip() {
		super();
	}
	
	public Trip(String carType, String departureDate, String departureTime, String destination, String driver,
			int maximumOnlineTicketNumber) {
		super();
		this.carType = carType;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.destination = destination;
		this.driver = driver;
		this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
	}

	public Trip(int bookedTicketNumber, String carType, String departureDate, String departureTime, String destination,
			String driver, int maximumOnlineTicketNumber) {
		super();
		this.bookedTicketNumber = bookedTicketNumber;
		this.carType = carType;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.destination = destination;
		this.driver = driver;
		this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
	}
	public Trip(int tripId, int bookedTicketNumber, String carType, String departureDate, String departureTime,
			String destination, String driver, int maximumOnlineTicketNumber) {
		super();
		this.tripId = tripId;
		this.bookedTicketNumber = bookedTicketNumber;
		this.carType = carType;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.destination = destination;
		this.driver = driver;
		this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
	}
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public int getBookedTicketNumber() {
		return bookedTicketNumber;
	}
	public void setBookedTicketNumber(int bookedTicketNumber) {
		this.bookedTicketNumber = bookedTicketNumber;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public int getMaximumOnlineTicketNumber() {
		return maximumOnlineTicketNumber;
	}
	public void setMaximumOnlineTicketNumber(int maximumOnlineTicketNumber) {
		this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
	}
	@Override
	public String toString() {
		return "Trip [tripId=" + tripId + ", bookedTicketNumber=" + bookedTicketNumber + ", carType=" + carType
				+ ", departureDate=" + departureDate + ", departureTime=" + departureTime + ", destination="
				+ destination + ", driver=" + driver + ", maximumOnlineTicketNumber=" + maximumOnlineTicketNumber + "]";
	}
	
}
