public class java {
    public static void bubbleSort(int array[]) {

        for (int m = 0; m < array.length; m++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swapNumbers(i, i + 1, array);
                }
            }
            printNumbers(array);
        }
    }

    private static void swapNumbers(int i, int j, int[] array) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void printNumbers(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
            if(i != data.length-1){
                System.out.print(", ");
            }
        }
        System.out.println("\n");
    }

    public static void main(String args[]){
        int[] data= {8, 5, 4, 2, 1};
        bubbleSort(data);
    }
}