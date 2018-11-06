
public class Helper {

	public static boolean checkStringCharacters(String checkString, String checkType)
	/**
	 * Uses a for loop to check each character of a string.
	 * checkType can be used to specify what you would like to check.
	 * returns boolean True if found and False if not found.
	 */
	{
		boolean foundIndicator = false;
		switch (checkType.toUpperCase()) {
		case "INTEGER":
		// Check all of the characters
		for (int x = 0; x < checkString.length(); x++) {
			String checkChar = checkString.substring(x, x + 1);
			if (checkChar.matches("[a-z]") | checkChar.matches("[A-Z]")) {			
			}

		}

		}
		return foundIndicator;
	}

}
