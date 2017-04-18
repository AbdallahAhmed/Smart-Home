package RestServices;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import Controller.User;
import Controller.UserManagement;

@Path("/SignIn/{username}/{password}")
public class SignIn {
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	public String SignIn(@PathParam("username")String username, @PathParam("password") String password)
	{
		  UserManagement um = new UserManagement();
		  User user = new User(username, password);
		  System.out.println(username + " " + password);
		  JSONObject object = new JSONObject();		  
		  object.put("signin", um.SignIn(user));
		  user = um.getUser(user.name, user.password);
		  object.put("user", user.toJson());
		  return object.toString();
	}
}