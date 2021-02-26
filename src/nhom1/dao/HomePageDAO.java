package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nhom1.connection.ConnectionClass;
import nhom1.model.PhotographerOrModel;
import nhom1.ultility.HomePageQuery;

public class HomePageDAO {
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;
	public List<PhotographerOrModel> get8Photo(){
		List<PhotographerOrModel> listPOM = new ArrayList<>();
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(HomePageQuery.GET8PHOTO);
			rs = preparedStmt.executeQuery();
			
			while (rs.next()) {
				
				String photoId = rs.getString("photographerormodel.id");
				String photoEmail = rs.getString("photographerormodel.email");
				String photoFullName = rs.getString("photographerormodel.fullName");
				String photoNgheDanh = rs.getString("photographerormodel.ngheDanh");
				String photoPassWord = rs.getString("photographerormodel.password");
				String photoPhone = rs.getString("photographerormodel.phone");
				String photoTheCanCuoc = rs.getString("photographerormodel.theCanCuoc");
				String photoGender = rs.getString("photographerormodel.gender");
				String photoBod = rs.getString("photographerormodel.bod");
				String photoAddress = rs.getString("photographerormodel.address");
				String photoWorkOfPlace = rs.getString("photographerormodel.noilamviec");
				String photoQuymo = rs.getString("photographerormodel.quymo");
				String photoAvatar = rs.getString("photographerormodel.avatar");
				PhotographerOrModel p= new PhotographerOrModel(photoId, photoEmail, photoFullName, photoNgheDanh, photoPassWord, photoPhone, photoTheCanCuoc, photoBod, photoAddress, photoGender, photoWorkOfPlace, photoQuymo, photoAvatar);
				listPOM.add(p);	
			}
			return listPOM;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
