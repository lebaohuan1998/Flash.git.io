package nhom1.model;

public class ScheduleAvailable {
	private String id;
	private String date;
	private String idAlbum;
	public ScheduleAvailable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ScheduleAvailable(String id, String date, String idAlbum) {
		super();
		this.id = id;
		this.date = date;
		this.idAlbum = idAlbum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getIdAlbum() {
		return idAlbum;
	}
	public void setIdAlbum(String idAlbum) {
		this.idAlbum = idAlbum;
	}
	
}
