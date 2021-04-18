package adminsubscriber;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import studentpublisher.IStudent;
import studentpublisher.Student;

public class AllStudentUI {

	private JFrame frame;
	
	private IStudent studentService;
	
	JButton btnHome;
	JButton btnAddStudent;
	JButton btnAllStudents;
	JButton btnUpdateStudent;
	JButton btnRemoveStudent;
	JButton btnFindStudent;
	JScrollPane scrollPane;
	private JLabel lblAllStudent;
	private JTable table;

	/**
	 * Create the application.
	 */
	public AllStudentUI(IStudent studentService) {
		this.studentService = studentService;
		initialize();
		
		ArrayList<Student> student = studentService.get_all_students();
		if (!student.isEmpty()) {
		    List<Object[]> list = new ArrayList<Object[]>();
		    for (int i = 0; i < student.size(); i++) {
		        list.add(new Object[] { 
		        		student.get(i).getId(), 
		        		student.get(i).getName(),
		        		student.get(i).getGrade(),
		        		student.get(i).getAddress()
		                              });

		    }
		    table.setModel(new DefaultTableModel(list.toArray(new Object[][] {}), 
		                        new String[] {"ID","Name", "Grade", "Address"}));
		}
	
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
		
		
		lblAllStudent = new JLabel("All Student");
		lblAllStudent.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAllStudent.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(lblAllStudent);
		
		table = new JTable();
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(172, 58, 254, 184);
		frame.getContentPane().add(scrollPane);

	}
}

