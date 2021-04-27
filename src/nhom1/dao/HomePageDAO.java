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
import nhom1.ultility.HomePageQuery;

public class HomePageDAO {
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;
	public List<Photographer> get10Photo(){
		List<Photographer> listP= new ArrayList<>();
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(HomePageQuery.GET10PHOTO);
			rs = preparedStmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("photographers.id");
				String fullName = rs.getString("photographers.fullName");
				String nickName = rs.getString("photographers.nickName");
				String password = rs.getString("photographers.password");
				String gender = rs.getString("identity_photographers.gender");
				String workPlace = rs.getString("photographers.provinceId");
				String organize = rs.getString("photographers.organize");
				String avatar = rs.getString("photographers.avatar");
				Photographer p= new Photographer();
				p.setId(id);
				p.setFullName(fullName);
				p.setNickName(nickName);
				p.setPassword(password);
				p.setGender(gender);
				p.setProvinceId(workPlace);
				p.setOrganize(organize);
				p.setAvata(avatar);
				listP.add(p);	
			}
			return listP;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<Article> get8Article() {
		List<Article> listA = new ArrayList<>();
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(HomePageQuery.GET8ARTICLE);
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
				listA.add(a);
			}
			return listA;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
