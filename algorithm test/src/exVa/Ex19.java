package exVa;

import java.util.Scanner;

public class Ex19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("첫 번 째 숫자를 입력하세요: ");
        int num1 = scanner.nextInt();

        System.out.print("두 번 째 숫자를 입력하세요: ");
        int num2 = scanner.nextInt();

        if (num1 > num2) {
            System.out.print("두 숫자 사이의 모든 정수: ");
            for (int i = num2; i <= num1; i++) {
                System.out.print(i);
                if (i < num1){
                    System.out.print(",");
                }
            }
        } else {
            int tmp = 0;
            tmp = num1;
            num1 = num2;
            num2 = tmp;
            System.out.print("두 숫자 사이의 모든 정수: ");
            for (int i = num2; i <= num1; i++) {
                System.out.print(i);
                if (i < num1){
                    System.out.print(",");
                }
            }
        }
    }
}
