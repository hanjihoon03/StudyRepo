package exVa;

public class Ex34 {
    public static void main(String[] args) {
        int balance = 10000;

        balance = deposit(balance,1000);
        balance = withdraw(balance, 3500);
        System.out.println("최종 잔액은: "+ balance + "원 입니다.");

    }
    public static int deposit(int balance, int amount){
        balance += amount;
        System.out.println(amount +"원을 입금 했습니다. 현재 잔액: "+ balance + "원");
        return balance;
    }
    public static int withdraw(int balance, int wamount){
        if (balance >= wamount) {
            balance -= wamount;
            System.out.println(wamount +"원을 출금 했습니다. 현재 잔액: " + balance + "원");

        }else{
            System.out.println(wamount + "원을 출금하려 했으나 잔액이 부족합니다.");
        }
        return balance;
    }
}
