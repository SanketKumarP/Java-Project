

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CS401prj<T extends Comparable<T>> {
    private T[] arr;                                      // array of generic type T
    private int count;

    public static void main(String[] args) {
        CS401prj<Integer> project = new CS401prj<>();    // create an instance of the CS401prj class
      

        System.out.println("Welcome to the Sorting and Searching Program!");

        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Sort list");
            System.out.println("2. Search list");
            System.out.println("3. Exit");

            Scanner scanner = new Scanner(System.in);	// create a Scanner object to read user input
            int option = scanner.nextInt();				// read user input for selected option

            if (option == 1) {							// If user select sorting
                project.readFile();						// read data from file
                System.out.println("Original list:");
                project.printList();					// print the original list of elements
                project.sortMenu();						// Calling the sorting menu

            } else if (option == 2) {					// If user select searching
                project.readFile();						// read data from file
                System.out.println("Original list:");
                project.printList();					// print the original list of elements
                project.searchMenu();					// Calling the searching menu
            } else if (option == 3) {					// If user select to exit
                System.out.println("Thank you for using the program!");
                break;
            } else {									// If user enter an invalid option
                System.out.println("Invalid option, please try again.");
            }
        }
    }


    // read data from a file and store in array
    public void readFile() {
        Object[] dataArray = new Object[1000]; 				//initialize array to hold 1000 elements
        int count = 0; 										//counter variable to keep track of number of elements in the array
        System.out.println("Enter the file path:");
        Scanner sc = new Scanner(System.in);
        String filepath = sc.nextLine();
        File inputFile = new File(filepath);				// create a File object with the name of the input file
        try {
            Scanner scanner = new Scanner(inputFile);   	// create a Scanner object to read from the input file
            while (scanner.hasNextLine()) {					// read the file line by line
                String line = scanner.nextLine();			// read the current line
                Scanner lineScanner = new Scanner(line); 	// create a new scanner to read the values in the line
                while (lineScanner.hasNext()) {				// read the values in the line
                    if (lineScanner.hasNextInt()) {			// if the value is an integer
                        int value = lineScanner.nextInt(); // read the integer value
                        dataArray[count] = value;			// store the value in the dataArray
                        count++;							// increment the counter
                    } else if (lineScanner.hasNextFloat()) {	// if the value is a float
                        float value = lineScanner.nextFloat();	// read the float value
                        dataArray[count] = value;			// store the value in the dataArray
                        count++;							// increment the counter
                    } else {								// if the value is a string
                        String value = lineScanner.next();  // read the string value
                        dataArray[count] = value;			// store the value in the dataArray
                        count++;							// increment the counter
                    }
                }
                lineScanner.close();						// close the scanner for the current line
            }
            scanner.close();								// close the scanner for the input file
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        arr = (T[]) new Comparable[count];   				//create a new array to hold only the elements that were read from the file
        System.arraycopy(dataArray, 0, arr, 0, count);     //copy the elements from the original array to the trimmed array
        dataArray=null;										// to garbage the temporary array
    }

    // Method to print the array list
    public void printList() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if ((i + 1) % 10 == 0) {						// To Print in a newline after every 10 elements
                System.out.println();
            }
        }
        System.out.println();
    }

    // Method to display the sorting menu and perform sorting operations based on user input
    public void sortMenu() {
        System.out.println("\nPlease select two sorting algorithms:");
        System.out.println("1. Selection Sort");
        System.out.println("2. Merge Sort");
        Scanner scanner = new Scanner(System.in);
        int algorithm1 = scanner.nextInt();				// Read the user's choice for algorithm 1
        int algorithm2 = scanner.nextInt();				// Read the user's choice for algorithm 2

        // Create sorters based on user input
        CS401Sort<T> sorter1;							// Declare a CS401Sort object for algorithm 1
        CS401Sort<T> sorter2;							// Declare a CS401Sort object for algorithm 2

        if (algorithm1 == 1) {							// Check the user's choice for algorithm 1
            sorter1 = new CS401SelectionSort<>();		// If 1, create a new CS401SelectionSort object
        } else {
            sorter1 = new CS401MergeSort<>();			// If not 1, Create a new CS401MergeSort object
        }

        if (algorithm2 == 1) {							// Check the user's choice for algorithm 2
            sorter2 = new CS401SelectionSort<>();		// If 1, create a new CS401SelectionSort object
        } else {
            sorter2 = new CS401MergeSort<>();			// Create a new CS401MergeSort object
        }

        
        T[] copy = arr.clone();							// Create a copy of the original array and perform sorting operations
        System.out.println("\nSorting with algorithm 1:\n");
        sorter1.sort(copy);								// Sort the copy of the array using algorithm 1
        System.out.println("Number of comparisons made to sort data using algorithm 1 : " + sorter1.getCount());
        
        copy = arr.clone();								// Make a new copy of the array
        System.out.println("\nSorting with algorithm 2:\n");
        sorter2.sort(copy);								// Sort the copy of the array using algorithm 2
        System.out.println("Number of comparisons made to sort data using algorithm 2 :  " + sorter2.getCount());
    }

    // Method to display the search menu and perform search operations based on user input
    public void searchMenu() {
        System.out.println("\nPlease select a search algorithm:");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search (with sorted list)");
        System.out.println("3. Hash Function Search");
        Scanner scanner = new Scanner(System.in);		// Create a new Scanner object to read user input
        int algorithm = scanner.nextInt();				// Read the user's choice of search algorithm
        // Create a searcher based on user input
        CS401Search<T> searcher;

        if (algorithm == 1) { 							// Check the user's choice of algorithm
            searcher = new CS401LinearSearch<>();		// If 1, create a new CS401LinearSearch object
        } else if (algorithm == 2) {					// If 2
            CS401Sort<T> sorter = new CS401MergeSort<>();	// Sorting the array by MergeSort before performing binary search
            sorter.sort(arr);
            searcher = new CS401BinarySearch<>(arr);      // create a new CS401BinarySearch object      
        } else {
            searcher = new CS401HashFunctionSearch<>();	// If not 1 or 2, create a new CS401HashFunctionSearch object
        }

        // Get the search value from user input
        System.out.println("Enter a value to search:");
        T value = null ;
        if(scanner.hasNextInt()) {
          // Convert input to integer if it is an integer
 		  value = (T) Integer.valueOf(scanner.nextInt());
 		}
 		else
 		{
 			// Convert input to float if it is a float, otherwise keep it as string
 			if(scanner.hasNextFloat()) {
 				value = (T) Float.valueOf(scanner.nextFloat());
 			}
 			else {
 			value = (T) scanner.next();
 			}
 		}
        
        // Perform search operation and print the result
        int index = searcher.search(arr, value);
        if (index >= 0) {
            System.out.println("Value " + value + " found at index " + index);
        } else {
            System.out.println("Value " + value + " not found in the list.");
        }
        System.out.println("Number of comparisons: " + searcher.getCount());
    }
    
    // Getter and setter methods for count variable
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}

       
