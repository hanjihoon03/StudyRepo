package exVa;

import java.util.Scanner;

public class Ex35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int balance = 0;

        while (true){
            System.out.println("----------------------------------");
            System.out.println("1.입금 | 2.출금 | 3.잔액 확인 | 4.종료");
            System.out.println("----------------------------------");
            System.out.print("선택: ");
            int menu = scanner.nextInt();

            if (menu == 1){
                System.out.print("입금액을 입력하세요: ");
               balance = deposit(balance, scanner.nextInt());
            }else if (menu == 2){
                System.out.print("출금액을 입력하세요: ");
                balance = withdraw(balance, scanner.nextInt());
            }else if (menu == 3){
                System.out.println("현재 잔액: " + balance + "원");
            } else if (menu == 4) {
                System.out.println("시스템을 종료합니다.");
                System.exit(0);

            }else {
                System.out.println("올바른 메뉴를 입력해 주세요.");
            }


        }

    }
    public static int deposit(int balance, int inmoney){
        balance += inmoney;
        System.out.print(inmoney + "원 을 입금 했습니다. ");
        System.out.println("현재 잔액: " + balance);
        return balance;

    }
    public static int withdraw(int balance, int outmoney){
        if (balance > outmoney){
            balance -= outmoney;
            System.out.print(outmoney + "원을 출금 했습니다. ");
            System.out.println("현재 잔액: " + balance);
        }else {
            System.out.println(outmoney + "원을 출금하려 했으나 잔액이 부족합니다.");
        }
        return balance;
    }
}
