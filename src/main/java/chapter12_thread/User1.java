package chapter12_thread;

public class User1 extends Thread{
    private final Calculator calculator;

    public User1(Calculator calculator) {
        this.calculator = calculator;
        this.setName("User1");
    }

    public void run() {
        this.calculator.setMemory(100);
    }
}
