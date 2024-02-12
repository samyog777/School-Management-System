package Samyog_koirala_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class J_UpdateStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField First;
	private JTextField last;
	private JTextField mail;
	private JTextField number;
	private JTextField course;
	private JTextField ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					J_UpdateStudent frame = new J_UpdateStudent();
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
	public J_UpdateStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 569);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFirstName.setBounds(162, 166, 109, 15);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblLastName.setBounds(162, 222, 109, 15);
		contentPane.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEmail.setBounds(162, 284, 109, 15);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPhone.setBounds(162, 350, 109, 15);
		contentPane.add(lblPhone);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCourse.setBounds(162, 411, 109, 15);
		contentPane.add(lblCourse);
		
		First = new JTextField();
		First.setBounds(356, 159, 166, 30);
		contentPane.add(First);
		First.setColumns(10);
		
		last = new JTextField();
		last.setColumns(10);
		last.setBounds(356, 215, 166, 30);
		contentPane.add(last);
		
		mail = new JTextField();
		mail.setColumns(10);
		mail.setBounds(356, 277, 166, 30);
		contentPane.add(mail);
		
		number = new JTextField();
		number.setColumns(10);
		number.setBounds(356, 343, 166, 30);
		contentPane.add(number);
		
		course = new JTextField();
		course.setColumns(10);
		course.setBounds(356, 404, 166, 30);
		contentPane.add(course);
		
		JButton update = new JButton("Update Details");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname = First.getText();
				String lname = last.getText();
				String email = mail.getText();
				String phone = number.getText();
				String module = course.getText();
				C_StudentEdit se = new C_StudentEdit();
				String id = ID.getText();
				se.editStudent(id,fname,lname, email, phone, module);
				Dashboard.dataStudent();
				dispose();
			}
		});
		update.setBounds(246, 462, 162, 40);
		contentPane.add(update);
		
		JLabel lblUpdateStudentDetails = new JLabel("Update Details Of Students");
		lblUpdateStudentDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateStudentDetails.setFont(new Font("Dialog", Font.BOLD, 22));
		lblUpdateStudentDetails.setBounds(25, 23, 578, 67);
		contentPane.add(lblUpdateStudentDetails);
		
		ID = new JTextField();
		ID.setColumns(10);
		ID.setBounds(356, 111, 166, 30);
		contentPane.add(ID);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Dialog", Font.BOLD, 14));
		lblId.setBounds(162, 118, 109, 15);
		contentPane.add(lblId);
	}

}