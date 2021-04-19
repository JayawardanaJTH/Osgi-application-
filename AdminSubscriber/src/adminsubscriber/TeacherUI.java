package adminsubscriber;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;

import teacherpublisher.ITeacher;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeacherUI {

	private JFrame frame;

	private ITeacher teacherService;
	
	JButton btnHome;
	JButton btnAddTeacher;
	JButton btnAllTeachers;
	JButton btnUpdateTeacher;
	JButton btnRemoveTeacher;
	JButton btnFindTeacher;

	/**
	 * Create the application.
	 */
	public TeacherUI(ITeacher teacherService) {
		this.teacherService = teacherService;
		initialize();
		
	
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainUI(teacherService);
				frame.setVisible(false);
			}
		});
		
		btnAddTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddTeacherUI(teacherService);
				frame.setVisible(false);
			}
		});
		
		btnAllTeachers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AllTeacherUI(teacherService);
				frame.setVisible(false);
			}
		});
		
		btnUpdateTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateTeacherUI(teacherService);
				frame.setVisible(false);
			}
		});
		
		btnRemoveTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RemoveTeacherUI(teacherService);
				frame.setVisible(false);
			}
		});
		
		btnFindTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FindTeacherUI(teacherService);
				frame.setVisible(false);
			}
		});
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		btnHome = new JButton("Home");
		btnHome.setBounds(10, 12, 140, 21);
		frame.getContentPane().add(btnHome);
		
		btnAddTeacher = new JButton("Add Teacher");
		btnAddTeacher.setBounds(10, 55, 140, 21);
		frame.getContentPane().add(btnAddTeacher);
		
		btnAllTeachers = new JButton("All Teachers");
		btnAllTeachers.setBounds(10, 98, 140, 21);
		frame.getContentPane().add(btnAllTeachers);
		
		btnUpdateTeacher = new JButton("Update Teacher");
		btnUpdateTeacher.setBounds(10, 144, 140, 21);
		frame.getContentPane().add(btnUpdateTeacher);
		
		btnRemoveTeacher = new JButton("Remove Teacher");
		btnRemoveTeacher.setBounds(10, 188, 140, 21);
		frame.getContentPane().add(btnRemoveTeacher);
		
		btnFindTeacher = new JButton("Find Teacher");
		btnFindTeacher.setBounds(10, 232, 140, 21);
		frame.getContentPane().add(btnFindTeacher);
	}

}

