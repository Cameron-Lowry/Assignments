import java.util.Scanner;
public class LargestInMatix {
    public static void main(String args[])
    {

        int[][] myArray = new int[3][4];
        Scanner sc = new Scanner(System.in);
        for(int row=0; row<myArray.length ; row++)
        {
            for (int col=0; col<myArray[0].length ;col++)
            {
                System.out.println("Enter a value: ");
                myArray[row][col] = sc.nextInt();
            }

        }
        System.out.println("The entered matrix:");
        for ( int i=0; i < myArray.length; i++){
            for (int j =0; j < myArray[i].length; j++){
                System.out.print("\t" + myArray[i][j]);
            }
            System.out.println("");
        }

        int[] res = findMax(myArray);
        System.out.println("The largest value is located at row " + res[0] + " and column " + res[1]);
    }
    public static int[] findMax(int[][] A){
        int[] arr = new int[2];
        int max = A[0][0];
        for (int row = 0; row < A.length; row++) {
            for (int col = 0; col < A[0].length; col++){
                if (A[row][col] > max) {
                    max = A[row][col];
                    arr[0] = row;
                    arr[1] = col;
                }
            }
        }
        return arr;
    }
}
