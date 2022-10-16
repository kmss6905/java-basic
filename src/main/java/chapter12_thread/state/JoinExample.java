package chapter12_thread.state;

/**
 * 607 page
 * 다른 스레드가 종료될 때까지 일시 정지 상태 유지
 */
public class JoinExample {
    public static void main(String[] args) {
        SumThread sumThread = new SumThread();
        sumThread.start();
        try {
            sumThread.join(); // sumThread 가 종료할 때 까지 메인스레드를 일시 정시시킴
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1 ~ 100 까지의 합 : " + sumThread.getSum());
    }
}
