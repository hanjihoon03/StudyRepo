package sort;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysSortTester {
    //sort를 사용한 퀵정렬
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = sc.nextInt();
        int[] x = new int[num];

        for (int i = 0; i < x.length; i++) {
            System.out.print("x[" + i + "]:");
            x[i] = sc.nextInt();
        }

        Arrays.sort(x);

        System.out.println("오름차순 정렬");
        for (int i = 0; i < x.length; i++) {
            System.out.println("x[" + i + "]:" + x[i]);
        }
    }
}
