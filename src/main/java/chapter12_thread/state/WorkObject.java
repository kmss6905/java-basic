package chapter12_thread.state;


/**
 *  두 개의 스레드를 교대로 번갈아 가며 실행해야 할 경우 (가령 정확한 교대 작업이 필요할 경우!)
 *  자신의 작업이 끝나면 상대방 스레드를 일시 정지 상태에서 풀어주고, 자신은 일지 정지 상태로 만든다.
 *  이 방법의 핵심은 공유 객체에 있다.
 *  공유 객체는 두 스레드가 작업할 내용을 각각 동기화 메소드로 구분해 놓는다. 한 스레드가 작업을 완료하면 notify() 메소드를 호출해서
 *  일시정지 상태에 있는 다른 스레드를 실행 대기 상태로 만들고 자신은 두번 작업을 하지 않도록 wait() 메소드를호출하여 일시 정지 상태로 만든다.
 *
 *  물론 wait() 대신 wait(long timeout) 이나, wait(long timeout, int nanos) 을 사용하면 notify()을 호출하여
 *  일시정지 상태에 있는 다른 스레드를 굳이 직접적으로 호출 하지 않아도 지정된 시간이 지나면 스레드가 자동적으로 실행 대기 상태가 된다.
 *
 *  단, 위의 메서드들은 전부 동시화 메서드 또는 동기화 블록 내에서만 사용할 수 있다.
 */
public class WorkObject {
    public synchronized void methodA() {
        System.out.println("ThreadA 의 작업 시작");
        notify(); // 일시정지 상태에 있는 ThreadB를 실행 대기 상태로 만듦
        try {
            wait(); // ThreadA를 일시 정지 상태로 만듦
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void methodB() {
        System.out.println("ThreadB 의 작업 시작");
        notify();
        try {
            wait(); // 일시
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
