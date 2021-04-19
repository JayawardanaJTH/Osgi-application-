package teacherpublisher;

import java.util.ArrayList;

public class TeacherImpl implements ITeacher{

	private ArrayList<Teacher> teacherList = new ArrayList<>();

	@Override
	public boolean addTeacher(Teacher teacher) {
		teacherList.add(teacher);
		return true;
	}

	@Override
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

	@Override
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

	@Override
	public ArrayList<Teacher> get_all_teachers() {
		return teacherList;
	}
	


	@Override
	public boolean updateTeacher(String id, Teacher teacher) {
		if(teacherList.isEmpty()) {
			return false;
		}
		else {
			int i = -1;
			for(Teacher obj : teacherList) {
				i =i + 1;
				if(obj.getId().equals(id)) {
					teacherList.set(i, new Teacher(teacher.getId(),teacher.getName(),teacher.getSubject(),teacher.getAddress()));
					return true;
				}
			}
			return false;
		}
	}
	
}
