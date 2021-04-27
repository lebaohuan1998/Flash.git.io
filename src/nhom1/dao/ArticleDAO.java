package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nhom1.connection.ConnectionClass;
import nhom1.model.Article;
import nhom1.model.Photographer;
import nhom1.model.ServicePackage;
import nhom1.ultility.ArticleQuery;
import nhom1.ultility.HomePageQuery;
import nhom1.ultility.PhotoOrModelQuery;
import nhom1.ultility.ServicePackageQuery;

public class ArticleDAO {
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;

	public Article getByArticleId(String idAr) {
		try {
			Article a = new Article();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ArticleQuery.GETBYARTICLEID);
			preparedStmt.setString(1, idAr);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("articles.id");
				String title = rs.getString("articles.title");
				String content = rs.getString("articles.content");
				String typeId = rs.getString("articles.typeId");
				String author_article = rs.getString("articles.author_article");
				String avatar_article = rs.getString("articles.avatar_article");
				a = new Article(id, title, content, typeId, author_article, avatar_article);
			}
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStmt != null) {
					preparedStmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}
	public List<ServicePackage> getServicePackageArticle(){
		try {
			List<ServicePackage> listS = new ArrayList<>();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ServicePackageQuery.GETALBUMArticle);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String serviceId = rs.getString("servicepackages.id");
				String servicepackageName = rs.getString("servicepackages.servicepackageName");
				String category = rs.getString("categories.categoryName");
				String shootingLocation = rs.getString("provinces.provinceName");
				String priceService = rs.getString("servicepackages.price");
				String nickName = rs.getString("photographers.nickName");
				String deposit = rs.getString("servicepackages.deposit");
				String photographerID = rs.getString("servicepackages.photographerId");
				String coverImage = rs.getString("images.imageName");
				float pointRating =rs.getFloat("servicepackages.pointRating");
				ServicePackage s = new ServicePackage();
				s.setId(serviceId);
				s.setServicepackageName(servicepackageName);
				s.setCategoryName(category);
				s.setShootingLocation(shootingLocation);
				s.setDeposit(Integer.parseInt(deposit));
				s.setPrice(Integer.parseInt(priceService));
				s.setPhotographerID(photographerID);
				s.setNickName(nickName);
				s.setCoverImage(coverImage);
				s.setPointRating(pointRating);
				listS.add(s);
			}
			return listS;
		} catch (

		SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStmt != null) {
					preparedStmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public List<Article> get5NewArticle(String idAr) {
		List<Article> listNA = new ArrayList<>();
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ArticleQuery.GET5NEWARTICLE);
			preparedStmt.setString(1, idAr);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("articles.id");
				String title = rs.getString("articles.title");
				String content = rs.getString("articles.content");
				String typeId = rs.getString("articles.typeId");
				String author_article = rs.getString("articles.author_article");
				String avatar_article = rs.getString("articles.avatar_article");
				Article a = new Article();
				a.setId(id);
				a.setContent(content);
				a.setTitle(title);
				a.setTypeId(typeId);
				a.setAuthor_article(author_article);
				a.setAvatar_article(avatar_article);
				listNA.add(a);
			}
			return listNA;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<Article> get4ArticleRandom(String idARR) {
		List<Article> listAR = new ArrayList<>();
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(ArticleQuery.GET4ARTICLERA);
			preparedStmt.setString(1, idARR);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("articles.id");
				String title = rs.getString("articles.title");
				String content = rs.getString("articles.content");
				String typeId = rs.getString("articles.typeId");
				String author_article = rs.getString("articles.author_article");
				String avatar_article = rs.getString("articles.avatar_article");
				Article a = new Article();
				a.setId(id);
				a.setContent(content);
				a.setTitle(title);
				a.setTypeId(typeId);
				a.setAuthor_article(author_article);
				a.setAvatar_article(avatar_article);
				listAR.add(a);
			}
			return listAR;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
