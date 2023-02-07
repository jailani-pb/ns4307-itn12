package ns4307_itn12.week03.slot02;

import java.io.*;

public class LearningDataInputStream {

	public static void main(String[] args) throws Exception {
		try(
			DataInputStream input = new DataInputStream(
					new FileInputStream("data.dat"));	
				) {
			System.out.println(input.readInt());
			System.out.println(input.readDouble());
			System.out.println(input.readUTF());
		}
	}
	
}
