
/**
 * An interface for Purchasable objects. purchasable objects are required to
 * have setter and getter methods for Price and Purchased.
 * 
 * @author Walter Stock
 *
 */
public interface Purchasable {

//	public void setItemPrice(double newPrice);

//	public void setPurchased(boolean newPurchased);

//	public double getItemPrice();

//	public boolean getItemPurchased();

	// setters
	public void setItemName(String newName);

	public void setItemPriority(int newPriority);

	public void setItemPrice(double newPrice);

	public void setPurchased(boolean newPurchased);

	// getters
	public String getItemName();

	public int getItemPriority();

	public double getItemPrice();

	public boolean getItemPurchased();

	// equals method - covered in chapter 5
	// equalsName checks name only and is used to prevent list duplicates
//	public boolean equalsName(Item otherItem) {
//		return this.equalsName(otherItem);
//	}

}