public class MethBeanTest {
    public static void main(String[] args){
        MethBean math = new MethBean();

        math.printClassName();
        math.printNumber(5000);
        int x = math.getOne();
        System.out.println(x);
        int i = math.plus(1,2);
        System.out.println(i);

    }
}
