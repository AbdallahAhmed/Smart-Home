package Controller;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class User {
	public String name;
	public String password;
	public ArrayList<Board> boards=new ArrayList<Board>();
	public User(String username, String password){
		this.name = username;
		this.password = password;
	}
	public JSONObject toJson(User user)
	{
		JSONObject object = new JSONObject();
		object.put("name", user.name);
		object.put("password", user.password);
		JSONArray brds = new JSONArray();
		for(int i = 0; i < boards.size(); i++){
			brds.add(boards.get(i).toJson());
		}
		object.put("boards", (Object)brds);
		return object;
	}
}
