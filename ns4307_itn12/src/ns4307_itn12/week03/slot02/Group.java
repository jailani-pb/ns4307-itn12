package ns4307_itn12.week03.slot02;

import java.io.Serializable;

public class Group implements Serializable {

	String name;
	int intake;
	
	public Group(String name, int intake) {
		this.name = name;
		this.intake = intake;
	}
	
}
