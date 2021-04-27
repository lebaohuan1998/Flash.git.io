package nhom1.ultility;

public interface DescribePhotographerQuery {
	public static final String GET_DESCRIBE = "SELECT * FROM capstone2.describe_photographer where photographerId=?";

	public static final String UPDATE_DESCRIBE = "UPDATE capstone2.describe_photographer"
			+ " SET  capstone2.describe_photographer.photographerId =?,capstone2.describe_photographer.describeText =?,capstone2.describe_photographer.imageFirst =?,capstone2.describe_photographer.imageSecond =? "
			+ "WHERE capstone2.describe_photographer.photographerId=?";
	public static final String GET_ID = "SELECT * FROM capstone2.photographers WHERE photographers.email=?";
	public static final String Insert_Firt_Decribe ="Insert into capstone2.describe_photographer(photographerId, describeText,imageFirst,imageSecond) Values (?,?,?,?)";
}