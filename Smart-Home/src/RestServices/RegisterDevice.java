package RestServices;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Controller.Device;
import Controller.DeviceManagement;
import Controller.Operation;


@Path("/RegisterDevice")
public class RegisterDevice {
	  @POST
	  @Produces(MediaType.TEXT_PLAIN)
	public String RegisterDevice(@FormParam("Device") String s, @FormParam("Username")String Username,@FormParam("port") String port) throws ParseException
	{	
		System.out.println("fel service");
		int portnumber = Integer.parseInt(port);
		JSONParser parser = new JSONParser();
		JSONObject dev = (JSONObject) parser.parse(s);
		Device regDev = new Device();
		regDev.Id = Integer.parseInt(dev.get("id").toString());
		regDev.model = (String) dev.get("model");
		regDev.name = (String) dev.get("name");
		regDev.status = (String) dev.get("status");
		JSONArray j = new JSONArray();
		j = (JSONArray) dev.get("operations");
		for(int i = 0; i < j.size(); i++){
			JSONObject op = new JSONObject();
			op = (JSONObject) j.get(i);
			Operation dop = new Operation();
			dop.name = (String) op.get("name");
			dop.UIComponent = (String) op.get("UIComponent");
			dop.UIComponentID = Integer.parseInt(op.get("UIComponentID").toString());
			JSONArray ja = new JSONArray();
			ja = (JSONArray) op.get("values");
			for(int r = 0; r < ja.size(); r++){
				dop.values.add((String)ja.get(i));
			}
			regDev.operations.add(dop);
			
		}
		DeviceManagement dm = new DeviceManagement();
		JSONObject ob = new JSONObject();		
		ob.put("valid", dm.RegisterDevice(regDev, portnumber, Username));
		return ob.toJSONString();
				
	}

}
