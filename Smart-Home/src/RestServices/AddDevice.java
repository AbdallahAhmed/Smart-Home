package RestServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Controller.Device;

@Path("/AddDevice/{userID}/{boardID}/{deviceID}")
public class AddDevice {
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	public Boolean AddDevice(Device dev)
	{
		return true;
	}
	  

}
