package exVa;

import java.util.Scanner;

public class Ex28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min =0;
        int max =0;



        System.out.print("입력 받을 숫자의 개수를 입력하세요:");
        int count = scanner.nextInt();
        int[] num = new int[count];

        System.out.println(count +"개의 정수를 입력하세요:");
        for (int i = 0; i < count; i++){
            num[i] = scanner.nextInt();

        }
        min = num[0];
        max = num[0];
        for (int i = 0; i < count; i++){
            if (min > num[i]){
                min = num[i];
            }
            if (max < num[i]){
                max = num[i];
            }
        }
        System.out.println("가장 작은 정수: " + min);
        System.out.println("가장 큰 정수: " + max);


    }
}
