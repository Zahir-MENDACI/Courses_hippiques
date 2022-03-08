package controller;

import java.util.List;

import dao.ChevalDao;
import dao.CourseDao;
import model.Cheval;

public class ChevalController {
	CourseDao courseDao;
	ChevalDao chevalDao;
	public ChevalController() {
		courseDao = new CourseDao();
		chevalDao = new ChevalDao();
	}
	public boolean addChevalToCourse(String nameCourse, String nameCheval, int age, int nbVictoire) {
		int courseId = courseDao.getCourseId(nameCourse);
		if (courseId == -1) return false;
		Cheval ch = new Cheval(nameCheval, age, nbVictoire);
		return chevalDao.addChevalToCourse(ch, courseId);
	}

	public boolean printChevaux(String nameCourse) {
		int courseId = courseDao.getCourseId(nameCourse);
		if (courseId == -1) return false;
		List<Cheval> chevaux = chevalDao.getAllCheval(courseId);
		for (Cheval ch: chevaux) {
			System.out.println("   -  Nom: " + ch.getName() + "      Age: " + ch.getAge() + "      NbVictoires: " + ch.getNbVitoire());
		}
		return true;
	}

	public boolean updateCheval(String oldName, String newName) {
		int chevalId = chevalDao.getChevalId(oldName);
		if (chevalId == -1) return false;
		return chevalDao.updateCheval(chevalId, newName);
	}

	public boolean deleteCheval(String name) {
		int chevalId = chevalDao.getChevalId(name);
		if (chevalId == -1) return false;
		return chevalDao.deleteCheval(chevalId);
	}
}
