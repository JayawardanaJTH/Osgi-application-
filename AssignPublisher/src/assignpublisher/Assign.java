package assignpublisher;

import studentpublisher.Student;
import subjectpublisher.Subject;

public class Assign {
	
	private int id;
	private Student student;
	private Subject subject;
	
	
	public Assign() {
		super();
	}

	public Assign(int id, Student student, Subject subject) {
		super();
		this.id = id;
		this.student = student;
		this.subject = subject;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	
}
