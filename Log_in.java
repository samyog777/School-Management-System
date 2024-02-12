package Samyog_koirala_project;
import java.sql.*;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.util.regex.*;
import javax.swing.DropMode;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JCheckBox;
public class Log_in extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField userEmail;
	private JPasswordField userPass;
	private static JComboBox ComboField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log_in frame = new Log_in();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Log_in() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 522);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginPage = new JLabel("LOG IN PAGE");
		lblLoginPage.setBounds(200, 37, 159, 41);
		lblLoginPage.setFont(new Font("Dialog", Font.BOLD, 20));
		contentPane.add(lblLoginPage);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setBounds(239, 279, 171, 46);
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userLogIn();
				C_Activities.activity();
			}
			
		});
		contentPane.add(loginBtn);
		
		userEmail = new JTextField();
		userEmail.setBounds(254, 117, 245, 34);
		contentPane.add(userEmail);
		userEmail.setColumns(10);
		
		
		
		JLabel username = new JLabel("Email");
		username.setBounds(137, 120, 78, 27);
		username.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPane.add(username);
		
		JLabel Password = new JLabel("Password");
		Password.setBounds(137, 169, 78, 31);
		Password.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPane.add(Password);
		
		JButton singupBtn = new JButton("SignUp");
		singupBtn.setBounds(379, 387, 171, 41);
		singupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sign_up s = new Sign_up();
				s.setVisible(true);
				dispose();
			}
		});
		contentPane.add(singupBtn);
		
		userPass = new JPasswordField();
		userPass.setBounds(254, 168, 245, 34);
		contentPane.add(userPass);
		
		ComboField = new JComboBox();
		ComboField.setBounds(255, 226, 93, 27);
		ComboField.setModel(new DefaultComboBoxModel(new String[] {"Select user", "Admin", "Teacher", "Student"}));
		contentPane.add(ComboField);
		
		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setBounds(137, 212, 69, 29);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Don't have an account ?");
		lblNewLabel_1.setBounds(85, 396, 310, 17);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);
		
		JCheckBox Show_Pass = new JCheckBox("Show");
		Show_Pass.setBackground(new Color(128, 128, 128));
		Show_Pass.setBounds(507, 172, 62, 25);
		contentPane.add(Show_Pass);
		Show_Pass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Show_Pass.isSelected()) {
                    userPass.setEchoChar((char) 0); // Show password
                } else {
                    userPass.setEchoChar('*'); // Hide password
                }
            }
        });
	}
	
	public static String comboVal() {
		String combo2 = (String)ComboField.getSelectedItem();
		return combo2;
		
	}
	public static String mail() {
		String email =  userEmail.getText();
		return email;
	}
	
	public void userLogIn() {
		
		String email = userEmail.getText();
		char[] userPassword = userPass.getPassword();
		String pass = new String(userPassword);
		String comboo = (String)ComboField.getSelectedItem();
		
	
		if(!email.equals("") && !pass.equals("")) {
			
			String url = "jdbc:mysql://localhost:3306/Course_Man_System";
	        String baseUsername = "root";
	        String basePassword = "";
	        try {
	        	 Connection logData = DriverManager.getConnection(url, baseUsername, basePassword);
	             Statement s = logData.createStatement();
	            if(comboo.equals("Student")) {
	            	 String querry = "SELECT Password FROM student where Email = '" + email + "'";
		             ResultSet result = s.executeQuery(querry);
		             if (result.next()){
		            	 String storedPass = result.getString("Password");
		            	 if(storedPass.equals(pass)) {
		            		 JOptionPane.showMessageDialog(null, "Login sucessful");
		            		 dispose();
		     				J_StudentDashboard sd = new J_StudentDashboard();
		     				sd.setVisible(true);

		            	 }
		            	 else {
			            	 JOptionPane.showMessageDialog(null, "Login failed");
			             }
		            	 
		             }else {
		            	 JOptionPane.showMessageDialog(null, "User not found");
		             }
	            } else if(comboo.equals("Teacher")) {
	            	 String querry2 = "SELECT Password FROM teacher where Email = '" + email + "'";
		             ResultSet result2 = s.executeQuery(querry2);
		             if (result2.next()){
		            	 String storedPass2 = result2.getString("Password");
		            	 if(storedPass2.equals(pass)) {
		            		 JOptionPane.showMessageDialog(null, "Login sucessful");
		            		 dispose();
		     				J_TeacherDashboard d = new J_TeacherDashboard();
		     				d.setVisible(true);

		            	 }
		            	 else {
			            	 JOptionPane.showMessageDialog(null, "Login failed");
			             }
		            	 
		             }else {
		            	 JOptionPane.showMessageDialog(null, "User not found");
		             }
	            } else if(comboo.equals("Admin")) {
	            	 String querry3 = "SELECT Password FROM admin where Email = '" + email + "'";
		             ResultSet result3 = s.executeQuery(querry3);
		             if (result3.next()){
		            	 String storedPass = result3.getString("Password");
		            	 if(storedPass.equals(pass)) {
		            		 JOptionPane.showMessageDialog(null, "Login sucessful");
		            		 dispose();
		     				Dashboard d = new Dashboard();
		     				d.setVisible(true);

		            	 }
		            	 else {
			            	 JOptionPane.showMessageDialog(null, "Login failed");
			             }
		            	 
		             }else {
		            	 JOptionPane.showMessageDialog(null, "User not found");
		             }
	            }
	             
	        }catch(Exception e) {
	        	JOptionPane.showMessageDialog(null, e);
	        }
		
		} else {
			JOptionPane.showMessageDialog(null, "Fill the box");
		}	
	}
}