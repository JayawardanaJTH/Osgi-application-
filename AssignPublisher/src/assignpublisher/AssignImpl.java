package assignpublisher;

import java.util.ArrayList;

public class AssignImpl implements IAssign {

	//add assign data to the array list to store
	private ArrayList<Assign> assignDataList = new ArrayList<>();

	@Override
	public boolean addAssign(Assign assign) {

		if(assign != null) {
			assignDataList.add(assign);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Assign getAssignByID(int id) {

		for(Assign obj : assignDataList) {

			if(1==id) {
				return obj;
			}
			else {
				return new Assign();
			}
		}

		return new Assign();
	}

	@Override
	public ArrayList<Assign> getAllAssigns() {

		if(!assignDataList.isEmpty()) {

			return assignDataList;
		}
		else {

			return null;
		}
	}

	@Override
	public boolean updateAssign(int id, Assign assign) {

		for(Assign obj : assignDataList) {

			if(1==id) {

				obj = assign;
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean deleteAssign(int id) {

		for(Assign obj : assignDataList) {

			if(1==id) {

				assignDataList.remove(obj);
				return true;
			}
		}

		return false;
	}

}
