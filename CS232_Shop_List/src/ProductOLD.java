/**
 * Class for products that can be prioritized and purchased and included in a
 * list. This class is a child class of Item.
 * 
 * @author Walter Stock
 *
 */
public class ProductOLD
{

	// declaring variables
	private String itemName;
	private Integer itemPriority;
	private Double itemPrice;
	private Boolean itemPurchased;

	// Constructors - constructors are covered in chapter 6
	// constructor 1 - default
	public ProductOLD() {
		super();
		// itemName = "Unused ProductOLD Location";
		itemPriority = -1;
		itemPrice = -1.0;
		itemPurchased = false;
	}

	// constructor 2 - name only
	public ProductOLD(String initName) {
		super(initName);
		itemPriority = -1;
		itemPrice = -1.0;
		itemPurchased = false;
	}

	// constructor 3 - name and priority
	public ProductOLD(String initName, int initPriority) {
		super(initName);
		itemPriority = initPriority;
		itemPrice = -1.0;
		itemPurchased = false;
	}

	// setters
	public void setItemName(String newName) {
		super.setItemName(newName);
	}

	public void setItemPriority(int newPriority) {
		itemPriority = newPriority;
	}

	public void setItemPrice(double newPrice) {
		itemPrice = newPrice;
	}

	public void setPurchased(boolean newPurchased) {
		itemPurchased = newPurchased;
	}

	// getters
	public String getItemName() {
		return super.getItemName();
	}

	public int getItemPriority() {
		return itemPriority;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public boolean getItemPurchased() {
		return itemPurchased;
	}

	// equals method - covered in chapter 5
	// equalsName checks name only and is used to prevent list duplicates
	public boolean equalsName(Item otherItem) {
		return this.equalsName(otherItem);
	}

}
