package Samyog_koirala_project;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

public class J_CourseAdd extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField courseName;
	private JTextField batch;
	private JTextField seats;
	private JTextField studyYear;
	private JTextField moduleNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					J_CourseAdd frame = new J_CourseAdd();
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
	public J_CourseAdd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 663);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nameCourse = courseName.getText();
				String year = batch.getText();
				String seat = seats.getText();
				String study = studyYear.getText();
				String module = moduleNumber.getText();
				C_Course cs = new C_Course();
				cs.course(nameCourse,year,seat, study, module);
				Dashboard.courseData();
				dispose();
			}
		});
		btnAdd.setBounds(224, 481, 160, 46);
		contentPane.add(btnAdd);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(134, 133, 136, 30);
		lblCourseName.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPane.add(lblCourseName);
		
		courseName = new JTextField();
		courseName.setBounds(381, 131, 136, 32);
		contentPane.add(courseName);
		courseName.setColumns(10);
		
		batch = new JTextField();
		batch.setBounds(381, 202, 136, 30);
		contentPane.add(batch);
		batch.setColumns(10);
		
		JLabel lblBatch = new JLabel("Batch");
		lblBatch.setBounds(134, 208, 97, 23);
		lblBatch.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPane.add(lblBatch);
		
		JLabel lblNoOfSeats = new JLabel("No. of seats");
		lblNoOfSeats.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNoOfSeats.setBounds(136, 279, 117, 23);
		contentPane.add(lblNoOfSeats);
		
		seats = new JTextField();
		seats.setBounds(381, 273, 136, 30);
		contentPane.add(seats);
		seats.setColumns(10);
		
		JLabel lblTotalYears = new JLabel("Total years");
		lblTotalYears.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTotalYears.setBounds(134, 341, 117, 30);
		contentPane.add(lblTotalYears);
		
		studyYear = new JTextField();
		studyYear.setBounds(381, 339, 136, 32);
		contentPane.add(studyYear);
		studyYear.setColumns(10);
		
		JLabel lblModuleNumber = new JLabel("Module Number");
		lblModuleNumber.setFont(new Font("Dialog", Font.BOLD, 14));
		lblModuleNumber.setBounds(134, 410, 136, 35);
		contentPane.add(lblModuleNumber);
		
		moduleNumber = new JTextField();
		moduleNumber.setBounds(381, 410, 134, 30);
		contentPane.add(moduleNumber);
		moduleNumber.setColumns(10);
		
		JLabel lblAddNewCourse = new JLabel("Add New Course");
		lblAddNewCourse.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNewCourse.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAddNewCourse.setBackground(new Color(0, 191, 255));
		lblAddNewCourse.setBounds(146, 32, 371, 77);
		contentPane.add(lblAddNewCourse);
	}
}