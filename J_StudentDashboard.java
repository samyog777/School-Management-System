package Samyog_koirala_project;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;

public class J_StudentDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private static JTable tableCourse;
	private JTextField searchCourse;
	
	private static JTable tutorTable;
	private JTextField fName;
	private JTextField LName;
	private static JTable studentTable;
	private JTextField studentSearch;
	private JTextField studentUserName;
	private JTextField studentNumber;
	private JTextField StudentIdentity;
	private JTextField StudentLastName;
	private JTextField StudentEmail;
	private JPasswordField previous;
	private JPasswordField present;
	private JTextField emailStudent;
	private static JTable activityTable;
	private static JLabel totalStudent;
	private static JLabel totalCourse;
	private static JLabel totalTeachers;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void courseData(){
			
			DefaultTableModel model = (DefaultTableModel)tableCourse.getModel();
			model.setRowCount(0);			
			String url = "jdbc:mysql://localhost:3306/Course_Man_System";
	        String baseUsername = "root";
	        String basePassword = "";
	        try {
		           Connection con = DriverManager.getConnection(url, baseUsername, basePassword);
		           Statement stmt = con.createStatement();
		           String query = "select * from Course_Man_System.Course";
		           ResultSet rs = stmt.executeQuery(query);
		    	   boolean check = false;    
		           while(rs.next()){
		        	   String id = rs.getString(1);
		        	   String course_name = rs.getString(2);
		        	   String course_seat= rs.getString(3);
		        	   String course_batch = rs.getString(4);
		        	   String course_year= rs.getString(5);
		        	   String course_pass = rs.getString(6);
		        	   String data[]= {id,course_name, course_seat, course_batch, course_year,course_pass	};
		        	   model.addRow(data);
		        	   
		           }

		       }
				catch (SQLException e1) {
		           e1.printStackTrace();
		       }	
}
	
public static void tutorsData() {
	DefaultTableModel model2 = (DefaultTableModel)tutorTable.getModel();
	model2.setRowCount(0);			
	String url = "jdbc:mysql://localhost:3306/Course_Man_System";
    String baseUsername = "root";
    String basePassword = "";
    try {
           Connection con2 = DriverManager.getConnection(url, baseUsername, basePassword);
           Statement stmt2 = con2.createStatement();
           String query2 = "select * from Course_Man_System.teacher";
           ResultSet rs2 = stmt2.executeQuery(query2);
           while(rs2.next()){
        	   String id = rs2.getString(1);
        	   String firstName = rs2.getString(2);
        	   String lastName = rs2.getString(3);
        	   String email= rs2.getString(4);
        	   String phone = rs2.getString(7);
        	   String course = rs2.getString(8);
        	  
        	   String data[]= {id,firstName, lastName, email, phone,course};
        	   model2.addRow(data);
        	   
           }

       }
		catch (SQLException e1) {
           e1.printStackTrace();
       }	
}


public static void searchCourse(String courseName){
	String url = "jdbc:mysql://localhost:3306/Course_Man_System";
    String username = "root";
    String password = "";
    String course = courseName;
	DefaultTableModel model3 = (DefaultTableModel)tableCourse.getModel();
	model3.setRowCount(0);
	
    try {
        Connection con = DriverManager.getConnection(url, username, password);
        Statement stmt = con.createStatement();
        String query = "SELECT * FROM Course_Man_System.Course WHERE Course_Name = '" + course + "'";
        ResultSet rss = stmt.executeQuery(query);
        if (rss.next()) {
        	String id = rss.getString(1);
     	   String course_name = rss.getString(2);
     	   String course_seat= rss.getString(3);
     	   String course_batch = rss.getString(4);
     	   String course_year= rss.getString(5);
     	   String course_pass = rss.getString(6);
     	   String data[]= {id,course_name, course_seat, course_batch, course_year,course_pass	};
     	   model3.addRow(data);
        }
        rss.close();
        stmt.close();
        con.close();			                    
    } catch (SQLException e) {
    	System.out.println(e);
    }
}

public static void searchTutor(String userName, String lname) {
	String url = "jdbc:mysql://localhost:3306/Course_Man_System";
    String username = "root";
    String password = "";
    String tutor = userName;
    String last = lname;
	DefaultTableModel model4 = (DefaultTableModel)tutorTable.getModel();
	model4.setRowCount(0);
	
    try {
        Connection con = DriverManager.getConnection(url, username, password);
        Statement stmt = con.createStatement();
        String query = "SELECT * FROM Course_Man_System.teacher WHERE First_Name = '" + tutor + "' AND Last_Name = '"+last+"'";
        ResultSet rs3 = stmt.executeQuery(query);
        if (rs3.next()) {
        	 String id = rs3.getString(1);
      	   String firstName = rs3.getString(2);
      	   String lastName = rs3.getString(3);
      	   String email= rs3.getString(4);
      	   String phone = rs3.getString(7);
      	   String course = rs3.getString(8);
      	  
      	   String data[]= {id,firstName, lastName, email, phone,course};
      	   model4.addRow(data);
        }
        rs3.close();
        stmt.close();
        con.close();			                    
    } catch (SQLException e) {
    	System.out.println(e);
    }
}


public static void studentData() {
	DefaultTableModel model5 = (DefaultTableModel)studentTable.getModel();
	model5.setRowCount(0);			
	String url = "jdbc:mysql://localhost:3306/Course_Man_System";
    String baseUsername = "root";
    String basePassword = "";
    try {
           Connection co = DriverManager.getConnection(url, baseUsername, basePassword);
           Statement stmt = co.createStatement();
           String query = "select * from Course_Man_System.student";
           ResultSet rs = stmt.executeQuery(query);
    	      
           while(rs.next()){
        	   String id = rs.getString(1);
        	   String first_name = rs.getString(2);
        	   String last_name= rs.getString(3);
        	   String email = rs.getString(4);
        	   String course= rs.getString(8);
        	  
        	   String data[]= {id,first_name, last_name, email,course};
        	   model5.addRow(data);
        	   
           }

       }
		catch (SQLException e1) {
           e1.printStackTrace();
       }	
}

public static void SearchStudentEnter(String student){
	DefaultTableModel mo = (DefaultTableModel)studentTable.getModel();
	mo.setRowCount(0);
    String enteredStudent = student;
    String url = "jdbc:mysql://localhost:3306/Course_Man_System";
    String baseUsername = "root";
    String basePassword = "";
    try {
           Connection con = DriverManager.getConnection(url, baseUsername, basePassword);
           Statement stmt = con.createStatement();
           String query = "select * from Course_Man_System.student WHERE FirstName ='"+enteredStudent+"'";
           ResultSet r = stmt.executeQuery(query);   
           while(r.next()){
        	   String id = r.getString(1);
        	   String first_name = r.getString(2);
        	   String last_name= r.getString(3);
        	   String email = r.getString(4);
        	   String course= r.getString(8);
        	  
        	   String data[]= {id,first_name, last_name, email,course};
        	   mo.addRow(data);
        	   
           }

       }
		catch (SQLException e1) {
           e1.printStackTrace();
       }	   
    
    System.out.println("Text entered: " + enteredStudent);
}
public static void displayStudentDashboard(){
	DefaultTableModel model2 = (DefaultTableModel)activityTable.getModel();
	model2.setRowCount(0);			
	String url = "jdbc:mysql://localhost:3306/Course_Man_System";
    String baseUsername = "root";
    String basePassword = "";
    try {
           Connection con2 = DriverManager.getConnection(url, baseUsername, basePassword);
           Statement stmt2 = con2.createStatement();
           String query2 = "select * from Course_Man_System.activity";
           ResultSet rs2 = stmt2.executeQuery(query2);
           while(rs2.next()){
        	   String id = rs2.getString(1);
        	   String activity= rs2.getString(2);
        	   String data[]= {id,activity};
        	   model2.addRow(data);
           }
       }
		catch (SQLException e1) {
           e1.printStackTrace();
       }	
}


public static String Total(String tableName) {
    String url = "jdbc:mysql://localhost:3306/Course_Man_System";
    String username = "root";
    String password = "";
    int count = 0;
    try {
        Connection con = DriverManager.getConnection(url, username, password);
        Statement stmt = con.createStatement();
        String data = "SELECT * FROM Course_Man_System." + tableName;
        ResultSet rs = stmt.executeQuery(data);
        while (rs.next()) {
            count++;
        }
        System.out.println(count);
        stmt.close();
        con.close(); 
        return String.valueOf(count);

    } catch (SQLException e) {
        System.out.println(e);
        return String.valueOf(count);

    }

}


	/**
	 * Create the frame.
	 */
	public J_StudentDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1346, 723);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(12, 12, 236, 681);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton dashboardBtn = new JButton("Dashboard");
		dashboardBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
				displayStudentDashboard();
				String studentTotal = Total("student");
				totalStudent.setText(studentTotal);
				String totalTutor =Total("teacher");
				totalTeachers.setText(totalTutor);
				String courseTotal =Total("Course");
				totalCourse.setText(courseTotal);
			}
		});
		dashboardBtn.setBounds(34, 165, 158, 46);
		panel.add(dashboardBtn);
		
		JButton coursesBtn = new JButton("Courses");
		coursesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
				courseData();
			}
		});
		coursesBtn.setBounds(34, 336, 158, 46);
		panel.add(coursesBtn);
		
		JButton tutorBtn = new JButton("Tutor");
		tutorBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);			
				tutorsData();
			}
			
		});
		tutorBtn.setBounds(34, 492, 158, 46);
		panel.add(tutorBtn);
		
		JButton studentBtn = new JButton("student");
		studentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
				studentData();
				
				
				
			}
		});
		studentBtn.setBounds(34, 410, 158, 46);
		panel.add(studentBtn);
		
		JButton settingBtn = new JButton("Setting");
		settingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
				
				
			}
		});
		settingBtn.setBounds(34, 246, 158, 46);
		panel.add(settingBtn);
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Log_in l = new Log_in();
				l.setVisible(true);
				dispose();
			}
		});
		logoutBtn.setBounds(34, 566, 158, 46);
		panel.add(logoutBtn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 128, 128));
		panel_2.setBounds(1110, 25, 214, 656);
		contentPane.add(panel_2);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(192, 192, 192));
		tabbedPane.setBounds(260, 97, 838, 584);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 128));
		tabbedPane.addTab("Dashboard", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(12, 222, 809, 302);
		panel_1.add(scrollPane_3);
		
		activityTable = new JTable();
		scrollPane_3.setViewportView(activityTable);
		activityTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Activity"
			}
		));	
		
		activityTable.getColumnModel().getColumn(0).setPreferredWidth(30);
		activityTable.getColumnModel().getColumn(0).setMinWidth(80);
		activityTable.getColumnModel().getColumn(0).setMaxWidth(80);
		activityTable.getColumnModel().getColumn(1).setPreferredWidth(316);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(192, 192, 192));
		panel_6.setBounds(22, 28, 203, 153);
		panel_1.add(panel_6);
		panel_6.setBorder(BorderFactory.createRaisedBevelBorder());
		panel_6.setLayout(null);
		
		JLabel lblTotalStudents = new JLabel("Total Students");
		lblTotalStudents.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalStudents.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTotalStudents.setBounds(12, 12, 168, 29);
		panel_6.add(lblTotalStudents);
		
		totalStudent = new JLabel("0");
		totalStudent.setHorizontalAlignment(SwingConstants.CENTER);
		totalStudent.setFont(new Font("Dialog", Font.BOLD, 20));
		totalStudent.setBounds(49, 60, 99, 40);
		panel_6.add(totalStudent);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setBackground(new Color(192, 192, 192));
		panel_6_1.setBounds(272, 28, 198, 153);
		panel_1.add(panel_6_1);
		panel_6_1.setBorder(BorderFactory.createRaisedBevelBorder());
		panel_6_1.setLayout(null);
		
		JLabel lblTotalCourse = new JLabel("Total Courses");
		lblTotalCourse.setBounds(34, 12, 131, 19);
		lblTotalCourse.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalCourse.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_6_1.add(lblTotalCourse);
		
		totalCourse = new JLabel("0");
		totalCourse.setHorizontalAlignment(SwingConstants.CENTER);
		totalCourse.setFont(new Font("Dialog", Font.BOLD, 20));
		totalCourse.setBounds(50, 59, 99, 40);
		panel_6_1.add(totalCourse);
		
		JPanel panel_6_2 = new JPanel();
		panel_6_2.setBackground(new Color(192, 192, 192));
		panel_6_2.setBounds(544, 28, 188, 153);
		panel_1.add(panel_6_2);
		panel_6_2.setBorder(BorderFactory.createRaisedBevelBorder());
		panel_6_2.setLayout(null);
		
		JLabel lblTotalTeachers = new JLabel("Total Teachers");
		lblTotalTeachers.setBounds(28, 12, 131, 19);
		lblTotalTeachers.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalTeachers.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_6_2.add(lblTotalTeachers);
		
		totalTeachers = new JLabel("0");
		totalTeachers.setHorizontalAlignment(SwingConstants.CENTER);
		totalTeachers.setFont(new Font("Dialog", Font.BOLD, 20));
		totalTeachers.setBounds(38, 54, 99, 40);
		panel_6_2.add(totalTeachers);
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Courses", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 133, 809, 412);
		panel_3.add(scrollPane_1);
		
		tableCourse = new JTable();
		tableCourse.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Id","Course Name", "Seats", "Batch", "No. of Years", "Module"
			}
		));
		scrollPane_1.setViewportView(tableCourse);
		
		searchCourse = new JTextField();
		searchCourse.setToolTipText("");
		searchCourse.setBounds(12, 84, 644, 37);
		panel_3.add(searchCourse);
		searchCourse.setColumns(10);
		
		JButton searchBtn = new JButton("Search");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseSearch = searchCourse.getText();
				searchCourse(courseSearch);
				
			}
		});
		searchBtn.setBounds(670, 84, 151, 37);
		panel_3.add(searchBtn);
		
		JLabel lblCourseInformation = new JLabel("Course Information");
		lblCourseInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourseInformation.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCourseInformation.setBounds(12, 12, 809, 55);
		panel_3.add(lblCourseInformation);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(12, 62, 809, 10);
		panel_3.add(separator_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Tutors", null, panel_4, null);
		
		JButton btnDeleteTutors = new JButton("Search Tutor");
		btnDeleteTutors.setBounds(683, 83, 138, 34);
		btnDeleteTutors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName =  fName.getText();
				String lastName = LName.getText();
				searchTutor(firstName,lastName);
				
			}
		});
		panel_4.setLayout(null);
		panel_4.add(btnDeleteTutors);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 129, 809, 416);
		panel_4.add(scrollPane);
		
		tutorTable = new JTable();
		scrollPane.setViewportView(tutorTable);
		tutorTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID","First_Name", "Last_Name", "Email", "Course"
			}
		));
		
		fName = new JTextField();
		fName.setBounds(165, 86, 158, 29);
		panel_4.add(fName);
		fName.setColumns(10);
		
		LName = new JTextField();
		LName.setBounds(505, 86, 150, 29);
		panel_4.add(LName);
		LName.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(12, 89, 135, 22);
		lblFirstName.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_4.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(366, 86, 122, 28);
		lblLastName.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_4.add(lblLastName);
		
		JLabel lblTeacherInformation = new JLabel("Teacher Information");
		lblTeacherInformation.setBackground(new Color(192, 192, 192));
		lblTeacherInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeacherInformation.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTeacherInformation.setBounds(12, 12, 809, 55);
		panel_4.add(lblTeacherInformation);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(12, 61, 809, 10);
		panel_4.add(separator_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Students", null, panel_5, null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 126, 809, 419);
		
		studentTable = new JTable();
		studentTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "First_Name", "Last_Name", "Email", "Course"
			}
		));
		scrollPane_2.setViewportView(studentTable);
		
		studentSearch = new JTextField();
		studentSearch.setBounds(12, 79, 446, 35);
		studentSearch.setColumns(10);
		
		JButton btnSearchStudent = new JButton("Search Student");
		btnSearchStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String student = studentSearch.getText();
;				SearchStudentEnter(student);
			}
		});
		btnSearchStudent.setBounds(470, 79, 174, 35);
		panel_5.setLayout(null);
		panel_5.add(studentSearch);
		panel_5.add(btnSearchStudent);
		panel_5.add(scrollPane_2);
		
		JLabel lblStudentInformation = new JLabel("Student Information");
		lblStudentInformation.setFont(new Font("Dialog", Font.BOLD, 20));
		lblStudentInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentInformation.setBounds(12, 12, 809, 55);
		panel_5.add(lblStudentInformation);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 66, 809, 10);
		panel_5.add(separator_1);
		
		JButton btnViewReport = new JButton("View Report");
		btnViewReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				J_StudentReport sr = new J_StudentReport();
				sr.setVisible(true);
				sr.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});
		btnViewReport.setBounds(656, 79, 165, 35);
		panel_5.add(btnViewReport);
		
		
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Setting", null, panel_7, null);
		panel_7.setLayout(null);
		
		JLabel lblSetting = new JLabel("Change Information");
		lblSetting.setBounds(12, 12, 231, 24);
		lblSetting.setFont(new Font("Dialog", Font.BOLD, 20));
		panel_7.add(lblSetting);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 48, 809, 10);
		panel_7.add(separator);
		
		JLabel lblUsername = new JLabel("First Name");
		lblUsername.setBounds(12, 70, 108, 15);
		panel_7.add(lblUsername);
		
		studentUserName = new JTextField();
		studentUserName.setBounds(150, 70, 141, 24);
		panel_7.add(studentUserName);
		studentUserName.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone ");
		lblPhone.setBounds(12, 127, 108, 15);
		panel_7.add(lblPhone);
		
		JLabel lblLastName_1 = new JLabel("Last Name");
		lblLastName_1.setBounds(374, 70, 108, 15);
		panel_7.add(lblLastName_1);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(374, 127, 108, 15);
		panel_7.add(lblEmail);
		
		JLabel lblUsername_3_1 = new JLabel("ID");
		lblUsername_3_1.setBounds(12, 176, 108, 15);
		panel_7.add(lblUsername_3_1);
		
		studentNumber = new JTextField();
		studentNumber.setColumns(10);
		studentNumber.setBounds(150, 123, 141, 24);
		panel_7.add(studentNumber);
		
		StudentIdentity = new JTextField();
		StudentIdentity.setColumns(10);
		StudentIdentity.setBounds(150, 172, 141, 24);
		panel_7.add(StudentIdentity);
		
		StudentLastName = new JTextField();
		StudentLastName.setColumns(10);
		StudentLastName.setBounds(512, 66, 141, 24);
		panel_7.add(StudentLastName);
		
		StudentEmail = new JTextField();
		StudentEmail.setColumns(10);
		StudentEmail.setBounds(512, 123, 141, 24);
		panel_7.add(StudentEmail);
		
		JButton btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String fname = studentUserName.getText();
			String lname = StudentLastName.getText();
			String email = StudentEmail.getText();
			String id = StudentIdentity.getText();
			String number = studentNumber.getText();
			String table = "student";
			C_ChangeData dc = new C_ChangeData();
			dc.changeUserData(fname, lname, email,id, number,table);
			JOptionPane.showMessageDialog(null, "Data edited");
			
			}
			
		});
		btnEditProfile.setBounds(512, 171, 141, 31);
		panel_7.add(btnEditProfile);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(12, 277, 809, 10);
		panel_7.add(separator_4);
		
		JLabel lblSecurityLogin = new JLabel("Change Password");
		lblSecurityLogin.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSecurityLogin.setBounds(12, 241, 244, 24);
		panel_7.add(lblSecurityLogin);
		
		JLabel lblOldPassword = new JLabel("Old Password");
		lblOldPassword.setBounds(12, 300, 134, 15);
		panel_7.add(lblOldPassword);
		
		previous = new JPasswordField();
		previous.setBounds(164, 300, 166, 24);
		panel_7.add(previous);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setBounds(413, 300, 134, 15);
		panel_7.add(lblNewPassword);
		
		present = new JPasswordField();
		present.setBounds(597, 300, 166, 24);
		panel_7.add(present);
		
		emailStudent = new JTextField();
		emailStudent.setColumns(10);
		emailStudent.setBounds(164, 355, 166, 24);
		panel_7.add(emailStudent);
		
		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setBounds(12, 359, 108, 15);
		panel_7.add(lblEmail_1);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] pre = previous.getPassword();
				String old = new String(pre);
				char[] pres = present.getPassword();
				String newest = new String(pres);
				String table = "student";
				String passEmail = Log_in.mail();
				C_PassChange cp = new C_PassChange();
				cp.passChange(newest,old,passEmail,table);
				JOptionPane.showMessageDialog(null, "Password changed");
				System.out.println(old);
				System.out.println(newest);
			}
		});
		btnChangePassword.setBounds(582, 348, 181, 37);
		panel_7.add(btnChangePassword);
		
		JLabel lblHelpServices = new JLabel("Help");
		lblHelpServices.setFont(new Font("Dialog", Font.BOLD, 20));
		lblHelpServices.setBounds(12, 412, 244, 24);
		panel_7.add(lblHelpServices);
		
		JSeparator separator_4_1 = new JSeparator();
		separator_4_1.setBounds(12, 445, 809, 10);
		panel_7.add(separator_4_1);
		
		JLabel lblReportIfAny = new JLabel("Issue?");
		lblReportIfAny.setFont(new Font("Dialog", Font.BOLD, 15));
		lblReportIfAny.setBounds(35, 467, 50, 15);
		panel_7.add(lblReportIfAny);
		
		JLabel lblNewLabel = new JLabel("For help --------------------->");
		lblNewLabel.setBounds(35, 509, 400, 17);
		panel_7.add(lblNewLabel);
		
		JLabel lblCmsSupportHotline = new JLabel("Help");
		lblCmsSupportHotline.setBounds(476, 467, 193, 15);
		panel_7.add(lblCmsSupportHotline);
		
		JLabel lblEmailHeraldcollegegmailcom = new JLabel("Email:- samyogkoirala18@gmail.com");
		lblEmailHeraldcollegegmailcom.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblEmailHeraldcollegegmailcom.setBounds(476, 494, 244, 15);
		panel_7.add(lblEmailHeraldcollegegmailcom);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number: 9819320008");
		lblPhoneNumber.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblPhoneNumber.setBounds(476, 521, 244, 15);
		panel_7.add(lblPhoneNumber);
		
		JLabel lblNewLabel_1 = new JLabel("Created By Samyog Koirala");
		lblNewLabel_1.setBounds(250, 535, 200, 20);
		panel_7.add(lblNewLabel_1);
		
		JLabel lblNotifications = new JLabel("Notifications");
		lblNotifications.setBounds(1110, -5, 166, 30);
		lblNotifications.setFont(new Font("Dialog", Font.BOLD, 16));
		contentPane.add(lblNotifications);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(260, 12, 832, 73);
		panel_8.setBackground(new Color(0, 0, 0));
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblStudentDashboard = new JLabel("Student Dashboard");
		lblStudentDashboard.setBounds(12, 12, 808, 49);
		lblStudentDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentDashboard.setForeground(new Color(46, 139, 87));
		lblStudentDashboard.setFont(new Font("Dialog", Font.BOLD, 24));
		lblStudentDashboard.setBackground(Color.BLACK);
		panel_8.add(lblStudentDashboard);
		
		
		
		
		
	}
}