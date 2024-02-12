package Samyog_koirala_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_CourseUpdate {
public void updatingCourse(String courseID, String courseName, String moduleName, String batch, String seats, String studyYear) {
	
	String url = "jdbc:mysql://localhost:3306/Course_Man_System";
    String baseUsername = "root";
    String basePassword = "";
    String id = courseID;
    String name = courseName;
    String module = moduleName;
    String group = batch;
    String seatNumber = seats;
    String year = studyYear;
    try {
    	Connection c = DriverManager.getConnection(url,baseUsername,basePassword);
    	Statement s = c.createStatement();
    	
    	String query = " CREATE DATABASE IF NOT EXISTS Course_Man_System";           

        s.executeUpdate(query);
        
        String createTable = "CREATE TABLE IF NOT EXISTS Course_Man_System.Course(ID INT AUTO_INCREMENT PRIMARY KEY,Course_Name varchar(100), Seats varchar(1000), Batch varchar(1000), No_of_Years varchar(120), Module varchar(1000))";

//      Execute the SQL statement to create the table

        s.executeUpdate(createTable);

        String updateQuery = "UPDATE Course_Man_System.Course SET "
                + "Course_Name = '" + name + "', "
                + "Seats = '" + seatNumber + "', "
                + "Batch = '" + group + "', "
                + "No_of_Years = '" + year + "' ,"
                + "Module = '"+module+"'"
                + "WHERE ID = " + id;

        s.executeUpdate(updateQuery);
        s.close();
        c.close();
    } catch (SQLException e) {
    	System.out.print(e);
    }
	
	
}
}