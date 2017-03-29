package RestServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/viewBoard/{boardID}")
public class viewBoard {
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	public void viewBoard()
	{
		
	}
}
