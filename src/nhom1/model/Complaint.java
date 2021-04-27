package nhom1.model;

public class Complaint {
	
	private String id;
	private String userId;
	private String bookingId;
	private String numberPhone;
	private String content;
	private String title;
	private String resolve;
	private String createdDate;
	private String modifiedDate;
	private String modifiedBy;
	private int flagComplaint;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNumberPhone() {
		return numberPhone;
	}
	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getResolve() {
		return resolve;
	}
	public void setResolve(String resolve) {
		this.resolve = resolve;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public int getFlagComplaint() {
		return flagComplaint;
	}
	public void setFlagComplaint(int flagComplaint) {
		this.flagComplaint = flagComplaint;
	}

	
	
	
	
	
	
	
	
}
