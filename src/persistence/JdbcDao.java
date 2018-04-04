package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDao {
	private static String connDriver = "com.mysql.jdbc.Driver";
	private static String connURL = "jdbc:mysql://127.0.0.1:3306/biblioteca";
	private static String connUser = "root";
	private static String connPass = "";

	private static Connection conn;

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		try {
			if (conn != null) {
				return conn;
			} else {
				Class.forName(connDriver);
				return DriverManager.getConnection(connURL, connUser, connPass);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return conn;
		}
	}
}
