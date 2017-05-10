package RestServices;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Controller.NotificationManagement;

@Path("/GetNotification/{username}")
public class GetNotifications {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String SendNotification(@PathParam("username")String username)
	{
		  NotificationManagement nm = new NotificationManagement();
		  ArrayList<String> n = nm.getNotification(username);
		  JSONArray arr = new JSONArray();
		  for (String s : n) {
			arr.add(s);
		}
		  JSONObject obj = new JSONObject();
		  obj.put("notifications", arr);
		  return obj.toString();
	}

}
