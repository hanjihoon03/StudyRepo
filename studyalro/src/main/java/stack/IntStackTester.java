package stack;

import java.util.Scanner;

public class IntStackTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntStack s = new IntStack(64);

        while (true) {
            System.out.println();
            System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
            System.out.println("1.push 2.pop 3.peek 4.dump 5.clear 6.isEmpty 7.isFull 8.search 0.종료");
            System.out.print("입력:");

            int menu = sc.nextInt();
            if (menu == 0) {
                break;
            }

            int x;
            boolean flag;
            switch (menu) {
                case 1: //push
                    System.out.print("데이터:");
                    x = sc.nextInt();
                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2: //pop
                    try {
                        x = s.pop();
                        System.out.println("pop 데이터는 " + x + " 입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 3: //peek;
                    try {
                        x = s.peek();
                        System.out.println("peek 데이터는 " + x + " 입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 4: //dump
                    s.dump();
                    break;

                case 5: //clear
                    System.out.println("스택을 clear 합니다.");
                    s.clear();
                    break;

                case 6: //isEmpty
                   flag = s.isEmpty();
                    if (flag) {
                        System.out.println("스택은 비어있습니다.");
                    } else {
                        System.out.println("스택은 비어있지 않습니다.");
                    }
                    break;

                case 7: //isFull
                    flag = s.isFull();
                    if (flag) {
                        System.out.println("스택이 가득 찼습니다.");
                    } else {
                        System.out.println("스택이 가득 차 있지 않습니다.");
                    }
                    break;

                case 8: //index
                    System.out.print("검색할 데이터를 입력해주세요:");
                    x = sc.nextInt();
                    int index = s.indexOf(x);
                    if (index >= 0) {
                        System.out.println("찾은 데이터의 위치는 " + s.size() + "개의 데이터 중 " + index + "번 째에 있습니다.");
                    } else {
                        System.out.println("데이터가 스택에 존재하지 않습니다.");
                    }
                    break;
            }
        }
    }
}
