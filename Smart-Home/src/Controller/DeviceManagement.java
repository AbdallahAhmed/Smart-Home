package Controller;

import java.util.ArrayList;

import DataAccess.DeviceDBAccess;

public class DeviceManagement {
	public Device device;

	public Boolean RegisterDevice(Device dev) {
		if (CheckDevice(dev)) {
			return (new DeviceDBAccess()).RegisterDevice(dev);
		} else
			return false;
	}

	public Boolean CheckDevice(Device dev) {
		return (new DeviceDBAccess().CheckDevice(dev));
	}

	public Boolean RemoveDevice(Device dev) {
		return true;
	}

	public Boolean EditDevice(Device dev) {
		return true;
	}

	public Device ViewDevice(int dev) {
		return new Device();
	}

	public Boolean AddDevice(String username, String boardname, String deviceId) {
		return (new DeviceDBAccess()).AddDevice(username, boardname, Integer.parseInt(deviceId));
	}

	public Boolean SetStatus(int ID) {
		return true;
	}

	public ArrayList<Device> ViewDevices() {
		ArrayList<Device> dev = null;
		return (new DeviceDBAccess()).getDevices();
	}

	public void ExecuteCommand(String s) {

	}

}
