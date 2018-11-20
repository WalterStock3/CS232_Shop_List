import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

/**
 * Class for lists of items that can be prioritized and purchased.
 * 
 * @author Walter Stock
 *
 */

public class ShoppingList implements Serializable {

	// declaring variables
	private int listItemKey = 0;
	private ArrayList<ShoppingListProduct> shoppingList;

	public ShoppingList() {
		shoppingList = new ArrayList<ShoppingListProduct>(20);
	}

	public ArrayList getShoppingList() {
		return this.shoppingList;
	}

	public void setShoppingList(ArrayList<ShoppingListProduct> newShoppingList) {
		this.shoppingList = newShoppingList;
	}

	public boolean equals(Object otherObject) {
		// Well designed equals method that overrides Java's base objects equals method
		// and checks that the passed object is a ShoppingList.
		boolean isEqual = false;
		if ((otherObject != null) && (otherObject instanceof ShoppingList)) {
			ShoppingList otherShoppingList = (ShoppingList) otherObject;
			isEqual = this.shoppingList == otherShoppingList.getShoppingList();
		}

		return isEqual;
	}

	public void addItem(Product product, int itemQuantity, int itemPriority) {

		if (Tester.testing == "Y") {
			System.out.println();
			System.out.println(
					"TESTING - About to add an item to the shopping list by creating a new shopping list item.");
			System.out.println();
		}

		ShoppingListProduct shoppingListProduct = new ShoppingListProduct(listItemKey, product, itemQuantity,
				itemPriority);
		listItemKey++;

		if (Tester.testing == "Y") {
			System.out.println();
			System.out.println("TESTING - shoppingListProduct created: \n" + shoppingListProduct.toString());
			System.out.println();
		}

		shoppingList.add(shoppingListProduct);

	}

	public void removeItem(int index) {
		this.shoppingList.remove(index);
	}

	public void removeItem(String productName, int productPriority) {
		int itemLocation = this.getProductLocation(productName, productPriority);
		if (itemLocation >= 0) {
			this.shoppingList.remove(itemLocation);
			System.out.println("The product has been successfully removed from the list");
		} else {
			System.out.println("A list item matching the criteria could not be found.");
		}
	}

	public void updateItemPriority(String productName, int productPriority, int newPriority) {
		int itemLocation = this.getProductLocation(productName, productPriority);
		if (itemLocation >= 0) {
			this.shoppingList.get(itemLocation).setPriority(newPriority);
			System.out.println("The list item's priority has been updated.");
		} else {
			System.out.println("A list item matching the criteria could not be found.");
		}
	}

	public int getProductLocation(String productName, int productPriority) {
		int itemLocation = -1;
		for (int index = 0; index < this.shoppingList.size(); index++) {
			if (Tester.testing == "Y") {
				System.out.println("TESTING - index " + index + " has a product and priority of: "
						+ this.shoppingList.get(index).getProduct().getProductName()
						+ this.shoppingList.get(index).getPriority());
			}
			if (this.shoppingList.get(index).getProduct().getProductName().equals(productName)
					&& this.shoppingList.get(index).getPriority() == productPriority) {
				itemLocation = index;
				if (Tester.testing == "Y") {
					System.out.println("TESTING - itemLocation set to: " + itemLocation);
				}
			}
		}
		return itemLocation;
	}

}