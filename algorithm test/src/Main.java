import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);
        int a = stdIn.nextInt();
        int sum  = 0;
        for(int i = 1; i <= a; i++){
            sum = sum+i;

        }
        sum = sum/10;

    }

}