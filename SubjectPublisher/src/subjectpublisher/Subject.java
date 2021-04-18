package subjectpublisher;

public class Subject {
	
	private int id;
	private String subject_name;
	private String grade;
	
	public Subject(int id, String subject_name, String grade) {
		this.id = id;
		this.subject_name = subject_name;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSubject_name() {
		return subject_name;
	}
	
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
