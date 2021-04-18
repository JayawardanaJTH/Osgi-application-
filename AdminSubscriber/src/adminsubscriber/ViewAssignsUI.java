package adminsubscriber;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import assignpublisher.Assign;
import assignpublisher.IAssign;
import studentpublisher.IStudent;
import subjectpublisher.ISubject;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class ViewAssignsUI {

	private JFrame frmViewAssigns;

	private IStudent studentService;
	private ISubject subjectService;
	private IAssign assignService;
	private JTable table;
	
	private ArrayList<Object[]> assignsList = new ArrayList<>();
	private ArrayList<Assign> assigns = new ArrayList<>();
	/**
	 * Create the application.
	 */
	public ViewAssignsUI(IStudent studentService, ISubject subjectService, IAssign assignService) {
		this.studentService = studentService;
		this.subjectService = subjectService;
		this.assignService = assignService;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		assigns = assignService.getAllAssigns();
		
		if(assigns != null) {
			
			for(Assign obj : assigns) {
				
				assignsList.add(new Object[] {
						obj.getId(),
						obj.getStudent().getName(),
						obj.getSubject().getSubject_name()
				});
			}
		}
		
		frmViewAssigns = new JFrame();
		frmViewAssigns.setTitle("View assigns");
		frmViewAssigns.setBounds(100, 100, 560, 305);
		frmViewAssigns.getContentPane().setLayout(null);
		frmViewAssigns.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 205, 261);
		frmViewAssigns.getContentPane().add(panel);
		
		JButton btnAddAssign = new JButton("Add subject to student");
		btnAddAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddAssignUI(studentService, subjectService, assignService);
				frmViewAssigns.setVisible(false);
			}
		});
		btnAddAssign.setBounds(10, 33, 185, 23);
		panel.add(btnAddAssign);
		
		JButton btnViewAssign = new JButton("View assigns");
		btnViewAssign.setBounds(10, 89, 185, 23);
		panel.add(btnViewAssign);
		
		JButton btnUpdateAssign = new JButton("Update assign");
		btnUpdateAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateAssignUI(studentService, subjectService, assignService);
				frmViewAssigns.setVisible(false);
			}
		});
		btnUpdateAssign.setBounds(10, 145, 185, 23);
		panel.add(btnUpdateAssign);
		
		JButton btnDeleteAssign = new JButton("Delete assign");
		btnDeleteAssign.setBounds(10, 201, 185, 23);
		panel.add(btnDeleteAssign);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(215, 29, 319, 197);
		frmViewAssigns.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			assignsList.toArray(new Object[][] {}),
			new String[] {
				"ID", "Student", "Subject"
			}
		));
	}
}
