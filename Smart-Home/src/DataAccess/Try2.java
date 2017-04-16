package DataAccess;

import Controller.User;

public class Try2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDBAccess udb = new UserDBAccess();
		User u = udb.getUser("2", "2");
		System.out.println(u.toJson());
	}
}
