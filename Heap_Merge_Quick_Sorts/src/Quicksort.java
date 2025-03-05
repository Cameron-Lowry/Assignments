// Name: <Cameron Lowry>
// Class: CS 4306/01
// Term: Summer 2024
// Instructor: Dr. Haddad
// Assignment: 4
// IDE: <IntelliJ>

public class Quicksort {

    private static long comparisons;

    //method to start the sort with a way to handle StackOverFlow
    public static long sort(int[] arr) {
        comparisons = 0;
        try {
            quicksort(arr, 0, arr.length - 1);
        } catch (StackOverflowError e) {
            System.out.println("StackOverflowError occurred.");
            return -1; // Returns a value to show SOE
        }
        return comparisons;
    }

    //recursively performs the quicksort on sub-arrays
    private static void quicksort(int[] arr, int l, int h) {
        if (l < h) {
            int pi = partition(arr, l, h);
            quicksort(arr, l, pi - 1);
            quicksort(arr, pi + 1, h);
        }
    }

    //method to partition the array with a pivot element
    private static int partition(int[] arr, int l, int h) {
        int pivot = arr[h];
        int i = (l - 1);
        for (int j = l; j < h; j++) {
            comparisons++;
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[h];
        arr[h] = temp;

        return i + 1;
    }
}