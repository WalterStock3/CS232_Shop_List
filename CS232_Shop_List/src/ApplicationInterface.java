import java.util.Scanner;

import java.io.PrintWriter;
import java.io.FileNotFoundException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * User interface class.
 * 
 * This class is for the user interface The user interface also controls most of
 * the flow of the application.
 * 
 * @author Walter Stock
 *
 */
public class ApplicationInterface {

	public void startInterface() {
		Scanner keyboard = new Scanner(System.in);
		String inputValue = new String();

		UserList userList = new UserList();

		// UserList userList = startInterfaceLoadUsers();

		System.out.println("Application loaded with " + userList.getUserList().size() + " existing user records. \n");

		do {
			System.out.println("Welcome to Shopping List enter one of the following:");
			System.out.println("N - to setup a new user");
			System.out.println("O - to open an existing user");
			// System.out.println("D - to delete a user");
			System.out.println("X - to exit the application");
			System.out.println("T - to turn on testing");

			inputValue = keyboard.nextLine();

			switch (inputValue.toUpperCase()) {

			case "N":
				startInterfaceNewUser(userList);
				break;

			case "O":
				startInterfaceOpenUser(userList);
				break;

			case "T":
				startInterfaceTestInterface();
				break;

			default:
				System.out.println();
			}

			// X is used to exit the program.
		} while (!inputValue.equalsIgnoreCase("X"));

		startInterfaceSaveUsers(userList);
		keyboard.close();

	}

	public void startInterfaceSaveUsers(UserList userList) {
		// PrintWriter outputStream = null;
		ObjectOutputStream outputStream = null;
		String fileName = "ShoppingList.records";

		try {
			// outputStream = new PrintWriter(fileName);
			outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
		} catch (IOException e) {// FileNotFoundException e) {
			System.out.println("Error opening output file :" + fileName);
			System.exit(0);
		}

		try {
			outputStream.writeObject(userList);
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Error writing to file :" + fileName);
		}
		System.out.println(fileName + " saved successfully.\n");
	}

	public UserList startInterfaceLoadUsers() {

		String fileName = "ShoppingList.records";

		ObjectInputStream inputStream = null;

		try {
			inputStream = new ObjectInputStream(new FileInputStream(fileName));
		} catch (IOException e) {
			System.out.println("Error opening input file " + fileName);
			System.out.println("A new ShoppingList file will be created.");
			UserList userList = new UserList();
			return userList;
			// System.exit(0);
		}
		UserList userList = null;
		try {
			userList = (UserList) inputStream.readObject();
			inputStream.close();
		} catch (Exception e) {
			System.out.println("Error reading from file " + fileName);
		}
		return userList;
	}

	public void startInterfaceNewUser(UserList userList) {

		Scanner keyboard = new Scanner(System.in);
		String inputName = new String();

		System.out.println("Enter your name:");
		try {
			inputName = keyboard.nextLine();
			for (int i = 0; i < inputName.length(); i++) {
				String inputNameChar = inputName.substring(i, i + 1);

//				System.out.println("The character to check: " + checkChar);

				if (inputNameChar.matches("[1-9]")) {
					throw new ExceptionNumericNotAllowed("Numbers are not allowed in names.\n");
				}

				// each user has a shopping list and product list

			}
			Person user = new Person(inputName);
			userList.addUser(user);
			shoppingListInterface(user);

		} catch (ExceptionNumericNotAllowed e) {
			System.out.println(e.getMessage());
			startInterface();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Try again.\n");
			startInterface();
		}

	}

	public void startInterfaceOpenUser(UserList userList) {
		Scanner keyboard = new Scanner(System.in);
		String inputName = new String();
		Person user = new Person();
		boolean found = false;

		do {

			System.out.println("Enter user's name from saved list:");

			int listSize = userList.getUserList().size();

			for (int position = 0; position < listSize; position++) {
				user = (Person) userList.getUserList().get(position);
				System.out.println(user.getPersonName());
			}

			System.out.println("Enter user name or X to exit Open User:");
			inputName = keyboard.nextLine();

			if (Tester.testing == "Y") {
				System.out.println(
						"\n TESTGING - User location returned from user list: " + userList.getUserLocation(inputName));
			}
			if (userList.getUserLocation(inputName) >= 0) {
				found = true;
				user = userList.getUser(userList.getUserLocation(inputName));
				shoppingListInterface(user);
			}
		} while (!found && !inputName.toUpperCase().equals("X"));

		/**
		 * Deprecated - saving is now completed on open and save. fileName = inputName +
		 * ".records";
		 * 
		 * ObjectInputStream inputStream = null;
		 * 
		 * try { inputStream = new ObjectInputStream(new FileInputStream(inputName +
		 * ".records")); } catch (IOException e) { System.out.println("Error opening
		 * input file " + inputName + ".records"); System.exit(0); } Person user = null;
		 * try { user = (Person) inputStream.readObject(); inputStream.close(); } catch
		 * (Exception e) { System.out.println("Error reading from file " + fileName); }
		 * shoppingListInterface(user);
		 */
	}

	public void startInterfaceTestInterface() {
		shoppingListInterfaceTestInterface();
	}

	public void shoppingListInterface(Person user) {
		Scanner keyboard = new Scanner(System.in);
		String inputValue = new String();

		// using a do loop b/c this will always execute once
		do {
			System.out.println("Welcome to Shopping List.  Enter one of the following:");
			System.out.println("A - to add an item to your list");
			System.out.println("R - to remove an item from your list");
			System.out.println("U - to update a list item's priority");
			System.out.println("O - to order/sort your list by priority");
			System.out.println("D - to display your list");
			System.out.println("P - to get prices");
			System.out.println("S - to go shopping");
			System.out.println("SV - to save your list to a text file.");
			System.out.println("T - to test");
			System.out.println("X - to exit this list");

			inputValue = keyboard.nextLine();

			switch (inputValue.toUpperCase()) {

			case "A":// add an item to a list
				shoppingListInterfaceAddItem(user);
				break;

			case "R":// remove an item to a list
				shoppingListInterfaceRemoveItem(user);
				break;

			case "U":// update list
				shoppingListInterfaceUpdatePriority(user);
				break;

			case "O":// order/sort list
				shoppingListInterfaceSort(user);
				break;

			case "D":// display list
				shoppingListInterfaceDisplayList(user, false);
				break;

			case "P":// get prices
				shoppingListInterfaceSetPrices(user);
				break;

			case "S":// go shopping
				shoppingListInterfaceGoShopping(user);
				break;

			case "SV":// save to text
				shoppingListInterfaceSaveText(user);

			case "T":// test
				shoppingListInterfaceTestInterface();
				break;

			// deprecated case - saving occurs at close
			// case "SV":// save
			// shoppingListInterfaceSaveToFile(user);
			// break;

			case "X":// exit
				System.out.println("Exiting");
				break;
			default:
				System.out.println();
			}
			// X is used to exit the program.
		} while (!inputValue.equalsIgnoreCase("X"));
	}

	public void shoppingListInterfaceAddItem(Person user) {
		Scanner keyboard = new Scanner(System.in);
		String inputValue = new String();
		String itemName = "NoNameYet";
		int itemQuantity = -1;
		String units = "NoUnitsYet";
		int itemPriority = -1;

		System.out.println("Enter the item's name:");
		itemName = keyboard.nextLine();

		System.out.println("Enter the quantity:");
		itemQuantity = keyboard.nextInt();

		System.out.println("Enter the units of the quanity:");
		keyboard.nextLine();
		units = keyboard.nextLine();

		System.out.println("Enter the priority:");
		itemPriority = keyboard.nextInt();

		Product product = new Product(itemName);
		user.getProductList().addProduct(product);

		user.getShoppingList().addItem(product, itemQuantity, units, itemPriority);

		if (Tester.testing == "Y") {
			System.out.println("\n TESTING - Size of the shopping list array after adding item: "
					+ user.getShoppingList().getShoppingListArray().size() + "\n");
		}
	}

	public void shoppingListInterfaceRemoveItem(Person user) {
		Scanner keyboard = new Scanner(System.in);
		String productName = new String();
		int productPriority = -1;

		System.out.println("Enter the item's name:");
		productName = keyboard.nextLine();

		System.out.println("Enter the priority of the instance to remove:");
		productPriority = keyboard.nextInt();

		user.getShoppingList().removeItem(productName, productPriority);

		System.out.println("The product has been successfully removed from the list");
	}

	public void shoppingListInterfaceUpdatePriority(Person user) {
		Scanner keyboard = new Scanner(System.in);
		String productName = new String();
		int productPriority = -1;
		int newPriority = -1;

		System.out.println("Enter the item's name:");
		productName = keyboard.nextLine();

		System.out.println("Enter the priority of the instance to update:");
		productPriority = keyboard.nextInt();

		System.out.println("Enter a new item priority:");
		newPriority = keyboard.nextInt();

		user.getShoppingList().updateItemPriority(productName, productPriority, newPriority);

		// int itemPriorityInt = Integer.parseInt(itemPriority);

		// this.listItem[itemLocation].setItemPriority(itemPriorityInt);

		// System.out.println("The item's priority has been updated.");
	}

	public void shoppingListInterfaceDisplayList(Person user, Boolean showPurchased) {

		ShoppingList shoppingList = user.getShoppingList();
		ShoppingListProduct shoppingListProduct;

		String product = "";
		String space1 = "";
		String quantity = "";
		String space2 = "";
		String priority = "";
		String space3 = "";
		String price = "";
		String space4 = "";
		String purchased = "";

		System.out.println("\nYour List");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("Product                           Quantity    Priority    Price         Purchased");
		System.out.println("------------------------------    --------    --------    ----------    ----------");

		if (Tester.testing == "Y") {
			System.out.println("\n TESTING - shopping list array size: "
					+ user.getShoppingList().getShoppingListArray().size() + "\n");
		}

		for (int index = 0; index < shoppingList.getShoppingListArray().size(); index++) {

			shoppingListProduct = (ShoppingListProduct) shoppingList.getShoppingListArray().get(index);

			if (shoppingListProduct.getPurchased() == false || showPurchased == true) {

				product = " " + shoppingListProduct.getProduct().getProductName();
				quantity = Integer.toString(shoppingListProduct.getQuantity());
				priority = Integer.toString(shoppingListProduct.getPriority());
				if (shoppingListProduct.getPrice() > 0.0) {
					price = DollarFormat.returnString(shoppingListProduct.getPrice());
				} else {
					price = "";
				}
				if (shoppingListProduct.getPurchased())
					purchased = "Yes";
				else
					purchased = "No";

				// spaces are dependent on items populated above
				// when left justified include the size of the item in the previous space
				// when right justified include the size of the item in the following space
				space1 = createSpace(41 - product.length() - quantity.length()); // quantity is left justified
				space2 = createSpace(12 - priority.length()); // priority is left justified
				space3 = createSpace(14 - price.length());
				space4 = createSpace(13 - purchased.length());

				System.out
						.println(product + space1 + quantity + space2 + priority + space3 + price + space4 + purchased);

			}
		}
		System.out.println();

	}

	public void shoppingListInterfaceSort(Person user) {
		if (Tester.testing == "Y") {
			System.out.println("\n TESTING - about to enter MergeSort\n");
		}
		MergeSort.sort(user.getShoppingList());

	}

	public void shoppingListInterfaceSetPrices(Person user) {
		Double priceTotal = 0.0;
		while (priceTotal < 100) {
			for (int index = 0; index < user.getShoppingList().getShoppingListArray().size(); index++) {
				ShoppingListProduct product = (ShoppingListProduct) user.getShoppingList().getShoppingListArray()
						.get(index);
				double price = product.getPrice();
				if (price == -1.0) {
					price = (Math.random() * 12500);
					price = price / 100;
					product.setPrice(price);
				}
			}
			for (int index = 0; index < user.getShoppingList().getShoppingListArray().size(); index++) {
				ShoppingListProduct product = (ShoppingListProduct) user.getShoppingList().getShoppingListArray()
						.get(index);
				double price = product.getPrice();
				if (price != -1.0) {
					priceTotal = priceTotal + product.getPrice();
					// System.out.println(priceTotal);
				}
			}
		}

	}

	public void shoppingListInterfaceGoShopping(Person user) {
		Scanner keyboard = new Scanner(System.in);
		Double bankAccount = 0.0;

		System.out.println("Enter your budget:");

		try {
			bankAccount = keyboard.nextDouble();
			if (bankAccount < 0) {
				throw new ExceptionNegativeNotAllowed("Negative budget is not allowed.  Please try again.\n");
			}
		} catch (ExceptionNegativeNotAllowed e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Try again.\n");
		}

		System.out.println("\nSorting and getting prices for any unpriced products.\n");
		shoppingListInterfaceSort(user);
		shoppingListInterfaceSetPrices(user);
		System.out.println("These are the items that you can purchase.");

		//Partial Fill algorithm
		//Check for identical priority
		//buy one and then two and so on for both, if possible.
		//split out the remainder
		for (int index = 0; index < user.getShoppingList().getShoppingListArray().size(); index++) {

			ShoppingListProduct shoppingListProduct = (ShoppingListProduct) user.getShoppingList()
					.getShoppingListArray().get(index);

			if (shoppingListProduct.getPurchased() != true
					&& shoppingListProduct.getPrice() * shoppingListProduct.getQuantity() <= bankAccount) {
				bankAccount = bankAccount - (shoppingListProduct.getPrice() * shoppingListProduct.getQuantity());
				shoppingListProduct.setPurchased(true);

			}
		}
		this.shoppingListInterfaceDisplayList(user, true);

	}

	public void shoppingListInterfaceSaveText(Person user) {
		PrintWriter outputStream = null;
		String fileName = user.getPersonName() + ".txt";

		ShoppingList shoppingList = user.getShoppingList();
		ShoppingListProduct shoppingListProduct;

		String product = "";
		String space1 = "";
		String quantity = "";
		String space2 = "";
		String priority = "";
		String space3 = "";
		String price = "";
		String space4 = "";
		String purchased = "";

		try {
			outputStream = new PrintWriter(fileName);
		} catch (IOException e) {// FileNotFoundException e) {
			System.out.println("Error opening output file :" + fileName);
			System.exit(0);
		}

		try {
			outputStream.println("\nYour List");
			outputStream.println("----------------------------------------------------------------------------------");
			outputStream.println("Product                           Quantity    Priority    Price         Purchased");
			outputStream.println("------------------------------    --------    --------    ----------    ----------");

			if (Tester.testing == "Y") {
				System.out.println("\n TESTING - shopping list array size: "
						+ user.getShoppingList().getShoppingListArray().size() + "\n");
			}

			for (int index = 0; index < shoppingList.getShoppingListArray().size(); index++) {

				shoppingListProduct = (ShoppingListProduct) shoppingList.getShoppingListArray().get(index);

				product = " " + shoppingListProduct.getProduct().getProductName();
				quantity = Integer.toString(shoppingListProduct.getQuantity());
				priority = Integer.toString(shoppingListProduct.getPriority());
				if (shoppingListProduct.getPrice() > 0.0) {
					price = DollarFormat.returnString(shoppingListProduct.getPrice());
				} else {
					price = "";
				}
				if (shoppingListProduct.getPurchased())
					purchased = "Yes";
				else
					purchased = "No";

				// spaces are dependent on items populated above
				// when left justified include the size of the item in the previous space
				// when right justified include the size of the item in the following space
				space1 = createSpace(41 - product.length() - quantity.length()); // quantity is left justified
				space2 = createSpace(12 - priority.length()); // priority is left justified
				space3 = createSpace(14 - price.length());
				space4 = createSpace(13 - purchased.length());

				outputStream
						.println(product + space1 + quantity + space2 + priority + space3 + price + space4 + purchased);

			}

			System.out.println(fileName + " saved successfully.\n");
		} catch (Exception e) {
			System.out.println("Error writing to file :" + fileName);
		}

		outputStream.close();

	}

	public void shoppingListInterfaceTestInterface() {
		Scanner keyboard = new Scanner(System.in);
		String inputValueTesting = new String();
		do {
			System.out.println("Here are your testing options:");
			System.out.println("ON - to turn on testing");
			System.out.println("OFF - to turn off testing");
			System.out.println("X - to exist testing");

			inputValueTesting = keyboard.nextLine();

			switch (inputValueTesting.toUpperCase()) {
			case "ON":
				Tester.testing = "Y";
				System.out.println("Testing mode is turned on.");
				break;
			case "OFF":
				Tester.testing = "N";
				System.out.println("Testing mode is turned off.");
				break;
			default:
				System.out.println();
			}
		} while (!inputValueTesting.equalsIgnoreCase("X"));
	}

	public void deprecated_shoppingListInterfaceSaveToFile(Person user) {

		// PrintWriter outputStream = null;
		ObjectOutputStream outputStream = null;
		String fileName = user.getPersonName() + ".records";

		try {
			// outputStream = new PrintWriter(fileName);
			outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
		} catch (IOException e) {// FileNotFoundException e) {
			System.out.println("Error opening output file :" + fileName);
			System.exit(0);
		}

		try {
			outputStream.writeObject(user);
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Error writing to file :" + fileName);
		}
		System.out.println(fileName + " saved successfully.\n");
	}

	private String createSpace(int space) {
		// This method is used to create space when printing the report.

		String spaceString = "";
		for (int x = 0; x < space; x++) {
			spaceString = spaceString + " ";
		}
		return spaceString;
	}

}