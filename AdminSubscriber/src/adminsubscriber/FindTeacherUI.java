package adminsubscriber;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import teacherpublisher.ITeacher;
import teacherpublisher.Teacher;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FindTeacherUI {

	private JFrame frame;

private ITeacher teacherService;
	
	JButton btnHome;
	JButton btnAddTeacher;
	JButton btnAllTeachers;
	JButton btnUpdateTeacher;
	JButton btnRemoveTeacher;
	JButton btnFindTeacher;
	private JLabel lblFindTeacher;
	private JLabel lblEnterTeacherId;
	private JTextField textFieldSearch;
	private JButton btnSearchTeacher;
	private JTextArea textAreaSearcResult;

	/**
	 * Create the application.
	 */
	public FindTeacherUI(ITeacher teacherService) {
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
		
		lblFindTeacher = new JLabel("Find Teacher");
		lblFindTeacher.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFindTeacher.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(lblFindTeacher);
		
		lblEnterTeacherId = new JLabel("Teacher ID");
		lblEnterTeacherId.setBounds(186, 46, 113, 13);
		frame.getContentPane().add(lblEnterTeacherId);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(258, 43, 96, 19);
		frame.getContentPane().add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		btnSearchTeacher = new JButton("Find");
		btnSearchTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = textFieldSearch.getText().trim();
				if(id.isEmpty()) {
					textAreaSearcResult.setText("");
					JOptionPane.showMessageDialog( frame, "Please Add teacher ID number","Error",JOptionPane.WARNING_MESSAGE);
				}
				else {

					try {
							
							Teacher teacher = teacherService.teacher_get_by_id(id);
							if(teacher != null) {
								textAreaSearcResult.setText("Teacher ID : " + teacher.getId()  +
										"\nTeacher Name : " + teacher.getName() +
										"\nSubject : " + teacher.getSubject() +
										"\nTeacher Address : " + teacher.getAddress() + "\n" );
								
						}else {
							textAreaSearcResult.setText("\n\nSorry, but nothing matched your search \nteacher. Please try again with different \nteacher ID.");
							JOptionPane.showMessageDialog( frame, "Can not find Teacher","Error",JOptionPane.WARNING_MESSAGE);
						}

					}catch (Exception ex) {
						textAreaSearcResult.setText("Something went wrong");
						JOptionPane.showMessageDialog( frame, "Something went wrong","Error",JOptionPane.WARNING_MESSAGE);
						
					}
				
				}
			}
		});
		btnSearchTeacher.setBounds(366, 41, 60, 21);
		frame.getContentPane().add(btnSearchTeacher);
		
		textAreaSearcResult = new JTextArea();
		textAreaSearcResult.setBounds(186, 83, 240, 170);
		frame.getContentPane().add(textAreaSearcResult);
	}

}
