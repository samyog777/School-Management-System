package Samyog_koirala_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_ChangeData {
    public void changeUserData(String name, String cast, String mail, String userId, String number, String tableName) {
        String url = "jdbc:mysql://localhost:3306/Course_Man_System";
        String baseUsername = "root";
        String basePassword = "";
        String table = tableName;
        String userName = name;
        String lname = cast;
        String email = mail;
        String phone = number;
        String id = userId;
       
        try {
            Connection c = DriverManager.getConnection(url, baseUsername, basePassword);
            Statement s = c.createStatement();
            String query = " CREATE DATABASE IF NOT EXISTS Course_Man_System";
            s.executeUpdate(query);
            String updateQuery = "UPDATE Course_Man_System." + table + " SET " +
                    "FirstName = '" + userName + "', " +
                    "LastName = '" + lname + "', " +
                    "Email = '" + email + "', " +
                    "Phone = '" + phone + "' " + 
                    "WHERE ID = " + id;
            s.executeUpdate(updateQuery);
            s.close();
            c.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}