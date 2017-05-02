package Controller;

public class Slider implements UILoader{
	public String execute()
	{
		String s = "</form><form><div class='operation'><label>Volume</label> <input type='range' step='2' value='50'min='0' max='100' onchange='updateChosen(this)'><div id='chosen'>50</div></div></form>";
		return s;
	}

}
