package Controller;

public class Slider implements UILoader{
	public String execute(int min, int max)
	{
		String s = "<html><body><input type=\"range\" min=\"" + min + "\"" + " max=\"" + max + "\""  + "value=\"0\" "
				+ "step=\"5\"onchange=\"showValue(this.value)\" /><span id=\"range\">"
				+ "0</span><script type=\"text/javascript\">function showValue(newValue)"
				+ "{document.getElementById(\"range\").innerHTML=newValue;}"
				+ "</script><input type=\"submit\" data-inline=\"true\" value=\"Submit\"></body></html>";
		return s;
	}

}
