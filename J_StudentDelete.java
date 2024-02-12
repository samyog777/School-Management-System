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

public class J_StudentDelete extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField studentId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					J_StudentDelete frame = new J_StudentDelete();
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
	public J_StudentDelete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Dialog", Font.BOLD, 16));
		lblId.setBounds(86, 111, 68, 15);
		contentPane.add(lblId);
		
		studentId = new JTextField();
		studentId.setBounds(225, 106, 139, 30);
		contentPane.add(studentId);
		studentId.setColumns(10);
		
		JButton btnDelete = new JButton("Delete ");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = studentId.getText();
				C_DeleteStudent ds = new C_DeleteStudent();
				ds.deleteing(id);
				Dashboard.dataStudent();
				dispose();
			}
		});
		btnDelete.setBounds(113, 185, 144, 37);
		contentPane.add(btnDelete);
		
		JLabel lblDeleteStudent = new JLabel("Delete Student ");
		lblDeleteStudent.setFont(new Font("Dialog", Font.BOLD, 22));
		lblDeleteStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteStudent.setBounds(113, 39, 213, 37);
		contentPane.add(lblDeleteStudent);
	}

}