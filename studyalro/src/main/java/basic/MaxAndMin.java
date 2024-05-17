package basic;

public class MaxAndMin {
    public static void main(String[] args) {
        int a = 6;
        int b = 11;
        int c = 3;
        int d = 1;
        int result = max4(a, b, c, d);
        System.out.println("result = " + result);
        result = min3(a,b,c);
        System.out.println("result = " + result);
        result = min4(a, b, c, d);
        System.out.println("result = " + result);


    }

    static int max4(int a, int b, int c, int d) {
        int result = 0;
        result = Math.max(a, b);
        result = Math.max(result,c);
        result = Math.max(result,d);
        return result;
    }
    static int min3(int a, int b, int c) {
        int result = 0;
        result = Math.min(a, b);
        result = Math.min(result,c);
        return result;
    }
    static int min4(int a, int b, int c,int d) {
        int result = 0;
        result = Math.min(a, b);
        result = Math.min(result,c);
        result = Math.min(result,d);
        return result;
    }
}
