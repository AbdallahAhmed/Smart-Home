package RestServices;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Controller.Board;

@Path("/AddBoard/{userID}")
public class AddBoard {
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	public Boolean AddBoard(Board b)
	{
		return true;
	}

}
