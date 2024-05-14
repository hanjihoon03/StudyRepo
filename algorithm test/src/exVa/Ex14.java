package exVa;

import java.util.Scanner;

public class Ex14 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("당신의 이름을 입력하세요:");
        String name = stdIn.next();

        System.out.print("당신의 나이를 입력하세요");
        int age = stdIn.nextInt();


        System.out.println("당신의 이름은" + name + "이고, 나이는 " + age + "살 입니다.");


    }
}
