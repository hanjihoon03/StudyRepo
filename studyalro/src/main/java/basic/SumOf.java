package basic;

import java.util.Scanner;

public class SumOf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("n부터 n까지 합을 구합니다.");

        System.out.print("n의 값:");
        int n = sc.nextInt();

        System.out.print("m의 값:");
        int m = sc.nextInt();

        int result = 0;

        if (n > m) {
            int change = m;
            m = n;
            n = change;
        }

        for (int i = n; i <= m; i++) {
            result += i;
        }
        System.out.println("result = " + result);
    }
}
