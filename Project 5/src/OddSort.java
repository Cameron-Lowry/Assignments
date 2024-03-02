public class OddSort {

    static void sort(int array[]) {
        // array is originally unsorted
        boolean sorted = false;

        //while loop to keep sorting until the array is sorted
        while(sorted == false) {
            //sets sorted to true to complete the sort if none of the if statements run
            sorted =true;

            int a = 0;

            //bubble sort for odd, to sort the odd numbers and their neighbors
            for (int i = 1; i <= array.length - 2; i = i + 2) {
                if(array[i]>array[i+1]){
                    a = array[i];
                    array[i]= array[i+1];
                    array[i+1] = a;
                    sorted = false;
                    //sets the sorted boolean to false to continue the sort
                }
            }

            //bubble sort for even, to sort the even numbers and their neighbors
            for (int i = 0; i <= array.length - 2; i = i + 2) {
                    if(array[i]>array[i+1]){
                        a = array[i];
                        array[i]= array[i+1];
                        array[i+1] = a;
                        sorted = false;
                        //sets the sorted boolean to false to continue the sort
                    }
            }
        }
        return;
    }
}
