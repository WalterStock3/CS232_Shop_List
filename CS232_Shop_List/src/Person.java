import java.io.Serializable;

/**
 * Person Class.
 * 
 * A person object is created for each user.
 * 
 * This class doesn't have a base abstract class because because the Person
 * object will be the same for all class types.
 * 
 * @author Walter Stock
 *
 */
public class Person implements Serializable{
	private String personName;
	private ShoppingList shoppingList;
	private ProductList productList;

	public Person() {
		this.personName = "UnNamedPerson";
	}

	public Person(String initName) {
		this.personName = initName;
	}

	public boolean equals(Object otherObject) {
		boolean isEqual = false;
		if ((otherObject != null) && (otherObject instanceof Person)) {
			Person otherPerson = (Person) otherObject;
			isEqual = this.personName == otherPerson.getPersonName();
		}

		return isEqual;
	}

	public void setPersonName(String newName) {
		this.personName = newName;
	}

	public String getPersonName() {
		return this.personName;
	}

	public void newShoppingList() {
		this.shoppingList = new ShoppingList();
	}
	
	public ShoppingList getShoppingList() {
		return this.shoppingList;
	}
	
	public void newProductList() {
		this.productList = new ProductList();
	}

	public ProductList getProductList() {
		return this.productList;
	}
}
