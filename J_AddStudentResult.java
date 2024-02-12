package Samyog_koirala_project;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class J_AddStudentResult extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fullName;
	private JTextField userEmail;
	private JTextField module;
	private JTextField courseName;
	private JTextField studentMarks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					J_AddStudentResult frame = new J_AddStudentResult();
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
	public J_AddStudentResult() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 493);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(50, 25, 454, 494);
		contentPane.add(panel);
		panel.setLayout(null);
		
		fullName = new JTextField();
		fullName.setBounds(232, 116, 172, 31);
		panel.add(fullName);
		fullName.setColumns(10);
		
		userEmail = new JTextField();
		userEmail.setBounds(232, 177, 172, 31);
		panel.add(userEmail);
		userEmail.setColumns(10);
		
		module = new JTextField();
		module.setBounds(232, 234, 172, 31);
		panel.add(module);
		module.setColumns(10);
		
		courseName = new JTextField();
		courseName.setBounds(232, 289, 172, 31);
		panel.add(courseName);
		courseName.setColumns(10);
		
		studentMarks = new JTextField();
		studentMarks.setBounds(232, 349, 172, 31);
		panel.add(studentMarks);
		studentMarks.setColumns(10);
		
		JButton btnAddResult = new JButton("Add Result");
		btnAddResult.setBounds(109, 392, 172, 38);
		panel.add(btnAddResult);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(SystemColor.controlLtHighlight);
		lblNewLabel.setBounds(71, 115, 143, 31);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		
		JLabel lblResult_1 = new JLabel("Add Result");
		lblResult_1.setBounds(143, 36, 123, 35);
		panel.add(lblResult_1);
		lblResult_1.setForeground(Color.WHITE);
		lblResult_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblResult_1.setBackground(Color.WHITE);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(SystemColor.controlLtHighlight);
		lblEmail.setBounds(71, 176, 108, 31);
		panel.add(lblEmail);
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 15));
		
		JLabel lblNewLabel_1_1 = new JLabel("Module");
		lblNewLabel_1_1.setForeground(SystemColor.controlLtHighlight);
		lblNewLabel_1_1.setBounds(71, 233, 94, 31);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 15));
		
		JLabel lblNewLabel_1_2 = new JLabel("Course Name");
		lblNewLabel_1_2.setForeground(SystemColor.controlLtHighlight);
		lblNewLabel_1_2.setBounds(71, 288, 134, 31);
		panel.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.BOLD, 15));
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Marks");
		lblNewLabel_1_2_1.setForeground(SystemColor.controlLtHighlight);
		lblNewLabel_1_2_1.setBounds(71, 348, 108, 31);
		panel.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setFont(new Font("Dialog", Font.BOLD, 15));
		btnAddResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = fullName.getText();
				String email = userEmail.getText();
				String m = module.getText();
				String course = courseName.getText();
				String mark = studentMarks.getText(); 
				C_Result.StudentResult(name,email, m, course,mark);
				dispose();
				
			}
		});
	}
}