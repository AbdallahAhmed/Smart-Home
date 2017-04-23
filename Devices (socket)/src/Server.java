import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Server extends JFrame {

	private JTextField usertext;
	private JTextArea chatwindow;

	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;


	public Server ()
	{
		super ("Server");
		usertext = new JTextField ();
		usertext.setEditable(false);
		usertext.addActionListener(
				new ActionListener ()
				{
					public void actionPerformed(ActionEvent event)
					{
						try {
							sendMessage (event.getActionCommand());
						} catch (IOException e) {
							e.printStackTrace();
						} 
						usertext.setText("");
					} 
				}
				);

		add (usertext,BorderLayout.NORTH);
		chatwindow = new JTextArea();
		add(new JScrollPane (chatwindow),BorderLayout.CENTER);
		setSize(300,300);
		setVisible(true);
	}


	public void startRunning () throws IOException, ClassNotFoundException
	{
		int portnumber = 1111;
		int backlog = 500;
		try 
		{
			server = new ServerSocket (portnumber,backlog);
			while (true)
			{
				try 
				{
					waitingForConnection();
					setupStreams();
					whileChatting();

				}catch (EOFException eof)
				{
					showMessage ("\nConnection is ended\n");
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
	private void waitingForConnection() throws IOException
	{
		showMessage ("\nWaiting for someone to connect...!");
		connection = server.accept();
		showMessage ("\nNow Connected to " + connection.getInetAddress().getHostName());
	}

	private void setupStreams() throws IOException
	{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage ("\nStreams are setup");
	}

	private void whileChatting () throws IOException, ClassNotFoundException 
	{
		String message;
		message = "\nyou are connected"; 
		showMessage (message);
		abletotype(true);
		//	sendMessage(message);
		do 
		{
			message = (String)input.readObject();

			//	sendMessage(message);
			
			showMessage(message);
		}
		while (!message.equals("close"));

	}
	private void closeConnection() throws IOException
	{
		showMessage("\nClosing Connection ... ");
		abletotype(false);

		output.close();
		input.close();
		connection.close();
		showMessage ("\n Connection is closed");
	}

	public void sendMessage(String message) throws IOException
	{
		output.writeObject("Server : " + message);
		output.flush();
		showMessage ("\nServer : " + message);
	}

	public void showMessage(final String text)
	{
		SwingUtilities.invokeLater(
				new Runnable ()
				{
					public void run()
					{
						chatwindow.append(text);
					}
				}
				);
	}

	public void abletotype(boolean b)
	{
		SwingUtilities.invokeLater(
				new Runnable ()
				{
					public void run ()
					{
						usertext.setEditable(b);
					}
				}
				);
	}

}
