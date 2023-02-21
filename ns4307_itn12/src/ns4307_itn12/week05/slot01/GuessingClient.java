package ns4307_itn12.week05.slot01;

import java.util.*;
import java.net.*;
import java.io.*;

public class GuessingClient {

	public static void main(String[] args) throws Exception {
		// 192.168.0.100
		Socket socket = new Socket("localhost", 9102);
		System.out.println("Connected to server");
		DataInputStream fromServer = 
				new DataInputStream(socket.getInputStream());
		DataOutputStream toServer =
				new DataOutputStream(socket.getOutputStream());
		
		String welcomeMsg = fromServer.readUTF();
		System.out.println(welcomeMsg);
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("Your turn.");
			System.out.println("Guess a number from 1 to 100:");
			int guessedNumber = Integer.parseInt(scanner.nextLine());
			toServer.writeInt(guessedNumber);
			
			System.out.println(fromServer.readUTF());
			if(fromServer.readBoolean()) {
				break;
			}
		}
	}
	
}
