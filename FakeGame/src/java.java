class Trunk {
    int baseballs, softballs, basketballs, footballs;
    Trunk(){
     baseballs = 1;
     softballs = 0;
     basketballs = 1;
     footballs = 2;
    }
    Trunk( int base, int soft, int basket, int foot){
        baseballs = base;
        softballs = soft;
        basketballs = basket;
        footballs = foot;
    }
    int Total(){
        return baseballs + softballs + basketballs + footballs;
    }
}

public class java {
    public static void main(String[] args) {
        Trunk obj = new Trunk();

        System.out.println(obj.Total());

        Trunk item = new Trunk(1, 2, 3, 4);
        System.out.println(item.Total());
       int[] AccountBalances = new int[57];
        for(int i = 0; i < AccountBalances.length; i++){
            if( AccountBalances[i] >= 30000){
                System.out.println(AccountBalances[i]);
            }
        }


    }
}



