package chapter12_thread.state;

public class InterruptExample {
    public static void main(String[] args) {
        Thread thread = new PrintThread2();
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("인터럽 됨 ? : " + thread.isInterrupted());
        thread.interrupt();
        System.out.println("인터럽 됨 ? : " + thread.isInterrupted());
    }
}
