package com.example.fw;

/*
~~의 종류는 상속
Controller의 종류가 여러개
초기화 - 같은 코드
실행 - 다른 코드
마무리 - 같은 코드
*/
public abstract class Controller {
    //사용자가 excute로 메서드를 실행하게 해야하는데 init, close와 같은 메서드를 따로 실행하지 않게끔 하기 위해
    //public이 아닌 protected를 사용.
    //protected는 같은 패키지거나 상속 받았을 때만 사용 가능하다
    //자식 클래스기 메서드를 사용하지 못하게 하기 위해선 final을 붙혀 오버라이딩 하지 못하게 한다.
    protected final void init(){
        System.out.println("초기화 하는 코드");
    }
    protected final void close(){
        System.out.println("마무리 하는 코드");
    }
    protected abstract void run(); //매번 다른 코드

    // 내가 가지고 있는 메소드 호출
    // 어떤 순서를 가지고 있다. 아래와 같은 메소드를 템플릿 메소드라 한다.
    public void excute(){
        this.init();
        this.run();
        this.close();

    }
}
