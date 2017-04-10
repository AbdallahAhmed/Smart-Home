package RestServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.PathParam;

import Controller.User;
import Controller.UserManagement;

@Path("/SignIn/{username}/{password}")
public class SignIn {
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	public String SignIn(@PathParam("username")String username, @PathParam("password") String password) throws JSONException
	{
		  UserManagement um = new UserManagement();
		  User user = new User(username, password);
		  JSONObject object = new JSONObject();
		  
		  object.put("signin", um.SignIn(user));
		  object.put("userdetails", um.getUser(username, password));
		  return object.toString();
	}
}
