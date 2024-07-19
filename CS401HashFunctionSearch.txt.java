

import java.util.HashMap; 
import java.util.Map;

//CS401HashFunctionSearch class implements the CS401Search interface
public class CS401HashFunctionSearch<T extends Comparable<T>> implements CS401Search<T> {
    private int count;

    // override the search method from the CS401Search interface
    @Override
    public int search(T[] arr1, T value) {
        count = 0;											// initialize count variable to zero
        Map<T, Integer> map = new HashMap<>();				// Create a new HashMap to store elements of the array as keys and their indexes as values
        for (int i = 0; i < arr1.length; i++) {				// Loop through the array and put each element and its index into the HashMap
            map.put(arr1[i], i);
        }
        Integer index = map.get(value);						// Get the index of the value from the HashMap
        if (index != null) {								// If the index is not null, return the index; otherwise, return -1
            return index;
        } else {
            return -1;
        }
    }

    // override the getCount method from the CS401Search interface
    @Override
    public int getCount() {
        return count;
    }
}
