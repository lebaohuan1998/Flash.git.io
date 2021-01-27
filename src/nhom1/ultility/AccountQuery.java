package nhom1.ultility;

public interface AccountQuery {
	public static final String GETACCOUNT = "SELECT * FROM users WHERE users.username=? and users.password=?";
}
