import java.util.Scanner;

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

		do {
			System.out.println("Welcome to Shopping List Enter one of the following:");
			System.out.println("N - to setup a new user");
			System.out.println("O - to open an existing list");
			System.out.println("X - to exit the application");

			inputValue = keyboard.nextLine();

			switch (inputValue.toUpperCase()) {

			case "N":
				newUser();
				break;

			case "O":
				break;
			default:

				System.out.println();
			}

			// X is used to exit the program.
		} while (!inputValue.equalsIgnoreCase("X"));
		keyboard.close();

	}

	public void newUser() {

		Scanner newUserKeyboard = new Scanner(System.in);
		String inputName = new String();

		System.out.println("Enter your name:");
		inputName = newUserKeyboard.nextLine();

		Person user = new Person(inputName);
	}

}
