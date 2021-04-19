package adminsubscriber;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import studentpublisher.IStudent;
import studentpublisher.Student;

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
	private JTextField textFieldUpdateGrade;
	private JTextField textFieldUpdateAddress;
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
		lblUpdateSutdentId.setBounds(172, 59, 88, 13);
		frame.getContentPane().add(lblUpdateSutdentId);
		
		lblUpdateStudentName = new JLabel("Student Name");
		lblUpdateStudentName.setBounds(172, 102, 88, 13);
		frame.getContentPane().add(lblUpdateStudentName);
		
		lblUpdateGrade = new JLabel("Grade");
		lblUpdateGrade.setBounds(172, 148, 88, 13);
		frame.getContentPane().add(lblUpdateGrade);
		
		lblUpdateAddress = new JLabel("Address");
		lblUpdateAddress.setBounds(172, 192, 88, 13);
		frame.getContentPane().add(lblUpdateAddress);
		
		textFieldUpdateStudentId = new JTextField();
		textFieldUpdateStudentId.setBounds(235, 56, 117, 19);
		frame.getContentPane().add(textFieldUpdateStudentId);
		textFieldUpdateStudentId.setColumns(10);
		
		textFieldUpdateStudentName = new JTextField();
		textFieldUpdateStudentName.setBounds(270, 99, 117, 19);
		frame.getContentPane().add(textFieldUpdateStudentName);
		textFieldUpdateStudentName.setColumns(10);
		
		textFieldUpdateGrade = new JTextField();
		textFieldUpdateGrade.setBounds(270, 145, 117, 19);
		frame.getContentPane().add(textFieldUpdateGrade);
		textFieldUpdateGrade.setColumns(10);
		
		textFieldUpdateAddress = new JTextField();
		textFieldUpdateAddress.setBounds(270, 189, 117, 19);
		frame.getContentPane().add(textFieldUpdateAddress);
		textFieldUpdateAddress.setColumns(10);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id, name, grade, address;
				id = textFieldUpdateStudentId.getText().trim();
				name = textFieldUpdateStudentName.getText().trim();
				grade = textFieldUpdateGrade.getText().trim();
				address = textFieldUpdateAddress.getText().trim();
				
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
							boolean isStudent = studentService.updateStudent(id,student);
							if(isStudent) {
								textFieldUpdateStudentId.setText("");
								textFieldUpdateStudentName.setText("");
								textFieldUpdateGrade.setText("");
								textFieldUpdateAddress.setText("");
								
								JOptionPane.showMessageDialog( frame, "Student update sucessfully","Success",JOptionPane.PLAIN_MESSAGE);
						}else {
							
							JOptionPane.showMessageDialog( frame, "Can not update Student","Error",JOptionPane.WARNING_MESSAGE);
						}

					}catch (Exception ex) {
						JOptionPane.showMessageDialog( frame, "Something went wrong","Error",JOptionPane.WARNING_MESSAGE);
						
					}
				}
			}
		});
		btnUpdate.setBounds(235, 232, 85, 21);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnUpdateFind = new JButton("Find");
		btnUpdateFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textFieldUpdateStudentId.getText().trim();
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Add student ID number","Error",JOptionPane.WARNING_MESSAGE);
				}
				else {

					try {
							
							Student student = studentService.student_get_by_id(id);
							if(student != null) {
								textFieldUpdateStudentName.setText(student.getName());
								textFieldUpdateGrade.setText(student.getGrade());
								textFieldUpdateAddress.setText(student.getAddress());
								
						}else {
//							textAreaRemove.setText("\n\nSorry, but nothing matched your search \nstudent. Please try again with different \nstudent ID.");
							JOptionPane.showMessageDialog( frame, "Can not find Student","Error",JOptionPane.WARNING_MESSAGE);
						}

					}catch (Exception ex) {
//						textAreaRemove.setText("Something went wrong");
						JOptionPane.showMessageDialog( frame, "Something went wrong","Error",JOptionPane.WARNING_MESSAGE);
						
					}
				}
			}
		});
		
		btnUpdateFind.setBounds(362, 55, 64, 21);
		frame.getContentPane().add(btnUpdateFind);
	}
}
