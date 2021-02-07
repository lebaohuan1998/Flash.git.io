package nhom1.model;

import java.util.Date;

public class NormalUser {
	private String id;
	private String fullName;
	private String pass;
	private String numberPhone;
    private String email;
    private String address;
    private String role;
    private String bod;
    private String gender;
    private String avata;
    private String status;
    private Date createdDate;
    private Date modifiedDate;
    private String createBy;
    private String modifiedBy;
    
    
    
	public NormalUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	



	public NormalUser(String fullName, String pass, String numberPhone, String email, String role) {
		super();
		this.fullName = fullName;
		this.pass = pass;
		this.numberPhone = numberPhone;
		this.email = email;
		this.role = role;
	}




	public NormalUser(String fullName, String pass, String numberPhone, String email, String address, String bod) {
		super();
		this.fullName = fullName;
		this.pass = pass;
		this.numberPhone = numberPhone;
		this.email = email;
		this.address = address;
		this.bod = bod;
	}






	public NormalUser(String fullName, String pass, String numberPhone, String email, String address, String bod,
			String avata) {
		super();
		this.fullName = fullName;
		this.pass = pass;
		this.numberPhone = numberPhone;
		this.email = email;
		this.address = address;
		this.bod = bod;
		this.avata = avata;
	}




	public NormalUser(String id, String fullName, String pass, String numberPhone, String email, String address,
			String role, String bod, String avata, String status,String gender) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.pass = pass;
		this.numberPhone = numberPhone;
		this.email = email;
		this.address = address;
		this.role = role;
		this.bod = bod;
		this.avata = avata;
		this.status = status;
		this.gender=gender;
	}






	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getFullName() {
		return fullName;
	}


	public String getId() {
		return id;
	}






	public void setId(String id) {
		this.id = id;
	}






	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getNumberPhone() {
		return numberPhone;
	}


	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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


	public String getBod() {
		return bod;
	}


	public void setBod(String bod) {
		this.bod = bod;
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
