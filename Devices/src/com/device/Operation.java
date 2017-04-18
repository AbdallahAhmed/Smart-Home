package com.device;

import java.util.Vector;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path ("/operation")
public class Operation {

	private Vector <Device> devices;

	public Operation ()
	{
		devices = new Vector <Device> ();
	}

	public Device requiredDevice (String deviceName , String deviceID)
	{
		int id =  Integer.parseInt(deviceID); 
		for (int i = 0 ; i < devices.size() ; i++)
		{
			if (devices.get(i).getName() == deviceName &&  devices.get(i).getID() == id)
				return devices.get(i);
		}
		return null;
	}

	@GET
	@Path("/get/{DeviceName}/{DeviceID}")
	@Produces (MediaType.APPLICATION_JSON)
	public String getDeviceInfo(@PathParam ("DeviceName") String deviceName , @PathParam ("DeviceID") String deviceID)
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
			String response = "Sorry , The required device is not found !";
			return response;
		}
	}


	@POST
	@Path ("/addDevice/{DeviceName}/{DeviceID}/{Status}/{Operations}")
	@Produces (MediaType.APPLICATION_JSON)
	public String addDevice (@FormParam("DeviceName") String deviceName , @FormParam("DeviceID") String deviceID , 
			@FormParam("Status") String deviceStatus , @FormParam("Operations") Vector <String> deviceOperations )
	{
		Device newDevice = new Device ();
		newDevice.setName(deviceName);;
		newDevice.setID(Integer.parseInt(deviceID));
		newDevice.setStatus(deviceStatus);
		newDevice.setOperations(deviceOperations);
		String response = "Device : " + deviceName + " is added successfully!";
		return response;
	}

	@GET
	@Path ("/removeDevice/{DeviceName}/{DeviceID}")
	@Produces (MediaType.APPLICATION_JSON)
	public String removeDevice(@PathParam ("DeviceName") String deviceName , @PathParam ("DeviceID") String deviceID)
	{
		String response = "";
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

	@POST
	@Path ("/updateDevice/{DeviceName}/{DeviceID}/{Status}/{Operations}")
	@Produces (MediaType.APPLICATION_JSON)
	public String updateDevice (@FormParam("DeviceName") String deviceName , @FormParam("DeviceID") String deviceID , 
			@FormParam("Status") String deviceStatus , @FormParam("Operations") Vector <String> deviceOperations )
	{
		int id = Integer.parseInt(deviceID);
		String response = "";
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
}
