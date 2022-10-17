package chapter12_thread.state;

/**
 * stop 플래그를 이용하여 스레드를 종료합니다.
 * 스레드는 run()메서드가 끝나면 자동적으로 종료된다.
 * 즉 run() 메소드가 정상적으로 종료되도록 유도하는 방법 중 하나가 stop 플래그를 사용하는 것임
 */
public class StopFlagExample {
    public static void main(String[] args) {
        PrintThread1 thread = new PrintThread1();
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.setStop(true);
    }
}
