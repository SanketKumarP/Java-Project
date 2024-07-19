

import java.util.Arrays;

//This class implements the CS401Sort interface using the Merge sort algorithm.
public class CS401MergeSort<T extends Comparable<T>> implements CS401Sort<T> {
    private int count;

    // The sort() method overrides the method in the interface and sorts the input array in ascending order
    @Override
    public void sort(T[] arr) {
        count = 0;
        mergeSort(arr, 0, arr.length - 1);  //call the Merge sort function 
        
        // Print the sorted data in a readable format.
        System.out.println("Sorted data using Mergesort is as per below");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    // MergeSort algorithm implemented here.
    private void mergeSort(T[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(T[] arr, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
        T[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        T[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftSize && j < rightSize) {
            int cmp = leftArr[i].compareTo(rightArr[j]);
            count++;
            if (cmp <= 0) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
    
    // The getCount() method returns the number of comparisons made during sorting.
    @Override
    public int getCount() {
        return count;
    }
}

