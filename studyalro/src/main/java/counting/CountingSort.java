package counting;

import java.util.Scanner;

public class CountingSort {
    static void countingSort(int[] a, int n ,int max) {
        int[] f = new int[max+1]; //누적 도수
        int[] b = new int[n];

        for (int i = 0; i < n; i++) f[a[i]]++; //1단계
        for (int i = 1; i <= max; i++) f[i] += f[i-1]; //2단계
        for (int i = n - 1; i >= 0; i--) b[--f[a[i]]] = a[i]; //3단계
        for (int i = 0; i < n; i++) a[i] = b[i]; //4단계
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("도수 정렬");
        System.out.print("요솟수: ");
        int nx = sc.nextInt();
        int[] a = new int[nx];

        for (int i = 0; i < nx; i++) {
            do {
                System.out.print("x[" + i + "]: ");
                a[i] = sc.nextInt();
            }while (a[i] < 0);
        }
        int max = a[0];
        //배열 a의 최댓값을 구하여 max에 대입한다.
        for (int i = 1; i < nx; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        countingSort(a,nx,max); //배열 a를 도수 정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("a[" + i + "]:" + a[i]);
        }
    }
}
