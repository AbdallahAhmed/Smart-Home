package Devices;
import java.io.*;
import java.net.*;

public class MyServer {
public static void main(String[] args){
try{
ServerSocket ss=new ServerSocket(4444);
Socket s=ss.accept();//establishes connection 

DataOutputStream dis=new DataOutputStream(s.getOutputStream());


dis.writeUTF("Switch On");

ss.close();

}catch(Exception e){System.out.println(e);}
}
}
