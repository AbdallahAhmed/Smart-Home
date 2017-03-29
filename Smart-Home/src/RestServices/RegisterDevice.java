package RestServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/RegisterDevice/{deviceID}/{boardID}")
public class RegisterDevice {
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	public void RegisterDevice()
	{
		
	}

}
