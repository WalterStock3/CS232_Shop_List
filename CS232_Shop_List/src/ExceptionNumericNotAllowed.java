/**
 * @author Walter Stock
 *
 */
public class ExceptionNumericNotAllowed extends Exception {
	public ExceptionNumericNotAllowed() {
		super("You entered a number and that is not allowed.");

	}

	public ExceptionNumericNotAllowed(String message) {
		super(message);
	}

}
