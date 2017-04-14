package Controller;

import DataAccess.BoardDBAccess;

public class BoardManagement {
	public Board board;
	
	
	public Boolean AddBoard(Board board,User user)
	{
		return (new BoardDBAccess()).AddBoard(board, user);
	}
	public Boolean RemoveBoard(Board b)
	{
		return true;
	}

}
