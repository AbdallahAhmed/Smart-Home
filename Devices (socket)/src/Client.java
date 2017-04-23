import java.io.*;
import java.net.*;
import java.util.Vector;

public class Client {

	private ObjectOutputStream output;
	private ObjectInputStream input;
	private Socket connection;
	private String message = "";
	private String serverIP;
	private Operations operationObject;

	public Client (String host)
	{
		serverIP = host;
		operationObject = new Operations();
	}

	// This is the required format of the URL	
	// http://www.smartboard.net/operation/deviceName/deviceID/deviceStatus/deviceOperations
	//example: // http://www.smartboard.net/addDevice/television/1000/on/increasevolume/decreasevolume/turnon/turnoff	

	private String operations(String request) throws MalformedURLException 
	{
		URL url = new URL (request);
		String deviceName = "" , deviceID = "" , deviceStatus = "" , operation = "";
		Vector <String> deviceOperations = new Vector <String> ();
		String path = url.getFile();
		// path processing
		path = path.substring(1);
		int index = path.indexOf('/');
		operation = path.substring(0, index);
		path = path.substring(index + 1);
		
		index = path.indexOf('/');
		deviceName = path.substring(0, index);
		path = path.substring(index + 1);

		
		index = path.indexOf('/');
		deviceID = path.substring(0, index);
		path = path.substring(index + 1);

		index = path.indexOf('/');
		deviceStatus = path.substring(0, index);
		path = path.substring(index);
		
		while (path.charAt(index) == '/')
		{
			index = path.indexOf('/');
			deviceOperations.add(path.substring(0, index));
			path = path.substring(index);
		}
		
		if (operation.contains("addDevice"))
		{
			return operationObject.addDevice(deviceName , deviceID , deviceStatus , deviceOperations);
		}

		else if (operation.contains("getInfo"))
		{
			return operationObject.getDeviceInfo(deviceName , deviceID);
		}

		else if (operation.contains("removeDevice"))
		{
			return operationObject.removeDevice(deviceName , deviceID);
		}

		else if (operation.contains("updateDevice"))
		{
			return operationObject.updateDevice(deviceName , deviceID , deviceStatus , deviceOperations);
		}

		else
			return null;
	}


	public void startRunning () throws IOException, ClassNotFoundException
	{
		try 
		{
			while (true)
			{
				try 
				{
					connectoserver();
					setupStreams();
					whileChatting();

				}catch (EOFException eof)
				{
					eof.printStackTrace();
				}
			}
		}catch (IOException e)
		{
			e.printStackTrace();
		}finally
		{
			closeConnection();
		}

	}
	private void connectoserver() throws IOException
	{
		int portnumber = 1111;

		connection = new Socket (InetAddress.getByName(serverIP),portnumber);

	}

	private void setupStreams() throws IOException
	{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());

	}

	private void whileChatting () throws IOException, ClassNotFoundException 
	{
		do 
		{
			message = (String)input.readObject();

			// section of operations
			String response = operations(message);
			if (response != null)
				sendMessage(response);
			else
				sendMessage("Invalid URL !");

		}
		while (!message.equals("close"));
	}

	private void closeConnection() throws IOException
	{
		output.close();
		input.close();
		connection.close();
	}

	public void sendMessage(String message) throws IOException
	{
		output.writeObject("\nClient :" + message);
		output.flush();
	}

}
