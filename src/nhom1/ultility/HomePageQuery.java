package nhom1.ultility;

public interface HomePageQuery {
	public static final String GET10PHOTO = "SELECT * FROM capstone2.photographers INNER JOIN capstone2.identity_photographers ON photographers.id=identity_photographers.id Where photographers.statusAccountId=1 and identity_photographers.identityVerifyId=3   ORDER BY photographers.countFollower desc LIMIT 0,10";
	public static final String GET8ARTICLE = "SELECT * FROM capstone2.articles INNER JOIN capstone2.type_article ON articles.typeId=type_article.id  ORDER BY createdDate desc LIMIT 0,8";
}
