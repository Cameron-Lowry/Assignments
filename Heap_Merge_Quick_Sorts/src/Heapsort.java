// Name: <Cameron Lowry>
// Class: CS 4306/01
// Term: Summer 2024
// Instructor: Dr. Haddad
// Assignment: 4
// IDE: <IntelliJ>

public class Heapsort {

    private static long comp;

    //initializes the heap sort with comparisons equal to 0
    public static long sort(int[] arr) {
        comp = 0;
        heapsort(arr);
        return comp;
    }

    //method to perform the heapsort
    private static void heapsort(int[] arr) {
        int n = arr.length;


        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }


        for (int i = n - 1; i > 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;


            heapify(arr, i, 0);
        }
    }

    // method to heapify the stack in order to maintain the heap property
    private static void heapify(int[] arr, int n, int i) {
        int biggest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        comp++;
        if (l < n && arr[l] > arr[biggest]) {
            biggest = l;
        }

        comp++;
        if (r < n && arr[r] > arr[biggest]) {
            biggest = r;
        }

        if (biggest != i) {
            int s = arr[i];
            arr[i] = arr[biggest];
            arr[biggest] = s;
            heapify(arr, n, biggest);
        }
    }
}