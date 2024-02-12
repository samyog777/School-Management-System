package Samyog_koirala_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class C_TutorUpdate_for_TD {
    public void changeUserData(String name, String cast, String mail, String userId, String number) {
        String url = "jdbc:mysql://localhost:3306/Course_Man_System";
        String baseUsername = "root";
        String basePassword = "";

        // User data
        String userName = name;
        String lname = cast;
        String email = mail;
        String phone = number;
        String id = userId;

        try {
            Connection c = DriverManager.getConnection(url, baseUsername, basePassword);

            // Prepare statement with parameters
            String updateQuery = "UPDATE teacher " +
                    "SET First_Name = ?, " +
                    "Last_Name = ?, " +
                    "Email = ?, " +
                    "Phone = ? " +
                    "WHERE ID = ?";
            PreparedStatement statement = c.prepareStatement(updateQuery);
            statement.setString(1, userName);
            statement.setString(2, lname);
            statement.setString(3, email);
            statement.setString(4, phone);
            statement.setString(5, id);

            // Execute the update
            statement.executeUpdate();

            statement.close();
            c.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
