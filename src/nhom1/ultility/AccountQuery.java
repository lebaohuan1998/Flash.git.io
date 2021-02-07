package nhom1.ultility;

public interface AccountQuery {
	public static final String GETACCOUNTUSER = "SELECT * FROM users WHERE users.email=? and users.password=?";
	public static final String GETACCOUNTPHOTO = "SELECT * FROM photographerormodel WHERE photographerormodel.email=? and photographerormodel.password=?";

}
