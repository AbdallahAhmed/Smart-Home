package Controller;

public class UpAndDown implements UILoader{
	public String execute(String name, String up, String down)
	{
		String[] upSplit = up.split(":");
		String[] downSplit = down.split(":");
		String s = "";
		s+="<div class='operation' >"+
		"<label>" + name +"</label>"+
		"<form id = 'form1'>"+
		"<input id='sub' style='font-size:15px;' type='button' value='"+ upSplit[1] +"'>"+
		"<input id='sub2' style='font-size:15px;' type='button' value='"+ downSplit[1] +"'>"+
		"</form></div>";
		return s;
	}

}