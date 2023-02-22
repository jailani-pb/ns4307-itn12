package ns4307_itn12.week05.slot02;

import java.net.*;

public class ChatServer {

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(9103);
		System.out.println("Server started.");
		
		while(true) {
			Socket chatClient1 = serverSocket.accept();
			Socket chatClient2 = serverSocket.accept();
			Socket chatClient3 = serverSocket.accept();
			
			new Thread(new ChatHandler(
					chatClient1, chatClient2, chatClient3)).start();
		}
	}
	
}
