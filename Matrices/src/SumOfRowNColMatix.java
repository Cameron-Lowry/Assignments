import java.util.Scanner;
public class SumOfRowNColMatix {
    public static void main(String[] args)
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

        int[] coltot = columnTotal(myArray);
        int[] rowtot = rowTotal(myArray);
        for(int i = 0; i < coltot.length ; i++){
            System.out.println("Sum of column " +i+ " is " +coltot[i]);
        }
        for(int i = 0; i < rowtot.length ; i++){
            System.out.println("Sum of row " +i+ " is " +rowtot[i]);
        }
    }
    public static int[] columnTotal(int[][] A){
        int[] colsum = new int[A[0].length];
        for (int i = 0; i < A[0].length ; i++){
            for (int j = 0; j < A.length; j++){
                colsum[i] += A[j][i];
            }
        }
        return colsum;
    }
    public static int[] rowTotal(int[][] A){
        int[] rowsum = new int[A.length];
        for (int i = 0; i < A.length ; i++){
            for (int j = 0; j < A[0].length; j++){
                rowsum[i] += A[i][j];
            }
        }
        return rowsum;
    }
}
