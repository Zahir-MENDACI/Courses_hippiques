package model;

import java.util.Date;
import java.util.List;

public class Course {
	String name;
	Date date;
	List<Cheval> cheval;
	
	public Course(String name, Date date, List<Cheval> cheval) {
		this.name = name;
		this.date = date;
		this.cheval = cheval;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Cheval> getCheval() {
		return cheval;
	}
	public void setCheval(List<Cheval> cheval) {
		this.cheval = cheval;
	}
}
