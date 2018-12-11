import java.io.Serializable;

/**
 * This class is an instance of a product in a shopping list.
 * 
 * @author Walter Stock
 *
 */
public class ShoppingListProduct extends ListItemBase implements Purchasable, Serializable {
	private int listItemID = -1;
	private Product product;
	private int quantity = -1;
	private String units = "NoUnitsYet";
	private int priority = -1;
	private double price = -1.0;
	private boolean purchased = false;

	// constructors
	public ShoppingListProduct(Product product, int quantity, String units, int priority) {
		this.setListItemID();
		this.product = product;
		this.quantity = quantity;
		this.units = units;
		this.priority = priority;
	}

	public ShoppingListProduct(Product product, int quantity, String units, int priority, boolean purchased) {
		this.setListItemID();
		this.product = product;
		this.quantity = quantity;
		this.units = units;
		this.priority = priority;
		this.purchased = purchased;
	}
	

	// setters
	public void setListItemID() {
		super.setListItemID();
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	public void setPurchased(boolean purchased) {
		this.purchased = purchased;
	}

	// getters
	public int getListItemID() {
		return super.getListItemID();
	}

	public Product getProduct() {
		return this.product;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public String getUnits() {
		return this.units;
	}

	public int getPriority() {
		return this.priority;
	}

	public double getPrice() {
		return this.price;
	}


	public boolean getPurchased() {
		return this.purchased;
	}

	// additional methods
	public boolean equals(Object otherObject) {
		/**
		 * Well designed equals method that overrides Java's base object's equals method
		 * and checks that the passed object is a ShoppingList.
		 * 
		 * The definition of equals for a shopping list product instance is 1. Same
		 * product 2. Same priority
		 * 
		 * This support including a first instance of item at a higher priority than
		 * subsequent instances of the item on a list.
		 * 
		 */
		boolean isEqual = false;
		if ((otherObject != null) && (otherObject instanceof ShoppingListProduct)) {
			ShoppingListProduct otherShoppingListProduct = (ShoppingListProduct) otherObject;
			isEqual = this.product == otherShoppingListProduct.getProduct()
					&& this.priority == otherShoppingListProduct.getPriority();
		}

		return isEqual;
	}

	public String toString() {
		return "Product: " + this.product.getProductName() + "\n" + "quantity: " + this.quantity + "\n" + "priority: "
				+ this.priority + "\n" + "price: " + this.price + "\n";
	}

}
