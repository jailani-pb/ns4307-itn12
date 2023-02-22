package ns4307_itn12.week05.slot02;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class ChatClient {

	static DataInputStream fromServer;
	static DataOutputStream toServer;
	
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 9103);
		System.out.println("Connected to the server.");
		
		fromServer = new DataInputStream(socket.getInputStream());
		toServer = new DataOutputStream(socket.getOutputStream());
		
		Scanner scanner = new Scanner(System.in);
		
		new Thread(new Runnable() {
			public void run() {
				try {
					while(true) {
						if(fromServer.available() > 0) {
							String receivedMsg = fromServer.readUTF();
							System.out.println(">> " + receivedMsg);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		while(true) {
			System.out.println("Please type message: (Jangan capi-capi)");
			String msgToSend = scanner.nextLine();
			toServer.writeUTF(msgToSend);
		}
	}
	
}
