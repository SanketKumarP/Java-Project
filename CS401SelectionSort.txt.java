

//This class implements the CS401Sort interface using the Selection sort algorithm.

public class CS401SelectionSort<T extends Comparable<T>> implements CS401Sort<T> {
    private int count;
    
    // The sort() method overrides the method in the interface and sorts the input array in ascending order.
    @Override
    public void sort(T[] arr) {
        count = 0;
        int n = arr.length;

        //Algorithm for selection sort implemented.
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIdx]) < 0) {
                    minIdx = j;
                }
                count++;
            }
            T temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
        
        //The sorted data is printed in a readable format after sorting.
        System.out.println("Sorted data using Selection sort is as per below");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

 // The getCount() method returns the number of comparisons made during sorting.
    @Override
    public int getCount() {
        return count;
    }
}
