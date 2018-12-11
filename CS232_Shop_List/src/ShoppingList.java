import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

/**
 * Class for lists of items that can be prioritized and purchased.
 * 
 * @author Walter Stock
 *
 */

public class ShoppingList extends ListBase implements Serializable {

	// declaring variables
	private ArrayList<ShoppingListProduct> shoppingListArray;

	// constructors
	public ShoppingList() {
		shoppingListArray = new ArrayList<ShoppingListProduct>(20);
	}

	// setters
	public void setListID() {
		super.setListID();
	}

	public void setListName(String newName) {
		super.setListName(newName);
	}

	public void setShoppingListArray(ArrayList<ShoppingListProduct> newShoppingListArray) {
		shoppingListArray = newShoppingListArray;
	}

	// getters
	public int getListID() {
		return super.getListID();
	}

	public String getListName() {
		return super.getListName();
	}

	public ArrayList getShoppingListArray() {
		return this.shoppingListArray;
	}

	// equals
	public boolean equals(Object otherObject) {
		// Well designed equals method that overrides Java's base objects equals method
		// and checks that the passed object is a ShoppingList.
		boolean isEqual = false;
		if ((otherObject != null) && (otherObject instanceof ShoppingList)) {
			ShoppingList otherShoppingList = (ShoppingList) otherObject;
			isEqual = this.getListID() == otherShoppingList.getListID();
		}

		return isEqual;
	}

	public void addItem(ShoppingListProduct shoppingListProduct) {
		this.shoppingListArray.add(shoppingListProduct);
	}

	public void addItem(Product product, int itemQuantity, String units, int itemPriority) {

		ShoppingListProduct shoppingListProduct = new ShoppingListProduct(product, itemQuantity, units, itemPriority);

		this.shoppingListArray.add(shoppingListProduct);
	}

	public void addItem(Product product, int itemQuantity, String units, int itemPriority, boolean purchased) {

		ShoppingListProduct shoppingListProduct = new ShoppingListProduct(product, itemQuantity, units, itemPriority, purchased);

		this.shoppingListArray.add(shoppingListProduct);
	}


	public void removeItem(String productName, int productPriority) {
		int itemLocation = this.getProductLocation(productName, productPriority);
		if (itemLocation >= 0) {
			this.shoppingListArray.remove(itemLocation);
			System.out.println("The product has been successfully removed from the list");
		} else {
			System.out.println("A list item matching the criteria could not be found.");
		}
	}

	public void updateItemPriority(String productName, int productPriority, int newPriority) {
		int itemLocation = this.getProductLocation(productName, productPriority);
		if (itemLocation >= 0) {
			this.shoppingListArray.get(itemLocation).setPriority(newPriority);
			System.out.println("The list item's priority has been updated.");
		} else {
			System.out.println("A list item matching the criteria could not be found.");
		}
	}

	public int getProductLocation(String productName, int productPriority) {
		int itemLocation = -1;
		for (int index = 0; index < this.shoppingListArray.size(); index++) {
			if (Tester.testing == "Y") {
				System.out.println("TESTING - index " + index + " has a product and priority of: "
						+ this.shoppingListArray.get(index).getProduct().getProductName()
						+ this.shoppingListArray.get(index).getPriority());
			}
			if (this.shoppingListArray.get(index).getProduct().getProductName().equals(productName)
					&& this.shoppingListArray.get(index).getPriority() == productPriority) {
				itemLocation = index;
				if (Tester.testing == "Y") {
					System.out.println("TESTING - itemLocation set to: " + itemLocation);
				}
			}
		}
		return itemLocation;
	}

}