package exVa;

public class Ex24 {
    public static void main(String[] args) {
        int[] student = {90, 80, 70, 60, 50};
        int total = 0;


        for (int j : student) {
            total += j;
        }
        double average = (double) total/ student.length;

        System.out.println("점수 총합: "+ total);
        System.out.println("점수 평균: "+ average);
    }
}
