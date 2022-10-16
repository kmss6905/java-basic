package chapter12_thread.state;

// 스레드 상태를 살펴보기위한 샘플 스레드 예제
public class StatePrintThread extends Thread {
    private final Thread targetThread;

    public StatePrintThread(Thread targetThread) {
        this.targetThread = targetThread;
    }

    @Override
    public void run() {
        while (true) {
            State state = targetThread.getState();
            System.out.println("타켓 스레드 상태: " + state); // 스레드 상태를 얻습니다.

            if (state == State.NEW) {    // 객체 생성 상태일 경우 실행 대기 상태로 만듦
                targetThread.start();
            }
            System.out.println("타켓 스레드 상태: " + state); // 스레드 상태를 얻습니다.

            if (state == State.TERMINATED) { // 종료 상태일 경우 while문을 종료함
                break;
            }
            try {
                // 0.5초간 일시 정지
                Thread.sleep(500);
            }catch (Exception e){}
        }
    }
}
