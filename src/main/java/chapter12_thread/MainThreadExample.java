package chapter12_thread;

public class MainThreadExample {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        User1 user1 = new User1(calculator);
        User2 user2 = new User2(calculator);


        user1.start();
        user2.start();
    }
}
