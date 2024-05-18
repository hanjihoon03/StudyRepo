package prime;

import java.util.Arrays;

/**
 * 에라토스테네스의 체 알고리즘 응용
 */
public class PrimeNumber3 {
    public static void main(String[] args) {
    int count =0;
    int ptr = 0;
    int[] prime = new int[500];

    prime[ptr++] = 2;
    prime[ptr++] = 3;

        for (int n = 5; n <= 1000; n += 2) {
            boolean flag = false;

            //이미 찾은 소수로 나눔
            for (int i = 1; prime[i] * prime[i] <= n; i++) {
                count += 2;
                if (n % prime[i] == 0) {
                    flag = true;
                    //나누어 떨어지면 소수가 아니다.
                    break;
                }
            }
            if (!flag) {
                //마지막까지 나누어 떨어지지 않으면 소수므로 배열에 소수 저장
                prime[ptr++] = n;
                count++;
            }
        }
        System.out.println(Arrays.toString(prime));
        System.out.println("나눗셈을 수행한 횟수:" + count);
    }
}
