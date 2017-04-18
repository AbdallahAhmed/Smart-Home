package RestServices;
import javax.servlet.http.HttpServletRequest;
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

@Path("/AddBoard/{boardname}")
public class AddBoard {
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	public String AddBoard(@PathParam("username")String username,@PathParam("boardname")String boardname,HttpServletRequest request)
	{
		  Board board = new Board("boardname");
		  UserManagement um = new UserManagement(); 
		  User user = (User) request.getSession().getAttribute("user");
		  BoardManagement bm = new BoardManagement();
		  user.boards.add(board);
		  JSONObject object = new JSONObject();		  
		  object.put("addboard", bm.AddBoard(board,user));
		  return object.toString();
	}

}
