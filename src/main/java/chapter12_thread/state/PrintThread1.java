package chapter12_thread.state;

public class PrintThread1 extends Thread{
    private boolean stop = false;
    @Override
    public void run() {

        while (!stop) {
            System.out.println("실행중");
        }

        System.out.println("자원정리");
        System.out.println("실행종료");
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
