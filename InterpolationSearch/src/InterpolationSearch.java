// Name: <Cameron Lowry>
// Class: CS 4306/01
// Term: Summer 2024
// Instructor: Dr. Haddad
// Assignment: 4
// IDE: <Intellij>


public class InterpolationSearch {
    private boolean found;
    private int index;
    private int divisions;

    public InterpolationSearch(int[] arr, int key) {
        this.found = false;
        this.index = -1;
        this.divisions = 0;

        int low = 0;
        int high = arr.length - 1;

        //loop to search the array
        while (low <= high && key >= arr[low] && key <= arr[high]) {
            this.divisions++;

            // Formula for interpolation
            int pos = low + (((key - arr[low]) * (high - low)) / (arr[high] - arr[low]));

            if (arr[pos] == key) {
                this.found = true;
                this.index = pos;
                break;
            }

            if (arr[pos] < key)
                low = pos + 1;
            else
                high = pos - 1;
        }
    }

    public boolean isFound() {
        return found;
    }

    public int getIndex() {
        return index;
    }

    public int getDivisions() {
        return divisions;
    }

    public static void main(String[] args) {
        // example for testing the search
        int[] arr = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 25, 56, 99 };
        int key = 56;

        InterpolationSearch search = new InterpolationSearch(arr, key);

        if (search.isFound()) {
            System.out.println("Key found at index: " + search.getIndex() + " divs = " + search.divisions);
        } else {
            System.out.println("Key not found in the array.");
        }
    }
}