import java.util.Scanner;

/* calculator operations interface, has float addition,subtraction
 and multiplication */
interface CalcOp {
    public float add(float a, float b);
    public float subtract(float a, float b);
    public float multiply(float a, float b);
    public float divide(float a, float b);
}

public class calculatorMain{
    public static void main(String[] args){
        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);
        // while loop for menu and option selection
        while (true) {
            System.out.println("""
                    0 - Exit
                    1 - Addition
                    2 - Subtraction
                    3 - Multiplication
                    4 - Division""");
            System.out.print("Please Choose an Option: ");
            int i = (int) sc.nextInt();
            sc.nextLine();

            //exit line using 0 to break from the loop
            if (i == 0) {
                break;
            }

            //asks for both numbers for the calculation
            System.out.print("Please enter the first number ");
            float j = sc.nextFloat();
            sc.nextLine();
            System.out.print("Please enter the second number ");
            float k = sc.nextFloat();
            sc.nextLine();

            // if else statement to show
            if (i == 1) {
                System.out.println(calc.add(j, k));
            }
            else if (i == 2) {
                System.out.println(calc.subtract(j, k));
            }
            else if (i == 3) {
                System.out.println(calc.multiply(j, k));
            }
            else  if (i == 4)
                System.out.println(calc.divide(j,k));
            System.out.println();
        }
    }
}

/* implements CalcOp to make a working calculator */
class Calculator implements CalcOp{
    public float add(float a, float b){
        return a + b;
    }
    public float subtract(float a, float b){
        return a - b;
    }
    public float multiply(float a, float b){
        return a * b;
    }
    public float divide(float a, float b){
        return a / b;
    }
}