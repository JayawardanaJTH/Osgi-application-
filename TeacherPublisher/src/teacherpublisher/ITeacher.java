package teacherpublisher;

import java.util.ArrayList;

public interface ITeacher {
	
	public boolean addTeacher(Teacher teacher);
	public boolean deleteTeacher(String id);
	public Teacher teacher(String id);
	public ArrayList<Teacher> teacher();

}
