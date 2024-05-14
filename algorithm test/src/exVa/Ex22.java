package exVa;

import java.util.Scanner;

public class Ex22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;
        int flg = 1;

        System.out.println("숫자를 입력하세요. 입력을 중단하려면 -1을 입력하세요: ");


        while (flg != -1) {
            int num = scanner.nextInt();
            if (num == -1) {
                flg = -1;
            }
            sum = (sum + num);
            count++;
        }

        double average = (double) (sum+1)/(count-1);

        System.out.print("입력한 숫자들의 합계: " + (sum + 1));
        System.out.print("입력한 숫자들의 평균: " + average);

/*
축약 반복문
while((num = scanner.nextInt()) != 1){
sum += num;
count++;
}
 */

    }
}
