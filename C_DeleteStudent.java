package Samyog_koirala_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_DeleteStudent {
	public void deleteing(String id) {
		String url = "jdbc:mysql://localhost:3306/Course_Man_System";
	    String baseUsername = "root";
	    String basePassword = "";
	    
	    try {
	    	String studentId = id;
	    	Connection c = DriverManager.getConnection(url,baseUsername,basePassword);
	    	Statement s = c.createStatement();
	    	String deleteTutor = "DELETE FROM Course_Man_System.student WHERE id = '" + studentId + "'";
	        s.executeUpdate(deleteTutor);
	    	
	    } catch (SQLException e) {
	    	System.out.println(e);
	    }
	}
}