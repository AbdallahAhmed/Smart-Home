package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	static String serverPath;
	static Connection con;

	public void Connection() {

	}

	public static Connection getConnection() {
		try {

			Class.forName("com.mysql.jdbc.Driver");

			try {
				serverPath = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11168426?user=sql11168426&password=AyM67Fx1ab";
				con = DriverManager.getConnection(serverPath);
			}

			catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		catch (ClassNotFoundException e) {
			System.out.println(e);
		}

		return con;

	}

}