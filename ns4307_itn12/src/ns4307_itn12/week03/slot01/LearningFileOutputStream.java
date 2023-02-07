package ns4307_itn12.week03.slot01;

import java.io.*;

public class LearningFileOutputStream {

	public static void main(String[] args) {
		File file = new File("data.dat");
		try(FileOutputStream output = 
				new FileOutputStream(file)) {
			for(int i = 1; i <= 10; i++) {
				output.write(i);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Nada file atu");
		} catch (IOException e) {
			System.out.println("Ada masalah");
		}
	}
	
}
