package gz.ht.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String url = "jdbc:mysql://localhost:3306/mybatis";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String name = "root";
	private static String psw = "123456";
	
	static Connection conn = null;
	static{
		try {
			Class.forName(driver);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		if(conn==null||conn.isClosed()){
			conn = DriverManager.getConnection(url, name, psw);
		}
		return conn;
	}
	public static void main(String[] x) throws SQLException {
		System.out.print(getConnection());
	}
}
