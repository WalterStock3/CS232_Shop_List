import java.util.Scanner;

/**
 * @author Walter Stock
 *
 */
public class HelperConsoleInput {

	public static int getConsoleInt(Scanner keyboard) {

		while (!keyboard.hasNextInt()) {
			System.out.println("Please enter an integer.");
			keyboard.nextLine();

		}
		int num = keyboard.nextInt();

		return num;
	}

}
