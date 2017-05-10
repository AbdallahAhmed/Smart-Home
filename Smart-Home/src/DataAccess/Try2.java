package DataAccess;

import java.util.ArrayList;

import Controller.Board;
import Controller.BoardManagement;
import Controller.Device;
import Controller.Operation;
import Controller.User;

public class Try2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
//		DeviceDBAccess d = new DeviceDBAccess();
//		Device dev = new Device();
//		dev.name = "3'asala";
//		dev.model = "2014";
//		dev.Id = 5;
//		d.RegisterDevice(dev, 2, "admin");
/*		Operation o = new Operation();
		o.name = "Power";
		o.values = new ArrayList<String>();
		o.values.add("On");
		o.values.add("Off");
		Device d = new Device();
		d.name = "TV1";
		d.Id = 12;
		d.operations.add(o);
		DeviceDBAccess db = new DeviceDBAccess();
		db.RegisterDevice(d,4444,"admin");*/
		/*db.AddDevice("Admin", "Board2", d);*/
		/*UserDBAccess d = new UserDBAccess();
		System.out.println(d.getUser("Admin", "Admin").toJson());*/
		
		String Query = "insert into Notifications (Details, UserID) Values (\"" + "dnsjdfhd" + "\", " + 5 + ")";
		System.out.println(Query);
		
		NotificationDBAccess n = new NotificationDBAccess();
		boolean a = n.AddNotification("awel Notiii", "Admin");
		System.out.println(a);
		
		a = n.AddNotification("Tany Notiii", "Admin");
		System.out.println(a);
		
		a = n.AddNotification("awel Notiii", "7amada");
		System.out.println(a);
		
		ArrayList<String> ns = n.GetNotifications("Admin");
		for (String string : ns) {
			System.out.println(string);
		}
	}
}
