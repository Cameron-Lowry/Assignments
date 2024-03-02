// Name: Cameron Lowry
// Class CS 3305/Section 04
// Term: Spring 2202
// Instructor: Dr. Haddad
// Assignment: 2

import java.util.Scanner;

public class ReverseString {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        System.out.println("Input String:\t\t"+s);
        //splits string into word
        String[] l = s.split(" ");
        Stack<String> stack = new Stack<String>();
        //puts words in the stack
        for (String value : l) {
            stack.push(value);
        }
        String r = "";
        //reads stack from the top
        while (!stack.isEmpty()){
            r = r + " " + stack.pop();
        }
        if (r.length()>0)
            r = r.substring(1);
        System.out.println("Reversed String:\t"+r);
    }
}
