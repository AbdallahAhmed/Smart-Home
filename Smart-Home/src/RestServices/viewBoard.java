package RestServices;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Controller.BoardManagement;
import Controller.Device;
import Controller.DeviceManagement;

@Path("/viewBoard/{username}/{boardName}")
public class viewBoard {
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	public String viewBoard(@PathParam("username") String username, @PathParam("boardName")String boardName)
	{
		BoardManagement dm = new BoardManagement();
		ArrayList<Device> devs = dm.getDevices(username, boardName);
		JSONArray jDevs = new JSONArray();
		for(int i = 0; i < devs.size(); i++){
			jDevs.add(devs.get(i).toJson());
		}
		JSONObject obj = new JSONObject();
		obj.put("devices", (Object)jDevs);
		return obj.toJSONString();
	}
}
