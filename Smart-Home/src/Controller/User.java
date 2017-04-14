package Controller;

import java.util.ArrayList;

public class User {
	public String name;
	public String password;
	public ArrayList<Board> boards=new ArrayList<Board>();
	public User(String username, String password){
		this.name = username;
		this.password = password;
	}
}
