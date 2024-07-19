



//CS401BinarySearch class implements the CS401Search interface
public class CS401BinarySearch<T extends Comparable<T>> implements CS401Search<T> {
    private int count;							// private variables count
    private T[] arr1;							// private variables arr1

    
    // constructor to initialize the arr1 variable
    public CS401BinarySearch(T[] arr1) {
        this.setArr1(arr1);
    }

    // override the search method from the CS401Search interface
    @Override
    public int search(T[] arr1, T value) {
        count = 0;							// initialize count variable to zero
        int left = 0;
        int right = arr1.length - 1;

        //algorithm for Binarysearch implemented
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = value.compareTo(arr1[mid]);
            count++;
            if (cmp < 0) {
                right = mid - 1;
            } else if (cmp > 0) {
                left = mid + 1;
            } else {
                return mid;			// if value is equal to the middle element, return its index
            }
        }
        // return -1 if value not found in the array
        return -1;
    }

    // override the getCount method from the CS401Search interface
    @Override
    public int getCount() {
        return count;
    }

    //getter and setter for variable arr1
	public T[] getArr1() {
		return arr1;
	}

	public void setArr1(T[] arr1) {
		this.arr1 = arr1;
	}
}
