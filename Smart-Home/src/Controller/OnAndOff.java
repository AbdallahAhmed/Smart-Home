package Controller;

public class OnAndOff implements UILoader {
	public String execute(String status) {
		String s = "";
		s+="<form>"+
		"<div class=\"operation\">"+
		"<label>ON/OFF</label> <input onclick=\"updateSwitch(this)\""+
		"type=\"button\" class=\"fill\" id=\"statusbtn\""+ 
		 "value=\""
		 + status +"\"" +">"+
			"<button id=\"lamp\"></button></div></form>";
		//System.out.println(s);
		return s;
	}

}