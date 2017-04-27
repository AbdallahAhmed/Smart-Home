package Devices;
import java.io.*;
import java.net.*;

public class MyClient {
	
public static void main(String[] args) {
try{	
Socket s=new Socket("0.0.0.0",4444);	
DataInputStream dout=new DataInputStream(s.getInputStream());

String msg = (String)dout.readUTF();
System.out.println("message = " + msg);
dout.close();
s.close();

}catch(Exception e){System.out.println(e);}
}
}
