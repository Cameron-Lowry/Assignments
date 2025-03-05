// Name: <Cameron Lowry>
// Class: CS 4306/01
// Term: Summer 2024
// Instructor: Dr. Haddad
// Assignment: 4
// IDE: <IntelliJ>

// After many trials I noticed that the Mergesort performed the best across all array types.
// However, the Heapsort was much more consistent across all array types leading to a more stable
// search time. The Quicksort performs well in random arrays however performs much closer to it's
//worse case when doing a sort on sorted arrays. These results seem to reinforce what we already
//know about these sorts with their time complexity and use cases.

/*
trial 1

"Array Type: Random
Algorithm   n=1000    n=10000   n=100000  n=1000000
------------------------------------------------------------
Mergesort   8708      120421    1536797   18674496
Quicksort   11906     164550    1981835   24918365
Heapsort    19096     258494    3249934   39094164

Array Type: Increasing
Algorithm   n=1000    n=10000   n=100000  n=1000000
------------------------------------------------------------
Mergesort   5044      69008     853904    10066432
Quicksort   499500    49995000  SOE       SOE
Heapsort    20416     273912    3401708   40575584

Array Type: Decreasing
Algorithm   n=1000    n=10000   n=100000  n=1000000
------------------------------------------------------------
Mergesort   4932      64608     815024    9884992
Quicksort   499500    49995000  SOE       SOE
Heapsort    17632     243392    3094868   37666816  "

trial 2
"Array Type: Random
Algorithm   n=1000    n=10000   n=100000  n=1000000
------------------------------------------------------------
Mergesort   8714      120456    1536666   18674516
Quicksort   10917     156774    1945758   25435848
Heapsort    19264     258384    3250046   39096956

Array Type: Increasing
Algorithm   n=1000    n=10000   n=100000  n=1000000
------------------------------------------------------------
Mergesort   5044      69008     853904    10066432
Quicksort   499500    49995000  SOE       SOE
Heapsort    20416     273912    3401708   40575584

Array Type: Decreasing
Algorithm   n=1000    n=10000   n=100000  n=1000000
------------------------------------------------------------
Mergesort   4932      64608     815024    9884992
Quicksort   499500    49995000  SOE       SOE
Heapsort    17632     243392    3094868   37666816  "

trial 3 "
Array Type: Random
Algorithm   n=1000    n=10000   n=100000  n=1000000
------------------------------------------------------------
Mergesort   8706      120571    1536291   18673792
Quicksort   11495     155074    2020271   24257913
Heapsort    19192     258410    3249626   39096924

Array Type: Increasing
Algorithm   n=1000    n=10000   n=100000  n=1000000
------------------------------------------------------------
Mergesort   5044      69008     853904    10066432
Quicksort   499500    49995000  SOE       SOE
Heapsort    20416     273912    3401708   40575584

Array Type: Decreasing
Algorithm   n=1000    n=10000   n=100000  n=1000000
------------------------------------------------------------
Mergesort   4932      64608     815024    9884992
Quicksort   499500    49995000  SOE       SOE
Heapsort    17632     243392    3094868   37666816  "
More trials were done but I was uncertain on how much you wanted us to record
 */


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class testAdvancedSorting {

    // array sizes
    private static final int[] si = {1000, 10000, 100000, 1000000};

    // Arrays for storing test data
    private static int[][] randArrs = new int[si.length][];
    private static int[][] incArrs = new int[si.length][];
    private static int[][] decArrs = new int[si.length][];

    // Arrays to store comparisons
    private static long[][] mSComp = new long[3][si.length];
    private static long[][] qSComp = new long[3][si.length];
    private static long[][] hSComp = new long[3][si.length];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // menu functionality
        while (!exit) {
            menu();
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    populateAllArrays();
                    System.out.println("Arrays populated successfully.");
                    break;
                case 2:
                    runSortAlgorithms();
                    System.out.println("Sorting complete.");
                    break;
                case 3:
                    displayOutputs();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 4.");
                    break;
            }
        }
        scanner.close();
    }

    // Displays the menu
    private static void menu() {
        System.out.println("----------------------MAIN MENU-------------------");
        System.out.println("1.\tPopulate All Arrays");
        System.out.println("2.\tRun Sort Algorithms");
        System.out.println("3.\tDisplay Outputs");
        System.out.println("4.\tExit Program");
        System.out.print("Enter option number: ");
    }

    //Populates arrays
    private static void populateAllArrays() {
        for (int i = 0; i < si.length; i++) {
            randArrs[i] = randomIntegers(si[i]);
            incArrs[i] = increasingIntegers(si[i]);
            decArrs[i] = decreasingIntegers(si[i]);
        }
    }

    // Generates an array of random integers
    private static int[] randomIntegers(int n) {
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    // Generates an array of increasing integers
    private static int[] increasingIntegers(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    // Generates an array of decreasing integers
    private static int[] decreasingIntegers(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }
        return arr;
    }

    // Runs the sorting algorithms
    private static void runSortAlgorithms() {
        for (int i = 0; i < si.length; i++) {
            // Random arrays
            int[] randCopy = Arrays.copyOf(randArrs[i], randArrs[i].length);
            qSComp[0][i] = Quicksort.sort(randCopy);
            randCopy = Arrays.copyOf(randArrs[i], randArrs[i].length);
            mSComp[0][i] = Mergesort.sort(randCopy);
            randCopy = Arrays.copyOf(randArrs[i], randArrs[i].length);
            hSComp[0][i] = Heapsort.sort(randCopy);

            // Increasing arrays
            int[] incCopy = Arrays.copyOf(incArrs[i], incArrs[i].length);
            qSComp[1][i] = Quicksort.sort(incCopy);
            incCopy = Arrays.copyOf(incArrs[i], incArrs[i].length);
            mSComp[1][i] = Mergesort.sort(incCopy);
            incCopy = Arrays.copyOf(incArrs[i], incArrs[i].length);
            hSComp[1][i] = Heapsort.sort(incCopy);

            // Decreasing arrays
            int[] decCopy = Arrays.copyOf(decArrs[i], decArrs[i].length);
            qSComp[2][i] = Quicksort.sort(decCopy);
            decCopy = Arrays.copyOf(decArrs[i], decArrs[i].length);
            mSComp[2][i] = Mergesort.sort(decCopy);
            decCopy = Arrays.copyOf(decArrs[i], decArrs[i].length);
            hSComp[2][i] = Heapsort.sort(decCopy);
        }
    }

    // Displays results and tables
    private static void displayOutputs() {
        String[] algos = {"Mergesort", "Quicksort", "Heapsort"};


        System.out.println("\nArray Type: Random");
        displayComparisonTable(algos, si, mSComp, qSComp, hSComp, 0);


        System.out.println("\nArray Type: Increasing");
        displayComparisonTable(algos, si, mSComp, qSComp, hSComp, 1);


        System.out.println("\nArray Type: Decreasing");
        displayComparisonTable(algos, si, mSComp, qSComp, hSComp, 2);
    }

    // Comparison table
    private static void displayComparisonTable(String[] algos, int[] si, long[][] mSComp,
                                               long[][] qSComp, long[][] hSComp, int typeIndex) {
        System.out.printf("%-12s", "Algorithm");

        for (int size : si) {
            System.out.printf("%-10s", "n=" + size);
        }
        System.out.println("\n------------------------------------------------------------");

        // Mergesort results
        System.out.printf("%-12s", algos[0]); // Mergesort
        for (int j = 0; j < si.length; j++) {
            long comp = mSComp[typeIndex][j];
            if (comp == -1) {
                System.out.printf("%-10s", "SOE");
            } else {
                System.out.printf("%-10d", comp);
            }
        }
        System.out.println();

        // Quicksort results
        System.out.printf("%-12s", algos[1]); // Quicksort
        for (int j = 0; j < si.length; j++) {
            long comp = qSComp[typeIndex][j];
            if (comp == -1) {
                System.out.printf("%-10s", "SOE");
            } else {
                System.out.printf("%-10d", comp);
            }
        }
        System.out.println();

        // Heapsort results
        System.out.printf("%-12s", algos[2]); // Heapsort
        for (int j = 0; j < si.length; j++) {
            long comp = hSComp[typeIndex][j];
            if (comp == -1) {
                System.out.printf("%-10s", "SOE");
            } else {
                System.out.printf("%-10d", comp);
            }
        }
        System.out.println();
    }
}