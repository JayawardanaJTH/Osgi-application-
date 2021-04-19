package adminsubscriber;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import teacherpublisher.ITeacher;
import teacherpublisher.Teacher;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class AllTeacherUI {

	private JFrame frame;

private ITeacher teacherService;
	
	JButton btnHome;
	JButton btnAddTeacher;
	JButton btnAllTeachers;
	JButton btnUpdateTeacher;
	JButton btnRemoveTeacher;
	JButton btnFindTeacher;
	JScrollPane scrollPane;
	private JLabel lblAllTeacher;
	private JTable table;

	/**
	 * Create the application.
	 */
	public AllTeacherUI(ITeacher teacherService) {
		this.teacherService = teacherService;
		initialize();
		
		ArrayList<Teacher> teacher = teacherService.get_all_teachers();
		if (!teacher.isEmpty()) {
		    List<Object[]> list = new ArrayList<Object[]>();
		    for (int i = 0; i < teacher.size(); i++) {
		        list.add(new Object[] { 
		        		teacher.get(i).getId(), 
		        		teacher.get(i).getName(),
		        		teacher.get(i).getSubject(),
		        		teacher.get(i).getAddress()
		                              });

		    }
		    table.setModel(new DefaultTableModel(list.toArray(new Object[][] {}), 
		                        new String[] {"ID","Name", "Subject", "Address"}));
		}
		
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
		
		
		lblAllTeacher = new JLabel("All Teacher");
		lblAllTeacher.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAllTeacher.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(lblAllTeacher);
		
		table = new JTable();
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(172, 58, 254, 184);
		frame.getContentPane().add(scrollPane);

	}

}
