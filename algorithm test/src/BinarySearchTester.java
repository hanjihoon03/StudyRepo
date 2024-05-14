import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTester {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.print(":요솟수:");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0]:");
        x[0] = stdIn.nextInt();

        for (int i = 1; i < num; i++){

            do {
                System.out.print("x["+i+"]:");
                x[i] = stdIn.nextInt();
            }while (x[i] < x[i-1]);
            }
        System.out.print("검색할 값:");
        int ky= stdIn.nextInt();

        int idx = Arrays.binarySearch(x, ky);

        if(idx <0)
            for (int j = 0; j < num-1; j++) {
                if (ky < x[j])
                    System.out.println("삽입 포인트는 x[" + j + "]입니다.");
                else
                    System.out.println("삽입 포인트는 x["+j+1+"]입니다.");
            }
        else
            System.out.println("그 값은 x["+idx+"]에 있습니다.");
        }
}
