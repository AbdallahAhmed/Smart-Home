package Controller;

public class Slider implements UILoader{
	public String execute()
	{
		String s = "<html><body><input type=\"range\" min=\"0\" max=\"100\" value=\"0\" "
				+ "step=\"5\"onchange=\"showValue(this.value)\" /><span id=\"range\">"
				+ "0</span><script type=\"text/javascript\">function showValue(newValue)"
				+ "{document.getElementById(\"range\").innerHTML=newValue;}"
				+ "</script><input type=\"submit\" data-inline=\"true\" value=\"Submit\"></body></html>";
		return s;
	}

}
