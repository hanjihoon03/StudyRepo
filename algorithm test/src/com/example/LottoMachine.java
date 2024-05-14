package com.example;
/*
1. 1-45까지 써 있는 ball을 기계에 넣는다.
2. 로또 기계에 있는 ball을 섞는다
3. 섞인 ball wnd 6개를 꺼낸다
*/

public interface LottoMachine {
    int MAX_BALL_COUNT = 45;
    int RETURN_BALL_COUNT = 6;
    //위 필드들은 public static이 생략되어 있다.
    //메모리에 인스턴스가 올라가지 있지 않아도 사용할 수 있다.
    public void setBalls(Ball[] balls); // Ball[] Ball이 여러개를 받겠다.
    public void mix(); // 자신이 가지고 있는 Ball들을 섞는다.
    public Ball[] getBalls(); //6개의 Ball을 반환한다.
    //위 메소드들은 추상 메소드이다 abstract가 생략 되어 있다.
}
