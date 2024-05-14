package exVa;

public class Ex32 {
    public static void main(String[] args) {
        System.out.println(avg(15,25,35));
        System.out.println(avg(1,2,3));

    }
    public static double avg(int a, int b, int c){
        double average = 0.0;
        average = (double) (a + b + c)/3.0;

        return average;
    }
}
