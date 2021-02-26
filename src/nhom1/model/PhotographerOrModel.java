package nhom1.model;

import java.util.Date;

public class PhotographerOrModel {
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	private String email;
	private String fullName;
	private String ngheDanh;
	private String password;
	private String phone;
	private String tcc;
	private String bod;
	private String address;
	private String gender;
	private String noilamviec;
	private String quymo;
	private String xm1;
	private String xm2;
	private String xm3;
	private String statusXm;
	private String role;
	private String avata;
	private String tokenEmail;
	private String status;
    private Date createdDate;
    private Date modifiedDate;
    private String createBy;
    private String modifiedBy;
	
	public PhotographerOrModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhotographerOrModel(String email, String fullName, String ngheDanh, String password, String phone,
			String tcc, String role) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.ngheDanh = ngheDanh;
		this.password = password;
		this.phone = phone;
		this.tcc = tcc;
		this.role = role;
	}
	
	
	public PhotographerOrModel(String email, String fullName, String tokenEmail) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.tokenEmail = tokenEmail;
		
	}
	
	
	public PhotographerOrModel(String email, String fullName, String ngheDanh, String password, String phone,
			String tcc, String bod, String address, String gender, String noilamviec, String quymo, String xm1,
			String xm2, String xm3, String statusXm, String avata, String status) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.ngheDanh = ngheDanh;
		this.password = password;
		this.phone = phone;
		this.tcc = tcc;
		this.bod = bod;
		this.address = address;
		this.gender = gender;
		this.noilamviec = noilamviec;
		this.quymo = quymo;
		this.xm1 = xm1;
		this.xm2 = xm2;
		this.xm3 = xm3;
		this.statusXm = statusXm;
		this.avata = avata;
		this.status = status;
	}
	
	public PhotographerOrModel(String id, String email, String fullName, String ngheDanh, String password, String phone,
			String tcc, String bod, String address, String gender, String noilamviec, String quymo, String avata) {
		super();
		this.id = id;
		this.email = email;
		this.fullName = fullName;
		this.ngheDanh = ngheDanh;
		this.password = password;
		this.phone = phone;
		this.tcc = tcc;
		this.bod = bod;
		this.address = address;
		this.gender = gender;
		this.noilamviec = noilamviec;
		this.quymo = quymo;
		this.avata = avata;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNoilamviec() {
		return noilamviec;
	}
	public void setNoilamviec(String noilamviec) {
		this.noilamviec = noilamviec;
	}
	public String getQuymo() {
		return quymo;
	}
	public void setQuymo(String quymo) {
		this.quymo = quymo;
	}
	public String getXm1() {
		return xm1;
	}
	public void setXm1(String xm1) {
		this.xm1 = xm1;
	}
	public String getXm2() {
		return xm2;
	}
	public void setXm2(String xm2) {
		this.xm2 = xm2;
	}
	public String getXm3() {
		return xm3;
	}
	public void setXm3(String xm3) {
		this.xm3 = xm3;
	}
	
	public String getStatusXm() {
		return statusXm;
	}
	public void setStatusXm(String statusXm) {
		this.statusXm = statusXm;
	}
	public String getTokenEmail() {
		return tokenEmail;
	}
	public void setTokenEmail(String tokenEmail) {
		this.tokenEmail = tokenEmail;
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
	public String getNgheDanh() {
		return ngheDanh;
	}
	public void setNgheDanh(String ngheDanh) {
		this.ngheDanh = ngheDanh;
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
	public String getTcc() {
		return tcc;
	}
	public void setTcc(String tcc) {
		this.tcc = tcc;
	}
	public String getBod() {
		return bod;
	}
	public void setBod(String bod) {
		this.bod = bod;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAvata() {
		return avata;
	}
	public void setAvata(String avata) {
		this.avata = avata;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	

}
