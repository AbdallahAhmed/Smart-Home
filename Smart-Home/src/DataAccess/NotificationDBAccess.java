package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class NotificationDBAccess {
	
	static Connection currentCon;
	
	public boolean AddNotification(String n, String username) {
		boolean result = false;
		ResultSet rs = null;
		Statement stmt = null;
		String Query = "select * from Users where UserName = \"" + username + "\"";
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(Query);
			boolean more = rs.next();
			if (more) {
				Query = "insert into Notifications (Details, UserID) Values (\"" + n + "\", " + rs.getInt("UserID") + ")";
				stmt.executeUpdate(Query);
				result = true;
			}
		}

		catch (Exception ex) {
			System.out.println("Adding Notification failed: An Exception has occurred! " + ex);
		}

		// some exception handling
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (currentCon != null) {
				currentCon.close();
				currentCon = null;
			}
		} catch (Exception e) {

		}
		return result;

	}
	
	public ArrayList<String> GetNotifications(String username) {
		ResultSet rs = null;
		Statement stmt = null;
		ArrayList<String> n = new ArrayList<String>();
		String Query = "select * from Users Join Notifications on Users.UserID = Notifications.UserID where UserName = \"" + username + "\"";
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(Query);
			while (rs.next()) {
				n.add(rs.getString("Details"));
			}
		}

		catch (Exception ex) {
			System.out.println("Getting Notifications failed: An Exception has occurred! " + ex);
		}

		// some exception handling
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (currentCon != null) {
				currentCon.close();
				currentCon = null;
			}
		} catch (Exception e) {

		}
		return n;

	}

}
