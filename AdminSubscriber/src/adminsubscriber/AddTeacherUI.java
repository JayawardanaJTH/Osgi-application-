package adminsubscriber;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import teacherpublisher.ITeacher;
import teacherpublisher.Teacher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTeacherUI {

	private JFrame frame;

	private ITeacher teacherService;
	
	JButton btnHome;
	JButton btnAddTeacher;
	JButton btnAllTeachers;
	JButton btnUpdateTeacher;
	JButton btnRemoveTeacher;
	JButton btnFindTeacher;
	private JLabel lblAddTeacher;
	private JLabel lblTeacherId;
	private JTextField textFieldTeacherId;
	private JLabel lblTeacherName;
	private JTextField textFieldTeacherName;
	private JLabel lblSubject;
	private JTextField textFieldSubject;
	private JLabel lblAddress;
	private JTextField textFieldAddress;
	private JButton btnAdd;

	/**
	 * Create the application.
	 */
	public AddTeacherUI(ITeacher teacherService) {
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
		
		lblAddTeacher = new JLabel("Add Teacher");
		lblAddTeacher.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddTeacher.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(lblAddTeacher);
		
		lblTeacherId = new JLabel("Teacher ID");
		lblTeacherId.setBounds(198, 59, 96, 13);
		frame.getContentPane().add(lblTeacherId);
		
		textFieldTeacherId = new JTextField();
		textFieldTeacherId.setBounds(304, 56, 122, 19);
		frame.getContentPane().add(textFieldTeacherId);
		textFieldTeacherId.setColumns(10);
		
		lblTeacherName = new JLabel("Teacher Name");
		lblTeacherName.setBounds(198, 102, 96, 13);
		frame.getContentPane().add(lblTeacherName);
		
		textFieldTeacherName = new JTextField();
		textFieldTeacherName.setBounds(304, 99, 122, 19);
		frame.getContentPane().add(textFieldTeacherName);
		textFieldTeacherName.setColumns(10);
		
		lblSubject = new JLabel("Subject");
		lblSubject.setBounds(198, 148, 96, 13);
		frame.getContentPane().add(lblSubject);
		
		textFieldSubject = new JTextField();
		textFieldSubject.setBounds(304, 145, 122, 19);
		frame.getContentPane().add(textFieldSubject);
		textFieldSubject.setColumns(10);
		
		lblAddress = new JLabel("Address");
		lblAddress.setBounds(198, 192, 96, 13);
		frame.getContentPane().add(lblAddress);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(304, 189, 122, 19);
		frame.getContentPane().add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id, name, subject, address;
				id = textFieldTeacherId.getText().trim();
				name = textFieldTeacherName.getText().trim();
				subject = textFieldSubject.getText().trim();
				address = textFieldAddress.getText().trim();
				
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Add teacher ID number","Error",JOptionPane.WARNING_MESSAGE);
				}
				else if(name.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please add teacher name","Error",JOptionPane.WARNING_MESSAGE);
				}
				else if(subject.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please add subject","Error",JOptionPane.WARNING_MESSAGE);
				}
				else if(address.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please add address","Error",JOptionPane.WARNING_MESSAGE);
				}
				else {
					try {
							Teacher teacher = new Teacher(id,name,subject,address);
							boolean isTeacher = teacherService.addTeacher(teacher);
							if(isTeacher) {
								textFieldTeacherId.setText("");
								textFieldTeacherName.setText("");
								textFieldSubject.setText("");
								textFieldAddress.setText("");
								
								JOptionPane.showMessageDialog( frame, "Teacher add sucessfully","Success",JOptionPane.PLAIN_MESSAGE);
						}else {
							
							JOptionPane.showMessageDialog( frame, "Can not add Teacher","Error",JOptionPane.WARNING_MESSAGE);
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
