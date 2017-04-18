package Controller;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class User {
	public String name;
	public String password;
	public Board[] boards;
	public User(String username, String password){
		this.name = username;
		this.password = password;
	}
	public JSONObject toJson()
	{
		JSONObject object = new JSONObject();
		object.put("name", name);
		object.put("password", password);
		JSONArray brds = new JSONArray();
		for(int i = 0; i < boards.length; i++){
			brds.add(boards[i].toJson());
		}
		object.put("boards", (Object)brds);
		return object;
	}
}
