package Controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Device {
	public String model;
	public String name;
	public String status;
	public Operation[] operations;
	
	public JSONObject toJson(){
		JSONObject obj = new JSONObject();
		obj.put("model", model);
		obj.put("name", name);
		obj.put("status", status);
		JSONArray ops = new JSONArray();
		for(int i = 0; i < operations.length; i++){
			ops.add(operations[i].toJson());
		}
		obj.put("operations", (Object)ops);
		return obj;
	}
}
