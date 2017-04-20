package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Controller.Device;
import Controller.Operation;

public class DeviceDBAccess {

	static Connection currentCon;

	public boolean AddDevice(String username , String boardname, Device d) {
		ResultSet rs = null;
		Statement stmt = null;
		String Query = "select * from Users join UserBoard join Boards where UserName= \"" + username
				+ "\" and BoardName = \"" + boardname + "\"";
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(Query);
			boolean more = rs.next();

			if (!more) {
				return false;
			}

			else if (more) {
				int BoardID = rs.getInt("BoardID");
				Query = "insert into Devices (DeviceName, DeviceStatus, DeviceModel, BoardID) values (\"" 
				+ d.name + "\", \"" + d.status +  "\", \"" + d.model + "\", " + BoardID+ ")";
				stmt.executeUpdate(Query, Statement.RETURN_GENERATED_KEYS);
				rs = stmt.getGeneratedKeys();
				rs.next();
				int DeviceID = rs.getInt(1);
				for (int i = 0 ; i < d.operations.size(); i++){
					Query = "insert into Operations (OperationsName , UIComponent, DeviceID) values (\"" 
							+ d.operations.get(i).name + "\" , \"" + d.operations.get(i).UIComponent 
							+ "\" , " + DeviceID + ")";
					stmt.executeUpdate(Query, Statement.RETURN_GENERATED_KEYS);
					rs = stmt.getGeneratedKeys();
					rs.next();
					int OperationID = rs.getInt(1);
					for (int j = 0 ; j < d.operations.get(i).values.size(); j++){
						Query = "insert into OperationsValues (Value, OperationID) values (\"" 
								+ d.operations.get(i).values.get(j) + "\" , " + OperationID + ")";
						stmt.executeUpdate(Query);
					}
				}
				return true;
			}
		}

		catch (Exception ex) {
			System.out.println("Adding Board failed: An Exception has occurred! " + ex);
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
		return false;

	}

	public void RemoveDevice() {

	}

	public void EditDevice() {

	}

	public ArrayList<Device> getDevices(int BoardID) {
		ResultSet rs = null;
		Statement stmt = null;
		String Query = "select * from Devices where BoardID = " + BoardID;
		ArrayList<Device> d = new ArrayList<Device>();
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(Query);
			while(rs.next()) {
				Device dev = new Device();
				dev.name = rs.getString("DeviceName");
				dev.model = rs.getString("DeviceModel");
				dev.status = rs.getString("DeviceStatus");
				dev.operations = (ArrayList<Operation>) getOperations(rs.getInt("DeviceID")).clone();
				d.add(dev);
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
	
	public ArrayList<Operation> getOperations(int deviceID) {
		ResultSet rs = null;
		Statement stmt = null;
		String Query = "select * from Operations where DeviceID = " + deviceID;
		ArrayList<Operation> ops= new ArrayList<Operation>();
		
		try {
			/*currentCon = ConnectionManager.getConnection();*/
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(Query);
			while(rs.next()) {
				Operation o = new Operation();
				o.name = rs.getString("OperationsName");
				o.UIComponent = rs.getString("UIComponent");
				o.values = (ArrayList<String>) getValues(rs.getInt("OperationID")).clone();
				ops.add(o);
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
			/*if (currentCon != null) {
				currentCon.close();
				currentCon = null;
			}
*/		} catch (Exception e) {

		}

		return ops;

	}
	public ArrayList<String> getValues(int opID) {
		ResultSet rs = null;
		Statement stmt = null;
		String Query = "select * from OperationsValues where OperationID = " + opID;
		ArrayList<String> Values = new ArrayList<String>();
		
		try {
			/*currentCon = ConnectionManager.getConnection();*/
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(Query);
			while (rs.next()) {
				Values.add(rs.getString("Value"));
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
			/*if (currentCon != null) {
				currentCon.close();
				currentCon = null;
			}*/
		} catch (Exception e) {

		}

		return Values;
		
	}
}
