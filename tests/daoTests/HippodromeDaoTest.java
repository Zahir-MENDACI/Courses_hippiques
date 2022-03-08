package daoTests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import dao.HippodromeDao;

public class HippodromeDaoTest {

	HippodromeDao hDao = new HippodromeDao();
	
	@Test
	public void printHippodromeTest() {
		assertNotEquals(hDao.getHippodrome(), null);
	}
	
	@Test
	public void updateHippodromeTest() {
		assertTrue(hDao.setHippodrome("hipp"));
	}
}
