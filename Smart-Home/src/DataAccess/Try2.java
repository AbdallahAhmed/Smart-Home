package DataAccess;

import Controller.Board;
import Controller.BoardManagement;
import Controller.User;

public class Try2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDBAccess udb = new UserDBAccess();
		User u = udb.getUser("2", "2");
		Board b = new Board("4");
		BoardManagement bm = new BoardManagement();
		bm.AddBoard(b, u);
		bm.AddBoard(b, u);
		System.out.println(u.toJson());
	}
}
