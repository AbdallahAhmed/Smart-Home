package Devices;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import Connectors.RestConnector;
import Controller.Action;
import Controller.Device;
import Controller.Operation;

public class Light {
	public static void main(String[] args) throws ParseException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		RestConnector rc = new RestConnector("RegisterDevice", "POST");
		Device d = new Device();
		d.Id = 78;
		d.model = "ABC";
		d.name = "Room Light";
		Operation o = new Operation();
		ArrayList<String> values = new ArrayList<String>();
		values.add("Turn On:TurnON");
		values.add("Turn Off:TurnOFF");
		o.values = (ArrayList<String>) values.clone();
		/*o.values.add("Turn On:TurnON");
		o.values.add("Turn Off:TurnOFF");*/
		o.name = "On/Off";
		o.UIComponent = "OnAndOff";
		o.UIComponentID = 1;
		d.operations.add(o);
		d.status = "OFF";
		rc.addParamPost("Device", d.toJson().toJSONString());
		rc.addParamPost("Username","admin");
		rc.addParamPost("port", "4444");
		System.out.println(rc.getJSONObject());
		Connectors.SocketConnector sc = new Connectors.SocketConnector(4444);
		while(true){
			String msg = sc.recv();
			msg = "Controller." + msg;
			//System.out.println(sc.recv());
			Action ac = (Action)Class.forName(msg).newInstance();
			ac.execute();
		}
		
		
	}
}
