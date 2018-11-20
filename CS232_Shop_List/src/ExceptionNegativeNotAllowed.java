/**
 * @author Walter Stock
 *
 */
public class ExceptionNegativeNotAllowed extends Exception {
	public ExceptionNegativeNotAllowed() {
		super("You entered a negative number and that is not allowed.");

	}

	public ExceptionNegativeNotAllowed(String message) {
		super(message);
	}
}
