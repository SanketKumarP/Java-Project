

//CS401LinearSearch class implements the CS401Search interface
public class CS401LinearSearch<T extends Comparable<T>> implements CS401Search<T> {
	
    private int count;								// private variable count
    
    // override the search method from the CS401Search interface
    @Override
    public int search(T[] arr1, T key) {
        count = 0;									// initialize count variable to zero
        for (int i = 0; i < arr1.length; i++) {
            count++;
            if (arr1[i].equals(key)) {				// if element is equal to the key, return its index
                return i;
            }
        }
        return -1;									// return -1 if key not found in the array
    }

    // override the getCount method from the CS401Search interface
    @Override
    public int getCount() {
        return count;
    }
}
