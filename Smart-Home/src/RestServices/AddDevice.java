package RestServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import Controller.Board;
import Controller.Device;
import Controller.DeviceManagement;
import Controller.UserManagement;

@Path("/AddDevice/{username}/{boardname}/{deviceId}")
public class AddDevice {
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	public String AddDevice(@PathParam("username") String username, @PathParam("boardname") String boardname,
						 	 @PathParam("deviceId") String deviceId )
	{
		 System.out.println(username + " " + boardname + " " +deviceId);
		DeviceManagement dm = new DeviceManagement();
		//System.out.println("boardname" + boardname);
		boolean valid = dm.AddDevice(username, boardname, deviceId);
		JSONObject obj = new JSONObject();
		obj.put("valid", valid);
		return obj.toString();
	}
	  

}
