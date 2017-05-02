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

@Path("/ViewDevices/{username}")
public class ViewDevices {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String viewDevices(@PathParam("username") String username)
	{
		DeviceManagement dm = new DeviceManagement();
		ArrayList<Device> d = dm.ViewDevices(username);
		JSONObject obj = new JSONObject();
		JSONArray arr = new JSONArray();
		System.out.println("size" + d.size());
		for(int i = 0; i < d.size(); i++)
		{
			arr.add(d.get(i).toJson());
			System.out.println(d.get(i)+"mfish devices");
		}
		obj.put("Devices", (Object)arr);
		return obj.toJSONString();
	}

}
