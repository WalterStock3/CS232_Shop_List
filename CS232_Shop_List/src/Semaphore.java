import java.io.Serializable;

public class Semaphore implements Serializable {
	private static int itemID = -1;
	private static int listItemID = -1;
	private static int listID = -1;

	public static int getItemID() {
		itemID = itemID++;
		return itemID;
	}

	public static int getListItemID() {
		listItemID = listItemID++;
		return listItemID;
	}

	public static int getListID() {
		listID = listID++;
		return listID;
	}
}
