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
		o.UIComponentID = 2;
		o.values.add("OFF");
		Operation o1 = new Operation();
		o1.UIComponentID = 3;
		o1.name = "Temp";
		o1.values.add("Mode A");
		o1.values.add("Mode B");
		dev.operations.add(o);
		dev.operations.add(o1);
		for (int i = 0; i < dev.operations.size(); i++) {
			arr.add(dev.operations.get(i).GetUI(dev, dev.operations.get(i).UIComponentID, i));
		}
		obj.put("operations", (Object) arr);
		return obj.toJSONString();
	}
}
