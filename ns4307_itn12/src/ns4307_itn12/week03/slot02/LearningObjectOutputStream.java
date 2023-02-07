package ns4307_itn12.week03.slot02;

import java.io.*;
import java.util.Date;

public class LearningObjectOutputStream {

	public static void main(String[] args) throws Exception {
		try(
			ObjectOutputStream output = new ObjectOutputStream(
					new FileOutputStream("object.dat"));	
				) {
			output.writeUTF("Jailani");
			output.writeInt(50);
			output.writeObject(new Date());
			Student student = new Student("22FTT1234", "Abu",
					new Group("DITN12", 11));
			output.writeObject(student);
			Group group2 = new Group("DITN11", 10);
			Student student2 = new Student("21FTT1567", "Bakar",
					group2);
			output.writeObject(student2);
			Student student3 = new Student("21FTT2143", "Curi",
					group2);
			output.writeObject(student3);
		}
	}
	
}
