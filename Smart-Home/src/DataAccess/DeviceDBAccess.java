package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Controller.Device;
import Controller.Operation;

public class DeviceDBAccess {

	static Connection currentCon;

	public boolean RegisterDevice(Device d, int portNumber, String username) {
		boolean result = false;
		ResultSet rs = null;
		Statement stmt = null;
		String Query = "select * from Users where UserName = \"" + username + "\"";
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(Query);
			boolean more = rs.next();
			if (more) {
				Query = "insert into Devices (DeviceName, DeviceStatus, DeviceModel, ID, PortNumber, UserID) values (\"" + d.name + "\", \""
						+ d.status + "\", \"" + d.model + "\" ," + d.Id + "," + portNumber + "," + rs.getInt("UserID") +")";
				stmt.executeUpdate(Query, Statement.RETURN_GENERATED_KEYS);
				rs = stmt.getGeneratedKeys();
				rs.next();
				int DeviceID = rs.getInt(1);
				for (int i = 0; i < d.operations.size(); i++) {
					Query = "insert into Operations (OperationsName , UIComponent, DeviceID) values (\""
							+ d.operations.get(i).name + "\" , \"" + d.operations.get(i).UIComponent + "\" , "
							+ DeviceID + ")";
					stmt.executeUpdate(Query, Statement.RETURN_GENERATED_KEYS);
					rs = stmt.getGeneratedKeys();
					rs.next();
					int OperationID = rs.getInt(1);
					for (int j = 0; j < d.operations.get(i).values.size(); j++) {
						Query = "insert into OperationsValues (Value, OperationID) values (\""
								+ d.operations.get(i).values.get(j) + "\" , " + OperationID + ")";
						stmt.executeUpdate(Query);
					}
				}
				result = true;
			}
		}

		catch (Exception ex) {
			System.out.println("Registering Device failed: An Exception has occurred! " + ex);
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
		return result;

	}

	public boolean CheckDevice(Device d) {
		boolean result = false;
		ResultSet rs = null;
		Statement stmt = null;
		String Query = "select * from Devices where ID = " + d.Id;
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(Query);
			result = rs.next();
		}

		catch (Exception ex) {
			System.out.println("Checking Device failed: An Exception has occurred! " + ex);
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
		return result;
	}

	public boolean AddDevice(String username, String boardname, int ID) {
		boolean result = false;
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
				result = false;
			}

			else if (more) {
				int BoardID = rs.getInt("BoardID");
				Query = "update Devices set BoardID = " + BoardID;
				stmt.executeUpdate(Query);
				result = true;
			}
		}

		catch (Exception ex) {
			System.out.println("Adding Device failed: An Exception has occurred! " + ex);
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
		return result;

	}

	public void RemoveDevice() {

	}

	public void EditDevice() {

	}

	public ArrayList<Device> getDevices(String username) {
		ResultSet rs = null;
		Statement stmt = null;
		String Query = "select * from Users where UserName = \"" + username + "\"";
		ArrayList<Device> d = new ArrayList<Device>();
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(Query);
			boolean more = rs.next();
			if (more) {
				Query = "select * from Devices where BoardID is NULL && UserID = " + rs.getInt("UserID");
				rs = stmt.executeQuery(Query);
				while (rs.next()) {
					Device dev = new Device();
					dev.name = rs.getString("DeviceName");
					dev.model = rs.getString("DeviceModel");
					dev.status = rs.getString("DeviceStatus");
					dev.Id = rs.getInt("ID");
					//dev.operations = (ArrayList<Operation>) getOperations(rs.getInt("DeviceID")).clone();
					d.add(dev);
				}
			}
		} catch (Exception ex) {
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

	public ArrayList<Device> getDevices(String Username, String BoardName) {
		ResultSet rs = null;
		Statement stmt = null;
		String Query = "select * from Users join UserBoard join Boards on Users.UserID = UserBoard.UserID &&"
				+ " UserBoard.BoardID = Boards.BoardID where Users.UserName = \"" + Username
				+ "\" && Boards.BoardName = \"" + BoardName + "\"";
		ArrayList<Device> d = new ArrayList<Device>();
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(Query);
			rs.next();
			int BoardID = rs.getInt("BoardID");
			Query = "select * from Devices where BoardID = " + BoardID;
			rs = stmt.executeQuery(Query);
			while (rs.next()) {
				Device dev = new Device();
				dev.name = rs.getString("DeviceName");
				dev.model = rs.getString("DeviceModel");
				dev.status = rs.getString("DeviceStatus");
				dev.Id = rs.getInt("ID");
				dev.operations = (ArrayList<Operation>) getOperations(rs.getInt("DeviceID")).clone();
				d.add(dev);
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
		ArrayList<Operation> ops = new ArrayList<Operation>();

		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(Query);
			while (rs.next()) {
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

			if (currentCon != null) {
				currentCon.close();
				currentCon = null;
			}
		} catch (Exception e) {

		}

		return ops;

	}

	public ArrayList<String> getValues(int opID) {
		ResultSet rs = null;
		Statement stmt = null;
		String Query = "select * from OperationsValues where OperationID = " + opID;
		ArrayList<String> Values = new ArrayList<String>();

		try {
			currentCon = ConnectionManager.getConnection();
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

			if (currentCon != null) {
				currentCon.close();
				currentCon = null;
			}

		} catch (Exception e) {

		}

		return Values;

	}

	public ArrayList<Operation> getDevices(int dev) {
		
		ResultSet rs = null;
		Statement stmt = null;
		String Query = "select * from Devices join Operations on Devices.DeviceID = Operations.DeviceID where ID = " + dev;
		ArrayList<Operation> ops = new ArrayList<Operation>();

		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(Query);
			while (rs.next()) {
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

			if (currentCon != null) {
				currentCon.close();
				currentCon = null;
			}
		} catch (Exception e) {

		}

		return ops;


	}
}
