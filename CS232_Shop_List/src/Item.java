/**
 * Abstract class for items. Products are a child class.
 * 
 * @author Walter Stock
 *
 */
public abstract class Item {
	private String itemName;

	public Item() {
		itemName = "Unused Product Location";
	}

	public Item(String initName) {
		itemName = initName;
	}

	public void setItemName(String newName) {
		itemName = newName;
	}

	public String getItemName() {
		return itemName;
	}
	
	// equals method - covered in chapter 5
	// equalsName checks name only and is used to prevent list duplicates
	public boolean equalsName(Item otherItem) {
		return this.itemName.equalsIgnoreCase(otherItem.itemName);
	}
}
