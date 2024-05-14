package com.example;

public class LottoMachineMain {
    public static void main(String[] args){
        //LottoMachine 인스턴스 생성
        Ball[] balls = new Ball[LottoMachine.MAX_BALL_COUNT];

        for(int i = 0; i < LottoMachine.MAX_BALL_COUNT; i++){
            balls[i] = new Ball(i+1);
        }
        LottoMachine lottoMachine = new LottoMachinelmpl(); //로또머신 인퍼테이스를 구현하고 있는 인스턴스를 생성했고 로또머신으로 참조
        lottoMachine.setBalls(balls);
        lottoMachine.mix();
        Ball[] result = lottoMachine.getBalls();

        for(int i= 0; i < result.length; i++){
            System.out.println(result[i].getNumber());
        }
    }
}
