package Connectors;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketConnector {
	private static String host = "0.0.0.0";
	private static int port = 5555;
	private static Socket soc ;
	static{
		try {
			soc = new Socket(host, port);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private DataOutputStream dout;
	
	public SocketConnector(int port) throws UnknownHostException, IOException{
/*		host = "0.0.0.0";
		port = 5555;*/
		/*soc = new Socket(host, port);*/
		dout = new DataOutputStream(soc.getOutputStream());
	}
	
	public void send(String s) throws IOException{
		dout.writeUTF(s);
	}
	
}
