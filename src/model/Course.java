package model;

import java.util.Date;

public class Course {
	int id;
	String name;
	public Date date;
	
	public Course() {
		name = "";
		date = new Date();
	}
	public Course(String name, Date date) {
		this();
		this.name = name;
		this.date = date;
	}
	public Course(int id, String name, Date date) {
		this();
		this.id = id;
		this.name = name;
		this.date = date;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Date getDate() {
		return date;
	}
}
