package Controller;

import java.util.ArrayList;

import DataAccess.BoardDBAccess;
import DataAccess.DeviceDBAccess;

public class BoardManagement {
	public Board board;
	
	
	public Boolean AddBoard(Board board,String user)
	{
		return (new BoardDBAccess()).AddBoard(board, user);
	}
	public Boolean RemoveBoard(Board b)
	{
		return true;
	}
	
	public ArrayList<Device> getDevices(String username, String boardName){
		ArrayList<Device> devs = (new DeviceDBAccess()).getDevices(username, boardName);
		return devs;
	}

}
