package chapter12_thread;

public class BeepPrintExample3 {

    public static void main(String[] args) {
        BeepThread beepThread = new BeepThread();
        beepThread.start();
        print();
    }

    private static void print() {
        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
