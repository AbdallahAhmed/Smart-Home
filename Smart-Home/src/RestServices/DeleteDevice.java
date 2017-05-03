package RestServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import Controller.DeviceManagement;

@Path("/DeleteDevice/{DeviceId}")
public class DeleteDevice {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String DeleteDevice(@PathParam("DeviceId") String id) {
		DeviceManagement dm = new DeviceManagement();
		Boolean valid = dm.DeleteDevice(Integer.parseInt(id));
		JSONObject obj = new JSONObject();
		obj.put("valid", valid);
		return obj.toJSONString();
	}

}
