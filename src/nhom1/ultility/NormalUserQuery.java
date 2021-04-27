package nhom1.ultility;

public interface NormalUserQuery {
	public static final String INSERT_NORMALUSER = "INSERT INTO users(users.email, users.password,users.fullName,users.phone,users.tokenemail, users.roleId,users.statusAccountId) VALUES (?,?,?,?,?,?,2)";
	public static final String GETEMAIL = "SELECT * FROM users WHERE users.email=?";
	public static final String GET_ALLINFOUSER="SELECT * FROM users WHERE users.id=?";
	public static final String UPDATE_USERNORMAL = "UPDATE users SET users.fullName=?, users.dob=?, users.address=?, users.phone=?, users.gender=?, users.avatar=?  WHERE users.id=?";
	public static final String UPDATE_PASSWORD = "UPDATE users SET users.password =? WHERE users.id=?";
	public static final String UPDATE_ACTIVEMAIL = "UPDATE users SET users.statusAccountId=? WHERE users.id=?";
	public static final String QUEN_PASSWORD = "UPDATE users SET users.password =? WHERE users.email=?";
	public static final String GETUSER ="SELECT * FROM users INNER JOIN status_account ON users.statusAccountId = status_account.id WHERE users.roleId=? ORDER BY users.id asc LIMIT ?,10";
	public static final String COUNTUSER="SELECT COUNT(*) FROM users WHERE users.roleId=?";
	public static final String UPDATE_PASSWORDEMAIL = "UPDATE users SET users.password =? WHERE users.email=?";
	public static final String UPDATESTATUS = "UPDATE users SET users.statusAccountId =? WHERE users.id=?";
	public static final String UPDATEROLE = "UPDATE users SET users.roleId =? WHERE users.id=?";
	public static final String UPDATEACTIVEMAIL = "UPDATE users SET users.statusAccountId=? WHERE users.email=?";
}