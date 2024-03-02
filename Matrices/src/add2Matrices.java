import java.util.Scanner;
public class add2Matrices {
    public static void main(String args[]) {

        int[][] myArray1 = new int[3][3];
        int[][] myArray2 = new int[3][3];
        Scanner sc = new Scanner(System.in);

        System.out.println("Matrix A values:");
        for (int row = 0; row < myArray1.length; row++) {
            for (int col = 0; col < myArray1[0].length; col++) {
                System.out.println("Enter a value: ");
                myArray1[row][col] = sc.nextInt();
            }
            System.out.println("");
        }

            System.out.println("Matrix B values:");
            for (int row = 0; row < myArray2.length; row++) {
                for (int col = 0; col < myArray2[0].length; col++) {
                    System.out.println("Enter a value: ");
                    myArray2[row][col] = sc.nextInt();
                }
                System.out.println("");
        }

        System.out.println("MatrixA");
        for (int i = 0; i < myArray1.length; i++) {
            for (int j = 0; j < myArray1[i].length; j++) {
                System.out.print("\t" + myArray1[i][j]);
            }
            System.out.println("");
        }

        System.out.println("MatrixA");
        for (int i = 0; i < myArray2.length; i++) {
            for (int j = 0; j < myArray2[i].length; j++) {
                System.out.print("\t" + myArray2[i][j]);
            }
            System.out.println("");
        }


      myArray2 = addArrays(myArray1, myArray2);
        System.out.println("A + B:");
        for (int i = 0; i < myArray2.length; i++) {
            for (int j = 0; j < myArray2[i].length; j++) {
                System.out.print("\t" + myArray2[i][j]);
            }
            System.out.println("");
        }
}

    public static int[][] addArrays(int[][] one, int[][] two){
        int[][] sum = new int[one.length][one[0].length];
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[0].length; j++) {
                sum[i][j] = one[i][j] + two[i][j];
            }
        }
        return sum;
    }


}