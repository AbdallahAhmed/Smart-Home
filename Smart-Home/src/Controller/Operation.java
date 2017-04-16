package Controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Operation {
	public String name;
	public String UIComponent;
	public String [] values;
	public int UIComponentID;
	
	public void SetUI()
	{
		
	}
	public UILoader GetUI()
	{
		UILoader u = null;
		return u;
	}
	
	public JSONObject toJson(){
		JSONObject obj = new JSONObject();
		obj.put("name", name);
		obj.put("UIComponent", UIComponent);
		JSONArray vals = new JSONArray();
		for(int i = 0; i < values.length; i++){
			vals.add(values[i]);
		}			
		obj.put("values", (Object)vals);
		obj.put("UIComponentID", UIComponentID);
		return obj;
	}

}
