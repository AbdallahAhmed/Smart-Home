package DataAccess;

import java.sql.Connection;

public class ConnectionManager {

	static String serverPath;
	static Connection con;

	public void Connection() 
	{
		
	}

	public static Connection getConnection() 
	{
		return con;
		
	}
		
}