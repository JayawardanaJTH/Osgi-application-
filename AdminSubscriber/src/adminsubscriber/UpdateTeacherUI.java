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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateTeacherUI {

	private JFrame frame;

private ITeacher teacherService;
	
	JButton btnHome;
	JButton btnAddTeacher;
	JButton btnAllTeachers;
	JButton btnUpdateTeacher;
	JButton btnRemoveTeacher;
	JButton btnFindTeacher;
	private JLabel lblUpdateTeacher;
	private JLabel lblUpdateSutdentId;
	private JLabel lblUpdateTeacherName;
	private JLabel lblUpdateSubject;
	private JLabel lblUpdateAddress;
	private JTextField textFieldUpdateTeacherId;
	private JTextField textFieldUpdateTeacherName;
	private JTextField textFieldUpdateSubject;
	private JTextField textFieldUpdateAddress;
	private JButton btnUpdate;

	/**
	 * Create the application.
	 */
	public UpdateTeacherUI(ITeacher teacherService) {
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
		
		lblUpdateTeacher = new JLabel("Update Teacher");
		lblUpdateTeacher.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUpdateTeacher.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(lblUpdateTeacher);
		
		lblUpdateSutdentId = new JLabel("Teacher ID");
		lblUpdateSutdentId.setBounds(172, 59, 88, 13);
		frame.getContentPane().add(lblUpdateSutdentId);
		
		lblUpdateTeacherName = new JLabel("Teacher Name");
		lblUpdateTeacherName.setBounds(172, 102, 88, 13);
		frame.getContentPane().add(lblUpdateTeacherName);
		
		lblUpdateSubject = new JLabel("Subject");
		lblUpdateSubject.setBounds(172, 148, 88, 13);
		frame.getContentPane().add(lblUpdateSubject);
		
		lblUpdateAddress = new JLabel("Address");
		lblUpdateAddress.setBounds(172, 192, 88, 13);
		frame.getContentPane().add(lblUpdateAddress);
		
		textFieldUpdateTeacherId = new JTextField();
		textFieldUpdateTeacherId.setBounds(235, 56, 117, 19);
		frame.getContentPane().add(textFieldUpdateTeacherId);
		textFieldUpdateTeacherId.setColumns(10);
		
		textFieldUpdateTeacherName = new JTextField();
		textFieldUpdateTeacherName.setBounds(270, 99, 117, 19);
		frame.getContentPane().add(textFieldUpdateTeacherName);
		textFieldUpdateTeacherName.setColumns(10);
		
		textFieldUpdateSubject = new JTextField();
		textFieldUpdateSubject.setBounds(270, 145, 117, 19);
		frame.getContentPane().add(textFieldUpdateSubject);
		textFieldUpdateSubject.setColumns(10);
		
		textFieldUpdateAddress = new JTextField();
		textFieldUpdateAddress.setBounds(270, 189, 117, 19);
		frame.getContentPane().add(textFieldUpdateAddress);
		textFieldUpdateAddress.setColumns(10);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id, name, subject, address;
				id = textFieldUpdateTeacherId.getText().trim();
				name = textFieldUpdateTeacherName.getText().trim();
				subject = textFieldUpdateSubject.getText().trim();
				address = textFieldUpdateAddress.getText().trim();
				
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
							boolean isTeacher = teacherService.updateTeacher(id,teacher);
							if(isTeacher) {
								textFieldUpdateTeacherId.setText("");
								textFieldUpdateTeacherName.setText("");
								textFieldUpdateSubject.setText("");
								textFieldUpdateAddress.setText("");
								
								JOptionPane.showMessageDialog( frame, "Teacher update sucessfully","Success",JOptionPane.PLAIN_MESSAGE);
						}else {
							
							JOptionPane.showMessageDialog( frame, "Can not update Teacher","Error",JOptionPane.WARNING_MESSAGE);
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
				String id = textFieldUpdateTeacherId.getText().trim();
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Add teacher ID number","Error",JOptionPane.WARNING_MESSAGE);
				}
				else {

					try {
							
							Teacher teacher = teacherService.teacher_get_by_id(id);
							if(teacher != null) {
								textFieldUpdateTeacherName.setText(teacher.getName());
								textFieldUpdateSubject.setText(teacher.getSubject());
								textFieldUpdateAddress.setText(teacher.getAddress());
								
						}else {
							JOptionPane.showMessageDialog( frame, "Can not find Teacher","Error",JOptionPane.WARNING_MESSAGE);
						}

					}catch (Exception ex) {
						JOptionPane.showMessageDialog( frame, "Something went wrong","Error",JOptionPane.WARNING_MESSAGE);
						
					}
				}
			}
		});
		
		btnUpdateFind.setBounds(362, 55, 64, 21);
		frame.getContentPane().add(btnUpdateFind);
	}

}
