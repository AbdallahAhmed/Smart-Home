package DataAccess;

import Controller.Board;
import Controller.User;

public class Try2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		User u = new User("2", "2");
		BoardDBAccess bdb = new BoardDBAccess();
		Board b = new Board();
		b.name = "2";
		bdb.AddBoard(b, u);

	}
}
