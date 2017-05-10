package RestServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import Controller.NotificationManagement;

@Path("/SendNotification/{notification}/{username}")
public class SendNotification {
	
	 @GET
	 @Produces(MediaType.TEXT_PLAIN)
	public String SendNotification(@PathParam("notification")String n,@PathParam("username")String username)
	{
		  NotificationManagement nm = new NotificationManagement();
		  boolean valid = nm.sendNotification(n, username);
		  JSONObject obj = new JSONObject();
		  obj.put("valid", valid);
		  return obj.toString();
	}

}
