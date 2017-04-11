package RestServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.*;
<<<<<<< HEAD
=======

>>>>>>> 33daf5a603596b8948111381568ae5115892c416

import javax.ws.rs.PathParam;

import Controller.User;
import Controller.UserManagement;

@Path("/signin/{username}/{password}")
public class SignIn {
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
<<<<<<< HEAD
	public String getSignIn(@PathParam("username")String username, @PathParam("password") String password) 
=======
	public String SignIn(@PathParam("username")String username, @PathParam("password") String password) 
>>>>>>> 33daf5a603596b8948111381568ae5115892c416
	{
		  UserManagement um = new UserManagement();
		  User user = new User(username, password);
		  JSONObject object = new JSONObject();
		  
		  object.put("signin", um.SignIn(user));
		  object.put("userdetails", um.getUser(username, password));
		  return object.toJSONString();
	}
}
