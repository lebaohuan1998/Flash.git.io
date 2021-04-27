package nhom1.model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public class Booking {

	private String id;
	private String userId;
	private String codeBooking;
	private String servicePackageId;
	private int price;
	private int deposit;
	private String description;
	private String shootingLocationId;
	private String categoryId;
	private String note;
	private String phoneUser;
	private Date takeDate;
	private String statusBooking;
	private int statusBookingId;
	private String convertPrice;
	private String convertDeposit;
	private String convertCreatedDate;
	private String convertTaketDate;
	private ServicePackage servicePackage;
	private User user;
	private String productLink;
	private String statusBeforeCancel;
	//private String userAvatar;
	private LocalDateTime createDate;
	//private LocalDateTime modifyDate;
	private String modifyBy;
	private String modifyDate;
	int checkComplaint;
	public Booking( String userId, String servicePackageId, int price, int deposit,String description,String shootingLocationId, String categoryId,String note,String phoneUser, Date takeDate) {
		super();
		this.shootingLocationId= shootingLocationId;
		this.categoryId=categoryId;
		this.note= note;
		this.userId = userId;
		this.servicePackageId = servicePackageId;
		this.phoneUser =phoneUser;
		this.description=description;
		this.price = price;
		this.deposit = deposit;
		this.takeDate = takeDate;
		//this.createDate = createDate;
	}
	
	
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getServicePackageId() {
		return servicePackageId;
	}
	public void setServicePackageId(String servicePackageId) {
		this.servicePackageId = servicePackageId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public Date getTakeDate() {
		return takeDate;
	}
	public void setTakeDate(Date takeDate) {
		this.takeDate = takeDate;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoneUser() {
		return phoneUser;
	}
	public void setPhoneUser(String phoneUser) {
		this.phoneUser = phoneUser;
	}
	public String getShootingLocationId() {
		return shootingLocationId;
	}
	public void setShootingLocationId(String shootingLocationId) {
		this.shootingLocationId = shootingLocationId;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getConvertPrice() {
		return convertPrice;
	}
	public void setConvertPrice(String convertPrice) {
		this.convertPrice = convertPrice;
	}
	public String getConvertDeposit() {
		return convertDeposit;
	}
	public void setConvertDeposit(String convertDeposit) {
		this.convertDeposit = convertDeposit;
	}
	public String getStatusBooking() {
		return statusBooking;
	}
	public void setStatusBooking(String statusBooking) {
		this.statusBooking = statusBooking;
	}
	public String getConvertCreatedDate() {
		return convertCreatedDate;
	}
	public void setConvertCreatedDate(String convertCreatedDate) {
		this.convertCreatedDate = convertCreatedDate;
	}
	
	public Booking( String id, String convertPrice, String convertDeposit, String convertTaketDate,String convertCreateDate,int statusBookingId,String statusBooking,String modifyDate,String modifyBy,ServicePackage servicePackage,String phoneUser,String productlink,String statusBeforeCancel ) {
		super();
		this.id=id;
		this.convertPrice = convertPrice;
		this.convertDeposit = convertDeposit;
		this.convertTaketDate = convertTaketDate;
		this.convertCreatedDate=convertCreateDate;
		this.statusBooking=statusBooking;
		this.statusBookingId= statusBookingId;
		this.modifyBy=modifyBy;
		this.modifyDate=modifyDate;
		this.servicePackage = servicePackage;
		this.phoneUser=phoneUser;
		this.productLink=productlink;
		this.setStatusBeforeCancel(statusBeforeCancel);
	}
	public Booking( String id, String convertPrice, String convertDeposit, String convertTaketDate,String convertCreateDate,int statusBookingId,String statusBooking,String modifyDate,String modifyBy,ServicePackage servicePackage, User user,String description,String productLink ) {
		super();
		this.id=id;
		this.convertPrice = convertPrice;
		this.convertDeposit = convertDeposit;
		this.convertTaketDate = convertTaketDate;
		this.convertCreatedDate=convertCreateDate;
		this.statusBooking=statusBooking;
		this.statusBookingId= statusBookingId;
		this.modifyBy=modifyBy;
		this.modifyDate=modifyDate;
		this.servicePackage = servicePackage;
		this.user= user;
		this.description=description;
		this.productLink= productLink;
	}
	
	
	
	
	public ServicePackage getServicePackage() {
		return servicePackage;
	}
	public void setServicePackage(ServicePackage servicePackage) {
		this.servicePackage = servicePackage;
	}
	public String getCodeBooking() {
		return codeBooking;
	}
	public void setCodeBooking(String codeBooking) {
		this.codeBooking = codeBooking;
	}
	public String getConvertTaketDate() {
		return convertTaketDate;
	}
	public void setConvertTaketDate(String convertTaketDate) {
		this.convertTaketDate = convertTaketDate;
	}
	public int getStatusBookingId() {
		return statusBookingId;
	}
	public void setStatusBookingId(int statusBookingId) {
		this.statusBookingId = statusBookingId;
	}
	public String getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}




	public int getCheckComplaint() {
		return checkComplaint;
	}




	public void setCheckComplaint(int checkComplaint) {
		this.checkComplaint = checkComplaint;
	}




	public String getProductLink() {
		return productLink;
	}




	public void setProductLink(String productLink) {
		this.productLink = productLink;
	}




	public String getStatusBeforeCancel() {
		return statusBeforeCancel;
	}




	public void setStatusBeforeCancel(String statusBeforeCancel) {
		this.statusBeforeCancel = statusBeforeCancel;
	}
	
}
