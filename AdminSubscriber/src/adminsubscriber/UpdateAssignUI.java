package adminsubscriber;

import java.awt.EventQueue;

import javax.swing.JFrame;

import assignpublisher.Assign;
import assignpublisher.IAssign;
import studentpublisher.IStudent;
import studentpublisher.Student;
import subjectpublisher.ISubject;
import subjectpublisher.Subject;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class UpdateAssignUI {

	private JFrame frmUpdateAssign;

	private IStudent studentService;
	private ISubject subjectService;
	private IAssign assignService;
	private JTable table;
	
	private JComboBox cmbSubject;
	private JComboBox cmbStudent;
	
	private ArrayList<Object[]> assignsList = new ArrayList<>();
	private ArrayList<Assign> assigns = new ArrayList<>();
	
	private ArrayList<Student> studentList = new ArrayList<>();
	private ArrayList<Subject> subjectList = new ArrayList<>();
	
	private int selectedRow;
	private DefaultTableModel tablemodel ;
	/**
	 * Create the application.
	 */
	public UpdateAssignUI(IStudent studentService, ISubject subjectService, IAssign assignService) {
		this.studentService = studentService;
		this.subjectService = subjectService;
		this.assignService = assignService;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmUpdateAssign = new JFrame();
		frmUpdateAssign.setTitle("Update assign");
		frmUpdateAssign.setBounds(100, 100, 560, 327);
		frmUpdateAssign.getContentPane().setLayout(null);
		frmUpdateAssign.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 205, 261);
		frmUpdateAssign.getContentPane().add(panel);
		
		JButton btnAddAssign = new JButton("Add subject to student");
		btnAddAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddAssignUI(studentService, subjectService, assignService);
				frmUpdateAssign.setVisible(false);
			}
		});
		btnAddAssign.setBounds(10, 33, 185, 23);
		panel.add(btnAddAssign);
		
		JButton btnViewAssign = new JButton("View assigns");
		btnViewAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewAssignsUI(studentService, subjectService,assignService);
				frmUpdateAssign.setVisible(false);
			}
		});
		btnViewAssign.setBounds(10, 89, 185, 23);
		panel.add(btnViewAssign);
		
		JButton btnUpdateAssign = new JButton("Update assign");
		btnUpdateAssign.setBounds(10, 145, 185, 23);
		panel.add(btnUpdateAssign);
		
		JButton btnDeleteAssign = new JButton("Delete assign");
		btnDeleteAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteAssignUI(studentService, subjectService,assignService);
				frmUpdateAssign.setVisible(false);
			}
		});
		btnDeleteAssign.setBounds(10, 201, 185, 23);
		panel.add(btnDeleteAssign);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(215, 11, 319, 113);
		frmUpdateAssign.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"ID", "Student", "Subject"
				}
			));
		scrollPane.setViewportView(table);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selectedRow = table.getSelectedRow();
				
				if(selectedRow < 0) {
					JOptionPane.showMessageDialog(frmUpdateAssign, "Please select row", "Data missing", JOptionPane.ERROR_MESSAGE);
				}
				else {
					Assign assign = assigns.get(selectedRow);
					
					cmbStudent.setSelectedItem(assign.getStudent().getName());
				}
			}
		});
		btnSelect.setBounds(318, 128, 89, 23);
		frmUpdateAssign.getContentPane().add(btnSelect);
		
		cmbStudent = new JComboBox();
		cmbStudent.setEditable(true);
		cmbStudent.setEnabled(false);
		cmbStudent.setBounds(295, 162, 179, 28);
		frmUpdateAssign.getContentPane().add(cmbStudent);
		
		cmbSubject = new JComboBox();
		cmbSubject.setBounds(295, 213, 179, 28);
		frmUpdateAssign.getContentPane().add(cmbSubject);
		
		JLabel lblNewLabel_1 = new JLabel("Subject");
		lblNewLabel_1.setBounds(215, 220, 46, 14);
		frmUpdateAssign.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Student");
		lblNewLabel.setBounds(215, 169, 70, 14);
		frmUpdateAssign.getContentPane().add(lblNewLabel);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Assign assign = assigns.get(selectedRow);
				Subject subject_obj = null;
				
				String selected_subject = cmbSubject.getSelectedItem().toString().trim();
				
				for(Subject obj : subjectList) {
					
					if(obj.getSubject_name().contentEquals(selected_subject)) {
						subject_obj = obj;
						break;
					}
				}
				
				assign.setSubject(subject_obj);
				
				if(assignService.updateAssign(assign.getId(), assign)) {
					JOptionPane.showMessageDialog(frmUpdateAssign, "Update success", "Data Updated", JOptionPane.PLAIN_MESSAGE);
					
					tablemodel.setRowCount(0);
					loadTableData();
				}
				else {
					JOptionPane.showMessageDialog(frmUpdateAssign, "Update erro", "Data error", JOptionPane.ERROR_MESSAGE);
				}
		}});
		btnUpdate.setBounds(318, 252, 89, 23);
		frmUpdateAssign.getContentPane().add(btnUpdate);
		
		tablemodel = (DefaultTableModel) table.getModel();
		
		loadData();
		loadTableData();
	}
	
	private void loadData() {
		studentList = new ArrayList<>();
		subjectList = new ArrayList<>();
		
		studentList = studentService.get_all_students();
		subjectList = subjectService.get_all();
		
		cmbStudent.addItem("Select");
		
		if(studentList != null) {
			
			for(Student obj : studentList) {
				cmbStudent.addItem(obj.getName());
			}
		}
		
		cmbSubject.addItem("Select");
		
		if(subjectList != null) {
			
			for(Subject obj : subjectList) {
				cmbSubject.addItem(obj.getSubject_name());
			}
		}
	}
	
	private void loadTableData() {
		assigns = assignService.getAllAssigns();
		
		if(assigns != null) {
			
			Object[] data  = new Object[3];
			
			for(Assign obj : assigns) {
				
				data[0] = obj.getId();
				data[1] = obj.getStudent().getName();
				data[2] = obj.getSubject().getSubject_name();
						
				tablemodel.addRow(data);
			}
		}
		else {
			Object[] data  = new Object[3];
			tablemodel.addRow(data);
		}
		
		
	}
}
