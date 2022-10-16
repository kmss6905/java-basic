package chapter12_thread.state;

public class TargetThread extends Thread {
    public void run() {
        for (int i = 0; i < 1000000000; i++) {}
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            System.out.println(e);
        }
        for (int j = 0; j < 1000000000; j++) {}
    }
}
