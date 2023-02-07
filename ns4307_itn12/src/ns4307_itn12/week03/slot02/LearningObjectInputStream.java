package ns4307_itn12.week03.slot02;

import java.io.*;
import java.util.Date;

public class LearningObjectInputStream {

	public static void main(String[] args) throws Exception {
		try(
			ObjectInputStream input = new ObjectInputStream(
					new FileInputStream("object.dat"));	
				) {
			System.out.println(input.readUTF());
			System.out.println(input.readInt());
			System.out.println(input.readObject());
			Student student1 = (Student) input.readObject();
			System.out.println(student1.id + " " + student1.name);
			Student student2 = (Student) input.readObject();
			System.out.println(student2.id + " " + student2.name);
			Student student3 = (Student) input.readObject();
			System.out.println(student3.id + " " + student3.name);
		}
	}
	
}
