import java.util.ArrayList;
import java.io.Serializable;

public class UserList implements Serializable {

	// declaring variables
	private ArrayList<Person> userList;
	private Semaphore semaphore;

	public UserList() {
		userList = new ArrayList<Person>(5);
		semaphore = new Semaphore();
	}

	public ArrayList getUserList() {
		return this.userList;
	}

	public void addUser(Person user) {
		userList.add(user);
	}

	public Person getUser(int userLocation) {
		return this.userList.get(userLocation);
	}

	public int getUserLocation(String userName) {
		int itemLocation = -1;
		for (int index = 0; index < this.userList.size(); index++) {
			if (Tester.testing == "Y") {
				System.out.println("TESTING - index " + index + " has a user name of: "
						+ this.userList.get(index).getPersonName());
			}
			if (this.userList.get(index).getPersonName().equals(userName)) {
				itemLocation = index;
				if (Tester.testing == "Y") {
					System.out.println("TESTING - itemLocation set to: " + itemLocation);
				}
			}
		}
		if (Tester.testing == "Y") {
			System.out.println("TESTING - " + userName + " found at " + itemLocation + ".");
		}
		return itemLocation;
	}

}
