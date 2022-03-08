package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Utilitaires {
	public static String saisieString() {
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	
	public static Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	  }
	/*
	public static Connection db() {
		try {
			   Connection myConn = DriverManager.getConnection("jdbc:mysql://remotemysql.com/gPk2Vm2FgH", "gPk2Vm2FgH", "G8eczlCjXq");
			   
			   //create statement 
			   
			   return myConn;
			   
			  }
			  catch (Exception exc) {
			   exc.printStackTrace();
			   return null;
			  }
	}*/
	
}