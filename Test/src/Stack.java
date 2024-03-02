// Name: Cameron Lowry
// Class CS 3305/Section 04
// Term: Spring 2202
// Instructor: Dr. Haddad
// Assignment: 2

public class Stack <E> {
    public Node head;

    //constructor method to create a list of object with head.
    public Stack()
    {
        head = null;
    }

    // class to create nodes as objects
    private class Node
    {
        private E data;  //data field
        private Node next; //link field

        public Node(E item) //constructor method
        {
            data = item;
            next = null;
        }
    }
    // method to push an element on top of the stack
    public void push(E element){
        Node tmp = head;
        head = new Node(element);
        head.next = tmp;
    }
    // method to pop an element off the top of the stack
    public E pop(){
        if (head != null){
        Node tmp = head;
        head = head.next;
        return tmp.data;
        }
        return null;
    }
    // method displays the data of the top element
    public E top(){
        if (head != null){
        return head.data;
        }
        return null;
    }
    // method to return size
    public int size(){
        Node tmp = head;
        int i = 0;
        while (tmp != null) {
            i++;
            tmp = tmp.next;
        }
        return i;
    }
    // method to see if stack is empty
    public boolean isEmpty(){
        return (head==null);
    }
    // method to print the stack
    public void printStack(){
        Node tmp = head;
        int i = 0;
        while (tmp != null) {
            System.out.print(tmp.data.toString() + " ");
            tmp = tmp.next;
        }

    }
}
