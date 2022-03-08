package daoTests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import dao.CourseDao;
import model.Course;

public class CourseDaoTest {

	CourseDao cDao = new CourseDao();
	
	@Test
	public void dbConnectionClosedTest() {
		List<Course> courses = cDao.getLastCourses();
		assertNotEquals(courses, null);
		assertTrue(courses.size() >= 0 && courses.size() < 11);
	}
	
	@Test
	public void addCourseTest() {
		Course c = new Course("courseTestDao", new Date());
		assertTrue(cDao.addCourseToHippodrome(c));
	}
	
	@Test
	public void getAllCoursesTest() {
		assertNotNull(cDao.getAllCourses());
	}
	
	@Test
	public void updateCourseTest() {
		Course c = new Course("courseTestDao", new Date());
		cDao.addCourseToHippodrome(c);
		int courseId = cDao.getCourseId("courseTestDao");
		assertTrue(cDao.updateCourse(courseId, "newCourseTestDao"));
	}
	
	@Test
	public void updateInexistantCourseTest() {
		assertEquals(cDao.getCourseId("inexistantCourseTestDao"), -1);
	}
	
	@Test
	public void deleteCourseTest() {
		Course c = new Course("courseTestDao", new Date());
		cDao.addCourseToHippodrome(c);
		int courseId = cDao.getCourseId("courseTestDao");
		assertTrue(cDao.deleteCourse(courseId));
	}
	
	@Test
	public void deleteInexistantCourseTest() {
		assertEquals(cDao.getCourseId("inexistantCourseTestDao"), -1);
	}
}
