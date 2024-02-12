package Samyog_koirala_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_PasswordChange_from_TD {
	 public void passChange(String newP, String oldP, String userMail) {
	        String url = "jdbc:mysql://localhost:3306/Course_Man_System";
	        String baseUsername = "root";
	        String basePassword = "";
	        String oldPassword = oldP;
	        String newPassword = newP;
	        String passEmail = userMail;

	        try {
	            Connection c = DriverManager.getConnection(url, baseUsername, basePassword);
	            Statement s = c.createStatement();
	            String query = "CREATE DATABASE IF NOT EXISTS Course_Man_System";
	            s.executeUpdate(query);
	            System.out.println(oldPassword);
	            System.out.println(newPassword);
	            
	            String updateQuery = "UPDATE teacher SET " +
	                    "Password = '" + newPassword + "' " + 
	                    "WHERE Email = '" + passEmail + "'"; 
	            s.executeUpdate(updateQuery);
	            s.close();
	            c.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
}
