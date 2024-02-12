package Samyog_koirala_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class C_Course {
	public void course(String nameCourse,String year,String seat, String studyYear, String module) {
		String url = "jdbc:mysql://localhost:3306/Course_Man_System";
        String baseUsername = "root";
        String basePassword = "";
        
       String course = nameCourse;
       String years = year;
       String seats = seat;
       String yearStudy = studyYear;
       String numberModule = module;
        try {
        	
        	Connection c = DriverManager.getConnection(url,baseUsername,basePassword);
        	Statement s = c.createStatement();
        	
        	String createTableCourse = "CREATE TABLE IF NOT EXISTS Course_Man_System.Course(ID INT AUTO_INCREMENT PRIMARY KEY,Course_Name varchar(100), Seats varchar(1000), Batch varchar(1000), No_of_Years varchar(120), Module varchar(1000))";
        	s.execute(createTableCourse);

        	String insertCourse = "INSERT INTO Course_Man_System.Course (Course_Name, Seats, Batch, No_of_Years, Module) VALUES (?, ?, ?, ?, ?)";
        	PreparedStatement pstmt = c.prepareStatement(insertCourse);  // Use prepared statement
        	pstmt.setString(1, course);
        	pstmt.setString(2, seats);
        	pstmt.setString(3, years);
        	pstmt.setString(4, yearStudy);
        	pstmt.setString(5, numberModule);
        	pstmt.executeUpdate(); 
        } catch(Exception e) {
        	System.out.print(e);
        }
        
	}
}