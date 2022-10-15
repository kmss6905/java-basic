package chapter12_thread;

public class User2 extends Thread{
    private Calculator calculator;

    public User2(Calculator calculator) {
        this.calculator = calculator;
        this.setName("User2");
    }

    public void run() {
        this.calculator.setMemory(50);
    }
}
