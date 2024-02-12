package Samyog_koirala_project;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JSlider;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private static JTable courseTable;
	private JTextField searchCourse;
	private static JTable tableTutor;
	private static JTable studentDataTable;
	private JTextField searchTutor;
	private JTextField searchStudent;
	private static JTable dashboardTable;
	private static JLabel totalStudent;
	private static JLabel tutorTotal;
	private static JLabel totalCourse;
	private static JTextField nameUser;
	private static  JTextField userPhone;
	private static JTextField mailUser;
	private static JTextField lastName;
	private static JPasswordField oldPass;
	private static JPasswordField newPass;
	private static JTextField passChangeEmail;
	private static JTextField idUser;
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
			
			DefaultTableModel model = (DefaultTableModel)courseTable.getModel();
			model.setRowCount(0);			
			String url = "jdbc:mysql://localhost:3306/Course_Man_System";
	        String baseUsername = "root";
	        String basePassword = "";
	        try {
		           Connection con = DriverManager.getConnection(url, baseUsername, basePassword);
		           Statement stmt = con.createStatement();
		           String query = "select * from Course_Man_System.Course";
		           ResultSet rs = stmt.executeQuery(query);   
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
	DefaultTableModel model2 = (DefaultTableModel)tableTutor.getModel();
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



public static void dataStudent() {
	DefaultTableModel m = (DefaultTableModel)studentDataTable.getModel();
	m.setRowCount(0);			
	String url = "jdbc:mysql://localhost:3306/Course_Man_System";
    String baseUsername = "root";
    String basePassword = "";
    try {
           Connection c = DriverManager.getConnection(url, baseUsername, basePassword);
           Statement st = c.createStatement();
           String q = "select * from Course_Man_System.student";
           ResultSet r = st.executeQuery(q);
    	      
           while(r.next()){
        	   String id = r.getString(1);
        	   String first_name = r.getString(2);
        	   String last_name= r.getString(3);
        	   String email = r.getString(4);
        	   String course= r.getString(8);
        	  
        	   String data[]= {id,first_name, last_name, email,course};
        	   m.addRow(data);
        	   
           }

       }
		catch (SQLException e1) {
           e1.printStackTrace();
       }	
}

public static void studentSearchEnter(String student){
	DefaultTableModel mo = (DefaultTableModel)studentDataTable.getModel();
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

public static void courseSearchEnter(String course) {
	DefaultTableModel model = (DefaultTableModel)courseTable.getModel();
	model.setRowCount(0);
    String enteredText = course;
    String url = "jdbc:mysql://localhost:3306/Course_Man_System";
    String baseUsername = "root";
    String basePassword = "";
    try {
           Connection con = DriverManager.getConnection(url, baseUsername, basePassword);
           Statement stmt = con.createStatement();
           String query = "select * from Course_Man_System.course WHERE Course_Name ='"+enteredText+"'";
           ResultSet rs = stmt.executeQuery(query);   
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
    
    System.out.println("Text entered: " + enteredText);
}



public static void tutorSearchEnter(String tutor) {
	DefaultTableModel model2 = (DefaultTableModel)tableTutor.getModel();
	model2.setRowCount(0);			
	String url = "jdbc:mysql://localhost:3306/Course_Man_System";
    String baseUsername = "root";
    String basePassword = "";
    String teacher = tutor;
    try {
           Connection con2 = DriverManager.getConnection(url, baseUsername, basePassword);
           Statement stmt2 = con2.createStatement();
           String query2 = "select * from Course_Man_System.teacher where First_Name='"+teacher+"'";
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


public static void displayDashboard(){
	DefaultTableModel model2 = (DefaultTableModel)dashboardTable.getModel();
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

public static String TotalColumns(String tableName) {
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
	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1346, 723);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
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
				displayDashboard();
				String studentTotal = TotalColumns("student");
				totalStudent.setText(studentTotal);
				String totalTutor =TotalColumns("teacher");
				tutorTotal.setText(totalTutor);
				String courseTotal =TotalColumns("Course");
				totalCourse.setText(courseTotal);	
			}
		});
		dashboardBtn.setBounds(34, 160, 158, 46);
		panel.add(dashboardBtn);
		
		JButton coursesBtn = new JButton("Courses");
		coursesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
				courseData();
			}
		});
		coursesBtn.setBounds(34, 324, 158, 46);
		panel.add(coursesBtn);
		
		JButton tutorBtn = new JButton("Tutor");
		tutorBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);			
				tutorsData();
			}
			
		});
		tutorBtn.setBounds(34, 483, 158, 46);
		panel.add(tutorBtn);
		
		JButton studentBtn = new JButton("student");
		studentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
				dataStudent();
			}
		});
		studentBtn.setBounds(34, 399, 158, 46);
		panel.add(studentBtn);
		
		JButton settingBtn = new JButton("Setting");
		settingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);

				
			}
		});
		settingBtn.setBounds(34, 234, 158, 46);
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
		tabbedPane.setBounds(260, 92, 838, 589);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(105, 105, 105));
		tabbedPane.addTab("Dashboard", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(192, 192, 192));
		panel_9.setBorder(UIManager.getBorder("TextArea.border"));
		panel_9.setBounds(23, 12, 196, 126);
		panel_1.add(panel_9);
		panel_9.setLayout(null);
		panel_9.setBorder(BorderFactory.createRaisedBevelBorder());
		
		totalStudent = new JLabel("0");
		totalStudent.setHorizontalAlignment(SwingConstants.CENTER);
		totalStudent.setFont(new Font("Dialog", Font.BOLD, 20));
		totalStudent.setBounds(52, 53, 96, 36);
		panel_9.add(totalStudent);
		
		JLabel lblTotalStudents = new JLabel("Total Students");
		lblTotalStudents.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalStudents.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTotalStudents.setBounds(12, 12, 168, 29);
		panel_9.add(lblTotalStudents);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(12, 167, 809, 383);
		panel_1.add(scrollPane_3);
		
		dashboardTable = new JTable();
		scrollPane_3.setViewportView(dashboardTable);
		dashboardTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Activities"
			}
		));
		
		JPanel panel_9_1 = new JPanel();
		panel_9_1.setBackground(new Color(192, 192, 192));
		panel_9_1.setLayout(null);
		panel_9_1.setBorder(UIManager.getBorder("TextArea.border"));
		panel_9_1.setBounds(258, 12, 196, 126);
		panel_1.add(panel_9_1);
		panel_9_1.setBorder(BorderFactory.createRaisedBevelBorder());
		
		totalCourse = new JLabel("0");
		totalCourse.setHorizontalAlignment(SwingConstants.CENTER);
		totalCourse.setFont(new Font("Dialog", Font.BOLD, 20));
		totalCourse.setBounds(52, 53, 99, 40);
		panel_9_1.add(totalCourse);
		
		JLabel lblTotalCourses = new JLabel("Total Courses");
		lblTotalCourses.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalCourses.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTotalCourses.setBounds(12, 12, 168, 29);
		panel_9_1.add(lblTotalCourses);
		
		
		JPanel panel_9_2 = new JPanel();
		panel_9_2.setBackground(new Color(192, 192, 192));
		panel_9_2.setLayout(null);
		panel_9_2.setBorder(UIManager.getBorder("TextArea.border"));
		panel_9_2.setBounds(514, 12, 204, 126);
		panel_1.add(panel_9_2);
		panel_9_2.setBorder(BorderFactory.createRaisedBevelBorder());
		
		tutorTotal = new JLabel("0");
		tutorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		tutorTotal.setFont(new Font("Dialog", Font.BOLD, 20));
		tutorTotal.setBounds(52, 53, 99, 40);
		panel_9_2.add(tutorTotal);
		
		JLabel lblTotalTeachers = new JLabel("Total Teachers");
		lblTotalTeachers.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalTeachers.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTotalTeachers.setBounds(12, 12, 168, 29);
		panel_9_2.add(lblTotalTeachers);
		dashboardTable.getColumnModel().getColumn(0).setPreferredWidth(30);
		dashboardTable.getColumnModel().getColumn(0).setMinWidth(80);
		dashboardTable.getColumnModel().getColumn(0).setMaxWidth(80);
		dashboardTable.getColumnModel().getColumn(1).setPreferredWidth(316);
		
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Courses", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 155, 809, 395);
		panel_3.add(scrollPane_1);
		
		courseTable = new JTable();
		courseTable.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Id","Course Name", "Seats", "Batch", "No. of Years", "Module"
			}
		));
		scrollPane_1.setViewportView(courseTable);
		
		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				J_CourseAdd ca = new J_CourseAdd();
				ca.setVisible(true);
				ca.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
				
				
			}
		});
		btnAddCourse.setBounds(357, 93, 138, 33);
		panel_3.add(btnAddCourse);
		
		JButton btnEditCourse = new JButton("Edit Course");
		btnEditCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				J_CourseEdit ce = new J_CourseEdit();
				ce.setVisible(true);
				ce.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
				
				
			}
		});
		btnEditCourse.setBounds(516, 93, 138, 33);
		panel_3.add(btnEditCourse);
		
		JButton btnDeleteCourse = new JButton("Delete Course");
		btnDeleteCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				J_DeleteCourse cd = new J_DeleteCourse();
				cd.setVisible(true);
				cd.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
				
			}
		});
		btnDeleteCourse.setBounds(666, 93, 148, 33);
		panel_3.add(btnDeleteCourse);
		
		searchCourse = new JTextField();
		searchCourse.setBounds(12, 91, 332, 37);
		panel_3.add(searchCourse);
		searchCourse.setColumns(10);
		
		JSeparator separator_2_2 = new JSeparator();
		separator_2_2.setBounds(12, 55, 809, 13);
		panel_3.add(separator_2_2);
		
		JLabel lblCourseInformation = new JLabel("Course Information");
		lblCourseInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourseInformation.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCourseInformation.setBounds(12, 19, 783, 24);
		panel_3.add(lblCourseInformation);
		searchCourse.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		        	String course = searchCourse.getText();
		        	courseSearchEnter(course);
		        }
		    }
		});
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Tutors", null, panel_4, null);
		
		
		
		JButton btnAddTutors = new JButton("Add Tutors");
		btnAddTutors.setBounds(385, 77, 138, 42);
		btnAddTutors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				J_TutorAdd ta = new J_TutorAdd()
;				ta.setVisible(true);
				ta.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
				
			}
		});
		panel_4.setLayout(null);
		panel_4.add(btnAddTutors);
		
		JButton btnUpdateTutors = new JButton("Update Tutors");
		btnUpdateTutors.setBounds(533, 77, 138, 42);
		btnUpdateTutors.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        J_EditingTutor et = new J_EditingTutor();
		        et.setVisible(true);
		        et.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		    }
		});
		panel_4.add(btnUpdateTutors);

		JButton btnDeleteTutors = new JButton("Delete Tutors");
		btnDeleteTutors.setBounds(683, 77, 138, 42);
		btnDeleteTutors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				J_TutorDelete td = new J_TutorDelete();
				td.setVisible(true);
				td.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
				
				
			}
		});
		panel_4.add(btnDeleteTutors);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 150, 809, 400);
		panel_4.add(scrollPane);
		
		tableTutor = new JTable();
		scrollPane.setViewportView(tableTutor);
		tableTutor.setModel(new DefaultTableModel(
			new Object[][]{
			},
			new String[] {
				"ID","First_Name", "Last_Name", "Email", "Phone", "Course"
			}
		));
		
		searchTutor = new JTextField();
		searchTutor.setBounds(12, 78, 359, 42);
		panel_4.add(searchTutor);
		searchTutor.setColumns(10);
		
		JLabel lblTeacherInformation = new JLabel("Teacher Information");
		lblTeacherInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeacherInformation.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTeacherInformation.setBounds(12, 12, 783, 24);
		panel_4.add(lblTeacherInformation);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(12, 48, 809, 13);
		panel_4.add(separator_2_1);
		searchTutor.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent f){
			  // Check for Enter key is pressed
		        if (f.getKeyCode() == KeyEvent.VK_ENTER) {
		        	String tutor = searchTutor.getText();
		        	tutorSearchEnter(tutor);
		        }
		    }
		});
		
		 
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Students", null, panel_5, null);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 150, 809, 400);
		panel_5.add(scrollPane_2);
		
		studentDataTable = new JTable();
		studentDataTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID", "First_Name", "Last_Name", "Email", "Course"
			}
		));
		scrollPane_2.setViewportView(studentDataTable);
		
		searchStudent = new JTextField();
		searchStudent.setBounds(12, 82, 327, 42);
		panel_5.add(searchStudent);
		searchStudent.setColumns(10);
		searchStudent.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent f2){
			  // Check for Enter key is pressed
		        if (f2.getKeyCode() == KeyEvent.VK_ENTER) {
		        	String student = searchStudent.getText();
		        	studentSearchEnter(student);
		        }
		    }
		});
		JButton studentAdd = new JButton("Add Student");
		studentAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				J_AddStudent sa = new J_AddStudent();
				sa.setVisible(true);
				sa.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				
			}
		});
		studentAdd.setBounds(351, 86, 147, 33);
		panel_5.add(studentAdd);
		
		JButton btnEditStudent = new JButton("Edit Student");
		btnEditStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				J_UpdateStudent us = new J_UpdateStudent();
				us.setVisible(true);
				us.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				
			}
		});
		btnEditStudent.setBounds(511, 86, 140, 33);
		panel_5.add(btnEditStudent);
		
		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				J_StudentDelete dts = new J_StudentDelete();
				dts.setVisible(true);
				dts.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				
			}
		});
		btnDeleteStudent.setBounds(662, 86, 159, 33);
		panel_5.add(btnDeleteStudent);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(12, 57, 809, 13);
		panel_5.add(separator_2);
		
		JLabel lblStudentInformation = new JLabel("Student Information");
		lblStudentInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentInformation.setFont(new Font("Dialog", Font.BOLD, 20));
		lblStudentInformation.setBounds(23, 21, 783, 24);
		panel_5.add(lblStudentInformation);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Setting", null, panel_7, null);
		panel_7.setLayout(null);
		
		JLabel lblSetting = new JLabel("Change Information");
		lblSetting.setBounds(12, 21, 231, 24);
		lblSetting.setFont(new Font("Dialog", Font.BOLD, 20));
		panel_7.add(lblSetting);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 53, 809, 13);
		panel_7.add(separator);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(12, 76, 100, 15);
		panel_7.add(lblUsername);
		
		nameUser = new JTextField();
		nameUser.setBounds(130, 74, 152, 30);
		panel_7.add(nameUser);
		nameUser.setColumns(10);
		
		JLabel lblPhoneNo = new JLabel("Phone No.");
		lblPhoneNo.setBounds(12, 145, 100, 15);
		panel_7.add(lblPhoneNo);
		
		userPhone = new JTextField();
		userPhone.setBounds(130, 138, 152, 30);
		userPhone.setColumns(10);
		panel_7.add(userPhone);
		
		JLabel lblemail_1 = new JLabel("Email");
		lblemail_1.setBounds(353, 145, 100, 15);
		panel_7.add(lblemail_1);
		
		JLabel lbluser_1 = new JLabel("LastName");
		lbluser_1.setBounds(353, 81, 100, 15);
		panel_7.add(lbluser_1);
		
		mailUser = new JTextField();
		mailUser.setBounds(493, 138, 152, 30);
		mailUser.setColumns(10);
		panel_7.add(mailUser);
		
		lastName = new JTextField();
		lastName.setBounds(493, 69, 152, 30);
		lastName.setColumns(10);
		panel_7.add(lastName);
		
		JButton btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = nameUser.getText();
				String phone = userPhone.getText();
				String mail = mailUser.getText();
				String lname =  lastName.getText();
				String id = idUser.getText();
				C_ChangeData cd = new C_ChangeData();
//				String userMail = Login.mail();
				String table = "admin";
				cd.changeUserData(userName, lname, mail,id, phone,table);
				JOptionPane.showMessageDialog(null, "Data edited");
			}
		});
		btnEditProfile.setBounds(495, 214, 137, 30);
		panel_7.add(btnEditProfile);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 289, 809, 13);
		panel_7.add(separator_1);
		
		JLabel lblSecurityLogin = new JLabel("Change Password");
		lblSecurityLogin.setBounds(12, 257, 244, 24);
		lblSecurityLogin.setFont(new Font("Dialog", Font.BOLD, 20));
		panel_7.add(lblSecurityLogin);
		
		JLabel lblOldPassword = new JLabel("Old Password");
		lblOldPassword.setBounds(12, 318, 137, 15);
		panel_7.add(lblOldPassword);
		
		oldPass = new JPasswordField();
		oldPass.setBounds(162, 314, 152, 24);
		panel_7.add(oldPass);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setBounds(392, 318, 137, 15);
		panel_7.add(lblNewPassword);
		
		newPass = new JPasswordField();
		newPass.setBounds(561, 314, 152, 24);
		panel_7.add(newPass);
		
		JButton passChange = new JButton("Change Password");
		passChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] passOld = oldPass.getPassword();
			    String oldPassword = new String(passOld);
			    char[] passNew = newPass.getPassword();
			    String newPassword = new String(passNew);
			    String table = "admin";
			    String passEmail = passChangeEmail.getText();
			    
			    C_PassChange pc = new C_PassChange();
				pc.passChange(newPassword,oldPassword, passEmail,table);
				JOptionPane.showMessageDialog(null, "Password changed");
			}
		});
		passChange.setBounds(558, 364, 167, 30);
		panel_7.add(passChange);
		
		JLabel lblHelpServices = new JLabel("Help");
		lblHelpServices.setBounds(12, 417, 244, 24);
		lblHelpServices.setFont(new Font("Dialog", Font.BOLD, 20));
		panel_7.add(lblHelpServices);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(12, 448, 809, 13);
		panel_7.add(separator_1_1);
		
		JLabel lblEmailHeraldcollegegmailcom = new JLabel("Email:-\\ samyogkoirala18@gmail.com");
		lblEmailHeraldcollegegmailcom.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblEmailHeraldcollegegmailcom.setBounds(481, 486, 244, 15);
		panel_7.add(lblEmailHeraldcollegegmailcom);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number: 9819320008");
		lblPhoneNumber.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblPhoneNumber.setBounds(481, 513, 244, 15);
		panel_7.add(lblPhoneNumber);
		
		JLabel lblemail_1_1 = new JLabel("Email");
		lblemail_1_1.setBounds(12, 372, 100, 15);
		panel_7.add(lblemail_1_1);
		
		passChangeEmail = new JTextField();
		passChangeEmail.setColumns(10);
		passChangeEmail.setBounds(160, 360, 152, 30);
		panel_7.add(passChangeEmail);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(12, 206, 70, 15);
		panel_7.add(lblId);
		
		idUser = new JTextField();
		idUser.setColumns(10);
		idUser.setBounds(130, 192, 152, 30);
		panel_7.add(idUser);
		
		JLabel lblNewLabel = new JLabel("For help --------------------->");
		lblNewLabel.setBounds(36, 500, 400, 17);
		panel_7.add(lblNewLabel);
		
		JLabel lblReportIfAny = new JLabel("Issue?");
		lblReportIfAny.setFont(new Font("Dialog", Font.BOLD, 15));
		lblReportIfAny.setBounds(32, 473, 50, 15);
		panel_7.add(lblReportIfAny);
		
		JLabel lblNewLabel_1 = new JLabel("Created By Samyog Koirala");
		lblNewLabel_1.setBounds(253, 528, 200, 20);
		panel_7.add(lblNewLabel_1);
		
		JLabel lblCmsSupportHotline = new JLabel("Help");
		lblCmsSupportHotline.setBounds(481, 459, 193, 15);
		panel_7.add(lblCmsSupportHotline);
		
		JLabel lblNotifications = new JLabel("Notifications");
		lblNotifications.setBounds(1110, -5, 166, 30);
		lblNotifications.setFont(new Font("Dialog", Font.BOLD, 16));
		contentPane.add(lblNotifications);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(0, 0, 0));
		panel_8.setBounds(260, -5, 838, 87);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblAdminDashboard = new JLabel("Admin Dashboard");
		lblAdminDashboard.setForeground(new Color(255, 0, 255));
		lblAdminDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminDashboard.setFont(new Font("Dialog", Font.BOLD, 22));
		lblAdminDashboard.setBounds(12, 12, 797, 75);
		panel_8.add(lblAdminDashboard);
		
	}
}