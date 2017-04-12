package DataAccess;

import Controller.User;

public class Try2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDBAccess udb = new UserDBAccess();
		User u = new User("2", "2");
		udb.SignUp(u);

	}
}
