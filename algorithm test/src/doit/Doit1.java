package doit;

import java.util.Scanner;

public class Doit1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int b = 0;

        System.out.println("1부터 n까지의 합을 구합니다.");
        System.out.println("n값:");
        int a = scanner.nextInt();
        for (int i = 1; i <= a; i++){
            System.out.print(i);
            if (i < a){
                System.out.print("+");
            }
            b += i;
        }
        System.out.println("=" + b);
    }
}
