package nhom1.model;

public class Location {
	private String locationId;
	private String locationName;
	private String locationx;
	private String locationy;
	
	public String getLocationx() {
		return locationx;
	}
	public void setLocationx(String locationx) {
		this.locationx = locationx;
	}
	public String getLocationy() {
		return locationy;
	}
	public void setLocationy(String locationy) {
		this.locationy = locationy;
	}
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Location(String locationId, String locationName) {
		super();
		this.locationId = locationId;
		this.locationName = locationName;
	}
	
	public Location(String locationId, String locationName, String locationx, String locationy) {
		super();
		this.locationId = locationId;
		this.locationName = locationName;
		this.locationx = locationx;
		this.locationy = locationy;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	

}
