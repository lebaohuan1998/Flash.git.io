package nhom1.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionClass {
	private static ConnectionClass instance;
	private Connection connection;
	
//	private String host="node241350-flash.j.layershift.co.uk";
//	private String db ="capstone1";
//	
	

	private ConnectionClass() {
//		Properties properties = new Properties();
		try {
//			properties.load(ConnectionClass.class.getResourceAsStream("/config.properties"));
//			final String driver =("com.mysql.cj.jdbc.Driver"); 
//			String url="jdbc:mysql://"+host+"/"+db;
//			 String user = ("huan");
//			 String pass = ("lebaohuan1998");
//			 Class.forName(driver);
//			 connection = DriverManager.getConnection(url, user, pass);
//			
			final String driver =("com.mysql.cj.jdbc.Driver");
			final String server = ("jdbc:mysql://localhost:3306/capstone1");
			final String user = ("huan");
			final String pass = ("lebaohuan1998");
			Class.forName(driver);
			connection = DriverManager.getConnection(server, user, pass);

		} catch ( SQLException ex) {
			System.out.println("Database Connection Creation Failed : " + ex.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
		
	}

	public static ConnectionClass createConnect() throws SQLException {
		if (instance == null) {
			instance = new ConnectionClass();
		} else if (instance.getConnection().isClosed()) {
			instance = new ConnectionClass();
		}
		return instance;
	}
}
