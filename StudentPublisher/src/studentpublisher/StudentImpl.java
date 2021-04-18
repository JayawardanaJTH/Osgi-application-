package studentpublisher;

import java.util.ArrayList;

public class StudentImpl implements IStudent {

	private ArrayList<Student> studentList = new ArrayList<>();
	
	@Override
	public boolean addStudent(Student student) {
		System.out.println(student);
		studentList.add(student);
		return true;
	}

	@Override
	public boolean deleteStudent(String id) {
		if(studentList.isEmpty()) {
			return false;
		}
		else {
			for(Student student : studentList ) {
				if(student.getId().equals(id)) {
					studentList.remove(student);
					return true;
				}
			}
			return false;
		}
	}

	@Override
	public Student student_get_by_id(String id) {
		if(studentList.isEmpty()) {
			return null;
		}
		else {
			for(Student student : studentList) {
				if(student.getId().equals(id)) {
					return student;
				}
			}
			return null;
		}
	}

	@Override
	public ArrayList<Student> get_all_students() {
		return studentList;
	}

	@Override
	public boolean updateStudent(String id, Student student) {
		if(studentList.isEmpty()) {
			return false;
		}
		else {
			for(Student obj : studentList) {
				if(obj.getId().equals(id)) {
					obj = student;
					return true;
				}
			}
			return false;
		}
	}

}
