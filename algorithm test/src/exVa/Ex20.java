package exVa;

import java.util.Scanner;

public class Ex20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.print("이름을 입력하세요 (종료를 입력하면 종료) :");
            String name = scanner.nextLine();

            if (name.equals("종료")){
                System.out.print("프로그램을 종료합니다.");
                System.exit(0);
            }

            System.out.print("나이를 입력하세요:");
            int age = scanner.nextInt();
            scanner.nextLine(); // nextInt는 입력 되는 숫자 뒤에 \n이 부는데 줄바꿈을 이 줄이 먹어 없앤다.

            System.out.println("입력한 이름:" + name + ", 나이: "+ age);

        }

    }
}
