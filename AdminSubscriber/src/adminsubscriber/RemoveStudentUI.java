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

public class RemoveStudentUI {

	private JFrame frame;
	
	private IStudent studentService;

	JButton btnHome;
	JButton btnAddStudent;
	JButton btnAllStudents;
	JButton btnUpdateStudent;
	JButton btnRemoveStudent;
	JButton btnFindStudent;
	JButton btnRemove;
	
	private JLabel lblRemoveStudent;
	private JLabel lblRemove;
	private JTextField textFieldRemove;
	private JButton btnSearch;
	private JTextArea textAreaRemove;
	private JButton btnDelete;

	/**
	 * Create the application.
	 */
	public RemoveStudentUI(IStudent studentService) {
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
		
		lblRemoveStudent = new JLabel("Remove Student");
		lblRemoveStudent.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRemoveStudent.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(lblRemoveStudent);
		
		btnRemove = new JButton("Remove");
		frame.getContentPane().add(btnRemove);
		
		lblRemove = new JLabel("Student ID");
		lblRemove.setBounds(180, 45, 67, 13);
		frame.getContentPane().add(lblRemove);
		
		textFieldRemove = new JTextField();
		textFieldRemove.setBounds(245, 43, 96, 19);
		frame.getContentPane().add(textFieldRemove);
		textFieldRemove.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textFieldRemove.getText().trim();
				if(id.isEmpty()) {
					textAreaRemove.setText("");
					JOptionPane.showMessageDialog( frame, "Please Add student ID number","Error",JOptionPane.WARNING_MESSAGE);
				}
				else {

					try {
							
							Student student = studentService.student_get_by_id(id);
							if(student != null) {
								textAreaRemove.setText("Student ID : " + student.getId()  +
										"\nStudent Name : " + student.getName() +
										"\nGrade : " + student.getGrade() +
										"\nStudent Address : " + student.getAddress() + "\n" );
								
						}else {
							textAreaRemove.setText("\n\nSorry, but nothing matched your search \nstudent. Please try again with different \nstudent ID.");
							JOptionPane.showMessageDialog( frame, "Can not find Student","Error",JOptionPane.WARNING_MESSAGE);
						}

					}catch (Exception ex) {
						textAreaRemove.setText("Something went wrong");
						JOptionPane.showMessageDialog( frame, "Something went wrong","Error",JOptionPane.WARNING_MESSAGE);
						
					}
				}
			}
		});
		
		btnSearch.setBounds(351, 43, 75, 21);
		frame.getContentPane().add(btnSearch);
		
		textAreaRemove = new JTextArea();
		textAreaRemove.setBounds(180, 70, 246, 126);
		frame.getContentPane().add(textAreaRemove);
		
		btnDelete = new JButton("Remove Student");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textFieldRemove.getText().trim();
				
				
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Add student ID number","Error",JOptionPane.WARNING_MESSAGE);
				}
				else {
					try {
							
							boolean isStudent = studentService.deleteStudent(id);
							if(isStudent) {
								textFieldRemove.setText("");
								textAreaRemove.setText("\n\nStudent deleted sucessfully");
								
								JOptionPane.showMessageDialog( frame, "Student deleted sucessfully","Success",JOptionPane.PLAIN_MESSAGE);
						}else {
							textAreaRemove.setText("\n\nCan not delete Student");
							JOptionPane.showMessageDialog( frame, "Can not delete Student","Error",JOptionPane.WARNING_MESSAGE);
						}

					}catch (Exception ex) {
						textAreaRemove.setText("\n\nSomething went wrong..!");
						JOptionPane.showMessageDialog( frame, "Something went wrong","Error",JOptionPane.WARNING_MESSAGE);
						
					}
				}

			}
		});
		btnDelete.setBounds(274, 219, 152, 21);
		frame.getContentPane().add(btnDelete);
	}

}


