import java.util.*;

public class ReverseLetters {

    public static void main(String[] args){
        // created a linked list to hold the characters of the inputed word
        // and a string to hold the inputted word
        LinkedList<Character> word = new LinkedList<Character>();
        String input;


        Scanner scan = new Scanner(System.in);
        //asks the user to input a word to reverse and then saves the word in input
        System.out.println("Input the word you want to reverse");
        input = scan.next();

        //for loop to add the characters inside of the string input into the linkedlist
        for (int i=0; i<input.length(); i++){
            word.add(input.charAt(i));
        }

        //String Builder class imported to help convert the chars into a string
        StringBuilder reverse = new StringBuilder();

        //while loop to append the last char in word to reverse the inputted word
        while(word.size() > 0){
            reverse.append(word.removeLast());
        }

        System.out.println("The word reversed is: " + reverse.toString());

    }
}
