public abstract class Car2 {
    public Car2(String name){
        System.out.println("Car2() 생성자 호출");
    }
    //추상 메소드 Car2를 만든 사람은 run()이라는 메소드가 필요하다라 생각 했다,
    // run()은 자동차마다 다르게 구현할 것 같음
    public abstract void run();// 구현 부분 없이 선언만 함
}
