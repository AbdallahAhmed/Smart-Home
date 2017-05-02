package Controller;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Operation {
	public String name;
	public String UIComponent;
	public ArrayList<String> values = new ArrayList<String>();
	public int UIComponentID;

	public String GetUI(Device dev, int UIID, int onumber) {

		switch (UIID) {
		case 1:

			String name = dev.operations.get(onumber).name;
			int min = Integer.parseInt(dev.operations.get(onumber).values.get(0));
			int max = Integer.parseInt(dev.operations.get(onumber).values.get(1));
			return (new Slider().execute(name, min, max));
		case 2:
			String status = dev.operations.get(onumber).values.get(0);
			return (new OnAndOff().execute(status));
		case 3:
			ArrayList<String> mode = dev.operations.get(onumber).values;
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
