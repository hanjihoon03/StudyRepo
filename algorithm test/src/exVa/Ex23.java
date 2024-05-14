package exVa;

import java.util.Scanner;

public class Ex23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        String name = "";
        int price = 0;
        int counter = 0;
        int sum = 0;
        int flg = 0;



        while (true){
            System.out.println("1: 상품입력, 2: 결제, 3: 프로그램 종료");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.print("상품명을 입력하세요: ");
                name = scanner.nextLine();
                System.out.print("상품의 가격을 입력해 주세요: ");
                price = scanner.nextInt();
                System.out.print("구매 수량을 입력하세요:");
                counter = scanner.nextInt();
                sum += price * counter;
                System.out.println("상품명: " + name + " "+ "가격: " + price + " "+ " 수량: " + counter  +" " +
                        "합계: " + sum);

            } else if (option == 2) {
                System.out.println("총비용: " + sum);
                sum = 0;

            }else if (option == 3){
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            }else {
                System.out.println("올바른 숫자를 압력해 주세요.");
            }
        }
    }
}
