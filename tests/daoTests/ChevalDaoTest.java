package daoTests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import dao.ChevalDao;
import dao.CourseDao;
import model.Cheval;
import model.Course;

public class ChevalDaoTest {
	
	ChevalDao chDao = new ChevalDao();
	CourseDao cDao = new CourseDao();

	@Test
	public void addChevalTest() {
		Course c = new Course("courseForChevalDaoTest", new Date());
		cDao.addCourseToHippodrome(c);
		int courseId = cDao.getCourseId("courseForChevalDaoTest");
		Cheval ch = new Cheval("ChevalTestDao", 10, 15);
		assertTrue(chDao.addChevalToCourse(ch, courseId));
	}
	
	@Test
	public void getAllChevalTest() {
		Course c = new Course("courseForChevalDaoTest", new Date());
		cDao.addCourseToHippodrome(c);
		int courseId = cDao.getCourseId("courseForChevalDaoTest");
		assertNotNull(chDao.getAllCheval(courseId));
	}
	
	@Test
	public void getRandomChevalTest() {
		Course c = new Course("courseForRandomChevalDaoTest", new Date());
		cDao.addCourseToHippodrome(c);
		int courseId = cDao.getCourseId("courseForRandomChevalDaoTest");
		assertNotEquals(courseId, -1);
		Cheval ch = new Cheval("RandomChevalTestDao", 10, 15);
		chDao.addChevalToCourse(ch, courseId);
		assertNotEquals(chDao.getRandomCheval(courseId), null);
	}
	
	@Test
	public void updateChevalTest() {
		Course c = new Course("courseForUpdateChevalDaoTest", new Date());
		cDao.addCourseToHippodrome(c);
		int courseId = cDao.getCourseId("courseForUpdateChevalDaoTest");
		Cheval ch = new Cheval("ChevalToUpdateTestDao", 10, 15);
		chDao.addChevalToCourse(ch, courseId);
		int chevalId = chDao.getChevalId("ChevalToUpdateTestDao");
		assertTrue(chDao.updateCheval(chevalId, "ChevalUpdatedTestDao"));
	}
	
	@Test
	public void updateInexistantChevalTest() {
		Course c = new Course("courseForUpdateInexistantChevalDaoTest", new Date());
		cDao.addCourseToHippodrome(c);
		assertEquals(chDao.getChevalId("InexistantChevalToUpdateTestDao"), -1);
	}
	
	@Test
	public void deleteChevalTest() {
		Course c = new Course("courseForDeleteChevalTestDao", new Date());
		cDao.addCourseToHippodrome(c);
		int courseId = cDao.getCourseId("courseForDeleteChevalTestDao");
		Cheval ch = new Cheval("ChevalToDeleteTestDao", 10, 15);
		chDao.addChevalToCourse(ch, courseId);
		int chevalId = chDao.getChevalId("ChevalToDeleteTestDao");
		assertTrue(chDao.deleteCheval(chevalId));
	}
	
	@Test
	public void deleteInexistantCourseTest() {
		assertEquals(chDao.getChevalId("inexistantChevalTestDao"), -1);
	}
}
