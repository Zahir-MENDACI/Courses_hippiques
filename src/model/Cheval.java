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
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getNbVitoire() {
		return nbVitoire;
	}
	public void setNbVitoire(int nbVitoire) {
		this.nbVitoire = nbVitoire;
	}

}
