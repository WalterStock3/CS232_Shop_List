/**
 * Abstract class for items. Products are a child class.
 * 
 * @author Walter Stock
 *
 */
public abstract class Item {
	private String itemName;

	public Item() {
		itemName = "NoNameYet";
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
	
	public boolean equals(Item otherItem) {
		return this.itemName.equalsIgnoreCase(otherItem.itemName);
	}
}
