package basic;

import java.util.Scanner;

public class Gauss {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1부터 n까지 합을 구합니다.");
        System.out.print("n의 값:");
        int n = sc.nextInt();
        int result = (1 + n) * (n/2);
        System.out.println("result = " + result);

    }
}
