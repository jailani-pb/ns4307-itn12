package ns4307_itn12.week04.slot01;

import java.net.*;
import java.util.Date;
import java.io.*;

public class BasicServer {

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(9001);
		System.out.println("Server is running as of " + new Date());
		Socket socket = serverSocket.accept();
		System.out.println("Client connected.");
		
		DataInputStream fromClient = new DataInputStream(
				socket.getInputStream());
		
		while(true) {
			System.out.println("Waiting msg from client");
			String msg = fromClient.readUTF();
			System.out.println("Received msg: " + msg);
			
			if(msg.equalsIgnoreCase("q")) {
				System.out.println("Server terminated.");
				break;
			}
		}
		
		fromClient.close();
	}
	
}
