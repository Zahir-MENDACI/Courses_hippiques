package view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class viewTests {

	@Test
	public void menuTest() {
		Menu menu = new Menu();
		menu.choix(1);
		menu.choix(4);
		menu.choix(5);
	}
}
