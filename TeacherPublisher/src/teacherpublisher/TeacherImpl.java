package teacherpublisher;

import java.util.ArrayList;

public class TeacherImpl {

private ArrayList<Teacher> teacherList = new ArrayList<>();
	
	public boolean addTeacher(Teacher teacher) {
		teacherList.add(teacher);
		return true;
	}

	public boolean deleteTeacher(String id) {
		if(teacherList.isEmpty()) {
			return false;
		}
		else {
			for(Teacher teacher : teacherList ) {
				if(teacher.getId().equals(id)) {
					teacherList.remove(teacher);
					return true;
				}
			}
			return false;
		}
	}

	public Teacher teacher_get_by_id(String id) {
		if(teacherList.isEmpty()) {
			return null;
		}
		else {
			for(Teacher teacher : teacherList) {
				if(teacher.getId().equals(id)) {
					return teacher;
				}
			}
			return null;
		}
	}

	public ArrayList<Teacher> get_all_teachers() {
		return teacherList;
	}

	
}
