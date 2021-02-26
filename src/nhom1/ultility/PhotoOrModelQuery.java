package nhom1.ultility;

public interface PhotoOrModelQuery {
	public static final String INSERT_USER = "INSERT INTO photographerormodel(photographerormodel.email,photographerormodel.fullName,photographerormodel.ngheDanh, photographerormodel.password,photographerormodel.phone,photographerormodel.theCanCuoc,photographerormodel.address, photographerormodel.role,photographerormodel.tokenemail) VALUES (?,?,?,?,?,?,?,?,?)";
	public static final String GETEMAIL = "SELECT * FROM photographerormodel WHERE photographerormodel.email=?";
	public static final String UPDATE_ACTIVEMAIL = "UPDATE photographerormodel SET photographerormodel.status=? WHERE photographerormodel.id=?";
	public static final String QUEN_PASSWORD = "UPDATE photographerormodel SET photographerormodel.password =? WHERE photographerormodel.email=?";
	public static final String GET_ALLINFOPHOTO="SELECT * FROM photographerormodel WHERE photographerormodel.id=?";
	public static final String UPDATE_PHOTO = "UPDATE photographerormodel SET photographerormodel.fullName=?,photographerormodel.address=?, photographerormodel.bod=?, photographerormodel.phone=?, photographerormodel.gender=?, photographerormodel.theCanCuoc=?  WHERE photographerormodel.id=?";
	public static final String UPDATE_PASSWORD = "UPDATE photographerormodel SET photographerormodel.password =? WHERE photographerormodel.id=?";
	public static final String UPDATE_VIEW = "UPDATE photographerormodel SET photographerormodel.ngheDanh =?,photographerormodel.quymo =?,photographerormodel.noilamviec =?,photographerormodel.avatar =? WHERE photographerormodel.id=?";
	public static final String UPDATE_XM = "UPDATE photographerormodel SET photographerormodel.xm1 =?,photographerormodel.xm2 =?,photographerormodel.xm3 =? WHERE photographerormodel.id=?";
}
