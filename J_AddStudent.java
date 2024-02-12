package Samyog_koirala_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class J_AddStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField email;
	private JTextField phone;
	private JTextField course;
	private JPasswordField pass;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					J_AddStudent frame = new J_AddStudent();
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
	public J_AddStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(15, 0, 657, 560);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFirstName.setBounds(218, 149, 123, 22);
		contentPane.add(lblFirstName);
		
		firstName = new JTextField();
		firstName.setBounds(376, 145, 143, 31);
		contentPane.add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(376, 199, 143, 31);
		contentPane.add(lastName);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(376, 252, 143, 31);
		contentPane.add(email);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(376, 345, 143, 31);
		contentPane.add(phone);
		
		course = new JTextField();
		course.setColumns(10);
		course.setBounds(376, 390, 143, 31);
		contentPane.add(course);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblLastName.setBounds(218, 203, 123, 22);
		contentPane.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEmail.setBounds(218, 256, 123, 22);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPassword.setBounds(218, 299, 123, 22);
		contentPane.add(lblPassword);
		
		JLabel lblPhone = new JLabel("Phone ");
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPhone.setBounds(218, 349, 123, 22);
		contentPane.add(lblPhone);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCourse.setBounds(218, 394, 123, 22);
		contentPane.add(lblCourse);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String first = firstName.getText();
				String last = lastName.getText();
				String mail = email.getText();
				char[] pa = pass.getPassword();
				String pass = new String(pa);
				String number = phone.getText();
				String subject = course.getText();
				C_StudentAdd st = new C_StudentAdd();
				st.addStudent(first,last, mail, pass, number, subject);
				Dashboard.dataStudent();
				dispose();
				
			}
		});
		btnAddStudent.setBounds(266, 449, 150, 39);
		contentPane.add(btnAddStudent);
		
		pass = new JPasswordField();
		pass.setBounds(376, 295, 143, 31);
		contentPane.add(pass);
		
		lblNewLabel = new JLabel("Add Student ");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(288, 52, 184, 51);
		contentPane.add(lblNewLabel);
	}
}