public class MedianMethod {

    static double median(int sorted[]) {
        //if statement to find out whether the array is odd or even
        if (sorted.length % 2 == 0){

            return (((double)sorted[sorted.length/2] + (double)sorted[sorted.length/2 - 1]) / 2);
            //if it is even then take the two numbers that split the middle, add them
            // and then divide by 2 to find the median
        }


            return sorted[sorted.length/2];
            //if it is even find the middle value

        }


    public static void main(String[] args){
        //Example array to show the code can find the median
        int array[] = new int[6];
        array[0] = 1;
        array[1] = 2;
        array[2] = 2;
        array[3] = 5;
        array[4] = 5;
        array[5] = 6;

        System.out.println( median(array));
    }

}
