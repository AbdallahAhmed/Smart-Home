package RestServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import Controller.User;
import Controller.UserManagement;

@Path("/SignUp/{name}/{password}")
public class SignUp {
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	public String SignUp(@PathParam("name")String name, @PathParam("password") String password)
	{
		  User user = new User(name,password);
		  UserManagement um = new UserManagement();
		  JSONObject object = new JSONObject();		  
		  object.put("signup", um.SignUp(user));
		  user = um.getUser(user.name, user.password);
		  object.put("user", user.toJson());
		  return object.toString();
		
	}
}
