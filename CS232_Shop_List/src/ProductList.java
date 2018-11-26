import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

/**
 * Class for list of Products.
 * 
 * @author Walter Stock
 *
 */
public class ProductList implements Serializable{

	// declaring variables
	private ArrayList<Product> productList;

	//constructor
	public ProductList() {
		productList = new ArrayList<Product>(20);
	}

	//getters
	public ArrayList getProductList() {
		return this.productList;
	}

	public boolean equals(Object otherObject) {
		// Well designed equals method that overrides Java's base objects equals method
		// and checks that the passed object is a ProductList.
		boolean isEqual = false;
		if ((otherObject != null) && (otherObject instanceof ProductList)) {
			ProductList otherProductList = (ProductList) otherObject;
			isEqual = this.productList == otherProductList.getProductList();
		}

		return isEqual;
	}

	public void addProduct(Product product) {
		productList.add(product);
	}
	
}
