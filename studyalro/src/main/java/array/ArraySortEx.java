package array;

import basic.SumOf;

import java.util.Arrays;

public class ArraySortEx {
    public static void main(String[] args) {
        int[] a= {1,2,3,4,5};
        int[] c= new int[a.length];

        System.out.println(sumOf(a));
        int[] b = a.clone();
        System.out.println(Arrays.toString(a));
        System.out.println(a == b);
        System.out.println(Arrays.equals(a, b));
        System.out.println(Arrays.toString(b));


        for (int i = 0; i < a.length/2; i++) {
            swap(a,i,a.length -i -1);
        }
        System.out.println("역순 정렬 종료");
        System.out.println(Arrays.toString(a));

        rcopy(a,c);
        System.out.println(Arrays.toString(c));



    }
    static void swap(int[] a, int idx1, int idx2) {
        int trans = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = trans;
        System.out.println("[" + idx1 + "]과 [" + idx2 + "] 를 교환합니다.");
    }
    static void rcopy(int[] a, int[] c) {
        for (int i = 0; i < a.length; i++) {
            c[i] = a[a.length - i - 1];
        }
    }
    static int sumOf(int[] a) {
        return Arrays.stream(a).sum();
    }
}
