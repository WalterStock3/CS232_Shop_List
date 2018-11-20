import java.util.ArrayList;

/**
 * Class for sorting an array of integers from smallest to largest using the
 * merge sort algorithm.
 */
public class MergeSort {
	/**
	 * Precondition: Every indexed variable of the array a has a value.
	 * Postcondition: a[0] <= a[1] <= ... <= a[a.length - 1].
	 */
	public static void sort(int[] a) {
		if (a.length >= 2) {
			int halfLength = a.length / 2;
			int[] firstHalf = new int[halfLength];
			int[] lastHalf = new int[a.length - halfLength];
			divide(a, firstHalf, lastHalf);
			sort(firstHalf);
			sort(lastHalf);
			merge(a, firstHalf, lastHalf);
		}
		// else do nothing. a.length == 1, so a is sorted.
	}

	public static void sort(ShoppingList shoppingList) {
		if (Tester.testing == "Y") {
			System.out.println("\n TESTING - in MergeSort sort for ShoppingList object\n");
		}

		shoppingList.setShoppingList(sort(shoppingList.getShoppingList()));
	}

	// Overridden for ShoppingList
	public static ArrayList<ShoppingListProduct> sort(ArrayList<ShoppingListProduct> a) {
		if (Tester.testing == "Y") {
			System.out.println("\n TESTING - in MergeSort sort for ShoppingList array\n");
		}
		if (a.size() >= 2) {
			int firstHalfLength = a.size() / 2;
			int lastHalfLength = a.size() - firstHalfLength;
			ArrayList<ShoppingListProduct> firstHalf = new ArrayList();
			ArrayList<ShoppingListProduct> lastHalf = new ArrayList();
			divide(a, firstHalf, lastHalf, firstHalfLength, lastHalfLength);
			sort(firstHalf);
			sort(lastHalf);
			merge(a, firstHalf, lastHalf, firstHalfLength, lastHalfLength);
		}
		return a;
	}

	// Precondition: a.length = firstHalf.length + lastHalf.length.
	// Postcondition: All the elements of a are divided
	// between the arrays firstHalf and lastHalf.
	private static void divide(int[] a, int[] firstHalf, int[] lastHalf) {
		for (int i = 0; i < firstHalf.length; i++)
			firstHalf[i] = a[i];
		for (int i = 0; i < lastHalf.length; i++)
			lastHalf[i] = a[firstHalf.length + i];
	}

	private static void divide(ArrayList<ShoppingListProduct> a, ArrayList<ShoppingListProduct> firstHalf,
			ArrayList<ShoppingListProduct> lastHalf, int firstHalfLength, int lastHalfLength) {
		for (int i = 0; i < firstHalfLength; i++)
			firstHalf.add(a.get(i));
		for (int i = 0; i < lastHalfLength; i++)
			lastHalf.add(a.get(firstHalf.size() + i));
	}

	// Precondition: Arrays firstHalf and lastHalf are sorted from
	// smallest to largest; a.length = firstHalf.length +
	// lastHalf.length.
	// Postcondition: Array a contains all the values from firstHalf
	// and lastHalf and is sorted from smallest to largest.
	private static void merge(int[] a, int[] firstHalf, int[] lastHalf) {
		int firstHalfIndex = 0, lastHalfIndex = 0, aIndex = 0;

		while ((firstHalfIndex < firstHalf.length) && (lastHalfIndex < lastHalf.length)) {
			if (firstHalf[firstHalfIndex] < lastHalf[lastHalfIndex]) {
				a[aIndex] = firstHalf[firstHalfIndex];
				firstHalfIndex++;
			} else {
				a[aIndex] = lastHalf[lastHalfIndex];
				lastHalfIndex++;
			}
			aIndex++;
		}
		// At least one of firstHalf and lastHalf has been
		// completely copied to a.

		// Copy rest of firstHalf, if any.
		while (firstHalfIndex < firstHalf.length) {
			a[aIndex] = firstHalf[firstHalfIndex];
			aIndex++;
			firstHalfIndex++;
		}

		// Copy rest of lastHalf, if any.
		while (lastHalfIndex < lastHalf.length) {
			a[aIndex] = lastHalf[lastHalfIndex];
			aIndex++;
			lastHalfIndex++;
		}
	}

	private static void merge(ArrayList<ShoppingListProduct> a, ArrayList<ShoppingListProduct> firstHalf,
			ArrayList<ShoppingListProduct> lastHalf, int firstHalfLength, int lastHalfLength) {
		int firstHalfIndex = 0, lastHalfIndex = 0, aIndex = 0;
		if (Tester.testing == "Y") {
			System.out.println("\n TESTING - in MergeSort merge for ShoppingList array\n");
		}
		while ((firstHalfIndex < firstHalfLength) && (lastHalfIndex < lastHalfLength)) {
			if (firstHalf.get(firstHalfIndex).getPriority() < lastHalf.get(lastHalfIndex).getPriority()) {
				if (Tester.testing == "Y") {
					System.out.println("TESTING - first half priority: " + firstHalf.get(firstHalfIndex).getPriority());
				}
				a.set(aIndex, firstHalf.get(firstHalfIndex));
				firstHalfIndex++;
			} else {
				if (Tester.testing == "Y") {
					System.out.println("TESTING - second half priority: " + lastHalf.get(firstHalfIndex).getPriority());
				}
				a.set(aIndex, lastHalf.get(lastHalfIndex));
				lastHalfIndex++;
			}
			aIndex++;
		}

		while (firstHalfIndex < firstHalfLength) {
			a.set(aIndex, firstHalf.get(firstHalfIndex));
			if (Tester.testing == "Y") {
				System.out.println("TESTING - first half priority: " + firstHalf.get(firstHalfIndex).getPriority());
			}
			aIndex++;
			firstHalfIndex++;
		}
		while (lastHalfIndex < lastHalfLength) {
			a.set(aIndex, lastHalf.get(lastHalfIndex));
			if (Tester.testing == "Y") {
				System.out.println("TESTING - second half priority: " + lastHalf.get(firstHalfIndex).getPriority());
			}
			aIndex++;
			lastHalfIndex++;
		}

	}
}
