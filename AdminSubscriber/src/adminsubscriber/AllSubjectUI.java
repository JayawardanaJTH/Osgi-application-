package adminsubscriber;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import subjectpublisher.ISubject;
import subjectpublisher.Subject;

public class AllSubjectUI {

	private JFrame frame;
	
	private ISubject subjectService;
	
	JButton btnHome;
	JButton btnAddSubject;
	JButton btnAllSubject;
	JButton btnUpdateSubject;
	JButton btnRemoveSubject;
	JButton btnFindSubject;
	JScrollPane scrollPane;
	private JLabel lblAllSubject;
	private JTable table;

	/**
	 * Create the application.
	 */
	public AllSubjectUI(ISubject subjectService) {
		this.subjectService = subjectService;
		initialize();
		
		ArrayList<Subject> subject = subjectService.get_all();
		if (!subject.isEmpty()) {
		    List<Object[]> list = new ArrayList<Object[]>();
		    for (int i = 0; i < subject.size(); i++) {
		        list.add(new Object[] { 
		        		subject.get(i).getId(), 
		        		subject.get(i).getSubject_name(),
		        		subject.get(i).getGrade(),
		                              });

		    }
		    table.setModel(new DefaultTableModel(list.toArray(new Object[][] {}), 
		                        new String[] {"ID","Name", "Grade"}));
		}
	
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
		
		
		lblAllSubject = new JLabel("All Courses");
		lblAllSubject.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAllSubject.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(lblAllSubject);
		
		table = new JTable();
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(172, 58, 254, 184);
		frame.getContentPane().add(scrollPane);

	}
}
