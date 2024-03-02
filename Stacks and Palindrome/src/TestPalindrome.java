// Name: Cameron Lowry
// Class CS 3305/Section 04
// Term: Spring 2202
// Instructor: Dr. Haddad
// Assignment: 2
import java.util.Scanner;

public class TestPalindrome {public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String s = sc.nextLine();
    System.out.println("Input String:\t"+s);
    //creates a stack out of the inputted string. Then checks if the inputted string is the same backwards as forward.
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < s.length(); i++) {
        stack.push(s.charAt(i));
    }
    String r = "";
    while (!stack.isEmpty()){
        r = r + stack.pop();
    }
    if (r.equalsIgnoreCase(s))
        System.out.println("Judgement:\t\tPalindrome");
    else
        System.out.println("Judgement:\t\tNot Palindrome");
}
}
