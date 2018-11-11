/**
 * Base abstract class for a list. 
 * 
 * Similar to list items and list items instances all lists are required to have an equals method.
 * 
 * The equals method may vary based on the type of list, e.g. Shopping List or To Do List.
 * 
 * @author Walter Stock
 *
 */
public abstract class ListBase {

	private String listName;

	public abstract void equals();

	public void setListName(String newName) {
		listName = newName;
	}

	public String getListName() {
		return listName;
	}

	
}
