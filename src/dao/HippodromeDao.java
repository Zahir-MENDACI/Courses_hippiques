package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Hippodrome;
import utils.Utilitaires;

public class HippodromeDao {
	Hippodrome h;
	
	public HippodromeDao() {
		//h = new Hippodrome("Hippo Test");
		//Data.setHippodrome(h);
	}
	
	public boolean createHippodrome(String name) {
		Connection myConn = null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://remotemysql.com/gPk2Vm2FgH", "gPk2Vm2FgH", "G8eczlCjXq");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		Statement st = null;
		try {
			st = myConn.createStatement();
			st.executeUpdate("INSERT INTO hippodrome (id, name) VALUES (NULL, '" +name+"')");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		//Data.setHippodrome(h);
		finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					/* Ignored */}
			}
			if (myConn != null) {
				try {
					myConn.close();
				} catch (SQLException e) {
					/* Ignored */}
			}
		}
	}
	
	public Hippodrome getHippodrome(){
		Connection myConn = null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://remotemysql.com/gPk2Vm2FgH", "gPk2Vm2FgH", "G8eczlCjXq");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		Statement st = null;
		ResultSet myRs = null;
		try {
			st = myConn.createStatement();
			myRs = st.executeQuery("SELECT * FROM hippodrome WHERE id=1");
			Hippodrome h = null;
			while (myRs.next()) {
				h = new Hippodrome(Integer.parseInt(myRs.getString("id")), myRs.getString("name"));
			}
			return h;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					/* Ignored */}
			}
			if (myConn != null) {
				try {
					myConn.close();
				} catch (SQLException e) {
					/* Ignored */}
			}
		}
		
	}
	
	public boolean setHippodrome(String name){
		Connection myConn = null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://remotemysql.com/gPk2Vm2FgH", "gPk2Vm2FgH", "G8eczlCjXq");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		Statement st = null;
		try {
			st = myConn.createStatement();
			st.executeUpdate("UPDATE hippodrome SET name = '"+name+"' WHERE id=1");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					/* Ignored */}
			}
			if (myConn != null) {
				try {
					myConn.close();
				} catch (SQLException e) {
					/* Ignored */}
			}
		}
	}
}
