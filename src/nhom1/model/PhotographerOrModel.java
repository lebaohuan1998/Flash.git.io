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
	private Date bod;
	private String address;
	private String role;
	private String avata;
	private String tokenEmail;
	private String status;
	private String exp;
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
	
	public PhotographerOrModel(String email, String fullName, String ngheDanh, String password, String phone,
			String tcc, Date bod, String address, String role, String avata, String status, String exp) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.ngheDanh = ngheDanh;
		this.password = password;
		this.phone = phone;
		this.tcc = tcc;
		this.bod = bod;
		this.address = address;
		this.role = role;
		this.avata = avata;
		this.status = status;
		this.exp = exp;
	}
	
	public PhotographerOrModel(String email, String fullName, String tokenEmail) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.tokenEmail = tokenEmail;
		
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
	public Date getBod() {
		return bod;
	}
	public void setBod(Date bod) {
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
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
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
