package chapter12_thread;

public class ThreadA extends Thread{
    public boolean stop = false;
    public boolean work = true;
    public ThreadA() {
        setName("ThreadA");
    }

    @Override
    public void run() {
        while (!stop) {
            if (work) {
                System.out.println(getName() + "가 출력한 내용");
            } else {
                Thread.yield();
            }
        }
        System.out.println(getName() + "종료");
    }
}
