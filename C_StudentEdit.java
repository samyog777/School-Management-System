package Samyog_koirala_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_StudentEdit {
	public void editStudent(String id,String fName, String lName, String Email, String phone, String course){
		String url = "jdbc:mysql://localhost:3306/Course_Man_System";
	    String baseUsername = "root";
	    String basePassword = "";
	    String ID = id;
	    String first = fName;
	    String last = lName;
	    String mail = Email;
	    String number = phone;
	    String module = course;
	    
	    try {
	    	Connection c = DriverManager.getConnection(url,baseUsername,basePassword);
	    	Statement s = c.createStatement();
	    	
	    	String query = " CREATE DATABASE IF NOT EXISTS Course_Man_System";           

	        s.executeUpdate(query);
	        
	        String studentTable = "CREATE TABLE IF NOT EXISTS Course_Man_System.student(ID INT AUTO_INCREMENT PRIMARY KEY, FirstName varchar(50), LastName varchar(50), Email varchar(120), Password varchar(50), User varchar(50), Phone varchar(120), Course varchar(1000))";
        	s.execute(studentTable);
	        String updateQuery = "UPDATE Course_Man_System.student SET "
	                + "FirstName = '" + first + "', "
	                + "LastName = '" + last + "', "
	                + "Email = '" + mail + "', "
	                + "Phone = '" + number + "' ,"
	                + "Course = '"+module+"'"
	                + "WHERE ID = " + ID;

	        s.executeUpdate(updateQuery);
	        s.close();
	        c.close();
	    } catch (SQLException e) {
	    	System.out.print(e);
	    }
		
		
	}
		
	
	
}
