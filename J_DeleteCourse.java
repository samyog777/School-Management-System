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

public class J_DeleteCourse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField CourseID;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					J_DeleteCourse frame = new J_DeleteCourse();
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
	public J_DeleteCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 316);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(126, 138, 76, 24);
		contentPane.add(lblNewLabel);
		
		CourseID = new JTextField();
		CourseID.setBounds(240, 135, 129, 31);
		contentPane.add(CourseID);
		CourseID.setColumns(10);
		
		JButton courseDelete = new JButton("Delete Course");
		courseDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = CourseID.getText();
				C_CourseDelete cd = new C_CourseDelete();
				cd.deletingCourse(id);
				Dashboard.courseData();
				dispose();
				
			}
		});
		courseDelete.setBounds(157, 206, 168, 46);
		contentPane.add(courseDelete);
		
		lblNewLabel_1 = new JLabel("Delete Course");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(146, 49, 207, 31);
		contentPane.add(lblNewLabel_1);
	}
}