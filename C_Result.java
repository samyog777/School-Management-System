package Samyog_koirala_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Result {
public static void  StudentResult(String name, String email, String module, String subject, String marks) {
	 String url = "jdbc:mysql://localhost:3306/Course_Man_System";
     String baseUsername = "root";
     String basePassword = "";
     String full = name;
     String mail = email;
     String mo = module;
     String sub = subject;
     String mark = marks;
     

     try {
         Connection c = DriverManager.getConnection(url, baseUsername, basePassword);
         Statement s = c.createStatement();
         String query = " CREATE DATABASE IF NOT EXISTS Course_Man_System";
         s.executeUpdate(query);
         String creation = "CREATE TABLE IF NOT EXISTS Course_Man_System.Result(ID INT AUTO_INCREMENT PRIMARY KEY,Full_Name varchar(100), Email varchar(1000), Module varchar(1000), Subject varchar(120), Marks varchar(1000))";
     	s.execute(creation);
     	String insertCourse = "INSERT INTO Course_Man_System.Result (Full_Name, Email, Module, Subject, Marks) VALUES (?, ?, ?, ?, ?)";
    	PreparedStatement pstmt = c.prepareStatement(insertCourse);  // Use prepared statement
    	pstmt.setString(1, full);
    	pstmt.setString(2, mail);
    	pstmt.setString(3, mo);
    	pstmt.setString(4, sub);
    	pstmt.setString(5, mark);
    	pstmt.executeUpdate(); 
     		
         s.close();
         c.close();
     } catch (SQLException e) {
         System.out.println(e);
     }
	
	
}
}