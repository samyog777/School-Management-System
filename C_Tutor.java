package Samyog_koirala_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class C_Tutor {
	public void tutors(String firstname,String lastName,String userEmail, String module,String password, String number) {
		String url = "jdbc:mysql://localhost:3306/Course_Man_System";
        String baseUsername = "root";
        String basePassword = "";
        
        String firstName = firstname;
        String LastName = lastName;
        String email = userEmail;
        String phone = number;
        String user = "Teacher";
        String course = module;
        String pass = password;
        try {
        	Connection c = DriverManager.getConnection(url,baseUsername,basePassword);
        	Statement stn = c.createStatement();
        	String teacherTable = "CREATE TABLE IF NOT EXISTS Course_Man_System.teacher(ID INT AUTO_INCREMENT PRIMARY KEY, First_Name varchar(100), Last_Name varchar(1000), Email varchar(1000), Password varchar(1200), User varchar(50), Phone varchar(120), Course varchar(1000))";
        	stn.execute(teacherTable);
        	String valuesInserting =   "INSERT INTO Course_Man_System.teacher (First_Name, Last_Name, Email, Password, User, Phone, Course) VALUES (?, ?, ?, ?, ?, ?, ?)";
        	PreparedStatement ps = c.prepareStatement(valuesInserting);
        	ps.setString(1, firstName);
        	ps.setString(2, LastName);
        	ps.setString(3, email);
        	ps.setString(4, pass);
        	ps.setString(5, user);
        	ps.setString(6, phone);
        	ps.setString(7, course);
        	ps.executeUpdate();

        } catch(Exception e) {
        	System.out.print(e);
        }
        
	}
}