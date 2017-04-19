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

@Path("/AddBoard/{username}/{password}{boardname}")
public class AddBoard {
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	public String AddBoard(@PathParam("username")String username,@PathParam("boardname")String boardname,@PathParam("password") String password )
	{
		  UserManagement um = new UserManagement(); 
		  User user = um.getUser(username, password);
		  Board board = new Board("boardname");
		  BoardManagement bm = new BoardManagement();
		  bm.AddBoard(board,user);
		  JSONObject object = new JSONObject();		  
		  object.put("user", user.toJson());
		  
		  return object.toString();
	}

}
