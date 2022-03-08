package controllerTests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import controller.HippodromeController;

public class HippodromeControllerTest {
	
	HippodromeController hc = new HippodromeController();

	@Test
	public void createHippodromeTest(){
		assertTrue(hc.createHippodrome("Hippodrome"));
	}
	
	@Test
	public void printHippodromeTest() {
		assertTrue(hc.printHippodrome());
	}
	
	@Test
	public void updateHippodromeTest() {
		assertTrue(hc.updateHippodrome("hipp"));
	}
	
}
