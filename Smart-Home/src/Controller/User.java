package Controller;

public class User {
	public String name;
	public String password;
	public Board[] boards;
	public User(String username, String password){
		this.name = username;
		this.password = password;
	}
}
