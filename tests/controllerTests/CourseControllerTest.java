package controllerTests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import controller.CourseController;
import dao.CourseDao;
import model.Course;
import utils.Utilitaires;

public class CourseControllerTest {

	CourseController cc = new CourseController();
	CourseDao cDao = new CourseDao();
	
	@Test
	public void createCourseTest() {
		cc.addCourse("CourseTest", Utilitaires.parseDate("2022-01-01"));
		List<Course> list =  cDao.getAllCourses();
		assertTrue(list.get(list.size()-1).getName().equals("CourseTest") && 
				list.get(list.size()-1).getDate().equals(Utilitaires.parseDate("2022-01-01")));
	}
	
	@Test
	public void getLastCourseTest() {
		cc.addCourse("CourseTest", new Date());
		assertTrue(cc.updateCourse("CourseTest", "newCourseTest"));
	}
	
	@Test
	public void updateCourseTest() {
		cc.addCourse("CourseTest", new Date());
		assertTrue(cc.updateCourse("CourseTest", "newCourseTest"));
	}
	
	@Test
	public void updateInexistantCourseTest() {
		assertFalse(cc.updateCourse("InexistedCourseTest", "newCourseTest"));
	}
	
	@Test
	public void deleteCourseTest() {
		cc.addCourse("CourseTest", new Date());
		assertTrue(cc.deleteCourse("CourseTest"));
	}
	
	@Test
	public void deleteCourseTestNotExist() {
		assertFalse(cc.deleteCourse("InexistantCourseTest"));
	}
}
