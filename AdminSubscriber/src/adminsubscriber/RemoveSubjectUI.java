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

import subjectpublisher.ISubject;
import subjectpublisher.Subject;

public class RemoveSubjectUI {

		private JFrame frame;
		
		private ISubject subjectService;

		JButton btnHome;
		JButton btnAddSubject;
		JButton btnAllSubject;
		JButton btnUpdateSubject;
		JButton btnRemoveSubject;
		JButton btnFindSubject;
		JButton btnRemove;
		
		private JLabel lblRemoveSubject;
		private JLabel lblRemove;
		private JTextField textFieldRemove;
		private JButton btnSearch;
		private JTextArea textAreaRemove;
		private JButton btnDelete;

		/**
		 * Create the application.
		 */
		public RemoveSubjectUI(ISubject subjectService) {
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
			
			lblRemoveSubject = new JLabel("Remove Course");
			lblRemoveSubject.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblRemoveSubject.setBounds(248, 16, 124, 17);
			frame.getContentPane().add(lblRemoveSubject);
			
			btnRemove = new JButton("Remove");
			frame.getContentPane().add(btnRemove);
			
			lblRemove = new JLabel("Course ID");
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
						JOptionPane.showMessageDialog( frame, "Please Add subject ID number","Error",JOptionPane.WARNING_MESSAGE);
					}
					else {

						try {
								
								Subject subject = subjectService.get_by_id(Integer.parseInt(id));
								if(subject != null) {
									textAreaRemove.setText("Subject ID : " + subject.getId()  +
											"\nSubject Name : " + subject.getSubject_name() +
											"\nGrade : " + subject.getGrade());
									
							}else {
								textAreaRemove.setText("\n\nSorry, but nothing matched your search \nsubject. Please try again with different \nstudent ID.");
								JOptionPane.showMessageDialog( frame, "Can not find Subject","Error",JOptionPane.WARNING_MESSAGE);
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
			
			btnDelete = new JButton("Remove Subject");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id = textFieldRemove.getText().trim();
					
					
					if(id.isEmpty()) {
						JOptionPane.showMessageDialog( frame, "Please Add subject ID number","Error",JOptionPane.WARNING_MESSAGE);
					}
					else {
						try {
								
								boolean isSubject = subjectService.deleteSubject(Integer.parseInt(id));
								if(isSubject) {
									textFieldRemove.setText("");
									textAreaRemove.setText("\n\nSubject deleted sucessfully");
									
									JOptionPane.showMessageDialog( frame, "Subject deleted sucessfully","Success",JOptionPane.PLAIN_MESSAGE);
							}else {
								textAreaRemove.setText("\n\nCan not delete Subject");
								JOptionPane.showMessageDialog( frame, "Can not delete Subject","Error",JOptionPane.WARNING_MESSAGE);
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

