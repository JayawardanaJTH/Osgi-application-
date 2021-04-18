package adminsubscriber;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import studentpublisher.IStudent;
import studentpublisher.Student;

public class AddStudentUI {

	private JFrame frame;

	private IStudent studentService;
	
	JButton btnHome;
	JButton btnAddStudent;
	JButton btnAllStudents;
	JButton btnUpdateStudent;
	JButton btnRemoveStudent;
	JButton btnFindStudent;
	private JLabel lblAddStudent;
	private JLabel lblStudentId;
	private JTextField textFieldStudentId;
	private JLabel lblStudentName;
	private JTextField textFieldStudentName;
	private JLabel lblGrade;
	private JTextField textFieldGrade;
	private JLabel lblAddress;
	private JTextField textFieldAddress;
	private JButton btnAdd;

	/**
	 * Create the application.
	 */
	public AddStudentUI(IStudent studentService) {
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
		
		lblAddStudent = new JLabel("Add Student");
		lblAddStudent.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddStudent.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(lblAddStudent);
		
		lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(198, 59, 96, 13);
		frame.getContentPane().add(lblStudentId);
		
		textFieldStudentId = new JTextField();
		textFieldStudentId.setBounds(304, 56, 122, 19);
		frame.getContentPane().add(textFieldStudentId);
		textFieldStudentId.setColumns(10);
		
		lblStudentName = new JLabel("Student Name");
		lblStudentName.setBounds(198, 102, 81, 13);
		frame.getContentPane().add(lblStudentName);
		
		textFieldStudentName = new JTextField();
		textFieldStudentName.setBounds(304, 99, 122, 19);
		frame.getContentPane().add(textFieldStudentName);
		textFieldStudentName.setColumns(10);
		
		lblGrade = new JLabel("Grade");
		lblGrade.setBounds(198, 148, 81, 13);
		frame.getContentPane().add(lblGrade);
		
		textFieldGrade = new JTextField();
		textFieldGrade.setBounds(304, 145, 122, 19);
		frame.getContentPane().add(textFieldGrade);
		textFieldGrade.setColumns(10);
		
		lblAddress = new JLabel("Address");
		lblAddress.setBounds(198, 192, 81, 13);
		frame.getContentPane().add(lblAddress);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(304, 189, 122, 19);
		frame.getContentPane().add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id, name, grade, address;
				id = textFieldStudentId.getText().trim();
				name = textFieldStudentName.getText().trim();
				grade = textFieldGrade.getText().trim();
				address = textFieldAddress.getText().trim();
				
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Add student ID number","Error",JOptionPane.WARNING_MESSAGE);
				}
				else if(name.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please add student name","Error",JOptionPane.WARNING_MESSAGE);
				}
				else if(grade.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please add grade","Error",JOptionPane.WARNING_MESSAGE);
				}
				else if(address.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please add address","Error",JOptionPane.WARNING_MESSAGE);
				}
				else {
					try {
							Student student = new Student(id,name,grade,address);
							boolean isStudent = studentService.addStudent(student);
							if(isStudent) {
								textFieldStudentId.setText("");
								textFieldStudentName.setText("");
								textFieldGrade.setText("");
								textFieldAddress.setText("");
								
								JOptionPane.showMessageDialog( frame, "Student add sucessfully","Success",JOptionPane.PLAIN_MESSAGE);
						}else {
							
							JOptionPane.showMessageDialog( frame, "Can not add Student","Error",JOptionPane.WARNING_MESSAGE);
						}

					}catch (Exception ex) {
						JOptionPane.showMessageDialog( frame, "Something went wrong","Error",JOptionPane.WARNING_MESSAGE);
						
					}
				}
				
				
			}
		});
		btnAdd.setBounds(266, 232, 85, 21);
		frame.getContentPane().add(btnAdd);
		
		
	}

}


