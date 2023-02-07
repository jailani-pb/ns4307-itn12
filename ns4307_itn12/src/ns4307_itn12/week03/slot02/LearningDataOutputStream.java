package ns4307_itn12.week03.slot02;

import java.io.*;

public class LearningDataOutputStream {

	public static void main(String[] args) throws Exception {
		try(
			DataOutputStream output = new DataOutputStream(
					new FileOutputStream("data.dat", false));	
				) {
			output.writeInt(100);
			output.writeDouble(78.5);
			output.writeUTF("Jailani");
		}
	}
	
}
