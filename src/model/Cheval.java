package model;

public class Cheval {
	String name;
	int age;
	int nbVitoire;
	
	public Cheval(String name, int age, int nbVitoire) {
		this.name = name;
		this.age = age;
		this.nbVitoire = nbVitoire;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getNbVitoire() {
		return nbVitoire;
	}

}
