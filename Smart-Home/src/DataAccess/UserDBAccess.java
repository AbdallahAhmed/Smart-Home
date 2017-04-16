package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Controller.User;

public class UserDBAccess {
	static Connection currentCon;
	static ResultSet rs = null;

	public boolean SignUp(User u) {
		Statement stmt = null;
		String Query = "select * from Users where UserName= \"" + u.name + "\"";

		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(Query);
			boolean more = rs.next();

			if (!more) {
				Query = "insert into Users (UserName , UserPassword) values (\"" + u.name + "\" , \"" + u.password
						+ "\" )";
				stmt.executeUpdate(Query);
				return true;
			}

			else if (more) {
				System.out.println("Username already Exist");
				return false;
			}
		}

		catch (Exception ex) {
			System.out.println("Adding failed: An Exception has occurred! " + ex);
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
		return true;

	}

	public void RemoveUser() {

	}

	public void EditUser() {

	}

	public boolean checkUser(String username, String password) {
		Statement stmt = null;
		String Query = "select * from Users where UserName= \"" + username + "\" and UserPassword = \"" + password
				+ "\"";

		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(Query);
			boolean more = rs.next();

			if (!more) {
				return false;
			}

			else if (more) {
				return true;
			}
		}

		catch (Exception ex) {
			System.out.println("Checking failed: An Exception has occurred! " + ex);
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
		return false;

	}

	public User getUser(String username, String password) {
		Statement stmt = null;
		String Query = "select * from Users where UserName= \"" + username + "\" and UserPassword = \"" + password
				+ "\"";
		User u = new User(username, password);
		BoardDBAccess bdb = new BoardDBAccess();
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(Query);
			rs.next();
			u.boards = bdb.getBoards(rs.getInt("UserID"));

		}

		catch (Exception ex) {
			System.out.println("Getting User failed: An Exception has occurred! " + ex);
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

		return u;
	}

}
