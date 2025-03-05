// Name: <Cameron Lowry>
// Class: CS 4306/01
// Term: Summer 2024
// Instructor: Dr. Haddad
// Assignment: 4
// IDE: <IntelliJ>


//Mergesort class
public class Mergesort {

    private static long comp;

    //starts search and initializes to comparisons to 0
    public static long sort(int[] arr) {
        comp = 0;
        mergesort(arr, 0, arr.length - 1);
        return comp;
    }

    //main merge sort recursive method
    private static void mergesort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            mergesort(arr, lo, mid);
            mergesort(arr, mid + 1, hi);
            merge(arr, lo, mid, hi);
        }
    }

    //method to merge 2 sorted arrays into one array
    private static void merge(int[] arr, int lo, int mid, int hi) {
        int n1 = mid - lo + 1;
        int n2 = hi - mid;

        int[] le = new int[n1];
        int[] r = new int[n2];

        for (int i = 0; i < n1; i++) {
            le[i] = arr[lo + i];
        }
        for (int j = 0; j < n2; j++) {
            r[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = lo;
        while (i < n1 && j < n2) {
            if (le[i] <= r[j]) {
                arr[k] = le[i];
                i++;
            } else {
                arr[k] = r[j];
                j++;
            }
            comp++;
            k++;
        }

        while (i < n1) {
            arr[k] = le[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = r[j];
            j++;
            k++;
        }
    }
}