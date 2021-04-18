package adminsubscriber;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import studentpublisher.IStudent;
import javax.swing.JTextField;

public class UpdateStudentUI {

	private JFrame frame;
	
	private IStudent studentService;
	
	JButton btnHome;
	JButton btnAddStudent;
	JButton btnAllStudents;
	JButton btnUpdateStudent;
	JButton btnRemoveStudent;
	JButton btnFindStudent;
	private JLabel lblUpdateStudent;
	private JLabel lblUpdateSutdentId;
	private JLabel lblUpdateStudentName;
	private JLabel lblUpdateGrade;
	private JLabel lblUpdateAddress;
	private JTextField textFieldUpdateStudentId;
	private JTextField textFieldUpdateStudentName;
	private JTextField textFieldGrade;
	private JTextField textFieldAddress;
	private JButton btnUpdate;

	/**
	 * Create the application.
	 */
	public UpdateStudentUI(IStudent studentService) {
		this.studentService = studentService;
		initialize();
	
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainUI(studentService);
				frame.setVisible(false);
			}
		});
		
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddStudentUI(studentService);
				frame.setVisible(false);
			}
		});
		
		btnAllStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AllStudentUI(studentService);
				frame.setVisible(false);
			}
		});
		
		btnUpdateStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateStudentUI(studentService);
				frame.setVisible(false);
			}
		});
		
		btnRemoveStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RemoveStudentUI(studentService);
				frame.setVisible(false);
			}
		});
		
		btnFindStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FindStudentUI(studentService);
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
		
		btnAddStudent = new JButton("Add Student");
		btnAddStudent.setBounds(10, 55, 140, 21);
		frame.getContentPane().add(btnAddStudent);
		
		btnAllStudents = new JButton("All Students");
		btnAllStudents.setBounds(10, 98, 140, 21);
		frame.getContentPane().add(btnAllStudents);
		
		btnUpdateStudent = new JButton("Update Student");
		btnUpdateStudent.setBounds(10, 144, 140, 21);
		frame.getContentPane().add(btnUpdateStudent);
		
		btnRemoveStudent = new JButton("Remove Student");

		btnRemoveStudent.setBounds(10, 188, 140, 21);
		frame.getContentPane().add(btnRemoveStudent);
		
		btnFindStudent = new JButton("Find Student");
		btnFindStudent.setBounds(10, 232, 140, 21);
		frame.getContentPane().add(btnFindStudent);
		
		lblUpdateStudent = new JLabel("Update Student");
		lblUpdateStudent.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUpdateStudent.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(lblUpdateStudent);
		
		lblUpdateSutdentId = new JLabel("Student ID");
		lblUpdateSutdentId.setBounds(195, 55, 88, 13);
		frame.getContentPane().add(lblUpdateSutdentId);
		
		lblUpdateStudentName = new JLabel("Student Name");
		lblUpdateStudentName.setBounds(195, 98, 88, 13);
		frame.getContentPane().add(lblUpdateStudentName);
		
		lblUpdateGrade = new JLabel("Grade");
		lblUpdateGrade.setBounds(195, 144, 88, 13);
		frame.getContentPane().add(lblUpdateGrade);
		
		lblUpdateAddress = new JLabel("Address");
		lblUpdateAddress.setBounds(195, 188, 88, 13);
		frame.getContentPane().add(lblUpdateAddress);
		
		textFieldUpdateStudentId = new JTextField();
		textFieldUpdateStudentId.setBounds(309, 56, 117, 19);
		frame.getContentPane().add(textFieldUpdateStudentId);
		textFieldUpdateStudentId.setColumns(10);
		
		textFieldUpdateStudentName = new JTextField();
		textFieldUpdateStudentName.setBounds(309, 99, 117, 19);
		frame.getContentPane().add(textFieldUpdateStudentName);
		textFieldUpdateStudentName.setColumns(10);
		
		textFieldGrade = new JTextField();
		textFieldGrade.setBounds(309, 141, 117, 19);
		frame.getContentPane().add(textFieldGrade);
		textFieldGrade.setColumns(10);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(309, 185, 117, 19);
		frame.getContentPane().add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(255, 232, 85, 21);
		frame.getContentPane().add(btnUpdate);
	}

}
