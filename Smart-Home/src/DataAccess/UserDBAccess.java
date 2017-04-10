package DataAccess;

import java.sql.Connection;

import Controller.User;

public class UserDBAccess {
	static Connection currentCon;
	
	public void SignUp()
	{
		
	}
	public void RemoveUser()
	{
		
	}
	public void EditUser()
	{
		
	}
	
	public User getUser(String username, String password){
		User user = new User(username, password);
		return user;
		
	}

}
