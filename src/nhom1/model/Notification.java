package nhom1.model;

import java.time.LocalDateTime;

public class Notification {
	private String id;
	private String userId;
	private String photograherId;
	private String content;
	private String detailLink;
	private int flaging;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	private String convertCreatedDate;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPhotograherId() {
		return photograherId;
	}
	public void setPhotograherId(String photograherId) {
		this.photograherId = photograherId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDetailLink() {
		return detailLink;
	}
	public void setDetailLink(String detailLink) {
		this.detailLink = detailLink;
	}
	public int getFlaging() {
		return flaging;
	}
	public void setFlaging(int flaging) {
		this.flaging = flaging;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getConvertCreatedDate() {
		return convertCreatedDate;
	}
	public void setConvertCreatedDate(String convertCreatedDate) {
		this.convertCreatedDate = convertCreatedDate;
	}
	public Notification(String id, String photograherId, String content, String detailLink, int flaging,String convertCreatedDate) {
		super();
		this.id =id;
		
		this.photograherId = photograherId;
		this.content = content;
		this.detailLink = detailLink;
		this.flaging = flaging;
		this.convertCreatedDate = convertCreatedDate;
	}
	
	public Notification(String id, String userId, String content, String detailLink,String convertCreatedDate, int flaging) {
		super();
		this.id =id;
		
		this.userId = userId;
		this.content = content;
		this.detailLink = detailLink;
		this.flaging = flaging;
		this.convertCreatedDate = convertCreatedDate;
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	

}
