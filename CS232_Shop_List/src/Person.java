/**
 * 
 */

/**
 * @author walte
 *
 */
public class Person {
	private String personName;

	public boolean equals(Object otherObject) {
		boolean isEqual = false;
		if ((otherObject != null) && (otherObject instanceof Person)) {
			Person otherPerson = (Person) otherObject;
			isEqual = this.personName == otherPerson.getPersonName();
		}

		return isEqual;
	}

	public void setPersonName(String newName) {
		personName = newName;
	}

	public String getPersonName() {
		return personName;
	}

}
