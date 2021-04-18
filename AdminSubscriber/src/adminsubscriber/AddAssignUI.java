package adminsubscriber;

import javax.swing.JFrame;
import javax.swing.JPanel;

import assignpublisher.Assign;
import assignpublisher.IAssign;
import studentpublisher.IStudent;
import studentpublisher.Student;
import subjectpublisher.ISubject;
import subjectpublisher.Subject;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddAssignUI {

	private JFrame frmAddSubjectTo;
	private JComboBox cmbSubject;
	private JComboBox cmbStudent;

	private IStudent studentService;
	private ISubject subjectService;
	private IAssign assignService;
	
	private ArrayList<Student> studentList = new ArrayList<>();
	private ArrayList<Subject> subjectList = new ArrayList<>();
	
	private static int counter = 0;
	/**
	 * Create the application.
	 */
	public AddAssignUI(IStudent studentService, ISubject subjectService, IAssign assignService) {
		this.studentService = studentService;
		this.subjectService = subjectService;
		this.assignService = assignService;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddSubjectTo = new JFrame();
		frmAddSubjectTo.setTitle("Add subject to Student ");
		frmAddSubjectTo.setBounds(100, 100, 560, 305);
		frmAddSubjectTo.getContentPane().setLayout(null);
		frmAddSubjectTo.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 205, 261);
		frmAddSubjectTo.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnAddAssign = new JButton("Add subject to student");
		btnAddAssign.setBounds(10, 33, 185, 23);
		panel.add(btnAddAssign);
		
		JButton btnViewAssign = new JButton("View assigns");
		btnViewAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ViewAssignsUI(studentService, subjectService,assignService);
				frmAddSubjectTo.setVisible(false);
			}
		});
		btnViewAssign.setBounds(10, 89, 185, 23);
		panel.add(btnViewAssign);
		
		JButton btnUpdateAssign = new JButton("Update assign");
		btnUpdateAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateAssignUI(studentService, subjectService, assignService);
				frmAddSubjectTo.setVisible(false);
			}
		});
		btnUpdateAssign.setBounds(10, 145, 185, 23);
		panel.add(btnUpdateAssign);
		
		JButton btnDeleteAssign = new JButton("Delete assign");
		btnDeleteAssign.setBounds(10, 201, 185, 23);
		panel.add(btnDeleteAssign);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(215, 0, 329, 261);
		frmAddSubjectTo.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		cmbStudent = new JComboBox();
		cmbStudent.setBounds(90, 11, 179, 28);
		panel_1.add(cmbStudent);
		
		JLabel lblNewLabel = new JLabel("Student");
		lblNewLabel.setBounds(10, 18, 70, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Subject");
		lblNewLabel_1.setBounds(10, 69, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		cmbSubject = new JComboBox();
		cmbSubject.setBounds(90, 62, 179, 28);
		panel_1.add(cmbSubject);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(cmbStudent.getSelectedIndex() == 0 || cmbSubject.getSelectedIndex() == 0) {
					
					JOptionPane.showMessageDialog(frmAddSubjectTo, "Please select subject and student", "Data missing", JOptionPane.ERROR_MESSAGE);
				}
				else {
					
					String student = cmbStudent.getSelectedItem().toString().trim();
					String subject = cmbSubject.getSelectedItem().toString().trim();
					
					Student student_obj = null;
					Subject subject_obj = null;
					
					for(Student obj : studentList) {
						
						if(obj.getName().contentEquals(student)) {
							student_obj = obj;
							break;
						}
					}
					
					for(Subject obj : subjectList) {
						
						if(obj.getSubject_name().contentEquals(subject)) {
							subject_obj = obj;
							break;
						}
					}
					
					Assign assign = new Assign(++counter, student_obj, subject_obj);
					
					assignService.addAssign(assign);
				}
			}
		});
		
		btnSave.setBounds(129, 157, 89, 23);
		panel_1.add(btnSave);
		frmAddSubjectTo.setVisible(true);
		
		loadData();
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
}
