package nhom1.ultility;

public interface NormalUserQuery {
	public static final String INSERT_NORMALUSER = "INSERT INTO users(users.email, users.password,users.fullName,users.phone, users.role) VALUES (?,?,?,?,?)";
	public static final String GETEMAIL = "SELECT * FROM users WHERE users.email=?";
}