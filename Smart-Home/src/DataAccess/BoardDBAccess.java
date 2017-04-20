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
		Statement stmt = null;
		String Query = "select * from Users where UserName= \"" + u + "\"";
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(Query);
			boolean more = rs.next();

			if (!more) {
				return false;
			}

			else if (more) {
				int UserID = rs.getInt("UserID");
				Query = "select * from UserBoard join Boards where UserBoard.UserID = " + UserID ;
				rs = stmt.executeQuery(Query);
				if (rs.next()) return false;
				Query = "insert into Boards (BoardName) values (\"" + b.name + "\")";
				stmt.executeUpdate(Query, Statement.RETURN_GENERATED_KEYS);
				rs = stmt.getGeneratedKeys();
				rs.next();
				int BoardID = rs.getInt(1);
				Query = "insert into UserBoard (UserID , BoardID) values (\"" + UserID + "\" , \"" + BoardID + "\")";
				stmt.executeUpdate(Query);
				return true;
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
		return false;

	}

	public void RemoveBoard() {

	}

	public void EditBoard() {

	}
	
	public Board[] getBoards(int userID) {
		Statement stmt = null;
		String Query = "select * from Boards join UserBoard on Boards.BoardID = UserBoard.BoardID where UserBoard.UserID = " + userID;
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
				b[i] = new Board(rs.getString("BoardName"));
				b[i++].devices = db.getDevices(rs.getInt("BoardID"));
			}

		}


		catch (Exception ex) {
			System.out.println("Getting Devices failed: An Exception has occurred! " + ex);
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
