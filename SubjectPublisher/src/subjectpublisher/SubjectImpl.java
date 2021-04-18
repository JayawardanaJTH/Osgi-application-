package subjectpublisher;

import java.util.ArrayList;

public class SubjectImpl implements ISubject {
	
	private ArrayList<Subject> subjectList = new ArrayList<>();

	@Override
	public boolean addSubject(Subject subject) {
		System.out.println(subject);
		subjectList.add(subject);
		return true;

	}

	@SuppressWarnings("unused")
	@Override
	public boolean updateSubject(int id, Subject subject) {
		
		for(Subject newSubject : subjectList) {

			if(subject.getId() == id) {

				newSubject.setGrade(subject.getGrade());
				newSubject.setSubject_name(subject.getSubject_name());
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteSubject(int id) {
		
		if(subjectList.isEmpty()) {
			return false;
		}
		else {
			for(Subject subject : subjectList ) {
				if(subject.getId() == id) {
					subjectList.remove(subject);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Subject get_by_id(int id) {

		if(subjectList.isEmpty()) {
			return null;
			
		}else {
			for(Subject subject : subjectList) {

				if(subject.getId() == id) {
					return subject;
				}
			}

			return null;
		}
		
	}

	@Override
	public ArrayList<Subject> get_all() {
		if(subjectList.isEmpty()) {
			return null;
			
		}else {
			return subjectList;
			
		}
		
	}

}
