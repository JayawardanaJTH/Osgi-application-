package adminsubscriber;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class MainUI extends JFrame {

	private JPanel contentPane;
	private JButton btnStudent;


	/**
	 * Create the frame.
	 */
	public MainUI() {
		setTitle("Amin Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBounds(0, 0, 158, 340);
		contentPane.add(menuPanel);
		menuPanel.setLayout(null);
		
		btnStudent = new JButton("Student");
		btnStudent.setBounds(35, 48, 89, 23);
		menuPanel.add(btnStudent);
		
		JButton btnCourse = new JButton("Course");
		btnCourse.setBounds(35, 120, 89, 23);
		menuPanel.add(btnCourse);
		
		JButton btnTeacher = new JButton("Teacher");
		btnTeacher.setBounds(35, 192, 89, 23);
		menuPanel.add(btnTeacher);
		
		JButton btnAssign = new JButton("Assign");
		btnAssign.setBounds(35, 264, 89, 23);
		menuPanel.add(btnAssign);
		
		JPanel panelBody = new JPanel();
		panelBody.setBounds(168, 0, 356, 340);
		contentPane.add(panelBody);
	}
}
