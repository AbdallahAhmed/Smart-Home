package Controller;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Board {
	public String name;
	public ArrayList<Device> devices = new ArrayList<Device>();
	
	public Board(String name){
		this.name = name;
	}
	
	public JSONObject toJson(){
		JSONObject obj = new JSONObject();
		obj.put("name", name);
		JSONArray devs = new JSONArray();
		for(int i = 0; i < devices.size(); i++){
			devs.add(devices.get(i).toJson());
		}
		obj.put("devices", (Object)devs);
		return obj;
	}
	
}
