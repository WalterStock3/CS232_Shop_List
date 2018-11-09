/**
 * Base class for items. Products are a child class.
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

	public String toString() {
		//including to support polymorphism and dynamic binding by overriding system.out toString
		//it is a good idea to always supply a suitable toString method in an object for this
		//Walter Savitch, Java an Introduction to Programming - pg 620
		return "Item Name: " + itemName;
	}
	
	public boolean equals(Item otherItem) {
		return this.itemName.equalsIgnoreCase(otherItem.itemName);
	}
}
