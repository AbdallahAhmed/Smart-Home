package Controller;

import DataAccess.UserDBAccess;

public class UserManagement {
	public User user;
	
	public Boolean SignUp(User u)
	{
		return (new UserDBAccess()).SignUp(u);
	}
	public Boolean SignIn(User u){
		
		return (new UserDBAccess()).checkUser(u.name, u.password);
	}
	
	public boolean SignOut()
	{
		return true;
	}
	public User getUser(String username, String password)
	{
		UserDBAccess UDB = new UserDBAccess();
		return UDB.getUser(username, password);
	}
	public Boolean EditUser(User u)
	{
		return true;
	}
	public Boolean RemoveUser(User u)
	{
		
	}
}
