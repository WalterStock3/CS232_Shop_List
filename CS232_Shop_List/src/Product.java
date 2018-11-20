import java.io.Serializable;

/**
 * @author Walter Stock
 *
 */
public class Product implements Serializable{

	private String productName = "NoNameYet";

	public Product(String productName) {
		this.productName = productName;
	}

	public String getProductName() {
		return this.productName;
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
			isEqual = this.productName == otherProduct.getProductName();

		}
		return isEqual;
	}

	public String toString() {
		return "productName: " + this.productName;
	}
}