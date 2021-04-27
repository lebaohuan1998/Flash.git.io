package nhom1.model;

import java.util.Date;

public class Photographer {
	private String id;
	private String email;
	private String fullName;
	private String nickName;
	private String password;
	private String phone;
	private String identityCardNumber;
	private String dateOfBirth;
	private String addressOfId;
	private String gender;
	private String workPlace;
	private String provinceId;
	private String provinceName;
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	private String organize;
	private String frontPhoto;
	private String backPhoto;
	private String fullPhoto;
	private String identityVerifyId;
	private String roleId;
	private String avata;
	private String tokenEmail;
	private String statusAccountId;
    private String statusAccountName;
    private String countFollower;
    private boolean follow;
    public boolean isFollow() {
		return follow;
	}
	public void setFollow(boolean follow) {
		this.follow = follow;
	}
	private Date createdDate;
    private Date modifiedDate;
    private String createBy;
    private String modifiedBy;
	public Photographer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Photographer(String id, String email, String password, String roleId, String statusAccountId) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.roleId = roleId;
		this.statusAccountId = statusAccountId;
	}
	
	
	
	public Photographer(String email, String fullName, String nickName, String password, String phone,
			String identityCardNumber, String addressOfId, String roleId) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.nickName = nickName;
		this.password = password;
		this.phone = phone;
		this.identityCardNumber = identityCardNumber;
		this.addressOfId = addressOfId;
		this.roleId = roleId;
	}
	public Photographer(String email, String fullName, String nickName, String password, String phone,
			String identityCardNumber, String dateOfBirth, String addressOfId, String gender, String provinceId,
			String organize, String frontPhoto, String backPhoto, String fullPhoto, String identityVerifyId,
			String avata, String statusAccountId, String countFollower) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.nickName = nickName;
		this.password = password;
		this.phone = phone;
		this.identityCardNumber = identityCardNumber;
		this.dateOfBirth = dateOfBirth;
		this.addressOfId = addressOfId;
		this.gender = gender;
		this.provinceId = provinceId;
		this.organize = organize;
		this.frontPhoto = frontPhoto;
		this.backPhoto = backPhoto;
		this.fullPhoto = fullPhoto;
		this.identityVerifyId = identityVerifyId;
		this.avata = avata;
		this.statusAccountId = statusAccountId;
		this.countFollower=countFollower;
	}
	public Photographer(String id, String email, String fullName, String nickName, String password, String phone,
			String identityCardNumber, String dateOfBirth, String addressOfId, String gender, String workPlace,
			String provinceId, String organize, String frontPhoto, String backPhoto, String fullPhoto,
			String identityVerifyId, String roleId, String avata, String tokenEmail, String statusAccountId,
			String statusAccountName, String countFollower, Date createdDate, Date modifiedDate, String createBy,
			String modifiedBy) {
		super();
		this.id = id;
		this.email = email;
		this.fullName = fullName;
		this.nickName = nickName;
		this.password = password;
		this.phone = phone;
		this.identityCardNumber = identityCardNumber;
		this.dateOfBirth = dateOfBirth;
		this.addressOfId = addressOfId;
		this.gender = gender;
		this.workPlace = workPlace;
		this.provinceId = provinceId;
		this.organize = organize;
		this.frontPhoto = frontPhoto;
		this.backPhoto = backPhoto;
		this.fullPhoto = fullPhoto;
		this.identityVerifyId = identityVerifyId;
		this.roleId = roleId;
		this.avata = avata;
		this.tokenEmail = tokenEmail;
		this.statusAccountId = statusAccountId;
		this.statusAccountName = statusAccountName;
		this.countFollower = countFollower;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.createBy = createBy;
		this.modifiedBy = modifiedBy;
	}
	
	public void setCountFollower(String countFollower) {
		this.countFollower = countFollower;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIdentityCardNumber() {
		return identityCardNumber;
	}
	public void setIdentityCardNumber(String identityCardNumber) {
		this.identityCardNumber = identityCardNumber;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddressOfId() {
		return addressOfId;
	}
	public void setAddressOfId(String addressOfId) {
		this.addressOfId = addressOfId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getWorkPlace() {
		return workPlace;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getOrganize() {
		return organize;
	}
	public void setOrganize(String organize) {
		this.organize = organize;
	}
	public String getFrontPhoto() {
		return frontPhoto;
	}
	public void setFrontPhoto(String frontPhoto) {
		this.frontPhoto = frontPhoto;
	}
	public String getBackPhoto() {
		return backPhoto;
	}
	public void setBackPhoto(String backPhoto) {
		this.backPhoto = backPhoto;
	}
	public String getFullPhoto() {
		return fullPhoto;
	}
	public void setFullPhoto(String fullPhoto) {
		this.fullPhoto = fullPhoto;
	}
	public String getIdentityVerifyId() {
		return identityVerifyId;
	}
	public void setIdentityVerifyId(String identityVerifyId) {
		this.identityVerifyId = identityVerifyId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getAvata() {
		return avata;
	}
	public void setAvata(String avata) {
		this.avata = avata;
	}
	public String getTokenEmail() {
		return tokenEmail;
	}
	public void setTokenEmail(String tokenEmail) {
		this.tokenEmail = tokenEmail;
	}
	public String getStatusAccountId() {
		return statusAccountId;
	}
	public void setStatusAccountId(String statusAccountId) {
		this.statusAccountId = statusAccountId;
	}
	public String getStatusAccountName() {
		return statusAccountName;
	}
	public void setStatusAccountName(String statusAccountName) {
		this.statusAccountName = statusAccountName;
	}
	public String getCountFollower() {
		return countFollower;
	}
	public void setCountFollowr(String countFollower) {
		this.countFollower = countFollower;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Photographer(String id, String nickName, String provinceId, String organize, String roleId, String avata,
			String countFollower) {
		super();
		this.id = id;
		this.nickName = nickName;
		this.provinceId = provinceId;
		this.organize = organize;
		this.roleId = roleId;
		this.avata = avata;
		this.countFollower = countFollower;
	}
    
	
	
	
	
	
	
	
	
	

}
