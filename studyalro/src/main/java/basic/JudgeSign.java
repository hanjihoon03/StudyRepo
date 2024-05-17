package basic;

import java.util.Scanner;

public class JudgeSign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력하세요:");
        int a = sc.nextInt();
        judge(a);
    }
    static void judge(int a) {
        if (a > 0) {
            System.out.println("양수 입니다.");
        } else if (a < 0) {
            System.out.println("음수 입니다.");
        } else {
            System.out.println("0 입니다.");
        }

    }
}
