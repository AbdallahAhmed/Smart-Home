import java.io.IOException;

import javax.swing.JFrame;

public class RunServer {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Server server = new Server ();
		server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		server.startRunning();

	}

}
