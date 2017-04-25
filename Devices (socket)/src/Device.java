
import java.util.Vector;

public class Device {
	
	private String name;
	private int id;
	private String status;
	private Vector <String> operations; 
	
	public Device () 
	{
		name = "Machine";
		id = 1000;
		status = "off";
		operations = null;
	}
	
	public Device(String deviceName , int deviceId , String deviceStatus , String deviceOperations[] )
	{
		name = deviceName;
		id = deviceId;
		status = deviceStatus;
		operations = new Vector <String> ();
		for (int i = 0 ; i < deviceOperations.length ; i++){operations.addElement(deviceOperations[i]);}
	}
	
	
	public void setName(String deviceName)
	{
		name = deviceName;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setID(int deviceId)
	{
		id = deviceId;
	}
	
	public int getID()
	{
		return id;
	}
	
	public void setStatus(String deviceStatus)
	{
		status = deviceStatus;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public void setOperations(Vector <String> deviceOperations)
	{
		for (int i = 0 ; i < deviceOperations.size() ; i++){operations.addElement(deviceOperations.get(i));}
	}
	
	public Vector <String> getOperations()
	{
		return operations;
	}

	
}
