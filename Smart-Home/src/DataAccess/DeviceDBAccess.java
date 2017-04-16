package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Controller.Device;
import Controller.Operation;

public class DeviceDBAccess {

	static Connection currentCon;
	static ResultSet rs = null;

	public void AddDevice() {

	}

	public void RemoveDevice() {

	}

	public void EditDevice() {

	}

	public Device[] getDevices(int BoardID) {
		Statement stmt = null;
		String Query = "select * from Devices where BoardID = " + BoardID;
		Device[] d = null;
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(Query);
			rs.last();
			d = new Device[rs.getRow()];
			rs.beforeFirst();
			int i = 0;
			while (rs.next()) {
				d[i] = new Device();
				d[i].name = rs.getString("DeviceName");
				d[i].status = rs.getString("DeviceStatus");
				d[i].model = rs.getString("DeviceModel");
				d[i++].operations = getOperations(rs.getInt("DeviceID"));
			}

		}


		catch (Exception ex) {
			System.out.println("Getting Devices failed: An Exception has occurred! " + ex);
		}

		// some exception handling
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (currentCon != null) {
				currentCon.close();
				currentCon = null;
			}
		} catch (Exception e) {

		}

		return d;
	}
	public Operation[] getOperations(int deviceID) {
		Statement stmt = null;
		String Query = "select * from Operations where DeviceID = " + deviceID;
		Operation[] ops = null;
		
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(Query);
			rs.last();
			ops = new Operation[rs.getRow()];
			rs.beforeFirst();
			int i = 0;
			while (rs.next()) {
				ops[i] = new Operation();
				ops[i].name = rs.getString("OperationsName");
				ops[i].values = getValues(rs.getInt("OperationID"));
				ops[i++].UIComponent = rs.getString("UIComponent");
			}

		}

		catch (Exception ex) {
			System.out.println("Getting Opperations failed: An Exception has occurred! " + ex);
		}

		// some exception handling
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (currentCon != null) {
				currentCon.close();
				currentCon = null;
			}
		} catch (Exception e) {

		}

		return ops;

	}
	public String[] getValues(int opID) {
		Statement stmt = null;
		String Query = "select * from OpertionsValues where OperationID = " + opID;
		String[] Values = null;
		
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(Query);
			rs.last();
			Values = new String[rs.getRow()];
			rs.beforeFirst();
			int i = 0;
			while (rs.next()) {
				Values[i] = new String();
				Values[i++] = rs.getString("Value");
			}

		}

		catch (Exception ex) {
			System.out.println("Getting Values failed: An Exception has occurred! " + ex);
		}

		// some exception handling
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (currentCon != null) {
				currentCon.close();
				currentCon = null;
			}
		} catch (Exception e) {

		}

		return Values;
		
	}
}
