package teacherpublisher;

public class Teacher {
	
	private String id;
	private String name;
	private String subject;
	private String address;
	
	public Teacher(String id, String name, String subject, String address) {
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.address = address;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setGrade(String subject) {
		this.subject = subject;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

}
