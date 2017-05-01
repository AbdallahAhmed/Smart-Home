package RestServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Controller.Device;
import Controller.DeviceManagement;
import Controller.Operation;

@Path("/ViewDevice/{deviceId}")
public class ViewDevice {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String ViewDevice(@PathParam("deviceId") String deviceId) {
		DeviceManagement dm = new DeviceManagement();
		Device dev = dm.ViewDevice(Integer.parseInt(deviceId));
		JSONObject obj = new JSONObject();
		JSONArray arr = new JSONArray();
		Operation o = new Operation();
		o.UIComponentID = 1;
		dev.operations.add(o);
		Operation o2 = new Operation();
		o2.UIComponentID = 2;
		dev.operations.add(o2);
		for (int i = 0; i < dev.operations.size(); i++) {
			arr.add(dev.operations.get(i).GetUI(dev.operations.get(i).UIComponentID));
		}
		obj.put("operations", (Object) arr);
		return obj.toJSONString();
	}
}
