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

public class RemoveTeacherUI {

	private JFrame frame;

private ITeacher teacherService;
	
	JButton btnHome;
	JButton btnAddTeacher;
	JButton btnAllTeachers;
	JButton btnUpdateTeacher;
	JButton btnRemoveTeacher;
	JButton btnFindTeacher;
	JButton btnRemove;
	
	private JLabel lblRemoveTeacher;
	private JLabel lblRemove;
	private JTextField textFieldRemove;
	private JButton btnSearch;
	private JTextArea textAreaRemove;
	private JButton btnDelete;

	/**
	 * Create the application.
	 */
	public RemoveTeacherUI(ITeacher teacherService) {
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
		
		lblRemoveTeacher = new JLabel("Remove Teacher");
		lblRemoveTeacher.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRemoveTeacher.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(lblRemoveTeacher);
		
		btnRemove = new JButton("Remove");
		frame.getContentPane().add(btnRemove);
		
		lblRemove = new JLabel("Teacher ID");
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
					JOptionPane.showMessageDialog( frame, "Please Add teacher ID number","Error",JOptionPane.WARNING_MESSAGE);
				}
				else {

					try {
							
							Teacher teacher = teacherService.teacher_get_by_id(id);
							if(teacher != null) {
								textAreaRemove.setText("Teacher ID : " + teacher.getId()  +
										"\nTeacher Name : " + teacher.getName() +
										"\nSubject : " + teacher.getSubject() +
										"\nTeacher Address : " + teacher.getAddress() + "\n" );
								
						}else {
							textAreaRemove.setText("\n\nSorry, but nothing matched your search \nteacher. Please try again with different \nteacher ID.");
							JOptionPane.showMessageDialog( frame, "Can not find Teacher","Error",JOptionPane.WARNING_MESSAGE);
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
		
		btnDelete = new JButton("Remove Teacher");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textFieldRemove.getText().trim();
				
				
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Add teacher ID number","Error",JOptionPane.WARNING_MESSAGE);
				}
				else {
					try {
							
							boolean isTeacher = teacherService.deleteTeacher(id);
							if(isTeacher) {
								textFieldRemove.setText("");
								textAreaRemove.setText("\n\nTeacher deleted sucessfully");
								
								JOptionPane.showMessageDialog( frame, "Teacher deleted sucessfully","Success",JOptionPane.PLAIN_MESSAGE);
						}else {
							textAreaRemove.setText("\n\nCan not delete Teacher");
							JOptionPane.showMessageDialog( frame, "Can not delete Teacher","Error",JOptionPane.WARNING_MESSAGE);
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

