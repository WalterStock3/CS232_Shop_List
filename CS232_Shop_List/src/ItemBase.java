/**
 * Base abstract class for list items. Products are a child class. All list items in
 * this application must have an equals method. The equals method can vary based
 * on the type of list item, e.g. a product or task.
 * 
 * @author Walter Stock
 *
 */

public abstract class ItemBase {

	private String itemName;

	public abstract boolean equals();

	public void setItemName(String newName) {
		itemName = newName;
	}

	public String getItemName() {
		return itemName;
	}

}
