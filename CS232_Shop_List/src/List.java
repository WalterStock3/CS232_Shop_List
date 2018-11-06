import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * Class for lists of items that can be prioritized and purchased.
 * 
 * @author Walter Stock
 *
 */
public class List {

	// declaring variables
	private String listName;
	private int listLength = 7;// best practice is to assign a constant
	//private Product[] listItem = new Product[listLength];
	private Purchasable[] listItem = new Product[listLength];
	
	// Constructors
	/**
	 * Default constructor.
	 * 
	 * @author Walter Stock
	 *
	 */
	public List() {
		listName = "NoNameYet";
		for (int index = 0; index < listItem.length; index++)// written to handle any array length.
		{
			// populating all items with defaults
			listItem[index] = new Product();
		}
	}

	/**
	 * Constructor with name specified.
	 * 
	 * @author Walter Stock
	 *
	 */
	public List(String initName) {
		listName = initName;
		for (int index = 0; index < listItem.length; index++)// written to handle any array length.
		{
			// populating all items with defaults
			listItem[index] = new Product();
		}
	}

	// Setters and Getter
	/**
	 * Adds item to list in first available location.
	 * 
	 * @author Walter Stock
	 *
	 */
	public void setListItem(Product newItem) {
		int openLocation = -1;
		openLocation = this.findOpenLocation();
		this.listItem[openLocation] = newItem;
	}

	/**
	 * Overloaded setListItem to include location.
	 * 
	 * @author Walter Stock
	 *
	 */
	public void setListItem(Product newItem, int itemLocation) {
		System.out.println("Location is: " + itemLocation);
		this.listItem[itemLocation] = newItem;
	}

	/**
	 * Gets item from the list.
	 * 
	 * @author Walter Stock
	 *
	 */
	public Purchasable getListItem(int index) {
		return listItem[index];
	}

	// Additional Methods
	/**
	 * Adds an items to the list.
	 * 
	 * @author Walter Stock
	 *
	 */
	public void addListItem() {
		// declaring and initializing variables
		Scanner keyboard = new Scanner(System.in);
		String itemName = "Unused Product Space";
		String itemPriority = "-1";
		Product myItem = new Product();
		boolean inputOK = true;// used to bypass insert

		System.out.println("Here is your current list.");
		this.displayList();
		// check to see if the list if full.
		if (this.findOpenLocation() == -1) {
			System.out.println("The list is full.  Please remove an item first.");
			System.out.println();

			// return;// this is an early exit
		} else {
			System.out.println("Enter the item name:");
			itemName = keyboard.nextLine();
			System.out.println("Enter a unique item priority integer between 1 and 100:");
			itemPriority = keyboard.nextLine();
			// STEP check unique name
			for (int index = 0; index < listItem.length; index++)// written to handle any array length.
			{
				// System.out.println("checking for name dupe");
				if (listItem[index].getItemName().equals(itemName)) {
					System.out.println("The name you entered is a duplicate and this is not allowed.");
					return;
				}
			}
			// STEP check priority value which must be unique and an integer between 0
			// and 10
			int itemPriorityInt = Integer.parseInt(itemPriority);
			for (int index = 0; index < listItem.length; index++)// written to handle any array length.
			{
				// System.out.println("checking for priority dupe");
				if (listItem[index].getItemPriority() == itemPriorityInt) {
					System.out.println("The priority you entered is a duplicate and this is not allowed.");
					return;
				}
			}
			if (inputOK = true) {
				myItem.setItemName(itemName);
				myItem.setItemPriority(itemPriorityInt);
				this.setListItem(myItem);
				System.out.println("Your item has been added to your list.");
			}
		}
	}

	/**
	 * Removes an item from the list.
	 * 
	 * @author Walter Stock
	 *
	 */
	public void removeListItem() {
		// declaring and initializing variables
		Scanner keyboard = new Scanner(System.in);
		String itemName = "NoNameYet";
		Product blankItem = new Product();

		System.out.println("Here is your current list.");
		this.displayList();

		System.out.println("Enter the name of the item you would like to remove:");
		itemName = keyboard.nextLine();
		int itemLocation = this.findItemLocation(itemName);

		this.setListItem(blankItem, itemLocation);
		// myItem.setItemName(itemName);
		// myItem.setItemPriority(itemPriorityInt);
		// this.setListItem(myItem);

		System.out.println("The item has been removed from your list.");
	}

	/**
	 * Updates priority of a list item.
	 * 
	 * @author Walter Stock
	 *
	 */
	public void updateListItemPriority() {
		Scanner keyboard = new Scanner(System.in);
		int itemLocation = -1;
		String itemName = "NoNameYet";
		String itemPriority = "-1";

		System.out.println("Here is your current list.");
		this.displayList();
		System.out.println("Enter an item's name to update its priority:");
		itemName = keyboard.nextLine();
		itemLocation = this.findItemLocation(itemName);

		System.out.println("Enter a unique item priority integer between 1 and 10:");
		itemPriority = keyboard.nextLine();
		// TBD STEP check priority value which must be unique and an integer between 0
		// and 10
		int itemPriorityInt = Integer.parseInt(itemPriority);

		this.listItem[itemLocation].setItemPriority(itemPriorityInt);

		// myItem.setItemName(itemName);
		// myItem.setItemPriority(itemPriorityInt);
		// this.setListItem(myItem);

		System.out.println("The item's priority has been updated.");
	}

	/**
	 * Displays list.
	 * 
	 * @author Walter Stock
	 *
	 */
	public void displayList() {
		System.out.println("Your List");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Product                              Priority    Price         Purchased");
		System.out.println("------------------------------    --------    ----------    ----------");
		for (int index = 0; index < listItem.length; index++)// written to handle any array length.
		{
			// Product
			System.out.print(listItem[index].getItemName());
			Integer integerObject = listItem[index].getItemPriority();
			String sp0 = createSpace(41 - listItem[index].getItemName().length() - integerObject.toString().length());
			System.out.print(sp0);

			// Priority
			int spaceAfterPriority = 0;
			if (listItem[index].getItemPriority() == -1) {
				System.out.print("");
				spaceAfterPriority = 2;
			} else {
				System.out.print(listItem[index].getItemPriority());
				Double doubleObject = listItem[index].getItemPrice();
				spaceAfterPriority = doubleObject.toString().length();
			}
			String sp1 = createSpace(14 - spaceAfterPriority);
			System.out.print(sp1);

			// Price
			int spaceAfterPrice = 0;
			if (listItem[index].getItemPrice() == -1) {
				System.out.print("");
				spaceAfterPrice = 12;
			} else {
				System.out.print(listItem[index].getItemPrice());
				spaceAfterPrice = 8;
			}
			String sp3 = createSpace(spaceAfterPrice);
			System.out.print(sp3);
			System.out.println(listItem[index].getItemPurchased());
		}
		System.out.println();// add a space
	}

	/**
	 * Order/Sort list.
	 * 
	 * @author Walter Stock
	 *
	 */
	public void sortList() {

		int priority = 101;
		int priorityIndex = -1;
		int sortToIndex = -1;
		boolean finished = false;
		Purchasable tempItem = new Product();
		while (sortToIndex + 1 < listItem.length && !finished) {
			// get priority item
			priority = 101;
			finished = true;
			for (int index = sortToIndex + 1; index < listItem.length; index++)// written to handle any array length.
			{
				if (listItem[index].getItemPriority() > 0 && listItem[index].getItemPriority() < priority) {
					priority = listItem[index].getItemPriority();
					priorityIndex = index;
					finished = false;
				}
			}
			// put the priority item first
			if (!finished) {
				tempItem = listItem[sortToIndex + 1];
				listItem[sortToIndex + 1] = listItem[priorityIndex];
				listItem[priorityIndex] = tempItem;
				sortToIndex = sortToIndex + 1;
			}
		}
	}

	/**
	 * Order/Sort list using Merge Sort
	 * 
	 * @author Walter Stock
	 *
	 */
	public void sortListMerge() {
		Product[] listItemTemp = new Product[listItem.length];
		splitOfMergeSort(0, listItem.length - 1, listItemTemp);
	}

	/**
	 * Splits the array for merge sort.
	 * 
	 * @author Walter Stock
	 *
	 */
	private void splitOfMergeSort(int startIndex, int endIndex, Product[] listItemTemp) {
		//System.out.println("Starting splitOfMergeSort. startIndex is: " + startIndex + " endIndex is: " + endIndex);
		//only do something if the start index is less than the end index.
		if (startIndex < endIndex) {
			// this is the mid of the section of the array that we are working with.
			int midIndex = startIndex + (endIndex - startIndex) / 2;
			splitOfMergeSort(startIndex, midIndex, listItemTemp);
			splitOfMergeSort(midIndex + 1, endIndex, listItemTemp);
			mergeSorted(startIndex, midIndex, endIndex, listItemTemp);
		}
	}

	/**
	 * Splits the array for merge sort.
	 * 
	 * @author Walter Stock
	 *
	 */
	private void mergeSorted(int startIndex, int midIndex, int endIndex, Purchasable[] listItemTemp) {
		//System.out.println("    Starting mergeSorted. startIndex is: " + startIndex + " midIndex is:" + midIndex
		//		+ " endIndex is: " + endIndex);
		for (int i = startIndex; i <= endIndex; i++) {
			// for (startIndex; startIndex <= endIndex; startIndex++) {
			// System.out.print(i+" "+listItem[i].getItemName()+", ");
			// System.out.print(i+", ");
			listItemTemp[i] = listItem[i];
		}
		int i = startIndex;
		int j = midIndex + 1;
		int k = startIndex;
		while (i <= midIndex && j <= endIndex) {
			//System.out.println("        Inside the compare loop and i is: " + i + " which has a value of: "
			//		+ listItemTemp[i].getItemPriority() + "and j is:" + j + " which has a value of: "
			//		+ listItemTemp[j].getItemPriority() + " and k is: " + k);
			// doing this until we reach the end of one of the sides.
			if (listItemTemp[i].getItemPriority() <= listItemTemp[j].getItemPriority()) {
				//System.out.println("            i was smaller; setting lcoation k ("+k+" to "+listItemTemp[i].getItemName());
				// left side is smaller
				listItem[k] = listItemTemp[i];
				i++;
			} else {
				//System.out.println("            j was smaller; setting location k ("+k+") to: "+listItemTemp[j].getItemName());
				// right side is smaller
				listItem[k] = listItemTemp[j];
				j++;
			}
			//this.displayList();
			k++;
		}
		while (i <= midIndex) {
			//if we moved one side then put the replaced side where the replacer came from.
			listItem[k] = listItemTemp[i];
			k++;
			i++;
			//this.displayList();
		}
	}

	/**
	 * Price Items
	 * 
	 * @author Walter Stock
	 *
	 */
	public void priceItems() {
		Double priceTotal = 0.0;
		while (priceTotal < 100) {
			for (int index = 0; index < listItem.length; index++)// written to handle any array length.
			{
				Double price = 0.0;
				if (listItem[index].getItemPrice() == -1 && listItem[index].getItemName() != "Unused Product Location") {
					price = (Math.random() * 125.0);
					price = (double) Math.round(price * 100.0);
					price = price / 100;
					listItem[index].setItemPrice(price);
				}
			}
			// check that prices > 100

			for (int index = 0; index < listItem.length; index++)// written to handle any array length.
			{
				if (listItem[index].getItemPrice() != -1 && listItem[index].getItemName() != "Unused Product Location") {
					priceTotal = priceTotal + listItem[index].getItemPrice();
					// System.out.println(priceTotal);
				}
			}
		}
	}

	/**
	 * Go Shopping.
	 * 
	 * @author Walter Stock
	 *
	 */
	public void goShopping() {
		double availableDollars = 59.0;
		this.sortList();
		this.priceItems();
		System.out.println("Here are your items sorted by priority with any unpriced items priced:");
		this.displayList();
		System.out.println("With $59 you can purchase these items.");
		for (int index = 0; index < listItem.length; index++)// written to handle any array length.
		{
			if (listItem[index].getItemPrice() != -1 && listItem[index].getItemPrice() < availableDollars
					&& listItem[index].getItemName() != "Unused Product Location") {
				listItem[index].setPurchased(true);
				availableDollars = availableDollars - listItem[index].getItemPrice();
			}

		}
//		this.displayList();
		System.out.println("These are the items that you purchased:");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Product                              Priority    Price         Purchased");
		System.out.println("------------------------------    --------    ----------    ----------");
		for (int index = 0; index < listItem.length; index++)// written to handle any array length.
		{
			if (listItem[index].getItemPurchased() == true) {// Product

				System.out.print(listItem[index].getItemName());
				Integer integerObject = listItem[index].getItemPriority();
				String sp0 = createSpace(
						41 - listItem[index].getItemName().length() - integerObject.toString().length());
				System.out.print(sp0);

				// Priority
				int spaceAfterPriority = 0;
				if (listItem[index].getItemPriority() == -1) {
					System.out.print("");
					spaceAfterPriority = 2;
				} else {
					System.out.print(listItem[index].getItemPriority());
					Double doubleObject = listItem[index].getItemPrice();
					spaceAfterPriority = doubleObject.toString().length();
				}
				String sp1 = createSpace(14 - spaceAfterPriority);
				System.out.print(sp1);

				// Price
				int spaceAfterPrice = 0;
				if (listItem[index].getItemPrice() == -1) {
					System.out.print("");
					spaceAfterPrice = 12;
				} else {
					System.out.print(listItem[index].getItemPrice());
					spaceAfterPrice = 8;
				}
				String sp3 = createSpace(spaceAfterPrice);
				System.out.print(sp3);
				System.out.println(listItem[index].getItemPurchased());
			}

		}
		System.out.println();// add a space
		System.out.println("These are the items that you did not purchase:");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Product                              Priority    Price         Purchased");
		System.out.println("------------------------------    --------    ----------    ----------");
		for (int index = 0; index < listItem.length; index++)// written to handle any array length.
		{
			if (listItem[index].getItemPurchased() == false) {// Product

				System.out.print(listItem[index].getItemName());
				Integer integerObject = listItem[index].getItemPriority();
				String sp0 = createSpace(
						41 - listItem[index].getItemName().length() - integerObject.toString().length());
				System.out.print(sp0);

				// Priority
				int spaceAfterPriority = 0;
				if (listItem[index].getItemPriority() == -1) {
					System.out.print("");
					spaceAfterPriority = 2;
				} else {
					System.out.print(listItem[index].getItemPriority());
					Double doubleObject = listItem[index].getItemPrice();
					spaceAfterPriority = doubleObject.toString().length();
				}
				String sp1 = createSpace(14 - spaceAfterPriority);
				System.out.print(sp1);

				// Price
				int spaceAfterPrice = 0;
				if (listItem[index].getItemPrice() == -1) {
					System.out.print("");
					spaceAfterPrice = 12;
				} else {
					System.out.print(listItem[index].getItemPrice());
					spaceAfterPrice = 8;
				}
				String sp3 = createSpace(spaceAfterPrice);
				System.out.print(sp3);
				System.out.println(listItem[index].getItemPurchased());
			}

		}
		System.out.println();// add a space
	}

	/**
	 * Test.
	 * 
	 * @author Walter Stock
	 *
	 */
	public void test() {
		listItem[0] = new Product("Test Product A", 99);
		listItem[1] = new Product("Test Product B", 15);
		listItem[2] = new Product("Test Product C", 11);
		listItem[3] = new Product("Test Product D", 2);
		listItem[4] = new Product("Test Product E", 92);
		listItem[5] = new Product("Test Product F", 44);
		listItem[6] = new Product("Test Product G", 55);

	}

	/**
	 * Returns an open location index or -1 to indicate that one is not available.
	 * 
	 * @author Walter Stock
	 *
	 */
	private int findOpenLocation() {
		int openLocation = -1;
		for (int index = 0; index < listItem.length; index++)// written to handle any array length.
		{
			if (listItem[index].getItemName() == "Unused Product Location" && openLocation == -1) {
				openLocation = index;
			}
		}
		return openLocation;
	}

	/**
	 * Returns an item's location index or -1 to indicate that the item wasn't
	 * found.
	 * 
	 * @author Walter Stock
	 *
	 */
	private int findItemLocation(String itemName) {
		int itemLocation = -1;
		for (int index = 0; index < listItem.length; index++)// written to handle any array length.
		{
			if (listItem[index].getItemName().equals(itemName)) {
				itemLocation = index;
			}
		}
		return itemLocation;
	}

	/**
	 * Creates space to format reports.
	 * 
	 * @author Walter Stock
	 *
	 */
	private String createSpace(int space) {
		// This method is used to create space when printing the report.

		String spaceString = "";
		for (int x = 0; x < space; x++) {
			spaceString = spaceString + " ";
		}
		return spaceString;
	}

}