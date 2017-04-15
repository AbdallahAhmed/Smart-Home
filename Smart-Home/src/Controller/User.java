package Controller;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class User {
	public String name;
	public String password;
	public ArrayList<Board> boards=new ArrayList<Board>();
	public User(String username, String password){
		this.name = username;
		this.password = password;
	}
	public String toJson(User user)
	{
		JSONObject object = new JSONObject();
		object.put("name", user.name);
		object.put("password", user.password);
		
		return object.toString();
	}
}
