package RestServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import Controller.Board;
import Controller.BoardManagement;
import Controller.User;
import Controller.UserManagement;

@Path("/AddBoard/{username}/{boardname}")
public class AddBoard {
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	public String AddBoard(@PathParam("username")String username,@PathParam("boardname")String boardname)
	{
		  UserManagement um = new UserManagement(); 
		  Board board = new Board(boardname);
		  System.out.println(boardname);
		  BoardManagement bm = new BoardManagement();
		  boolean valid = bm.AddBoard(board,username);
		  JSONObject obj = new JSONObject();
		  obj.put("valid", valid);
		  return obj.toString();
		  
	}

}
