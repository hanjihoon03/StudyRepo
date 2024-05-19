package search;

import java.awt.*;

public class SeqSearch {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        int key = 3;
        int result = findKey(a,key);

        if (result == -1) {
            System.out.println("찾는 key가 요소에 없습니다.");
        } else {
        System.out.println("key = a[" + result + "]에 있습니다.");
        }

    }
    static int findKey(int[] a,int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
