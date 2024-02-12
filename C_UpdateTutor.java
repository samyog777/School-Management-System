package Samyog_koirala_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_UpdateTutor {

	public void updatingTutor(String tutorID, String tutorFName, String tutorLName, String email, String phone, String course) {
		
		String url = "jdbc:mysql://localhost:3306/Course_Man_System";
	    String baseUsername = "root";
	    String basePassword = "";
	    String id = tutorID;
	    String fname = tutorFName;
	    String lname = tutorLName;
	    String Email = email;
	    String number = phone;
	    String module = course;
	    try {
	    	Connection c = DriverManager.getConnection(url,baseUsername,basePassword);
	    	Statement s = c.createStatement();
	    	
	    	String query = " CREATE DATABASE IF NOT EXISTS Course_Man_System";           

	        s.executeUpdate(query);
	        
	        String teacherTable = "CREATE TABLE IF NOT EXISTS Course_Man_System.teacher(ID INT AUTO_INCREMENT PRIMARY KEY,Course_Name varchar(100), Seats varchar(1000), Batch varchar(1000), No_of_Years varchar(120), Module varchar(1000))";
	        s.executeUpdate(teacherTable);

	        String updateQuery = "UPDATE Course_Man_System.teacher SET "
	                + "First_Name = '" + fname + "', "
	                + "Last_Name = '" + lname + "', "
	                + "Email = '" + Email + "', "
	                + "Phone = '" + number + "' ,"
	                + "Course = '"+module+"'"
	                + "WHERE ID = " + id;

	        s.executeUpdate(updateQuery);
	        s.close();
	        c.close();
	    } catch (SQLException e) {
	    	System.out.print(e);
	    }
		
		
	}
}