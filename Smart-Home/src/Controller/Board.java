package Controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Board {
	public String name;
	public Device[] devices;
	
	public Board(String name){
		this.name = name;
	}
	
	public JSONObject toJson(){
		JSONObject obj = new JSONObject();
		obj.put("name", name);
		JSONArray devs = new JSONArray();
		for(int i = 0; i < devices.length; i++){
			devs.add(devices[i].toJson());
		}
		obj.put("devices", (Object)devs);
		return obj;
	}
	
}
