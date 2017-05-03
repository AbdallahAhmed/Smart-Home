package Controller;

import java.util.ArrayList;

public class modes implements UILoader{
	public String execute(ArrayList<String> mode)
	{
		
		String modes = "";
		String s = "";
		for(int i = 0; i < mode.size(); i++)
		{
			String[] parts = mode.get(i).split(":");
			String part1 = parts[0];
			String part2 = parts[1];
			modes+="<option value=\"" + part2 + "\">" + part1 +"</option>";
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