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
import java.awt.Color;

public class J_CourseEdit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField moduleNumber;
	private JTextField courseName;
	private JTextField seats;
	private JTextField batch;
	private JTextField yearsStudy;
	private JTextField courseId;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					J_CourseEdit frame = new J_CourseEdit();
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
	public J_CourseEdit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 492);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModuleName = new JLabel("Module Name");
		lblModuleName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblModuleName.setBounds(134, 158, 128, 20);
		contentPane.add(lblModuleName);
		
		JLabel lblSeats = new JLabel("Seats");
		lblSeats.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSeats.setBounds(134, 259, 128, 20);
		contentPane.add(lblSeats);
		
		JLabel lblBatch = new JLabel("Batch");
		lblBatch.setFont(new Font("Dialog", Font.BOLD, 14));
		lblBatch.setBounds(134, 303, 128, 20);
		contentPane.add(lblBatch);
		
		JLabel lblYearStudy = new JLabel("Years");
		lblYearStudy.setFont(new Font("Dialog", Font.BOLD, 14));
		lblYearStudy.setBounds(134, 344, 128, 20);
		contentPane.add(lblYearStudy);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCourseName.setBounds(134, 209, 128, 20);
		contentPane.add(lblCourseName);
		
		moduleNumber = new JTextField();
		moduleNumber.setBounds(315, 153, 147, 32);
		contentPane.add(moduleNumber);
		moduleNumber.setColumns(10);
		
		courseName = new JTextField();
		courseName.setColumns(10);
		courseName.setBounds(315, 204, 147, 32);
		contentPane.add(courseName);
		
		seats = new JTextField();
		seats.setColumns(10);
		seats.setBounds(315, 248, 147, 32);
		contentPane.add(seats);
		
		batch = new JTextField();
		batch.setColumns(10);
		batch.setBounds(315, 292, 147, 32);
		contentPane.add(batch);
		
		yearsStudy = new JTextField();
		yearsStudy.setColumns(10);
		yearsStudy.setBounds(315, 339, 147, 32);
		contentPane.add(yearsStudy);
		
		JButton btnUpdateCourse = new JButton("Update Course");
		btnUpdateCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = courseId.getText();
				String courseModule = moduleNumber.getText();
				String nameCourse =  courseName.getText();
				String courseSeat = seats.getText();
				String studentBatch = batch.getText();
				String  studyYear = yearsStudy.getText();
				C_CourseUpdate cu = new C_CourseUpdate();
				cu.updatingCourse(id,nameCourse, courseModule, studentBatch, courseSeat ,studyYear);
				Dashboard.courseData();
				dispose();
				
			}
		});
		btnUpdateCourse.setBounds(189, 402, 147, 43);
		contentPane.add(btnUpdateCourse);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Dialog", Font.BOLD, 14));
		lblId.setBounds(134, 117, 91, 15);
		contentPane.add(lblId);
		
		courseId = new JTextField();
		courseId.setBounds(315, 109, 147, 32);
		contentPane.add(courseId);
		courseId.setColumns(10);
		
		lblNewLabel = new JLabel("Edit Course");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(174, 48, 262, 17);
		contentPane.add(lblNewLabel);
	}
}