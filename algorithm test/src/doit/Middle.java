package doit;

import java.util.Scanner;

public class Middle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      int value1 = scanner.nextInt();
      int value2 = scanner.nextInt();

        System.out.println("두 정수 사이의 수의 합은: " + sumof(value1,value2) );
        int sum = 0;
        for (int i = 100; i <= 200; i++){
            sum += i;
        }

        System.out.println(sum);
    }
    public static int sumof(int a, int b){
        int tmp = 0;
        int sum = 0;
        if (b > a) {
            tmp = b;
            b = a;
            a = tmp;
        }
        for (int i = b; i <= a; i++){
            sum += i;
        }
        return sum;
    }
}
