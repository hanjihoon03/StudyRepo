package search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 이진 탐색
 */
public class BinSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("배열 요소수를 입력하세요:");

        int num = sc.nextInt();

        int[] x = new int[num];
        System.out.println("배열 요소를 순서대로 입력하세요");

        System.out.print("x[0]:");
        x[0] = sc.nextInt();

        for (int i = 1; i < x.length; i++) {
        do {
            System.out.print("x[" + i + "]:");
            x[i] = sc.nextInt();
         } while (x[i] < x[i-1]);
        }

        System.out.print("검색할 값을 입력하새요:");
        int key = sc.nextInt();

        int result = binSearch(x,num,key);
        if (result == -1) {
            System.out.println("찾는 값이 없습니다.");
        } else {
        System.out.println("result = x[" + result +"]에 존재 합니다.");

        }


        int result2 = refactoringBinSearch(x,num,key);
        if (result == -1) {
            System.out.println("찾는 값이 없습니다.");
        } else {
            System.out.println("result2 = x[" + result2 +"]에 존재 합니다.");

        }

    }

    static int binSearch(int[] x, int n, int key) {
        int pl = 0;
        int pr = n - 1;

        do {
            int pc = (pl + pr) / 2;
            if (x[pc] == key) {

                return pc;

            } else if (x[pc] < key) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        } while (pl <= pr);
        //검색  실패
        return -1;
    }
    static int refactoringBinSearch(int[] x, int n, int key) {
        int pl = 0;
        int pr = n - 1;

        do {
            int pc = (pl + pr) / 2;
            if (x[pc] == key) {
                for (int i = pc; i >= pl; i--) {
                    if (x[i] != key) {
                        return i+1;
                    }
                }
                return pc;

            } else if (x[pc] < key) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        } while (pl <= pr);
        //검색  실패
        return -1;
    }

}
