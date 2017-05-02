package DataAccess;

import java.util.ArrayList;

import Controller.Board;
import Controller.Device;
import Controller.Operation;
import Controller.User;

public class Try2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeviceDBAccess d = new DeviceDBAccess();
		ArrayList<Device> x = d.getDevices("admin");
		System.out.println(x.size());
		/*BoardDBAccess b = new BoardDBAccess();
		System.out.println(b.AddBoard(new Board("Board2"), "Admin"));*/
		/*DeviceDBAccess d = new DeviceDBAccess();
		ArrayList<Device> m = d.getDevices();
		for (Device device : m) {
			System.out.println(device.toJson());
		}*/
		/*UserDBAccess u = new UserDBAccess();
		System.out.println(u.checkUser("Admin", "Admin"));
		User n = u.getUser("Admin", "Admin");
		System.out.println(n.toJson());
		DeviceDBAccess d = new DeviceDBAccess();
		ArrayList<Device> m = d.getDevices("Admin", "Board1");
		for (Device device : m) {
			System.out.println(device.toJson());
		}*/
		/*Operation o = new Operation();
		o.name = "Power";
		o.values = new ArrayList<String>();
		o.values.add("On");
		o.values.add("Off");
		Device d = new Device();
		d.name = "TV";
		d.Id = 8000;
		d.operations.add(o);
		DeviceDBAccess db = new DeviceDBAccess();
		db.RegisterDevice(d,4444,"admin");*/
		//db.AddDevice("Admin", "Board2", d);
		/*UserDBAccess d = new UserDBAccess();
		System.out.println(d.getUser("Admin", "Admin").toJson());*/
	}
}
