package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Controller.Board;
import Controller.User;

public class BoardDBAccess {
	static Connection currentCon;
	static ResultSet rs = null;

	public boolean AddBoard(Board b, String u) {
		boolean result = false;
		Statement stmt = null;
		String Query = "select * from Users where UserName= \"" + u + "\"";
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(Query);
			boolean more = rs.next();

			if (!more) {
				result = false;
			}

			else if (more) {
				int UserID = rs.getInt("UserID");
				Query = "select * from UserBoard join Boards where UserBoard.UserID = " + UserID
						+ " && Boards.BoardName = \"" + b.name + " \" ";
				rs = stmt.executeQuery(Query);
				if (rs.next())
					result = false;
				else {
					Query = "insert into Boards (BoardName) values (\"" + b.name + "\")";
					stmt.executeUpdate(Query, Statement.RETURN_GENERATED_KEYS);
					rs = stmt.getGeneratedKeys();
					rs.next();
					int BoardID = rs.getInt(1);
					Query = "insert into UserBoard (UserID , BoardID) values (\"" + UserID + "\" , \"" + BoardID
							+ "\")";
					stmt.executeUpdate(Query);
					result = true;
				}
			}
		}

		catch (Exception ex) {
			System.out.println("Adding Board failed: An Exception has occurred! " + ex);
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

	public Boolean RemoveBoard(String boardname, int userid) {
		return true;
	}

	public void EditBoard() {

	}

	public Board[] getBoards(int userID) {
		Statement stmt = null;
		String Query = "select * from Boards join UserBoard on Boards.BoardID = UserBoard.BoardID where UserBoard.UserID = "
				+ userID;
		Board[] b = null;
		DeviceDBAccess db = new DeviceDBAccess();
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(Query);
			rs.last();
			b = new Board[rs.getRow()];
			rs.beforeFirst();
			int i = 0;
			while (rs.next()) {
				b[i++] = new Board(rs.getString("BoardName"));
				// b[i++].devices = db.getDevices(rs.getInt("BoardID"));
			}

		}

		catch (Exception ex) {
			System.out.println("Getting Boards failed: An Exception has occurred! " + ex);
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

		return b;

	}

}
