
/**
 * An interface for Purchasable objects. purchasable objects are required to
 * have setter and getter methods for Price and Purchased.
 * 
 * @author Walter Stock
 *
 */
public interface Purchasable {

	// setters
	public void setPriority(int newPriority);

	public void setPrice(double newPrice);

	public void setPurchased(boolean newPurchased);

	// getters
	public int getPriority();

	public double getPrice();

	public boolean getPurchased();

}