package sort;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    //버블 정렬
    static void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j -1, j);
                }
            }
        }
    }

    //이미 버블 정렬된 요소는 정렬하지 않는 버블정렬
    static void bubbleSort2(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int exchg = 0;

            for (int j = n - 1; j > i; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j -1, j);
                    exchg++;
                }
            }

            if (exchg == 0) {
                break;
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요소수:");
        int num = sc.nextInt();
        int[] x = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]:");
            x[i] = sc.nextInt();
        }
        bubbleSort2(x, num);

        System.out.println("오름 차순으로 정렬 했습니다.");
        for (int i = 0; i < num; i++) {
            System.out.println("x[" + i + "]:" + x[i]);
        }
    }
}
