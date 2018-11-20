
public class DollarFormat {
	/**
	 * Displays amount in dollars and cents notation. Rounds after two decimal
	 * places. Does not advance to the next line after output.
	 * 
	 * Source: Walter Savitch - Java an Introduction to Programming and Problem
	 * Solving Modified by: Walter Stock
	 */
	public static void write(double amount) {
		if (amount >= 0) {
			System.out.print("$");
			writePositive(amount);
		} else {
			double positiveAmount = -amount;
			System.out.print("$");
			System.out.print("-");
			writePositive(positiveAmount);
		}
	}

	/**
	 * Returns amount in dollars and cents notation. Rounds after two decimal
	 * places. Does not advance to the next line after output.
	 * 
	 * Created by: Walter Stock based on write method
	 */
	public static String returnString(double amount) {
		String formattedValue = "";
		if (amount >= 0) {
			formattedValue = "$";
			formattedValue = returnPositiveString(amount, formattedValue);
		} else {
			double positiveAmount = -amount;
			formattedValue = "$-";
			formattedValue = returnPositiveString(positiveAmount, formattedValue);
		}
		return formattedValue;
	}

	// Precondition: amount >= 0;
	// Displays amount in dollars and cents notation. Rounds
	// after two decimal places. Omits the dollar sign.
	private static void writePositive(double amount) {
		int allCents = (int) (Math.round(amount * 100));
		int dollars = allCents / 100;
		int cents = allCents % 100;
		System.out.print(dollars);
		System.out.print('.');

		if (cents < 10)
			System.out.print('0');
		System.out.print(cents);
	}

	private static String returnPositiveString(double amount, String formattedValue) {
		// String formattedValue = "";
		int allCents = (int) (Math.round(amount * 100));
		int dollars = allCents / 100;
		int cents = allCents % 100;

		formattedValue = formattedValue + Integer.toString(dollars) + ".";

		if (cents < 10)
			formattedValue = formattedValue + "0";
		formattedValue = formattedValue + Integer.toString(cents);
		return formattedValue;
	}

	/**
	 * Displays amount in dollars and cents notation. Rounds after two decimal
	 * points. Advances to the next line after output.
	 */
	public static void writeln(double amount) {
		write(amount);
		System.out.println();
	}
}