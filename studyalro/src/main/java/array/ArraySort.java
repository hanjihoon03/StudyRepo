package array;

import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        int[] a= {6,7,8,1,5};


        for (int i = 0; i < a.length/2; i++) {
            swap(a,i,a.length -i -1);
        }
            System.out.println(Arrays.toString(a));

    }
    static void swap(int[] a, int idx1, int idx2) {
        int trans = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = trans;
    }
}
