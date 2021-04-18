package adminsubscriber;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import assignpublisher.IAssign;
import studentpublisher.IStudent;
import subjectpublisher.ISubject;
import teacherpublisher.ITeacher;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainUI extends JFrame {

	private JPanel contentPane;
	private JButton btnStudent;

	private IStudent studentService;
	private ISubject subjectService;
	private IAssign assignService;
	private ITeacher teacherService;
	/**
	 * Create the frame.
	 */
	public MainUI(IStudent studentService) {
		this.studentService = studentService;
		Initial();
	}
	public MainUI(IStudent studentService, ISubject subjectService, IAssign assignService, ITeacher teacherService) {
		this.studentService = studentService;
		this.subjectService = subjectService;
		this.assignService = assignService;
		this.teacherService = teacherService;
		Initial();
	}
	public void Initial() {
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
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StudentUI(studentService);
			}
		});
		btnStudent.setBounds(35, 48, 89, 23);
		menuPanel.add(btnStudent);
		
		JButton btnCourse = new JButton("Course");
		btnCourse.setBounds(35, 120, 89, 23);
		menuPanel.add(btnCourse);
		
		JButton btnTeacher = new JButton("Teacher");
		btnTeacher.setBounds(35, 192, 89, 23);
		menuPanel.add(btnTeacher);
		
		JButton btnAssign = new JButton("Assign");
		btnAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddAssignUI(studentService, subjectService,assignService);
			}
		});
		btnAssign.setBounds(35, 264, 89, 23);
		menuPanel.add(btnAssign);
		
		JPanel panelBody = new JPanel();
		panelBody.setBounds(168, 0, 356, 340);
		contentPane.add(panelBody);
	}
}
