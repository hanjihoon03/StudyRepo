package recursive;

import composition.Main;

import javax.swing.text.AbstractDocument;
import javax.swing.text.Element;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Scanner;

/**
 * 유클리드 호재범으로 최대 공약수를 구하는 알고리즘
 */
public class EuclidGCD {

    static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }
    static int gcdRe(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
    static int gcdArray(int[] a, int start, int no) {
        if (no == 1)
            return a[start];
        else if (no == 2)
            return gcd(a[start], a[start + 1]);
        else
            return gcd(a[start], gcdArray(a, start + 1, no - 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("몇 개 정수의 최대 공약수를 구할까요? : ");
        int num;
        do {
            num = sc.nextInt();
        } while (num <= 1);

        int[] x = new int[num];					// 길이가 num 인 배열

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = sc.nextInt();
        }

        System.out.println("최대 공약수는 " + gcdArray(x, 0, num) + "입니다.");

//        System.out.println("두 정수의 최대 공약수를 구합니다.");
//
//        System.out.print("정수를 입력하세요:");
//        int x = sc.nextInt();
//        System.out.print("정수를 입력하세요:");
//        int y = sc.nextInt();
//
//        System.out.println("두 정수의 최대 공약수: " + gcd(x,y) + " 입니다.");
//        System.out.println("두 정수의 최대 공약수: " + gcdRe(x,y) + " 입니다.");
    }
}
