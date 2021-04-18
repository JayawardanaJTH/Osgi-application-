package adminsubscriber;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import subjectpublisher.Subject;
import subjectpublisher.ISubject;

public class AddSubjectUI {
		
		private JFrame frame;

		private ISubject subjectService;
		
		JButton btnHome;
		JButton btnAddSubject;
		JButton btnAllSubject;
		JButton btnUpdateSubject;
		JButton btnRemoveSubject;
		JButton btnFindSubject;
		private JLabel lblAddSubject;
		private JLabel lblSubjectId;
		private JTextField textFieldSubjectId;
		private JLabel lblSubjectName;
		private JTextField textFieldSubjectName;
		private JLabel lblGrade;
		private JTextField textFieldGrade;
		private JButton btnAdd;

		/**
		 * Create the application.
		 */
		public AddSubjectUI(ISubject subjectService) {
			this.subjectService = subjectService;
			initialize();
		
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new MainUI(subjectService);
					frame.setVisible(false);
				}
			});
			
			btnAddSubject.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AddSubjectUI(subjectService);
					frame.setVisible(false);
				}
			});
			
			btnAllSubject.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AllSubjectUI(subjectService);
					frame.setVisible(false);
				}
			});
			
			btnUpdateSubject.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new UpdateSubjectUI(subjectService);
					frame.setVisible(false);
				}
			});
			
			btnRemoveSubject.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new RemoveSubjectUI(subjectService);
					frame.setVisible(false);
				}
			});
			
			btnFindSubject.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new FindSubjectUI(subjectService);
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
			
			btnAddSubject = new JButton("Add Course");
			btnAddSubject.setBounds(10, 55, 140, 21);
			frame.getContentPane().add(btnAddSubject);
			
			btnAllSubject = new JButton("All Courses");
			btnAllSubject.setBounds(10, 98, 140, 21);
			frame.getContentPane().add(btnAllSubject);
			
			btnUpdateSubject = new JButton("Update Course");
			btnUpdateSubject.setBounds(10, 144, 140, 21);
			frame.getContentPane().add(btnUpdateSubject);
			
			btnRemoveSubject = new JButton("Remove Course");

			btnRemoveSubject.setBounds(10, 188, 140, 21);
			frame.getContentPane().add(btnRemoveSubject);
			
			btnFindSubject = new JButton("Find Course");
			btnFindSubject.setBounds(10, 232, 140, 21);
			frame.getContentPane().add(btnFindSubject);
			
			lblAddSubject = new JLabel("Add Course");
			lblAddSubject.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblAddSubject.setBounds(248, 16, 124, 17);
			frame.getContentPane().add(lblAddSubject);
			
			lblSubjectId = new JLabel("Course ID");
			lblSubjectId.setBounds(198, 59, 96, 13);
			frame.getContentPane().add(lblSubjectId);
			
			textFieldSubjectId = new JTextField();
			textFieldSubjectId.setBounds(304, 56, 122, 19);
			frame.getContentPane().add(textFieldSubjectId);
			textFieldSubjectId.setColumns(10);
			
			lblSubjectName = new JLabel("Course Name");
			lblSubjectName.setBounds(198, 102, 81, 13);
			frame.getContentPane().add(lblSubjectName);
			
			textFieldSubjectName = new JTextField();
			textFieldSubjectName.setBounds(304, 99, 122, 19);
			frame.getContentPane().add(textFieldSubjectName);
			textFieldSubjectName.setColumns(10);
			
			lblGrade = new JLabel("Grade");
			lblGrade.setBounds(198, 148, 81, 13);
			frame.getContentPane().add(lblGrade);
			
			textFieldGrade = new JTextField();
			textFieldGrade.setBounds(304, 145, 122, 19);
			frame.getContentPane().add(textFieldGrade);
			textFieldGrade.setColumns(10);
			
			
			btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String id, name, grade;
					id = textFieldSubjectId.getText().trim();
					name = textFieldSubjectName.getText().trim();
					grade = textFieldGrade.getText().trim();

					if(id.isEmpty()) {
						JOptionPane.showMessageDialog( frame, "Please Add subject ID number","Error",JOptionPane.WARNING_MESSAGE);
					}
					else if(name.isEmpty()) {
						JOptionPane.showMessageDialog( frame, "Please add subject name","Error",JOptionPane.WARNING_MESSAGE);
					}
					else if(grade.isEmpty()) {
						JOptionPane.showMessageDialog( frame, "Please add grade","Error",JOptionPane.WARNING_MESSAGE);
					}
					else {
						try {
								int cIid = Integer.parseInt(id);
								Subject subject = new Subject(cIid,name,grade);
								boolean isSubject = subjectService.addSubject(subject);
								if(isSubject) {
									textFieldSubjectId.setText("");
									textFieldSubjectName.setText("");
									textFieldGrade.setText("");
									
									JOptionPane.showMessageDialog( frame, "Subject add sucessfully","Success",JOptionPane.PLAIN_MESSAGE);
							}else {
								
								JOptionPane.showMessageDialog( frame, "Can not add Subject","Error",JOptionPane.WARNING_MESSAGE);
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
