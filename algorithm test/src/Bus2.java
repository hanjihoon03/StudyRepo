public class Bus2 extends Car2{
    public Bus2(){
        super("!!");// 부모의 기본 생성자를 호출하는 코드가 자동으로 삽입된다.
        System.out.println("Bus2 기본 생성자");
    }
//부모가 가지고 있는 추상 메소드는 자식에서 반드시 구현해야함
    @Override
    public void run() {
        System.out.println("버스는 후륜구동을 해야한다.");

    }
}
