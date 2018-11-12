import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingList {

	/**
	 * Class for lists of items that can be prioritized and purchased.
	 * 
	 * @author Walter Stock
	 *
	 */

	// declaring variables
	private ArrayList<ShoppingListProduct> shoppingListProduct;

	// Constructors

	public ShoppingList() {
		shoppingListProduct = new ArrayList<ShoppingListProduct>(20);
		shoppingListInterface();
	}

	public void shoppingListInterface() {
		Scanner keyboard = new Scanner(System.in);
		String inputValue = new String();

		// using a do loop b/c this will always execute once
		do {
			System.out.println("Welcome to Shopping List.  Enter one of the following:");
			System.out.println("A - to add an item to your list");
			System.out.println("R - to remove an item from your list");
			System.out.println("U - to update a list item's priority");
			System.out.println("O - to order/sort your list by priority");
			System.out.println("M - to order/sort your list by priority using Merge sort");
			System.out.println("D - to display your list");
			System.out.println("P - to get prices");
			System.out.println("S - to go shopping");
			System.out.println("T - to test");
			System.out.println("X - to exit this list");

			inputValue = keyboard.nextLine();

			switch (inputValue.toUpperCase()) {

			case "A":// add an item to a list
				break;
			case "R":// remove an item to a list
				// myList.removeListItem();
				break;
			case "U":// update list
				// myList.updateListItemPriority();
				break;
			case "D":// display list
				// myList.displayList();
				break;
			case "O":// order/sort list
				// myList.sortList();
				break;
			case "M":// order/sort list
				// myList.sortListMerge();
				break;
			case "P":// get prices
				// myList.priceItems();
				break;
			case "S":// go shopping
				// myList.goShopping();
				break;
			case "T":// test
				// myList.test();
				break;
			case "X":// exit
				break;
			default:
				System.out.println();
			}

			// X is used to exit the program.
		} while (!inputValue.equalsIgnoreCase("X"));
		// keyboard.close();

	}

}
