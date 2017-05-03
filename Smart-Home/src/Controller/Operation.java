package Controller;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Operation {
	public String name;
	public String UIComponent;
	public ArrayList<String> values = new ArrayList<String>();
	public int UIComponentID;

	public String GetUI(ArrayList<Operation> dev, String UIID, int onumber) {

		switch (UIID) {
		case "UpAndDown":
			String name = dev.get(onumber).name;
			String Up = dev.get(onumber).values.get(0);
			String down = dev.get(onumber).values.get(1);
			return (new UpAndDown().execute(name,Up, down));
		case "OnAndOff":
			String status = dev.get(onumber).values.get(0);
			return (new OnAndOff().execute(status));
		case "Modes":
			ArrayList<String> mode = dev.get(onumber).values;
			System.out.println(mode.get(0));
			System.out.println(mode.get(1));
			return (new modes().execute(mode));
		default:
			return null;
		}
	}

	public JSONObject toJson() {
		JSONObject obj = new JSONObject();
		obj.put("name", name);
		obj.put("UIComponent", UIComponent);
		JSONArray vals = new JSONArray();
		for (int i = 0; i < values.size(); i++) {
			vals.add(values.get(i));
		}
		obj.put("values", (Object) vals);
		obj.put("UIComponentID", UIComponentID);
		return obj;
	}

}
