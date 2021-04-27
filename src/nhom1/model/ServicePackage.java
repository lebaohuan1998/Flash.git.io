package nhom1.model;

import java.util.List;

public class ServicePackage {
	private String id;
	private String servicepackageName;
	private String description;
	private String categoryId;
	private String shootingLocation;
	private int price;
	private int deposit;
	private String photographerID;
	private String roleId;
	private String categoryName;
	private String provinceName;
	private String nickName;
	private float pointRating;
	private String numberRating;
	private String avatar;
	private String coverImage;
	private String convertPrice;
	private String convertDeposit;
	private String convertPoint;
	private String servicePackStatus;
	public String getServicePackStatus() {
		return servicePackStatus;
	}
	public void setServicePackStatus(String servicePackStatus) {
		this.servicePackStatus = servicePackStatus;
	}





	private List<ScheduleAvailable> date;

	
	
	public String getConvertPrice() {
		return convertPrice;
	}
	public void setConvertPrice(String convertPrice) {
		this.convertPrice =convertPrice;
	}
	public String getConvertDeposit() {
		return convertDeposit;
	}
	public void setConvertDeposit(String convertDeposit) {
		this.convertDeposit = convertDeposit;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public float getPointRating() {
		return pointRating;
	}

	public void setPointRating(float pointRating) {
		this.pointRating = pointRating;
	}

	public String getNumberRating() {
		return numberRating;
	}

	public void setNumberRating(String numberRating) {
		this.numberRating = numberRating;
	}
	

	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public List<ScheduleAvailable> getDate() {
		return date;
	}

	public void setDate(List<ScheduleAvailable> date) {
		this.date = date;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public ServicePackage() {
		super();
	}
	
	public ServicePackage(String servicepackageName, String description, String categoryId, String shootingLocation, int price,
			int deposit, String photographerID) {
		super();
		this.servicepackageName = servicepackageName;
		this.description = description;
		this.categoryId = categoryId;
		this.shootingLocation = shootingLocation;
		this.price = price;
		this.deposit = deposit;
		this.photographerID = photographerID;
	}

	public ServicePackage(String id, String servicepackageName, String description, String categoryId, String shootingLocation,
			int price, int deposit, String photographerID) {
		super();
		this.id = id;
		this.servicepackageName = servicepackageName;
		this.description = description;
		this.categoryId = categoryId;
		this.shootingLocation = shootingLocation;
		this.price = price;
		this.deposit = deposit;
		this.photographerID = photographerID;
	}
	
	public ServicePackage(String id, String servicepackageName, String description, String categoryId,
			String shootingLocation, int price, int deposit, String photographerID, String roleId, String categoryName,
			String provinceName, String nghedanh, float pointRating, String numberRating, String coverImage,
			List<ScheduleAvailable> date) {
		super();
		this.id = id;
		this.servicepackageName = servicepackageName;
		this.description = description;
		this.categoryId = categoryId;
		this.shootingLocation = shootingLocation;
		this.price = price;
		this.deposit = deposit;
		this.photographerID = photographerID;
		this.roleId = roleId;
		this.categoryName = categoryName;
		this.provinceName = provinceName;
		this.nickName = nghedanh;
		this.pointRating = pointRating;
		this.numberRating = numberRating;
		this.coverImage = coverImage;
		this.date = date;
	}
	

	public ServicePackage(String id, String photographerID, String roleId, String provinceName, String nghedanh,
			float pointRating, String numberRating, String coverImage, String avatar,String servicePackageName,int price,String convertPrice) {
		super();
		this.id = id;
		this.photographerID = photographerID;
		this.roleId = roleId;
		this.provinceName = provinceName;
		this.nickName = nghedanh;
		this.pointRating = pointRating;
		this.numberRating = numberRating;
		this.coverImage = coverImage;
		this.avatar= avatar;
		this.servicepackageName= servicePackageName;
		this.price = price;
		this.convertPrice=convertPrice;
		//this.convertPoint=convertPoint;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getServicepackageName() {
		return servicepackageName;
	}
	public void setServicepackageName(String servicepackageName) {
		this.servicepackageName = servicepackageName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getShootingLocation() {
		return shootingLocation;
	}
	public void setShootingLocation(String shootingLocation) {
		this.shootingLocation = shootingLocation;
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
	public String getPhotographerID() {
		return photographerID;
	}
	public void setPhotographerID(String photographerID) {
		this.photographerID = photographerID;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getConvertPoint() {
		return convertPoint;
	}
	public void setConvertPoint(String convertPoint) {
		this.convertPoint = convertPoint;
	}
	
	
	
	

	public ServicePackage(String photographerID, String servicepackageName, String description, String categoryName, String shootingLocation, String priceConvert,
			String depositConvert,  float pointStar, String convertPoint) {
		super();
		this.photographerID = photographerID;
		this.servicepackageName = servicepackageName;
		this.description = description;
		this.categoryName = categoryName;
		this.shootingLocation = shootingLocation;
		this.convertPrice = priceConvert;
		this.convertDeposit = depositConvert;
		this.convertPoint = convertPoint;
		this.pointRating =pointStar;
	
	
	}
	
	
}
