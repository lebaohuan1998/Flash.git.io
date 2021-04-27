package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nhom1.connection.ConnectionClass;
import nhom1.model.Category;
import nhom1.ultility.CategoryQuery;

public class CategoryDAO {
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;
	public List<Category> getListCategory(){
		try {
			List<Category> lc = new ArrayList<>();
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(CategoryQuery.GETALLCATEGORY);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("categories.id");
				String name = rs.getString("categories.categoryName");
				
				Category c= new Category(id, name);
				lc.add(c);
			}
			return lc;
		} catch (SQLException e) {
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

}
