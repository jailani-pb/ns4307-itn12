package ns4307_itn12.week04.slot01;

import java.net.*;
import java.io.*;
import java.util.Date;

public class MultipleClientServer {

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(9001);
		System.out.println("Server is running as of " + new Date());
		while(true) {
			Socket socket = serverSocket.accept();
			System.out.println("Client connected.");
			
			new Thread(new Runnable() {
				public void run() {
					DataInputStream fromClient = null;
					try {
						fromClient = new DataInputStream(
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
					} catch (Exception e) {
						
					} finally {
						if(fromClient != null) {							
							try {
								fromClient.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}).start();
		}
		
	}
	
}
