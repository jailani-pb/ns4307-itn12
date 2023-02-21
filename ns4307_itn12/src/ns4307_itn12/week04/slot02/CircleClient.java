package ns4307_itn12.week04.slot02;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class CircleClient {
	
	static DataInputStream fromServer;
	static DataOutputStream toServer;
	static Socket socket = null;

	public static void main(String[] args) {
		try {
			socket = new Socket("localhost", 9101);
			System.out.println("Connected to the server.");
			
			communicate();
		} catch (IOException e) {
			System.out.println("Problems connecting to server");
		} finally {
			if(socket != null) {
				try { socket.close(); } catch (IOException e) {}
			}
		}
	}
	
	public static void communicate() {
		Scanner scanner = new Scanner(System.in);
		try {
			fromServer = new DataInputStream(socket.getInputStream());
			toServer = new DataOutputStream(socket.getOutputStream());
						
			while(true) {
				System.out.println("Please type radius value ("
						+ "negative value will terminate app)");
				double radius = Double.parseDouble(scanner.nextLine());
				toServer.writeDouble(radius);
				if(radius < 0) {
					System.out.println("App terminated");
					System.exit(0);
				}
				double area = fromServer.readDouble();
				System.out.println("Area received: " + area);
			}
		} catch (IOException e) {
			System.out.println("Problems communication with server.");
		}
		
		
		scanner.close();
	}
	
}
