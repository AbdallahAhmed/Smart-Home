package Controller;

public class BoardManagement {
	public Board board;
	
	
	public Board AddBoard(Board board)
	{
		this.board = board;
		return board;
	}
	public Boolean RemoveBoard(Board b)
	{
		return true;
	}

}
