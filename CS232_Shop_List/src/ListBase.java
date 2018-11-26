/**
 * Base abstract class for a list.
 * 
 * Similar to list items and list items instances all lists are required to have
 * an equals method.
 * 
 * The equals method may vary based on the type of list, e.g. Shopping List or
 * To Do List.
 * 
 * @author Walter Stock
 *
 */
public abstract class ListBase {

	private int listID = -1;
	private String listName = "UnNamedList";

	public abstract boolean equals(Object otherObject);

	public void setListID() {
		if (this.listID == -1) {
			this.listID = Semaphore.getListID();
		} else {
			System.out.println("Changing a List ID is now allowed.");
		}
	}

	public void setListName(String newName) {
		listName = newName;
	}

	public int getListID() {
		return this.listID;
	}

	public String getListName() {
		return this.listName;
	}

}
