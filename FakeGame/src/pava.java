import java.util.*;
 class Cat{
    boolean doctor;
    String name;
    public Cat(String n){
        name = n;
        doctor = false;
    }
    boolean VisitDoctor(){
        doctor = true;
        return doctor;
    }
        }
public class pava {
    public static void main(String[] args){
       String name;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Cats name");
        name = sc.nextLine();
         Cat ho = new Cat(name);

    }

}
