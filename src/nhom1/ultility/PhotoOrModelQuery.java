package nhom1.ultility;

public interface PhotoOrModelQuery {
	public static final String INSERT_USER = "INSERT INTO photographerormodel(photographerormodel.email,photographerormodel.fullName,photographerormodel.ngheDanh, photographerormodel.password,photographerormodel.phone,photographerormodel.theCanCuoc, photographerormodel.role,photographerormodel.tokenemail) VALUES (?,?,?,?,?,?,?,?)";
	public static final String GETEMAIL = "SELECT * FROM photographerormodel WHERE photographerormodel.email=?";
	public static final String UPDATE_ACTIVEMAIL = "UPDATE photographerormodel SET photographerormodel.status=? WHERE photographerormodel.id=?";
}
