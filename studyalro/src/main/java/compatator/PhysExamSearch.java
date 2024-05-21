package compatator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhysExamSearch {
    static class PhyscData{
        private String name;
        private int height;
        private double vision;

        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public String getName() {
            return name;
        }

        public int getHeight() {
            return height;
        }

        public double getVision() {
            return vision;
        }

        @Override
        public String toString() {
            return
                    "name='" + name + '\'' +
                            ", height=" + height +
                            ", vision=" + vision;
        }

    }
    public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();

    public static class HeightOrderComparator implements Comparator<PhyscData> {
        @Override
        public int compare(PhyscData d1, PhyscData d2) {
            return (d1.height > d2.height) ? 1 :  (d1.height < d2.height) ? -1 : 0;
        }
    }

    public static final Comparator<PhyscData> VISION_ORDER = new VisionOrderComparator();

    public static class VisionOrderComparator implements Comparator<PhyscData> {
        @Override
        public int compare(PhyscData d1, PhyscData d2) {
            return (d1.vision > d2.vision) ? 1 :  (d1.vision < d2.vision) ? -1 : 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhyscData[] x = {
                new PhyscData("익명1",160,1.2),
                new PhyscData("익명2",170,1.8),
                new PhyscData("익명3",152,1.1),
                new PhyscData("익명4",166,1.9),
                new PhyscData("익명5",164,1.6),
        };



        System.out.println("키가 몇인 사람을 찾나요?: ");
        int height = sc.nextInt();
        int result = Arrays.binarySearch(x,new PhyscData("",height,0.0),HEIGHT_ORDER);
        if (result < 0) {
            System.out.println("입력한 키의 값의 사람이 없습니다.");
        } else {
            System.out.println("입력한 사람은 x[" + result +"]에 있습니다.");
            System.out.println("찾은 데이터:" + x[result]);
        }

        System.out.println("시력이 몇인 사람을 찾나요?: ");
        double vision = sc.nextDouble();
        int result2 = Arrays.binarySearch(x,new PhyscData("",0,vision),VISION_ORDER);
        if (result2 < 0) {
            System.out.println("입력한 시력의 값의 사람이 없습니다.");
        } else {
            System.out.println("입력한 사람은 x[" + result2 +"]에 있습니다.");
            System.out.println("찾은 데이터:" + x[result2]);
        }


    }

}
