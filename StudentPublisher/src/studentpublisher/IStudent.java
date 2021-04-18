package studentpublisher;

import java.util.ArrayList;

public interface IStudent {

	public boolean addStudent(Student student);
	public boolean deleteStudent(String id);
	public Student student_get_by_id(String id);
	public ArrayList<Student> get_all_students();
	public boolean updateStudent(String id, Student student);
}
