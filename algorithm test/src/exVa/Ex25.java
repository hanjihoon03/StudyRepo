package exVa;

import java.util.Scanner;

public class Ex25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] num = new int[5];

        System.out.println("5개의 정수를 입력하세요:");
        for (int i = 0; i < num.length; i++){
            num[i] = scanner.nextInt();
        }
        System.out.println("출력");
        for (int j = 0; j < num.length; j++){
            System.out.print(num[j]);
            if(j < num.length-1){
                System.out.print(", ");
            }
        }
    }
}
