package nhom1.ultility;

public interface AccountQuery {
	public static final String GETACCOUNTUSER = "SELECT * FROM users WHERE users.email=? and users.password=?";
	public static final String GETACCOUNTPHOTO = "SELECT * FROM photographers WHERE photographers.email=? and photographers.password=?";
	public static final String GETACCOUNTADMIN = "SELECT * FROM admin WHERE admin.username=? and admin.password=?";
	public static final String GETACTIVEEMAILUSER = "SELECT * FROM users WHERE users.email=? and users.tokenemail=?";
	public static final String GETACTIVEEMAILPHOTO = "SELECT * FROM photographers WHERE photographers.email=? and photographers.tokenemail=?";
	public static final String GETACCOUNTUSERBYEMAIl = "SELECT * FROM users WHERE users.email=? ";
	public static final String GETACCOUNTPHOTOBYEMAIL = "SELECT * FROM photographers WHERE photographers.email=?";
}
