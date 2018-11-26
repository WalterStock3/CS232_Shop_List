/**
 * Base abstract class for list items. Products are a child class. All list
 * items in this application must have an equals method. The equals method can
 * vary based on the type of list item, e.g. a product or task.
 * 
 * @author Walter Stock
 *
 */

public abstract class ItemBase {

	private int itemID = -1;
	private String itemName = "UnNamedItem";

	public abstract boolean equals(Object otherObject);

	// setters
	public void setItemID() {
		if (this.itemID == -1) {
			this.itemID = Semaphore.getItemID();
		}
		else {
			System.out.println("Changing an Item ID is now allowed.");
		}
	}

	public void setItemName(String newName) {
		this.itemName = newName;
	}

	// getters
	public int getItemID() {
		return itemID;
	}

	public String getItemName() {
		return itemName;
	}

}
