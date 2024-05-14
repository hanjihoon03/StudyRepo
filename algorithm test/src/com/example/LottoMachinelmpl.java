package com.example;
//인터페이스를 구현하게 되면 인터페이스가 가지고 있는 메소드를 오버라이딩 할 필요가 있다.
public class LottoMachinelmpl implements LottoMachine {
    private Ball[] balls;
    @Override
    public void setBalls(Ball[] balls) {
        this.balls = balls;

    }

    //math.ramdom 은 0.0보다 크로 1.0 보다 작은 수가 나온다 ex) 0.353535
    //실수를 정수로 바꾸어서 사용.

    @Override
    public void mix() {
        for(int i = 0; i < 10000; i++){
           int x1 = (int) (Math.random()* LottoMachine.MAX_BALL_COUNT);
           int x2 = (int) (Math.random()* LottoMachine.MAX_BALL_COUNT);
           if(x1 != x2){
               Ball tmp = balls[x1];
               balls[x1] = balls[x2];
               balls[x2] = tmp;
           }

        }

    }

    @Override
    public Ball[] getBalls() {
        Ball[] result = new Ball[LottoMachine.RETURN_BALL_COUNT];
        for(int i=0; i < LottoMachine.RETURN_BALL_COUNT; i++){
            result[i] = balls[i];
        }
        return result;
    }
}
