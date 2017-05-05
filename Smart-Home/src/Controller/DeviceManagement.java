package Controller;

import java.util.ArrayList;

import DataAccess.DeviceDBAccess;

public class DeviceManagement {
	public Device device;

	public Boolean RegisterDevice(Device dev, int portnumber, String username) {
		if (!CheckDevice(dev)) {
			return (new DeviceDBAccess()).RegisterDevice(dev, portnumber, username);
		} else
			return false;
	}

	public Boolean CheckDevice(Device dev) {
		return (new DeviceDBAccess().CheckDevice(dev));
	}

	public Boolean RemoveDevice(int deviceid, String boardname) {
		return true;
	}

	public Boolean EditDevice(Device dev) {
		return true;
	}

	public ArrayList<Operation> ViewDevice(int dev) {
		return (new DeviceDBAccess().getDevices(dev));
	}

	public Boolean AddDevice(String username, String boardname, String deviceId) {
		return (new DeviceDBAccess()).AddDevice(username, boardname, Integer.parseInt(deviceId));
	}

	public Boolean SetStatus(int ID) {
		return true;
	}

	public ArrayList<Device> ViewDevices(String username) {
		return (new DeviceDBAccess()).getDevices(username);
	}

	public void ExecuteCommand(String s) {

	}

}
