// Name: <Cameron Lowry>
// Class: CS 4306/01
// Term: Summer 2024
// Instructor: Dr. Haddad
// Assignment: 4
// IDE: <Intellij>

import java.util.*;


public class TestInterpolationSearch {
    private static int[] Values;
    private static int size;

    //function to print menu
    static void menu() {
        System.out.println("----------------------MAIN MENU-------------------\n" +
                "1.\tCreate, populate, and display array Values[]\n" +
                "2.\tRead output table size \n" +
                "3.\tRun interpolation search and display outputs\n" +
                "3.\tExit program\n\n" +
                "Enter option number: ");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        size = 0;
        int input = 0;

        //while loop and switch case to implement menu functionality
        while(input != 4){
            menu();
            input = scan.nextInt();

            switch (input) {
                case 1:
                    Values = randomDistinct();
                    displayArray(Values);
                    break;
                case 2:
                    size = readTableSize();
                    break;
                case 3:
                    if(size != 0){
                    runIntSearch(size);
                    }
                    else{
                        System.out.println("Please enter a table size");
                    }
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
            }

        }
    }

    // Method to generate random distinct array and sort it
    private static int[] randomDistinct() {
        int[] array = new int[1024];
        Random random = new Random();

        // Generate random distinct numbers
        for (int i = 0; i < 1024; i++) {
            array[i] = random.nextInt(9999) + 1;
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    i--;
                    break;
                }
            }
        }

        // Sort the array in ascending order
        Arrays.sort(array);
        return array;
    }

    // displays all values in the array with a width of 5 then spacing them with a tab and
    // creating a new line every 30 values
    private static void displayArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%5d", arr[i]);
            if ((i + 1) % 30 == 0) {
                System.out.println();
            } else {
                System.out.print("\t");
            }
        }
        System.out.println();
    }

    // Method to read output table size
    private static int readTableSize() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter table size: ");
        int size = scanner.nextInt();
        scanner.nextLine();
        return size;
    }

    // Runs the search and displays the table
    private static void runIntSearch(int size) {
        System.out.printf("%-5s %-5s %-7s %-9s\n", "Key", "Found", "Index", "Divisions");
        System.out.println("-------------------------------------------");

        int totalDiv = 0;
        for (int i = 0; i < size; i++) {
            Random ran = new Random();

            //randomly creates the keys from 1 to 9999 so many will not be found in the array
            //due to the size of the array and the possible values
            int key = ran.nextInt(9999) + 1;
            InterpolationSearch search = new InterpolationSearch(Values, key);

            //print that formats the table as required
            System.out.printf("%-5d %-5b %-7d %-9d\n", key, search.isFound(), search.getIndex(), search.getDivisions());
            totalDiv += search.getDivisions();
        }

        //calculations for divisions average and the difference
        double divAv = (double) totalDiv / size;
        double diff = Math.abs(3.322 - divAv);

        System.out.println("Divisions average: " + divAv);
        System.out.println("Difference: " + diff);
    }

}