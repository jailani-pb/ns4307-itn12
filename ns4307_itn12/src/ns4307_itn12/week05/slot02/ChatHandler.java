package ns4307_itn12.week05.slot02;

import java.net.*;
import java.io.*;

public class ChatHandler implements Runnable {
	
	Socket client1, client2, client3;
	DataInputStream fromClient1, fromClient2, fromClient3;
	DataOutputStream toClient1, toClient2, toClient3;
	
	public ChatHandler(Socket client1, Socket client2, Socket client3) {
		this.client1 = client1;
		this.client2 = client2;
		this.client3 = client3;
	}
	
	public void run() {
		try {
			fromClient1 = new DataInputStream(client1.getInputStream());
			fromClient2 = new DataInputStream(client2.getInputStream());
			fromClient3 = new DataInputStream(client3.getInputStream());
			
			toClient1 = new DataOutputStream(client1.getOutputStream());
			toClient2 = new DataOutputStream(client2.getOutputStream());
			toClient3 = new DataOutputStream(client3.getOutputStream());
			
			while(true) {
				if(fromClient1.available() > 0) {					
					String client1Msg = fromClient1.readUTF();
					toClient2.writeUTF(client1Msg);
					toClient3.writeUTF(client1Msg);
				}
				if(fromClient2.available() > 0) {					
					String client2Msg = fromClient2.readUTF();
					toClient1.writeUTF(client2Msg);
					toClient3.writeUTF(client2Msg);
				}
				if(fromClient3.available() > 0) {
					String client3Msg = fromClient3.readUTF();
					toClient1.writeUTF(client3Msg);
					toClient2.writeUTF(client3Msg);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
