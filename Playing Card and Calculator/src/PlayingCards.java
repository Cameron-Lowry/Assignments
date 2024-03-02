import java.util.*;

/* Creates a deck of playing cards then selects 5 random cards to form a hand*/

// class for Playing Cards with a constructor and an override toString
class PlayingCard{
    String suite, value;
    public PlayingCard(String s,String v){
        suite = s;
        value = v;
    }

    @Override
    public String toString(){
        String t;
        t = value + " of " + suite;
        return t;
    }
}


class PlayingCardMain {
    public static void main(String[] args) {
        Random myrand = new Random();

        /* creates deck by using 2 arrays one for the 4 suite
        and another for the 13 number/face cards then creating
        am array list */

        String[] suites =  {"Clubs","Diamonds","Hearts","Spades"};


        String[] values = {"A","2","3","4","5","6","7","8","9","10","J", "Q","K"};
        ArrayList<PlayingCard> DeckofPlayingCard = new ArrayList<>();


        //For loop to create the entire deck
        for(int i = 0; i < suites.length; i++){
            for(int j = 0; j < values.length; j++){
                PlayingCard card = new PlayingCard(suites[i], values[j]);
                DeckofPlayingCard.add(card);
            }
        }

       ArrayList<PlayingCard> hand = new ArrayList<>();
        int p;
        p = 0;
        int one, two,three, four, five;
        one = 52;
        two = 52;
        three = 53;
        four = 54;
        five  = 55;

        /* do while loop to draw cards and to check if each card is uniquely pulled to build a hand of 5 cards*/
        do {

           int pos=myrand.nextInt(51);


           if(pos == one){

           } else if(pos == two){

           } else if(pos == three){

           } else if(pos == four){

           } else if(pos == five){

           } else{
               hand.add(DeckofPlayingCard.get(pos));
               if (p == 0){
                   one = pos;
               } else if (p==1){
                   two = pos;
               }  else if (p==2){
                   three = pos;
               }  else if (p==3){
                   four = pos;
               } else {
                   five = pos;
               }

               p = p+1;
           }
       } while (p != 5);

        for(int j = 0; j < hand.size(); j++ ){
            System.out.println(hand.get(j).toString());
        }
     }

}