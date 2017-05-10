package Controller;

import java.util.ArrayList;

import DataAccess.NotificationDBAccess;

public class NotificationManagement {
	public boolean sendNotification(String s, String username){
		return (new NotificationDBAccess()).AddNotification(s, username);
	}
	
	public ArrayList<String> getNotification(String username){
		ArrayList<String> notifs = (new NotificationDBAccess()).GetNotifications(username);
		return notifs;
	}
}
