package Controller;

import java.util.ArrayList;

public class modes implements UILoader{
	public String execute(ArrayList<String> mode)
	{
		
		String modes = "";
		String s = "";
		for(int i = 0; i < mode.size(); i++)
		{
			modes+="<option value=\"" +mode.get(i) + "\">" + mode.get(i) +"</option>";
		}
		s += "<div class='operation'><label>Mode : "+
			"<div id='chosenMode'>"+ mode.get(0)  +"</div>"+
			"</label>"+
			"<form action=''>"+
			"<select name='mode' id='mode'>" + modes +"</select> <br>"+
			"<br> <input type='button' value='Submit' onclick='updateMode()'> </form></div>";
		return s;
	}

}