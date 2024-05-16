import java.lang.annotation.ElementType;
import java.util.Arrays;

public class UpperCaseLowerCase {
    public static void main(String[] args) {
        String str = "aBcDeFg";
       StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {

            if (Character.isUpperCase(c)){
            result.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(c);
            }
        }
        String resultString = result.toString();
        System.out.println("resultString = " + resultString);

    }
}
