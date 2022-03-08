package model;

public class Hippodrome {

	int id;
	String name;
	
	public Hippodrome() {
		name = "hippo Test";
	}

	public Hippodrome(int id, String name) {
		this();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
