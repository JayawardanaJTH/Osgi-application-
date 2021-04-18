package adminsubscriber;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import assignpublisher.Assign;
import assignpublisher.IAssign;
import studentpublisher.IStudent;
import subjectpublisher.ISubject;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DeleteAssignUI {

	private JFrame frmDeleteAssign;

	private IStudent studentService;
	private ISubject subjectService;
	private IAssign assignService;
	private JTable table;
	
	private ArrayList<Object[]> assignsList = new ArrayList<>();
	private ArrayList<Assign> assigns = new ArrayList<>();
	
	private int selectedRow;
	/**
	 * Create the application.
	 */
	public DeleteAssignUI(IStudent studentService, ISubject subjectService, IAssign assignService) {
		this.studentService = studentService;
		this.subjectService = subjectService;
		this.assignService = assignService;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmDeleteAssign = new JFrame();
		frmDeleteAssign.setTitle("Delete Assign");
		frmDeleteAssign.setBounds(100, 100, 560, 305);
		frmDeleteAssign.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmDeleteAssign.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 205, 261);
		frmDeleteAssign.getContentPane().add(panel);
		
		JButton btnAddAssign = new JButton("Add subject to student");
		btnAddAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddAssignUI(studentService, subjectService, assignService);
				frmDeleteAssign.setVisible(false);
			}
		});
		btnAddAssign.setBounds(10, 33, 185, 23);
		panel.add(btnAddAssign);
		
		JButton btnViewAssign = new JButton("View assigns");
		btnViewAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewAssignsUI(studentService, subjectService, assignService);
				frmDeleteAssign.setVisible(false);
			}
		});
		btnViewAssign.setBounds(10, 89, 185, 23);
		panel.add(btnViewAssign);
		
		JButton btnUpdateAssign = new JButton("Update assign");
		btnUpdateAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateAssignUI(studentService, subjectService, assignService);
				frmDeleteAssign.setVisible(false);
			}
		});
		btnUpdateAssign.setBounds(10, 145, 185, 23);
		panel.add(btnUpdateAssign);
		
		JButton btnDeleteAssign = new JButton("Delete assign");
		btnDeleteAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteAssign.setBounds(10, 201, 185, 23);
		panel.add(btnDeleteAssign);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(217, 31, 317, 136);
		frmDeleteAssign.getContentPane().add(scrollPane);
		
		table = new JTable();
		
		scrollPane.setViewportView(table);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selectedRow = table.getSelectedRow();
				
				if(selectedRow < 0) {
					JOptionPane.showMessageDialog(frmDeleteAssign, "Please select row", "Data missing", JOptionPane.ERROR_MESSAGE);
				}
				else {
					Assign assign = assigns.get(selectedRow);
					
				    int option = JOptionPane.showConfirmDialog(frmDeleteAssign, "Are you sure to delete this", "Data delete", 
							JOptionPane.YES_NO_OPTION);
				    
				    if(option == 0) {
				    	assignService.deleteAssign(assign.getId());
				    	
				    	table.removeAll();
				    	loadTableData();
				    }
					
				}
			}
		});
		btnDelete.setBounds(321, 201, 89, 23);
		frmDeleteAssign.getContentPane().add(btnDelete);
		frmDeleteAssign.setVisible(true);
		
		loadTableData();
	}
	
	private void loadTableData() {
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
		else {
			assignsList.add(new Object[] {});
		}
		
		table.setModel(new DefaultTableModel(
				assignsList.toArray(new Object[][] {}),
				new String[] {
						"ID", "Student", "Subject"
				}
				));
		
		
	}
}
