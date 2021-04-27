package nhom1.model;

public class Account {
	private int id;
	private String username;
	private String password;
	private String fullName;
	private int role;
	private String status;
	
	
	
	public Account() {
		super();
	}
	public Account(int id, String username, String password, String fullName, int role, String status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.role = role;
		this.status = status;
	}
	
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
