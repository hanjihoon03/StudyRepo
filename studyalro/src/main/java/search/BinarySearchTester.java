package search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTester {
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

        int result = Arrays.binarySearch(x,key);
        int insertPoint = Math.abs(result) - 1;
        if (result < 0) {
            System.out.println("존재하지 않습니다. 삽입 포인트:" + insertPoint);
        } else {
        System.out.println("result = x[" + result + "]에 존재합니다.");
        }

    }
}
