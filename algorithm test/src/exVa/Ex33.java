package exVa;

public class Ex33 {
    public static void main(String[] args) {
        printmessage("Hello, world", 5);
        printmessage("a", 7);
        printmessage("b", 6);

    }
    public static void printmessage(String message, int num){
        for(int i = 1; i <= num; i++){
            System.out.println(message);
        }
    }
}
