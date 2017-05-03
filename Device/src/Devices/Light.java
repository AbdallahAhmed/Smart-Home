package Devices;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.core.Form;

import org.json.simple.parser.ParseException;

import com.mysql.fabric.xmlrpc.base.Value;

import Connectors.RestConnector;
import Controller.Action;
import Controller.Device;
import Controller.Operation;
import Controller.SocketConnector;

public class Light {
	public static void main(String[] args) throws ParseException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		RestConnector rc = new RestConnector("RegisterDevice", "POST");
		Device d = new Device();
		d.Id = 20;
		d.model = "ABC";
		d.name = "Room Light";
		Operation o = new Operation();
		o.values.add("Turn On:TurnON");
		o.values.add("Turn Off:TurnOFF");
		o.name = "On/Off";
		o.UIComponent = "button";
		o.UIComponentID = 1;
		d.operations.add(o);
		d.status = "OFF";
		rc.addParamPost("Device", d.toJson().toJSONString());
		rc.addParamPost("Username","admin");
		rc.addParamPost("port", "4444");
		System.out.println(rc.getJSONObject());
		Connectors.SocketConnector sc = new Connectors.SocketConnector(5555);
		while(true){
			String msg = sc.recv();
			msg = "Controller." + msg;
			//System.out.println(sc.recv());
			Action ac = (Action)Class.forName(msg).newInstance();
			ac.execute();
		}
		
		
	}
}
