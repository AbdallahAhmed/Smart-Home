package RestServices;

import javax.ws.rs.GET;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import Controller.User;
import Controller.UserManagement;

@Path("/SignIn")
public class SignIn {
	  @POST	  
	  @Produces(MediaType.TEXT_PLAIN)
	public String SignIn(@FormParam("username")String username, @FormParam("password")String password)
	{
		 		  
		  UserManagement um = new UserManagement();
		  User user = new User(username, password);
		  System.out.println(username + " " + password);
		  JSONObject object = new JSONObject();
		  boolean valid = um.SignIn(user);
		  object.put("signin", valid);
		  user = um.getUser(user.name, user.password);
		  System.out.println(user.toJson());
		  if(valid == true){
			  object.put("user", user.toJson());
		  }
		  return object.toJSONString();
	}
}