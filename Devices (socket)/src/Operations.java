import java.util.Vector;

public class Operations {

	private Vector <Device> devices;
	private String response;

	public Operations()
	{
		devices = new Vector <Device>();
		response = "";
	}

	public String getDeviceInfo(String deviceName , String deviceID)
	{
		if (requiredDevice (deviceName , deviceID) != null)
		{
			Device device = requiredDevice(deviceName , deviceID);

			String deviceInfo = "Name : " + device.getName() + "\n"
					+   "ID : " + Integer.toString(device.getID()) + "\n"
					+   "Status : " + device.getStatus() + "\n"
					+ 	"Operations : " + device.getOperations().toString();
			return deviceInfo;
		}
		else
		{
			response = "Sorry , The required device is not found !";
			return response;
		}	
	}

	public String removeDevice(String deviceName , String deviceID)
	{
		int id = Integer.parseInt(deviceID);
		int index = 0;
		if (requiredDevice (deviceName , deviceID) != null)
		{
			for (int i = 0 ; i < devices.size() ; i++)
			{
				if (devices.get(i).getName() == deviceName &&  devices.get(i).getID() == id)
					index = i;
			}
			
			devices.remove(index);
		    response = "Device : " + deviceName + " is removed successfully!";
		}
		
		else
			response = "Sorry , The required device is not found !";
		
		return response;
	}

	public String updateDevice(String deviceName , String deviceID , String deviceStatus , Vector <String> deviceOperations)
	{
		int id = Integer.parseInt(deviceID);
		int index = 0;
		if (requiredDevice (deviceName , deviceID) != null)
		{
			for (int i = 0 ; i < devices.size() ; i++)
			{
				if (devices.get(i).getName() == deviceName &&  devices.get(i).getID() == id)
					index = i;
			}
			
			Device newDevice = new Device ();
			newDevice = devices.get(index);
			
			newDevice.setName(deviceName);;
			newDevice.setID(Integer.parseInt(deviceID));
			newDevice.setStatus(deviceStatus);
			newDevice.setOperations(deviceOperations);
		    response = "Information of " + deviceName + " device is updated successfully!";
		}
		else
			response = "Sorry , The required device is not found !";
		
		return response;
	}


	public String addDevice(String deviceName , String deviceID , String deviceStatus , Vector <String> deviceOperations)
	{
		Device newDevice = new Device ();
		newDevice.setName(deviceName);;
		newDevice.setID(Integer.parseInt(deviceID));
		newDevice.setStatus(deviceStatus);
		newDevice.setOperations(deviceOperations);
		response = "Device : " + deviceName + " is added successfully!";
		return response;
	}


	public Device requiredDevice (String deviceName , String deviceID)
	{
		int id =  Integer.parseInt(deviceID); 
		for (int i = 0 ; i < devices.size() ; i++)
		{
			if (devices.get(i).getName() == deviceName && devices.get(i).getID() == id)
				return devices.get(i);
		}
		return null;
	}


}
