package chapter12_thread.state;

import chapter12_thread.ThreadA;
import chapter12_thread.ThreadB;

public class YieldExample {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();

        threadA.start();
        threadB.start();

        stop();
        threadA.work = false; // Thread B만 실행

        stop();
        threadA.work = true; // Thread A, Thread B 모두 실행

        stop();
        threadB.stop = true; // thread A, Thread B 모두 종료
        threadA.stop = true;

    }

    private static void stop() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
