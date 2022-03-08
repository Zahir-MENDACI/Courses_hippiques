package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Course;
import model.Hippodrome;
import utils.Utilitaires;

public class CourseDao {

	public boolean addCourseToHippodrome(Course c) {
		Connection myConn = null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://remotemysql.com/gPk2Vm2FgH", "gPk2Vm2FgH", "G8eczlCjXq");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		Statement st = null;
		ResultSet rs = null;
		try {
			st = myConn.createStatement();
			st.executeUpdate("INSERT INTO courses (id, name, date, id_hipp) VALUES (NULL, '" + c.getName() + "', '"
					+ new Date(c.getDate().getTime()) + "', 1)", Statement.RETURN_GENERATED_KEYS);
			rs = st.getGeneratedKeys();
			if (rs.next()) {
				System.out.println(rs.getInt(1));
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					/* Ignored */}
			}
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

	public List<Course> getAllCourses() {
		Connection myConn = null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://remotemysql.com/gPk2Vm2FgH", "gPk2Vm2FgH", "G8eczlCjXq");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		Statement st = null;
		ResultSet myRs = null;
		try {
			List<Course> courses = new ArrayList<Course>();
			st = myConn.createStatement();
			myRs = st.executeQuery("SELECT id, name, date FROM courses WHERE id_hipp=1");
			while (myRs.next()) {
				Course c = new Course(Integer.parseInt(myRs.getString("id")), myRs.getString("name"),
						Utilitaires.parseDate(myRs.getString("date")));
				courses.add(c);
			}
			return courses;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			if (myRs != null) {
				try {
					myRs.close();
				} catch (SQLException e) {
					/* Ignored */}
			}
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

	public List<Course> getLastCourses() {
		Connection myConn = null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://remotemysql.com/gPk2Vm2FgH", "gPk2Vm2FgH", "G8eczlCjXq");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		Statement st = null;
		ResultSet myRs = null;
		try {
			List<Course> courses = new ArrayList<Course>();
			st = myConn.createStatement();
			myRs = st.executeQuery("SELECT id, name, date FROM courses WHERE id_hipp=1 ORDER BY date DESC LIMIT 10;");
			while (myRs.next()) {
				Course c = new Course(Integer.parseInt(myRs.getString("id")), myRs.getString("name"),
						Utilitaires.parseDate(myRs.getString("date")));
				courses.add(c);
			}
			return courses;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			if (myRs != null) {
				try {
					myRs.close();
				} catch (SQLException e) {
					/* Ignored */}
			}
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

	public boolean updateCourse(int courseId, String name) {
		Connection myConn = null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://remotemysql.com/gPk2Vm2FgH", "gPk2Vm2FgH", "G8eczlCjXq");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		Statement st = null;
		try {
			st = myConn.createStatement();
			st.executeUpdate("UPDATE courses SET name = '" + name + "' WHERE id=" + courseId);
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

	public int getCourseId(String name) {
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
			myRs = st.executeQuery("SELECT id FROM courses WHERE name='" + name + "'");
			if (myRs.next()) {
				return Integer.parseInt(myRs.getString("id"));
			} else {
				return -1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally {
			if (myRs != null) {
				try {
					myRs.close();
				} catch (SQLException e) {
					/* Ignored */}
			}
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

	public boolean deleteCourse(int courseId) {
		Connection myConn = null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://remotemysql.com/gPk2Vm2FgH", "gPk2Vm2FgH", "G8eczlCjXq");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		Statement st = null;
		try {
			st = myConn.createStatement();
			st.executeUpdate("DELETE FROM courses WHERE id=" + courseId);
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
