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
		UILoader u = null;

		switch (UIID) {
		case 1:
			int min = Integer.parseInt(dev.operations.get(onumber).values.get(0));
			int max = Integer.parseInt(dev.operations.get(onumber).values.get(1));
			System.out.println(min);
			System.out.println(max);
			return (new Slider().execute(min, max));
		case 2:
			return (new OnAndOff().execute());
		case 3:
			return (new UpAndDown().execute());
		case 4:
			return (new modes().execute());
		default:
			break;
		}
		return null;
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
