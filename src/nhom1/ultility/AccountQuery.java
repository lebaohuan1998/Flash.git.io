package nhom1.ultility;

public interface AccountQuery {
	public static final String GETACCOUNTUSER = "SELECT * FROM users WHERE users.email=? and users.password=?";
	public static final String GETACCOUNTPHOTO = "SELECT * FROM photographerormodel WHERE photographerormodel.email=? and photographerormodel.password=?";
	public static final String GETACTIVEEMAILUSER = "SELECT * FROM users WHERE users.email=? and users.tokenemail=?";
	public static final String GETACTIVEEMAILPHOTO = "SELECT * FROM photographerormodel WHERE photographerormodel.email=? and photographerormodel.tokenemail=?";

}
