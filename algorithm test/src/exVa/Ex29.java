package exVa;

import java.util.Scanner;

public class Ex29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] num = new int[4][3];
        int total = 0;



        for (int i = 0; i < 4; i++){
            System.out.println((i+1) +"번 학생의 성적을 입력하세요");
            for (int j =0; j < 3; j++){
                if (j == 0) {
                    System.out.print("국어 점수:");

                } else if (j == 1) {
                    System.out.print("영어 점수:");
                }else {
                    System.out.print("수학 점수:");
                }
                num[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 3; j++){
                total += num[i][j];
            }
            System.out.println(i+1 +"번 학생의 총점: "+ total + ", 평균: " + (double)total/3);
            total = 0;
        }

    }
}
