package Samyog_koirala_project;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C_Activities {
public static void activity() {
	String url = "jdbc:mysql://localhost:3306/Course_Man_System";
    String baseUsername = "root";
    String basePassword = "";
    String email= Log_in.mail();
	String user = Log_in.comboVal();
    try {
    	Connection con = DriverManager.getConnection(url,baseUsername, basePassword);
    	Statement s = con.createStatement();
    	String q = " CREATE DATABASE IF NOT EXISTS Course_Man_System";           
        s.executeUpdate(q);
        
        String activityTable = "CREATE TABLE IF NOT EXISTS Course_Man_System.activity(ID INT AUTO_INCREMENT PRIMARY KEY, Activities varchar(500))";
    	s.execute(activityTable);
    	
    	String time = currentTime();
    	String activity = "logged in by:'"+user+"' ,email: '"+email+"' at '"+time+"'";
    	String inserting = "INSERT INTO Course_Man_System.activity (Activities) VALUES (?)";
    	PreparedStatement pstmt = con.prepareStatement(inserting); 
    	pstmt.setString(1, activity);
    	pstmt.executeUpdate(); 
    	
    } catch(SQLException E) {
    	System.out.println(E);
    	
    }
    }

public static String currentTime(){
    // Get the current date and time
    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedDateTime = currentDateTime.format(formatter);
    return formattedDateTime;
	}
}