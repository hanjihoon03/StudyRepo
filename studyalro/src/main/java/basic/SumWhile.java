package basic;

import java.util.Scanner;

public class SumWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1부터 n까지 합을 구합니다.");
        System.out.print("n의 값:");
        int n = sc.nextInt();

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        System.out.println("result = " + result);
    }
}
