package prime;

import java.util.Arrays;

public class PrimeNumber2 {
    public static void main(String[] args) {
    int count =0;
    int[] prime = new int[500];
    int ptr = 0;
    prime[ptr++] = 2;

        for (int n = 3; n <= 1000; n += 2) {
            int i;
            //이미 찾은 소수로 나눔
            for (i = 1; i < ptr; i++) {
                count++;
                if (n % prime[i] == 0) {
                    //나누어 떨어지면 소수가 아니다.
                    break;
                }
            }
            if (ptr == i) {
                //마지막까지 나누어 떨어지지 않으면 소수므로 배열에 소수 저장
                prime[ptr++] = n;
            }
        }
        System.out.println(Arrays.toString(prime));
        System.out.println("나눗셈을 수행한 횟수:" + count);
    }
}
