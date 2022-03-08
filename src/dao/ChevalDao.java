package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Cheval;
import model.Course;
import model.Hippodrome;
import utils.Utilitaires;

public class ChevalDao {
	
	public boolean addChevalToCourse(Cheval ch, int courseId) {
		Connection myConn = null;
		  try {
				   myConn = DriverManager.getConnection("jdbc:mysql://remotemysql.com/gPk2Vm2FgH", "gPk2Vm2FgH", "G8eczlCjXq");
		  }
		  catch (Exception exc) {
		   exc.printStackTrace();
		  }
		Statement st = null;
		try {
			st = myConn.createStatement();
			st.executeUpdate("INSERT INTO chevaux (id, name, age, nbVictoires, id_course) VALUES (NULL, '"+ch.getName()+"', '"+ch.getAge()+"', '"+ch.getNbVitoire()+"', '"+courseId+"')");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
		    if (st != null) {
		        try {
		            st.close();
		        } catch (SQLException e) { /* Ignored */}
		    }
		    if (myConn != null) {
		        try {
		        	myConn.close();
		        } catch (SQLException e) { /* Ignored */}
		    }
		}
	}
	
	public List<Cheval> getAllCheval(int courseId) {
		Connection myConn = null;
		  try {
				   myConn = DriverManager.getConnection("jdbc:mysql://remotemysql.com/gPk2Vm2FgH", "gPk2Vm2FgH", "G8eczlCjXq");
		  }
		  catch (Exception exc) {
		   exc.printStackTrace();
		  }
		Statement st = null;
		ResultSet myRs = null;
		try {
			List <Cheval> chevaux = new ArrayList<Cheval>();
			st = myConn.createStatement();
			myRs = st.executeQuery("SELECT name, age, nbVictoires FROM chevaux WHERE id_course="+courseId);
			while (myRs.next()) {
				Cheval ch = new Cheval(myRs.getString("name"), Integer.parseInt(myRs.getString("age")), Integer.parseInt(myRs.getString("nbVictoires")));
			    chevaux.add(ch);
			}
			return chevaux;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			if (myRs != null) {
		        try {
		        	myRs.close();
		        } catch (SQLException e) { /* Ignored */}
		    }
		    if (st != null) {
		        try {
		            st.close();
		        } catch (SQLException e) { /* Ignored */}
		    }
		    if (myConn != null) {
		        try {
		        	myConn.close();
		        } catch (SQLException e) { /* Ignored */}
		    }
		}
	}
	
	public Cheval getRandomCheval(int courseId ) {
		Connection myConn = null;
		  try {
				   myConn = DriverManager.getConnection("jdbc:mysql://remotemysql.com/gPk2Vm2FgH", "gPk2Vm2FgH", "G8eczlCjXq");
		  }
		  catch (Exception exc) {
		   exc.printStackTrace();
		  }
		Statement st = null;
		ResultSet myRs = null;
		try {	
			st = myConn.createStatement();
			myRs = st.executeQuery("SELECT name, age, nbVictoires FROM chevaux WHERE id_course='"+courseId+"'ORDER BY RAND() LIMIT 1");
			if (myRs.next()) {
				Cheval ch = new Cheval(myRs.getString("name"), Integer.parseInt(myRs.getString("age")), Integer.parseInt(myRs.getString("nbVictoires")));
				return ch;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			if (myRs != null) {
		        try {
		        	myRs.close();
		        } catch (SQLException e) { /* Ignored */}
		    }
		    if (st != null) {
		        try {
		            st.close();
		        } catch (SQLException e) { /* Ignored */}
		    }
		    if (myConn != null) {
		        try {
		        	myConn.close();
		        } catch (SQLException e) { /* Ignored */}
		    }
		}
	}
	
	public int getChevalId(String name) {
		Connection myConn = null;
		  try {
				   myConn = DriverManager.getConnection("jdbc:mysql://remotemysql.com/gPk2Vm2FgH", "gPk2Vm2FgH", "G8eczlCjXq");
		  }
		  catch (Exception exc) {
		   exc.printStackTrace();
		  }
		ResultSet myRs = null;
		Statement st = null;
		try {	
			st = myConn.createStatement();
			myRs = st.executeQuery("SELECT id FROM chevaux WHERE name='"+name+"'");
			if (myRs.next()) {
				return Integer.parseInt(myRs.getString("id"));
			} else {
				return -1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return (Integer) null;
		} finally {
			if (myRs != null) {
		        try {
		        	myRs.close();
		        } catch (SQLException e) { /* Ignored */}
		    }
		    if (st != null) {
		        try {
		            st.close();
		        } catch (SQLException e) { /* Ignored */}
		    }
		    if (myConn != null) {
		        try {
		        	myConn.close();
		        } catch (SQLException e) { /* Ignored */}
		    }
		}
	}
	
	public boolean updateCheval(int chevalId, String name) {
		Connection myConn = null;
		  try {
				   myConn = DriverManager.getConnection("jdbc:mysql://remotemysql.com/gPk2Vm2FgH", "gPk2Vm2FgH", "G8eczlCjXq");
		  }
		  catch (Exception exc) {
		   exc.printStackTrace();
		  }
		PreparedStatement st = null;
		try {
			st = myConn.prepareStatement("UPDATE chevaux SET name = '"+name+"' WHERE id="+chevalId);
			st.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
		    if (st != null) {
		        try {
		            st.close();
		        } catch (SQLException e) { /* Ignored */}
		    }
		    if (myConn != null) {
		        try {
		        	myConn.close();
		        } catch (SQLException e) { /* Ignored */}
		    }
		}
	}
	
	public boolean deleteCheval(int chevalId) {
		Connection myConn = null;
		  try {
				   myConn = DriverManager.getConnection("jdbc:mysql://remotemysql.com/gPk2Vm2FgH", "gPk2Vm2FgH", "G8eczlCjXq");
		  }
		  catch (Exception exc) {
		   exc.printStackTrace();
		  }
		Statement st = null;
		try {
			st = myConn.createStatement();
			st.executeUpdate("DELETE FROM chevaux WHERE id="+chevalId);
			myConn.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
		    if (st != null) {
		        try {
		            st.close();
		        } catch (SQLException e) { /* Ignored */}
		    }
		    if (myConn != null) {
		        try {
		        	myConn.close();
		        } catch (SQLException e) { /* Ignored */}
		    }
		}
	}
	
}
