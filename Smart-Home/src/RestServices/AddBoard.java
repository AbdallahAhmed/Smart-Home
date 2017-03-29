package RestServices;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/AddBoard/{userID}")
public class AddBoard {
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	public void AddBoard()
	{
		
	}

}
