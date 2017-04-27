package Controller;

import DataAccess.DeviceDBAccess;

public class DeviceManagement {
	public Device device;
	
	public Boolean RegisterDevice(Device dev)
	{
		return (new DeviceDBAccess()).RegisterDevice(dev);
	}
	public Boolean RemoveDevice(Device dev)
	{
		return true;
	}
	public Boolean EditDevice(Device dev)
	{
		return true;
	}
	public Device ViewDevice(Device dev)
	{
		return dev;
	}
	public Boolean AddDevice()
	{
		return true;
	}
	public Boolean SetStatus(int ID )
	{
		return true;
	}
	public Device[] ViewDevices()
	{
		Device[] dev = null;
		return dev;
	}
	public void ExecuteCommand(String s)
	{
		
	}

}
