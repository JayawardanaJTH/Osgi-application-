package assignpublisher;

import java.util.ArrayList;

public interface IAssign {

	/**
	 * add new assign object to array list
	 * @param assign
	 * @return boolean value
	 */
	public boolean addAssign(Assign assign);
	
	/**
	 * get assign data according to id
	 * @param id
	 * @return assign object related to id
	 */
	public Assign getAssignByID(int id);
	
	/**
	 * get all assign data
	 * @return all data
	 */
	public ArrayList<Assign> getAllAssigns();
	
	/**
	 * update stored assign object
	 * @param id
	 * @param assign
	 * @return boolean value
	 */
	public boolean updateAssign(int id, Assign assign);
	
	/**
	 * delete assign object related to id
	 * @param id
	 * @return boolean value
	 */
	public boolean deleteAssign(int id);
}
