package ns4307_itn12.week04.slot02;

import java.net.*;
import java.io.*;

public class CircleSessionHandler implements Runnable {
	
	Socket socket;
	DataInputStream fromClient;
	DataOutputStream toClient;
	
	public CircleSessionHandler(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			fromClient = new DataInputStream(socket.getInputStream());
			toClient = new DataOutputStream(socket.getOutputStream());
			
			while(true) {
				System.out.println("Waiting radius from client.");
				double radius = fromClient.readDouble();
				if(radius < 0) {
					System.out.println("Client disconnected");
					break;
				}
				double area = Math.PI * radius * radius;
				toClient.writeDouble(area);
				System.out.println("Received radius: " + radius +
						", Sent area: " + area);
			}
			
		} catch (IOException e) {
			System.out.println("Problem communicating with client.");
		} finally {
			if(socket != null) {
				try { socket.close(); } catch (IOException e) {}
			}
			if(fromClient != null) {
				try { fromClient.close(); } catch (IOException e) {}
			}
			if(toClient != null) {
				try { toClient.close(); } catch (IOException e) {}
			}
		}
	}

}
