// Name: Cameron Lowry
// Class CS 3305/Section 04
// Term: Spring 2202
// Instructor: Dr. Haddad
// Assignment: 2

import java.util.Scanner;

public class myTest
{
   // this method prints the menu
   public static void printMenu() {
      System.out.print(
               "--------MAIN MENU-------" + '\n' +
               "1 – Push element" + '\n' +
               "2 – Pop element" + '\n' +
               "3 – Top element" + '\n' +
               "4 – Size of stack" + '\n' +
               "5 – Is Empty stack?" + '\n' +
               "6 - Print stack content" + '\n' +
               "7 - Exit program" + '\n' +
               "Enter option number:");
   }

   public static void main (String[] args)
   {  int choice, p;
      Integer v;
   // choice is used for menu, v is value for inputs, p is position.
      choice = 0;
      Scanner scan = new Scanner(System.in);

      Stack<Integer> myStack = new Stack<Integer>(); //create a list object
      do {
         // User's choice from the menu along with a switch case that executes specific actions based on the user's choice.
         printMenu();
         choice = scan.nextInt();
         scan.nextLine();
         switch (choice) {

            // adds an element to the top of the stack
            case 1:
               System.out.println("What would value would you like to push at the first node?");
               v = scan.nextInt();
               System.out.println("Testing method push()");
               System.out.println("Adding value " + v + " as head");
               System.out.println("List content before adding " + v + " is: " );
               myStack.printStack();
               System.out.println();
               myStack.push(v);
               System.out.println("List content after adding " + v + " is: " );
               myStack.printStack();
               System.out.println();
               break;

               // removes top element from the stack
            case 2:
               System.out.println("Testing method pop()");
               System.out.println("List content before popping is: " );
               myStack.printStack();
               System.out.println();
               v = myStack.pop();
               if (v == null) {
                  System.out.println("Stack is empty");
                  break;
               }
               System.out.println("List content after popping " + v + " is: " );
               myStack.printStack();
               System.out.println();
               break;

               //shows top element
            case 3:
               System.out.println("Testing method top()");
               System.out.println("List content before reading is: " );
               myStack.printStack();
               System.out.println();
               v = myStack.top();
               if (v == null) {
                  System.out.println("Stack is empty");
                  break;
               }
               System.out.println("List content after reading " + v + " is: " );
               myStack.printStack();
               System.out.println();
               break;

               //shows size of stack
            case 4:
               System.out.println("Testing method size()");
               System.out.println("List content before reading is: " );
               myStack.printStack();
               System.out.println();
               v = myStack.size();
               System.out.println("Size is " + v);
               break;

               //shows if stack is empty
            case 5:
               System.out.println("Testing method isEmpty()");
               if (myStack.isEmpty())
                  System.out.println("The stack is empty");
               else
                  System.out.println("The stack has elements in it");
               break;

               // shows the contents of the stack
            case 6:
               System.out.println("Stack content is: ");
               myStack.printStack();
               System.out.println();
               break;
         }
      } while (choice != 7);
      System.out.println("Exiting Program");
   } 
}
    
