package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nhom1.connection.ConnectionClass;
import nhom1.model.Photographer;
import nhom1.ultility.PhotoOrModelQuery;

public class PhotographerVerifycationDAO {
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;

	public List<Photographer> getInfo(String status, String search, int page) {
		List<Photographer> listP = new ArrayList<Photographer>();

		try {
			if (search == null) {
				search = "";
			}
			if (status == null) {
				status = "1";
			}
			connection = ConnectionClass.createConnect().getConnection();
			if(search.equals("")) {
				if (status.equals("1")) {
					preparedStmt = connection.prepareStatement(PhotoOrModelQuery.GETPHOTOGRAPHERIDENTITY);
					preparedStmt.setInt(1, page);
				} else {
					preparedStmt = connection.prepareStatement(PhotoOrModelQuery.GETPHOTOGRAPHERIDENTITYBYSTATUS);
					preparedStmt.setString(1, status);
					preparedStmt.setInt(2, page);
				}
			}else {
				preparedStmt = connection.prepareStatement(PhotoOrModelQuery.GETPHOTOGRAPHERIDENTITYBYID);
				preparedStmt.setInt(1, page);
			}
				
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String email = rs.getString("email");
				String name = rs.getString("fullName");
				String address = rs.getString("identity_photographers.addressOfId");
				String phone = rs.getString("phone");
				String gender = rs.getString("gender");
				String avata = rs.getString("avatar");
				String ngheDanh = rs.getString("nickName");
				String tcc = rs.getString("identity_photographers.identityCardNumber");
				String xm1 = rs.getString("frontPhoto");
				String xm2 = rs.getString("backPhoto");
				String xm3 = rs.getString("fullPhoto");
				String statusXm = rs.getString("identity_photographers.identityVerifyId");
				String statusIdentity = rs.getString("status_identityverify.statusName");
				String IdentityDate = rs.getString("identity_operaadmin.createDate");
				Photographer p = new Photographer();
				p.setId(id);
				p.setEmail(email);
				p.setFullName(name);
				p.setAddressOfId(address);
				p.setPhone(phone);
				p.setGender(gender);
				p.setAvata(avata);
				p.setNickName(ngheDanh);
				p.setIdentityCardNumber(tcc);
				p.setFrontPhoto(xm1);
				p.setBackPhoto(xm2);
				p.setFullPhoto(xm3);
				p.setIdentityVerifyId(statusXm);
				p.setGender(statusIdentity);
				p.setDateOfBirth(IdentityDate);
				listP.add(p);
			}
			return listP;
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
