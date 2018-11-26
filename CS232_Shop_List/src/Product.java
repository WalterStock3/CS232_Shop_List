import java.io.Serializable;

/**
 * @author Walter Stock
 *
 */
public class Product extends ItemBase implements Serializable {

	// constructors
	public Product() {
		super.setItemID();
		super.setItemName("UnNamedProduct");
	}

	public Product(String productName) {
		super.setItemID();
		super.setItemName(productName);
	}

	// getters
	public String getProductName() {
		return super.getItemName();
	}

	public boolean equals(Object otherObject) {
		/**
		 * Well designed equals method that overrides Java's base object's equals method
		 * and checks that the passed object is a ShoppingList.
		 * 
		 */
		boolean isEqual = false;
		if ((otherObject != null) && (otherObject instanceof Product)) {
			Product otherProduct = (Product) otherObject;
			isEqual = super.getItemName() == otherProduct.getItemName();
		}
		return isEqual;
	}

	public String toString() {

		return "productName: " + super.getItemName();
	}
}