package exVa;

import java.util.Scanner;

public class Ex27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        double average = 0;
        System.out.print("입력 받을 숫자의 개수를 입력하세요:");
        int number = scanner.nextInt();

        int[] num = new int[number];
        System.out.println(+ number + "개의 정수를 입력하세요:");

        for (int i = 0; i < num.length; i++){
            num[i] = scanner.nextInt();
            sum += num[i];
        }
        System.out.println("입력한 정수의 합계:" + sum);
        average = (double) sum/num.length;
        System.out.println("입력한 정수의 평균:" + average);
    }

}
