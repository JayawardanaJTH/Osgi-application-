package teacherpublisher;

import java.util.ArrayList;

public interface ITeacher {
	
	public boolean addTeacher(Teacher teacher);
	public boolean deleteTeacher(String id);
	public Teacher teacher_get_by_id(String id);
	public ArrayList<Teacher> get_all_teachers();
	public boolean updateTeacher(String id, Teacher teacher);

}
