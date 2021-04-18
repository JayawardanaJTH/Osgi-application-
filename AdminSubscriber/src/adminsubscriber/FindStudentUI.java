package adminsubscriber;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import studentpublisher.IStudent;
import studentpublisher.Student;

public class FindStudentUI {

	private JFrame frame;
	
	private IStudent studentService;
	
	JButton btnHome;
	JButton btnAddStudent;
	JButton btnAllStudents;
	JButton btnUpdateStudent;
	JButton btnRemoveStudent;
	JButton btnFindStudent;
	private JLabel lblFindStudent;
	private JLabel lblEnterStudentId;
	private JTextField textFieldSearch;
	private JButton btnSearchStudent;
	private JTextArea textAreaSearcResult;

	/**
	 * Create the application.
	 */
	public FindStudentUI(IStudent studentService) {
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
		
		lblFindStudent = new JLabel("Find Student");
		lblFindStudent.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFindStudent.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(lblFindStudent);
		
		lblEnterStudentId = new JLabel("Student ID");
		lblEnterStudentId.setBounds(186, 46, 113, 13);
		frame.getContentPane().add(lblEnterStudentId);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(258, 43, 96, 19);
		frame.getContentPane().add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		btnSearchStudent = new JButton("Find");
		btnSearchStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = textFieldSearch.getText().trim();
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Add student ID number","Error",JOptionPane.WARNING_MESSAGE);
				}
				else {

					try {
							
							Student student = studentService.student_get_by_id(id);
							if(student != null) {
								textAreaSearcResult.setText("Student ID : " + student.getId()  +
										"\nStudent Name : " + student.getName() +
										"\nGrade : " + student.getGrade() +
										"\nStudent Address : " + student.getAddress() + "\n" );
								
						}else {
							textAreaSearcResult.setText("\n\nSorry, but nothing matched your search \nstudent. Please try again with different \nstudent ID.");
							JOptionPane.showMessageDialog( frame, "Can not find Student","Error",JOptionPane.WARNING_MESSAGE);
						}

					}catch (Exception ex) {
						textAreaSearcResult.setText("Something went wrong");
						JOptionPane.showMessageDialog( frame, "Something went wrong","Error",JOptionPane.WARNING_MESSAGE);
						
					}
				
				}
			}
		});
		btnSearchStudent.setBounds(366, 41, 60, 21);
		frame.getContentPane().add(btnSearchStudent);
		
		textAreaSearcResult = new JTextArea();
		textAreaSearcResult.setBounds(186, 83, 240, 170);
		frame.getContentPane().add(textAreaSearcResult);
	}
}
