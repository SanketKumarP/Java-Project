


//CS401Search interface defines two methods that need to be implemented

public interface CS401Search<T extends Comparable<T>> {
    int search(T[] arr1, T value);  // search method takes an array and a value as input.
    int getCount();					// getCount method returns the count of comparisons made during the search operation
}
