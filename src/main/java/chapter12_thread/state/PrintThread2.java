package chapter12_thread.state;

public class PrintThread2 extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("스레드 : " + getName() + "가 실행중");
            if (Thread.interrupted()) {
                break;
            }
        }

        /**
         * 잠깐 일시정지를 만들 수도 있다.
         * try {
         *             while (true) {
         *                 System.out.println("스레드 : " + getName() + "가 실행중");
         *                 Thread.sleep(1);
         *             }
         *         } catch (InterruptedException e) {
         *             System.out.println("인터럽 발생");
         *  }
         */
        System.out.println("스레드 : " + getName() + "자원정리");
        System.out.println("스레드 : " + getName() + "실행 종료");
    }
}
