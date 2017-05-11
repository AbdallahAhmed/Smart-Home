package Connectors;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketConnector {
	private int port;
	private ServerSocket ss;
	private Socket soc;
	private DataInputStream din;
	
	public SocketConnector(int port) throws IOException{
		ss = new ServerSocket(port);
		soc = ss.accept();
		din = new DataInputStream(soc.getInputStream());
	}
	
	public String recv() throws IOException{
		return din.readUTF();
	}
	
	public void closeSoc() throws IOException{
		soc.close();
	}
}
