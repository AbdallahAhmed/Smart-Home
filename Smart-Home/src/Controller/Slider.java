package Controller;

public class Slider implements UILoader {
	public String execute(String name, int min, int max) {
		
		String s = "";
		s +="<form>" +
		"<div class=\"operation\">"+
		"<label>" + name + "</label> <input type=\"range\" step=\"2\" value=\"" + min +  "\""+
		"min="+ "\"" + min +"\"  max=\""+max+"\" onchange=\"updateChosen(this)\">"+
		"<div id=\"chosen\">"+ min +"</div>" +
		"</div></form>";
		return s;
	}

}
