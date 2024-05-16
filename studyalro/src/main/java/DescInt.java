import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DescInt {
    public static void main(String[] args) {
        long n = 118372;
        System.out.println("n = " + n);
        System.out.println("Desc n = " + sub(n));

    }
    public static long sub(long n) {
        String str = Integer.toString((int) n);
        Character[] digits = new Character[str.length()];
        for (int i = 0; i < str.length(); i++) {
            digits[i] = str.charAt(i);
        }
        Arrays.sort(digits, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (Character digit : digits) {
            sb.append(digit);
        }
        return Long.parseLong(sb.toString());
    }
}
