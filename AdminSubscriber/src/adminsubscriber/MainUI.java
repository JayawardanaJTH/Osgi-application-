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
	private JButton btnCourse;

	private IStudent studentService;
	private ISubject subjectService;
	private IAssign assignService;
	private ITeacher teacherService;
	/**
	 * Create the frame.
	 * 
	 */
	
	
	public MainUI(ISubject subjectService) {
		this.subjectService = subjectService;
		Initial();
	}
	
	public MainUI(IStudent studentService) {
		this.studentService = studentService;
		Initial();
	}
	
	public MainUI(ITeacher teacherService) {
		this.teacherService = teacherService;
		Initial();
	}
	/**
	 * @wbp.parser.constructor
	 */
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
		menuPanel.setBounds(0, 0, 524, 340);
		contentPane.add(menuPanel);
		menuPanel.setLayout(null);
		
		btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StudentUI(studentService);
			}
		});
		btnStudent.setBounds(221, 53, 89, 23);
		menuPanel.add(btnStudent);
		
		JButton btnCourse = new JButton("Course");
		btnCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SubjectUI(subjectService);
			}
		});
		btnCourse.setBounds(221, 125, 89, 23);
		menuPanel.add(btnCourse);
		
		JButton btnTeacher = new JButton("Teacher");
		btnTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeacherUI(teacherService);
			}
		});
		btnTeacher.setBounds(221, 197, 89, 23);
		menuPanel.add(btnTeacher);
		
		JButton btnAssign = new JButton("Assign");
		btnAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddAssignUI(studentService, subjectService,assignService);
			}
		});
		btnAssign.setBounds(221, 269, 89, 23);
		menuPanel.add(btnAssign);
	}

}
