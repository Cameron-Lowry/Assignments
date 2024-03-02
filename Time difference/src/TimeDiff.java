import java.util.*;
public class TimeDiff {

    /* method to calculate time difference in seconds by
     converting mins and hours into secs*/
static int timeDifference(String a){
    int hours,minutes, seconds;
    String[] arr = a.split(":", 3);
    hours = Integer.parseInt(arr[0]);
    minutes = Integer.parseInt(arr[1]);
    seconds = Integer.parseInt(arr[2]);
    return (hours*60*60) + (minutes*60) + seconds;

}
    public static void main(String[] args){
        String one,two;
        Scanner scan = new Scanner(System.in);

        // asks user for two times and finds the difference

        System.out.println("Enter time 1 in 24hr format as follows (HH:MM:SS)");
        one = scan.nextLine();

        System.out.println("Enter time 2 in 24hr format as follows (HH:MM:SS)");
        two = scan.nextLine();

        System.out.println("Difference in seconds: " + (timeDifference(one) - timeDifference(two)));
    }
}
