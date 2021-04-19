package adminsubscriber;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import subjectpublisher.ISubject;

public class SubjectUI {
		
		private JFrame frame;

		private ISubject subjectService;
		
		
		JButton btnHome;
		JButton btnAddSubject;
		JButton btnAllSubject;
		JButton btnUpdateSubject;
		JButton btnRemoveSubject;
		JButton btnFindSubject;

		/**
		 * Create the application.
		 */
		public SubjectUI(ISubject subjectService) {
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
			
			
		}
}
