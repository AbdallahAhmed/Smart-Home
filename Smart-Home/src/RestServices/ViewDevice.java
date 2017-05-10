package RestServices;

import java.util.ArrayList;

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
		ArrayList<Operation> dev = dm.ViewDevice(Integer.parseInt(deviceId));
		JSONObject obj = new JSONObject();
		JSONArray arr = new JSONArray();
		Operation o = new Operation();
		/*o.UIComponentID = 2;
		o.values.add("Turn on: TurnON");
		Operation o1 = new Operation();
		o1.UIComponentID = 3;
		o1.name = "Temp";
		o1.values.add("Temp up: TempUP");
		o1.values.add("Temp down: TempDOWN");
		dev.operations.add(o);
		dev.operations.add(o1);*/
		System.out.println("viewwww" + dev.size() + dev.get(0));
		for (int i = 0; i < dev.size(); i++) {
			arr.add(dev.get(i).GetUI(dev, dev.get(i).UIComponent, i));
			//System.out.println(dev.get(i).GetUI(dev, dev.get(i).UIComponent, i));
		}
		obj.put("operations", (Object) arr);
		return obj.toJSONString();
	}
}
