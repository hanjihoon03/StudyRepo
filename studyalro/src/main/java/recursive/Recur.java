package recursive;

import stack.IntStack;

import java.util.Scanner;

public class Recur {
    //재귀 함수
    static void recur(int n) {
        if (n > 0) {
            recur(n - 1);
            System.out.println(n);
            recur(n - 2);
        }
    }

    //--- 꼬리 재귀를 제거한 recur ---//
    static void recur2(int n) {
        while (n > 0) {
            recur(n - 1);
            System.out.println(n);
            n = n - 2;
        }
    }
    //--- 재귀를 제거한 recur ---//
    static void recur3(int n) {
        IntStack s = new IntStack(n);

        while (true) {
            if (n > 0) {
                s.push(n);                                // n 값을 푸시
                n = n - 1;
                continue;
            }
            if (s.isEmpty() != true) {    // 스택이 비어 있지 않으면
                n = s.pop();                            // 저장하고 있던 값을 n에 팝
                System.out.println(n);
                n = n - 2;
                continue;
            }
            break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        recur(num);
        System.out.println("-----------------");
        recur2(num);
        System.out.println("-----------------");
        recur3(num);
    }
}
