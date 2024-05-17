package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Median {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int c = sc.nextInt();
//
//        System.out.println(mid(a,b,c));
        int[] arr = new int[13];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(midRe(arr));

    }
    static int mid(int a, int b, int c) {

        if (a >= b) {
            if (a <= c) {
                return a;
            } else {
                return c;
            }
        } else if (b <= c) {
            return b;
        } else {
            return c;
        }
    }
    static int midRe(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length/2];
    }

}
