package Samyog_koirala_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_CourseDelete {
	public void deletingCourse(String id) {
		String url = "jdbc:mysql://localhost:3306/Course_Man_System";
	    String baseUsername = "root";
	    String basePassword = "";
	    
	    try {
	    	String courseId = id;
	    	Connection c = DriverManager.getConnection(url,baseUsername,basePassword);
	    	Statement s = c.createStatement();
	    	String delete = "DELETE FROM Course_Man_System.Course WHERE id = '" + courseId + "'";
	        s.executeUpdate(delete);
	    	
	    } catch (SQLException e) {
	    	System.out.println(e);
	    }
	}
	
}