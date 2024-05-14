public class VendingMachineMain {
    public static void main(String[] args){
        VendingMachine.printVersion();
        VendingMachine vm1 = new VendingMachine();
        VendingMachine vm2 = new VendingMachine();//인스턴스 생성
        //vm1이라는 이름으로 참조

        String product = vm1.pushProductButton(100);
        System.out.println(product);

        String product2 = vm1.pushProductButton(200);
        System.out.println(product2);

    }
}
