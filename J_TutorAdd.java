package Samyog_koirala_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class J_TutorAdd extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField email;
	private JTextField number;
	private JTextField courseTeaching;
	private JPasswordField teacherPass;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					J_TutorAdd frame = new J_TutorAdd();
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
	public J_TutorAdd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstname = new JLabel("FirstName");
		lblFirstname.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFirstname.setBounds(103, 133, 110, 24);
		contentPane.add(lblFirstname);
		
		JLabel lblLastname = new JLabel("LastName");
		lblLastname.setFont(new Font("Dialog", Font.BOLD, 14));
		lblLastname.setBounds(103, 188, 110, 24);
		contentPane.add(lblLastname);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEmail.setBounds(103, 229, 110, 24);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPassword.setBounds(103, 279, 110, 24);
		contentPane.add(lblPassword);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPhone.setBounds(103, 330, 110, 24);
		contentPane.add(lblPhone);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCourse.setBounds(103, 377, 110, 24);
		contentPane.add(lblCourse);
		
		firstName = new JTextField();
		firstName.setBounds(303, 131, 140, 29);
		contentPane.add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(303, 186, 140, 29);
		contentPane.add(lastName);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(303, 227, 140, 29);
		contentPane.add(email);
		
		number = new JTextField();
		number.setColumns(10);
		number.setBounds(303, 328, 140, 29);
		contentPane.add(number);
		
		courseTeaching = new JTextField();
		courseTeaching.setColumns(10);
		courseTeaching.setBounds(303, 375, 140, 29);
		contentPane.add(courseTeaching);
		
		teacherPass = new JPasswordField();
		teacherPass.setBounds(302, 277, 141, 29);
		contentPane.add(teacherPass);
		
		JButton addTeacher = new JButton("Add Teacher");
		addTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname = firstName.getText();
				String lname = lastName.getText();
				String userEmail = email.getText();
				String phone = number.getText();
				String module = courseTeaching.getText();
				char[] pass = teacherPass.getPassword();
				String password = new String(pass);
				C_Tutor t = new C_Tutor();
				t.tutors(fname,lname,userEmail, module, password, phone);
				Dashboard.tutorsData();
				dispose();
				
				
			}
		});
		addTeacher.setBounds(171, 440, 155, 45);
		contentPane.add(addTeacher);
		
		lblNewLabel = new JLabel("Add Tutor");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(171, 65, 167, 24);
		contentPane.add(lblNewLabel);
	}
}