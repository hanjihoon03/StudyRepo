package exVa;

import java.util.Scanner;

public class Ex31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] productNames = new String[10];
        int[] productPirces = new int[10];
        int productCount = 0;

        for (int i = 0; i < 11; i++){
            System.out.println("1. 상품 등록 | 2. 상품 목록 | 3. 종료");
            System.out.print("메뉴를 선택하세요: ");
            int num = scanner.nextInt();

            if (num == 1){
                if (productCount == 10){
                    System.out.print("더 이상 삼품을 등록 할 수 없습니다.");
                    break;
                }
                System.out.print("상품 이름을 입력하세요:");
                productNames[i] = scanner.next();
                System.out.print("상품 가격을 입력하세요:");
                productPirces[i] = scanner.nextInt();
                productCount++;
            } else if (num == 2) {
                if (productNames[0] == null){
                    System.out.println("등록된 상품이 없습니다.");
                    continue;
                }
                for(int j = 0; j < i; j++){
                    System.out.println( productNames[j] + ": "+ productPirces[j] + "원");
                }

            } else if (num == 3) {
                System.out.print("프로그램을 종료 합니다.");
                System.exit(0);

            }else {
                System.out.println("올바른 숫자를 입력 해 주세요.");
            }

        }
    }
}
