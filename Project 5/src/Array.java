import java.util.ArrayList;


public class  Array <e> {
      ArrayList<e> r;
      int itemCount;

    //constructor for the class creates and arraylist and sets itemCount to 0
    public Array(int size) {
        r = new ArrayList<>(size);
        itemCount = 0;
    }

    //returns the length of the list
    public int length(){
        return itemCount;
    }

    //gets the value at a place in the list, checks if the index you want to check is in
    // the range if it returns the item in that index
    public e getValAt(int place){
        e value;
        if(0<= place & place<itemCount){
            value = r.get(place);
            return value;
        }
       return null;
    }

    //Sets the val at a certain index in the list, checks if it is in range of the list
    public void setValAt(int place, e item){
        if(0<= place & place<itemCount) {
            r.set(place, item);
        }
    }

    //adds a new item into the list and increments the itemCount
    public void addItem(e item){
        itemCount ++;
        r.add(item);
    }

    //Finds the index of a certain item if it exists, if it doesn't it returns -1,
    // iterates across the lsit and compares the searched item to ever index
    public int find(e item){
        for(int i=0; i<itemCount; i++){
            if(r.get(i) == item) {
                return i;
            }
        }
        return -1;
    }

    // searchs the array for an item and returns its index, it does this by iterating
    // across the list comparing the item to the items in the array if it is found it
    // returns the index of the item if it is found
    public e search(e item){
        for(int i=0; i<itemCount; i++){
            if(r.get(i) == item) {
                return getValAt(i);
            }
    }
        return null;
    }

    //deletes a certain item if it exists in the list and verifies this by either
    // returning true if it is there and deleted and false if it is not found and
    //deleted
    public boolean delete(e item){
        for(int i=0; i<itemCount; i++){
            if(r.get(i) == item) {
                itemCount --;
                r.remove(i);
                return  true;
            }
        }
        return false;
    }

    //travels across the list and prints out all the items in the array
    public void travel(){
        for(int i=0; i<itemCount; i++){
            System.out.print(getValAt(i) + " ");
        }
    }
}

