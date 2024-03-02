public class insertion {
    public static int[] insertionSort(int data[]) {
        int temp;
        for (int i = 1; i < data.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(data[j] > data[j-1]){
                    temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;
                }
            }
        }
        return data;
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
        int[] data = {8, 2, 4, 9, 3, 6};
        //Print array elements
        printNumbers(data);
        int[] sortedDate = insertionSort(data);
        //Print sorted array elements
        printNumbers(sortedDate);
    }
}