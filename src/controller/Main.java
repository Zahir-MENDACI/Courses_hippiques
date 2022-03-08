package controller;


import java.sql.SQLException;

import view.Menu;

public class Main {

	public static void main(String[] args) throws SQLException {
		Menu menu = new Menu();
		menu.bonjour();
		while(true) {
			menu.choix();
		}
		/*	
		CourseController cc = new CourseController();
		ChevalController chc = new ChevalController();
		HippodromeController hc = new HippodromeController();
		//Date date = new Date(Utilitaires.parseDate("2022-01-02").getTime());
		cc.printCourses();
		//chc.printChevaux("course2");*/
	} 
}
