package Controller;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
public class SocketConnector {
	private String host;
	private int port;
	private Socket soc;
	private DataOutputStream dout;
	public SocketConnector(int port) throws UnknownHostException, IOException{
		soc = new Socket(host, port);
		dout = new DataOutputStream(soc.getOutputStream());
	}
	
	public void send(String msg) throws IOException {
		dout.writeUTF(msg);
	}
	
}
