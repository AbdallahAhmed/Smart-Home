package Controller;

import java.util.ArrayList;

public class modes implements UILoader{
	public String execute(ArrayList<String> mode)
	{
		String s = "";
		for(int i = 0; i < mode.size(); i++)
		{
			s += mode.get(i);
		}
		String HTML = "";
		return s;
	}

}