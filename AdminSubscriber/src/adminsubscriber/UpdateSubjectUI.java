package adminsubscriber;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import subjectpublisher.ISubject;
import subjectpublisher.Subject;

public class UpdateSubjectUI {

	private JFrame frame;
	
	private ISubject subjectService;
	
	JButton btnHome;
	JButton btnAddSubject;
	JButton btnAllSubject;
	JButton btnUpdateSubject;
	JButton btnRemoveSubject;
	JButton btnFindSubject;
	private JLabel lblUpdateSubject;
	private JLabel lblUpdateSubjectId;
	private JLabel lblUpdateSubjectName;
	private JLabel lblUpdateGrade;
	private JTextField textFieldUpdateSubjectId;
	private JTextField textFieldUpdateSubjectName;
	private JTextField textFieldGrade;
	private JButton btnUpdate;

	/**
	 * Create the application.
	 */
	public UpdateSubjectUI(ISubject subjectService) {
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
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id, name, grade;
				id = textFieldUpdateSubjectId.getText().trim();
				name = textFieldUpdateSubjectName.getText().trim();
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
							boolean isSubject = subjectService.updateSubject(cIid, subject);
							if(isSubject) {
								textFieldUpdateSubjectId.setText("");
								textFieldUpdateSubjectName.setText("");
								textFieldGrade.setText("");
								
								JOptionPane.showMessageDialog( frame, "Subject Update sucessfully","Success",JOptionPane.PLAIN_MESSAGE);
						}else {
							
							JOptionPane.showMessageDialog( frame, "Can not Update Subject","Error",JOptionPane.WARNING_MESSAGE);
						}

					}catch (Exception ex) {
						JOptionPane.showMessageDialog( frame, "Something went wrong","Error",JOptionPane.WARNING_MESSAGE);
						
					}
				}
				
				
			}
		});
		
		btnUpdate.setBounds(266, 232, 85, 21);
		frame.getContentPane().add(btnUpdate);
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
		
		lblUpdateSubject = new JLabel("Update Course");
		lblUpdateSubject.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUpdateSubject.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(lblUpdateSubject);
		
		lblUpdateSubjectId = new JLabel("Course ID");
		lblUpdateSubjectId.setBounds(195, 55, 88, 13);
		frame.getContentPane().add(lblUpdateSubjectId);
		
		lblUpdateSubjectName = new JLabel("Subject Name");
		lblUpdateSubjectName.setBounds(195, 98, 88, 13);
		frame.getContentPane().add(lblUpdateSubjectName);
		
		lblUpdateGrade = new JLabel("Grade");
		lblUpdateGrade.setBounds(195, 144, 88, 13);
		frame.getContentPane().add(lblUpdateGrade);
				
		textFieldUpdateSubjectId = new JTextField();
		textFieldUpdateSubjectId.setBounds(309, 56, 117, 19);
		frame.getContentPane().add(textFieldUpdateSubjectId);
		textFieldUpdateSubjectId.setColumns(10);
		
		textFieldUpdateSubjectName = new JTextField();
		textFieldUpdateSubjectName.setBounds(309, 99, 117, 19);
		frame.getContentPane().add(textFieldUpdateSubjectName);
		textFieldUpdateSubjectName.setColumns(10);
		
		textFieldGrade = new JTextField();
		textFieldGrade.setBounds(309, 141, 117, 19);
		frame.getContentPane().add(textFieldGrade);
		textFieldGrade.setColumns(10);
		
	}

}