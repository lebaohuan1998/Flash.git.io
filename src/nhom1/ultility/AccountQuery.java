package nhom1.ultility;

public interface AccountQuery {
	public static final String GETACCOUNT = "SELECT * FROM users WHERE users.email=? and users.password=?";
}
