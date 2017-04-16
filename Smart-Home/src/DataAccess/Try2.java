package DataAccess;

import Controller.User;

public class Try2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*DeviceDBAccess ddb = new DeviceDBAccess();
		ddb.getDevices(2);*/
		UserDBAccess udb = new UserDBAccess();
		User u = udb.getUser("2", "2");
		System.out.println("HI");
		System.out.println(u.toJson());
	}
}
