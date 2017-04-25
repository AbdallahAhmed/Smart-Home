import java.io.IOException;

public class RunClient{

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		Client client = new Client ("127.0.0.1");
		client.startRunning();
		
	}

}
