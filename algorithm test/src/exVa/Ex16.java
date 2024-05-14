package exVa;

import java.util.Scanner;

public class Ex16 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("음식 이름을 입력해주세요: ");
        String foodName = stdIn.nextLine();

        System.out.print("음식 가격을 입력해주세요: ");
        int foodPrice = stdIn.nextInt();

        System.out.print("음식 수량을 입력해주세요: ");
        int foodQuantitiy = stdIn.nextInt();

        int totalPrice = foodPrice * foodQuantitiy;
        System.out.println(foodName +" "+ foodQuantitiy + "개를 주문하셨습니다. 총 가격은 " + foodPrice + "원 입니다.");
    }
}
