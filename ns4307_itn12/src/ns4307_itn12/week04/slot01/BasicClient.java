package ns4307_itn12.week04.slot01;

import java.net.*;
import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class BasicClient {

	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		// 127.0.0.1
		Socket socket = new Socket("192.168.0.104", 9001);
		System.out.println("Connected to server since " + new Date());
		
		DataOutputStream toServer = new DataOutputStream(
				socket.getOutputStream());
		
		while(true) {
			System.out.println("Please input msg:");
			String msg = scanner.nextLine();
			toServer.writeUTF(msg);
			System.out.println("Sent msg: " + msg);
			
			if(msg.equalsIgnoreCase("q")) {
				System.out.println("Application terminated.");
				break;
			}
		}
		
		scanner.close();
		toServer.close();
	}
	
}
