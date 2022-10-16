package chapter12_thread;

public class ThreadB extends Thread{
    public boolean stop = false;
    public boolean work = true;


    public ThreadB() {
       setName("ThreadB");
    }


    @Override
    public void run() {
        while (!stop) {
            if (work) {
                for (int i = 0; i < 2; i++) {
                    System.out.println(getName() + "가 출력한 내용");
                }
            }else{
                Thread.yield();
            }
        }
        System.out.println(getName() + " 종료");
    }
}
