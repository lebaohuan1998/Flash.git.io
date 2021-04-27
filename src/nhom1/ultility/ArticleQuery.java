package nhom1.ultility;

public interface ArticleQuery {
	public static final String GETBYARTICLEID = "SELECT * FROM capstone2.articles INNER JOIN capstone2.type_article ON articles.typeId=type_article.id where articles.id=?";
	public static final String GET4SERVICEPACKAGE="SELECT * FROM capstone2.articles INNER JOIN capstone2.type_article ON articles.typeId=type_article.id  ORDER BY articles.id asc LIMIT 0,8";
	public static final String GET5NEWARTICLE="SELECT  * FROM capstone2.articles where articles.id <>? ORDER BY createdDate desc LIMIT 0,5";
	public static final String GET4ARTICLERA="SELECT * FROM capstone2.articles where articles.id <>? ORDER BY RAND() LIMIT 0,4;";
}
