package nhom1.model;

public class BookingOffice {
	private int officeId;
	private String endContractDeadline;
	private String officeName;
	private String officePhone;
	private String officePlace;
	private double officePrice;
	private String startContractDeadline;
	private int tripId;
//	private Trip trip;
	public BookingOffice() {
		super();
	}
//	public BookingOffice(int officeId,String endContractDeadline, String officeName, String officePhone, String officePlace,
//			double officePrice, String startContractDeadline, Trip trip) {
//		super();
//		this.officeId = officeId;
//		this.endContractDeadline = endContractDeadline;
//		this.officeName = officeName;
//		this.officePhone = officePhone;
//		this.officePlace = officePlace;
//		this.officePrice = officePrice;
//		this.startContractDeadline = startContractDeadline;
//		this.trip = trip;
//	}
	public BookingOffice(int officeId, String endContractDeadline, String officeName, String officePhone,
			String officePlace, double officePrice, String startContractDeadline, int tripId) {
		super();
		this.officeId = officeId;
		this.endContractDeadline = endContractDeadline;
		this.officeName = officeName;
		this.officePhone = officePhone;
		this.officePlace = officePlace;
		this.officePrice = officePrice;
		this.startContractDeadline = startContractDeadline;
		this.tripId = tripId;
	}
	public BookingOffice(String endContractDeadline, String officeName, String officePhone, String officePlace,
			double officePrice, String startContractDeadline, int tripId) {
		super();
		this.endContractDeadline = endContractDeadline;
		this.officeName = officeName;
		this.officePhone = officePhone;
		this.officePlace = officePlace;
		this.officePrice = officePrice;
		this.startContractDeadline = startContractDeadline;
		this.tripId = tripId;
	}
	public int getOfficeId() {
		return officeId;
	}
	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}
	public String getEndContractDeadline() {
		return endContractDeadline;
	}
	public void setEndContractDeadline(String endContractDeadline) {
		this.endContractDeadline = endContractDeadline;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public String getOfficePlace() {
		return officePlace;
	}
	public void setOfficePlace(String officePlace) {
		this.officePlace = officePlace;
	}
	public double getOfficePrice() {
		return officePrice;
	}
	public void setOfficePrice(double officePrice) {
		this.officePrice = officePrice;
	}
	public String getStartContractDeadline() {
		return startContractDeadline;
	}
	public void setStartContractDeadline(String startContractDeadline) {
		this.startContractDeadline = startContractDeadline;
	}
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
//	public Trip getTrip() {
//		return trip;
//	}
//	public void setTrip(Trip trip) {
//		this.trip = trip;
//	}
//	@Override
//	public String toString() {
//		return "BookingOffice [officeId=" + officeId + ", endContractDeadline=" + endContractDeadline + ", officeName="
//				+ officeName + ", officePhone=" + officePhone + ", officePlace=" + officePlace + ", officePrice="
//				+ officePrice + ", startContractDeadline=" + startContractDeadline + ", tripId=" + tripId + ", trip="
//				+ trip + "]";
//	}
	
	
	
}
