package nhom1.ultility;

public interface NormalUserQuery {
	public static final String INSERT_NORMALUSER = "INSERT INTO users(users.email, users.password,users.fullName,users.phone, users.role) VALUES (?,?,?,?,?)";
	public static final String GETEMAIL = "SELECT * FROM users WHERE users.email=?";
	public static final String GET_ALLINFOUSER="SELECT * FROM users WHERE users.id=?";
	public static final String UPDATE_USERNORMAL = "UPDATE users SET users.fullName=?, users.bod=?, users.address=?, users.phone=?, users.gender=?, users.avatar=?  WHERE users.id=?";
	public static final String UPDATE_PASSWORD = "UPDATE users SET users.password =? WHERE users.id=?";

}