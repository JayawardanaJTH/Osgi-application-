package subjectpublisher;

import java.util.ArrayList;

public interface ISubject {
	
	public boolean addSubject (Subject subject);
	public boolean updateSubject (int id, Subject subject);
	public boolean deleteSubject (int id);
	public Subject get_by_id (int id);
	public ArrayList<Subject> get_all();

}
