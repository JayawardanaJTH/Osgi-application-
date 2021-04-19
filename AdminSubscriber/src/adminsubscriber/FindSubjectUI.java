package adminsubscriber;

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

public class FindSubjectUI {

	private JFrame frame;
	
	private ISubject subjectService;
	
	JButton btnHome;
	JButton btnAddSubject;
	JButton btnAllSubject;
	JButton btnUpdateSubject;
	JButton btnRemoveSubject;
	JButton btnFindSubject;
	private JLabel lblFindSubject;
	private JLabel lblEnterSubjectId;
	private JTextField textFieldSearch;
	private JButton btnSearchSubject;
	private JTextArea textAreaSearcResult;

	/**
	 * Create the application.
	 */
	public FindSubjectUI(ISubject subjectService) {
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
		
		lblFindSubject = new JLabel("Find Course");
		lblFindSubject.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFindSubject.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(lblFindSubject);
		
		lblEnterSubjectId = new JLabel("Course ID");
		lblEnterSubjectId.setBounds(186, 46, 113, 13);
		frame.getContentPane().add(lblEnterSubjectId);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(258, 43, 96, 19);
		frame.getContentPane().add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		btnSearchSubject = new JButton("Find");
		btnSearchSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = textFieldSearch.getText().trim();
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Add student ID number","Error",JOptionPane.WARNING_MESSAGE);
				}
				else {

					try {
							
							Subject subject = subjectService.get_by_id(Integer.parseInt(id));
							if(subject != null) {
								textAreaSearcResult.setText("Subject ID : " + subject.getId()  +
										"\nSubject Name : " + subject.getSubject_name() +
										"\nGrade : " + subject.getGrade() +"\n" );
								
						}else {
							textAreaSearcResult.setText("\n\nSorry, but nothing matched your search \nsubject. Please try again with different \nstudent ID.");
							JOptionPane.showMessageDialog( frame, "Can not find Subject","Error",JOptionPane.WARNING_MESSAGE);
						}

					}catch (Exception ex) {
						textAreaSearcResult.setText("Something went wrong");
						JOptionPane.showMessageDialog( frame, "Something went wrong","Error",JOptionPane.WARNING_MESSAGE);
						
					}
				
				}
			}
		});
		btnSearchSubject.setBounds(366, 41, 60, 21);
		frame.getContentPane().add(btnSearchSubject);
		
		textAreaSearcResult = new JTextArea();
		textAreaSearcResult.setBounds(186, 83, 240, 170);
		frame.getContentPane().add(textAreaSearcResult);
	}
}