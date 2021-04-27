package nhom1.model;

public class MapPhoto {
	private String id;
	private String locationx;
	private String locationy;
	
	public MapPhoto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MapPhoto(String id, String locationx, String locationy) {
		super();
		this.id = id;
		this.locationx = locationx;
		this.locationy = locationy;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

}
