package ns4307_itn12.week03.slot01;

import java.io.*;

public class LearningFileInputStream {

	public static void main(String[] args) {
		try(FileInputStream input =
				new FileInputStream("data.dat")) {
			int value;
			while((value = input.read()) != -1) {
				System.out.println(value);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Inda jua ada tu.");
		} catch (IOException e) {
			System.out.println("Boh.");
		}
	}
	
}
