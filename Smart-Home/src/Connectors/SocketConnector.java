package Connectors;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketConnector {
	private static String host = "0.0.0.0";
	private static int port ;
	private static Socket soc ;
	private DataOutputStream dout;
	
	public SocketConnector(int port) throws UnknownHostException, IOException{
		if(SocketConnector.port != port){
			SocketConnector.port = port;
			SocketConnector.soc = new Socket(host, SocketConnector.port);
		}
		dout = new DataOutputStream(soc.getOutputStream());
	}
	
	public void send(String s) throws IOException{
		dout.writeUTF(s);
	}
	
}
