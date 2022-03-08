package controller;

import java.util.Date;
import java.util.List;

import dao.ChevalDao;
import dao.CourseDao;
import model.Cheval;
import model.Course;

public class CourseController {

	CourseDao courseDao;
	ChevalDao chevalDao;
	public CourseController() {
		courseDao = new CourseDao();
		chevalDao = new ChevalDao();
	}

	public boolean addCourse(String name, Date date) {
		Course c = new Course(name, date);
		return courseDao.addCourseToHippodrome(c);
	}

	public boolean printCourses() {
		List<Course> courses = courseDao.getAllCourses();
		if (courses == null) return false;
		for (Course course : courses) {
			System.out.println("   -  Nom: " + course.getName() + "      Date: " + course.getDate());
		}
		return true;
	}

	public boolean printLastCourses() {
		//Hippodrome h = hippodromeDao.getHippodrome();
		 //Collections.sort(h.getCourses(), new sortItems());
		 //Collections.reverse(h.getCourses());
		List<Course> courses = courseDao.getLastCourses();
		if (courses == null) return false;
		for (Course course : courses) {
			System.out.println("   -  Nom: " + course.getName() + "      Date: " + course.getDate());
			Cheval ch = chevalDao.getRandomCheval(course.getId());
			if (ch != null) {
				System.out.println("\"                  --- Vainqueur---  Nom: " + ch.getName() + "      Age: " + ch.getAge() + "      NbVictoires: " + ch.getNbVitoire());
			}
		}
		return true;
	}

	public boolean updateCourse(String name, String newName) {
		int courseId = courseDao.getCourseId(name);
		System.out.println(courseId);
		if (courseId == -1) return false;
		System.out.println(courseDao.updateCourse(courseId, newName));
		return true;
	}

	public boolean deleteCourse(String name) {
		int courseId = courseDao.getCourseId(name);
		if (courseId == -1) return false;
		return courseDao.deleteCourse(courseId);
	}
}
