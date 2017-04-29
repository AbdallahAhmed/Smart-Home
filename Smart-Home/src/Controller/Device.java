package Controller;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Device {
	public String model;
	public String name;
	public String status;
	public ArrayList<Operation> operations = new ArrayList<Operation>();
	public int Id;
	
	public JSONObject toJson(){
		JSONObject obj = new JSONObject();
		obj.put("model", model);
		obj.put("name", name);
		obj.put("status", status);
		JSONArray ops = new JSONArray();
		for(int i = 0; i < operations.size(); i++){
			ops.add(operations.get(i).toJson());
		}
		obj.put("operations", (Object)ops);
		return obj;
	}
}
