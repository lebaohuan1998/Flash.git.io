package nhom1.model;

import java.util.Date;

public class NormalUser {
	private String fullName;
	private String pass;
	private String numberPhone;
    private String email;
    private String address;
    private String role;
    private Date bod;
    private String avata;
    private String status;
    
    
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






	public NormalUser(String fullName, String pass, String numberPhone, String email, String address, String role,
			Date bod, String avata, String status) {
		super();
		this.fullName = fullName;
		this.pass = pass;
		this.numberPhone = numberPhone;
		this.email = email;
		this.address = address;
		this.role = role;
		this.bod = bod;
		this.avata = avata;
		this.status = status;
	}


	public String getFullName() {
		return fullName;
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


	public Date getBod() {
		return bod;
	}


	public void setBod(Date bod) {
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
    
    

}
