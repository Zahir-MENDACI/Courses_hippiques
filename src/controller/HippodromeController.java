package controller;

import java.sql.SQLException;

import dao.HippodromeDao;
import model.Hippodrome;

public class HippodromeController {
	HippodromeDao hippodromeDao;
	
	public HippodromeController() {
		hippodromeDao = new HippodromeDao();
	}
	
	public boolean createHippodrome(String name) {
		return hippodromeDao.createHippodrome(name);
	}
	
	public boolean printHippodrome() {
		Hippodrome h = hippodromeDao.getHippodrome();
		if (h != null) {
			System.out.println(h.getName());
			return true;
		} 
		return false;
	}
	
	public boolean updateHippodrome(String name) {
		return hippodromeDao.setHippodrome(name);
	}

}
