package RestServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Controller.Device;

@Path("/ControlDevice/{deviceID}/{operationID}")
public class ControlDevice {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Boolean ControlDevice(Device dev)
	{
		return true;
	}
}
