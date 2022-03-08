package controllerTests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import controller.ChevalController;
import controller.CourseController;
import dao.ChevalDao;
import dao.CourseDao;
import model.Cheval;
import model.Course;
import utils.Utilitaires;

public class ChevalControllerTest {
	
	CourseController cc = new CourseController();
	ChevalController chc = new ChevalController();
	CourseDao cDao = new CourseDao();
	ChevalDao chDao = new ChevalDao();
	
	@Test
	public void createChevalTest() {
		cc.addCourse("CourseTestForCheval", new Date());
		chc.addChevalToCourse("CourseTestForCheval", "ChevalTest", 10, 15);
		int courseId = cDao.getCourseId("CourseTestForCheval");
		List<Cheval> list =  chDao.getAllCheval(courseId);
		assertTrue(list.get(list.size()-1).getName().equals("ChevalTest"));
	}
	
	@Test
	public void createChevalInInexistantCourseTest() {
		assertFalse(chc.addChevalToCourse("InexistantCourseTestForCheval", "ChevalTest", 10, 15));
	}
	
	@Test
	public void updateChevalTest() {
		cc.addCourse("CourseTestForUpdateCheval", new Date());
		chc.addChevalToCourse("CourseTestForUpdateCheval", "ChevalUpdateTest", 10, 15);
		assertTrue(chc.updateCheval("ChevalUpdateTest", "ChevalUpdatedTest"));
	}
	
	@Test
	public void updateInexistantChevalTest() {
		cc.addCourse("CourseTestForUpdateInexistantCheval", new Date());
		assertFalse(chc.updateCheval("InexistantChevalUpdateTest", "ChevalUpdatedTest"));
	}
	
	@Test
	public void updateChevalInInexistantCourseTest() {
		assertFalse(chc.updateCheval("InexistantChevalUpdateTest", "ChevalUpdatedTest"));
	}
	
	@Test
	public void deleteChevalTest() {
		cc.addCourse("CourseTestForDeleteCheval", new Date());
		chc.addChevalToCourse("CourseTestForDeleteCheval", "ChevalDeleteTest", 10, 15);
		assertTrue(chc.deleteCheval("ChevalDeleteTest"));
	}
	
	@Test
	public void deleteCourseTestNotExist() {
		assertFalse(chc.deleteCheval("InexistantChevalDeleteTest"));
	}
}
