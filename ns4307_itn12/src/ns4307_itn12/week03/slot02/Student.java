package ns4307_itn12.week03.slot02;

import java.io.Serializable;

public class Student implements Serializable {

	String id;
	String name;
	Group group;
	
	public Student(String id, String name, Group group) {
		super();
		this.id = id;
		this.name = name;
		this.group = group;
	}
	
}
