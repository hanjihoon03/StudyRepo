package factorial;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력: ");
        int num = sc.nextInt();
        System.out.println("num의 팩토리얼은 " + factorial(num) + "입니다.");
    }
    static int factorial(int n) {
        if (n > 0) {
            return n * factorial(n - 1);
        } else {
            return 1;
        }
    }

}
