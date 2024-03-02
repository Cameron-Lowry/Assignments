class Node{
    Node next, prev;
    int data;

    Node(int d){
      data = d;
    }
}

class DLL{
    Node head;

    public void push(int d){
        Node new_Node = new Node(d);
        new_Node.prev = null;
        new_Node.next = head;
        head.prev = new_Node;
        new_Node = head;
    }

    public void end(int d){
        Node new_Node = new Node(d);
        new_Node.next = null;
        Node x = head;
        while(x.next != null){
            x = x.next;
        }
        x.next = new_Node;
        new_Node.prev = x;
    }
}
