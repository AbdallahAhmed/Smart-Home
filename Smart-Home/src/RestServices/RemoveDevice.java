package RestServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import Controller.DeviceManagement;

@Path("/RemoveDevice/{DeviceId}/{boardname}")
public class RemoveDevice {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String RemoveDevice(@PathParam("DeviceId") String id, @PathParam("boardname") String boardname) {
		DeviceManagement dm = new DeviceManagement();
		Boolean valid = dm.RemoveDevice(Integer.parseInt(id), boardname);
		JSONObject obj = new JSONObject();
		obj.put("valid", valid);
		return obj.toJSONString();
	}

}