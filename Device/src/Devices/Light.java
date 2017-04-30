package Devices;

import java.util.ArrayList;

import javax.ws.rs.core.Form;

import org.json.simple.parser.ParseException;

import Connectors.RestConnector;
import Controller.Device;
import Controller.Operation;

public class Light {
	public static void main(String[] args) throws ParseException{
		RestConnector rc = new RestConnector("RegisterDevice", "POST");
		Device d = new Device();
		d.model = "ABC";
		d.name = "Room Light";
		Operation o = new Operation();
		o.name = "On";
		o.UIComponent = "button";
		o.UIComponentID = 1;
		d.operations.add(o);
		d.status = "OFF";
		rc.addParamPost("Device", d.toJson().toJSONString());
		System.out.println(rc.getJSONObject());		
		
	}
}
