

//This is an interface that defines the contract for classes that implement a sorting algorithm.
//It has two methods: sort() to sort an array of comparable elements and getCount() to return the number of comparisons made during sorting.

public interface CS401Sort<T extends Comparable<T>> {
    void sort(T[] arr);
    int getCount();
}

