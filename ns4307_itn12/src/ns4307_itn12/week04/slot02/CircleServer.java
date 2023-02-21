package ns4307_itn12.week04.slot02;

import java.net.*;
import java.io.*;

public class CircleServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(9101);
			System.out.println("Server has started.");
			while(true) {
				Socket socket = serverSocket.accept();
				
				new Thread(new CircleSessionHandler(socket)).start();
			}
		} catch (IOException e) {
			System.out.println("Unable to start server.");
		} finally {
			if(serverSocket != null) {				
				try { serverSocket.close(); } catch (Exception e) {}
			}
		}
	}
	
}
