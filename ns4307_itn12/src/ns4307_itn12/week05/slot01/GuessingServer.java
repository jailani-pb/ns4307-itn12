package ns4307_itn12.week05.slot01;

import java.net.*;

public class GuessingServer {

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(9102);
		System.out.println("Server has started.");
		
		while(true) {
			Socket player1 = serverSocket.accept();
			Socket player2 = serverSocket.accept();
			
			new Thread(new GuessingHandler(player1, player2)).start();
		}
	}
	
}
