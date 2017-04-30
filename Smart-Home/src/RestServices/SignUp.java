package RestServices;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import Controller.User;
import Controller.UserManagement;

@Path("/SignUp")
public class SignUp {
	  @POST
	  @Produces(MediaType.TEXT_PLAIN)
	public String SignUp(@FormParam("name")String name, @FormParam("password") String password)
	{
		  System.out.println(name + " " + password + " From SignUp service");
		  User user = new User(name,password);
		  UserManagement um = new UserManagement();
		  JSONObject object = new JSONObject();	
		  boolean valid = um.SignUp(user);
		  user = um.getUser(name, password);
		  object.put("signup", valid);
		  if(valid == true){
			  object.put("user", user.toJson());
		  }
		  return object.toJSONString();
		
	}
}
