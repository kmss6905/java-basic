package chapter12_thread;

public class ThreadNameExample {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println("프로그램 시작 스레드 이름 : " + thread.getName());

        Thread a = new ThreadA();
        System.out.println("작업스레드 이름 : " + a.getName());
        a.start();

        Thread b = new ThreadB();
        System.out.println("작업스레드 이름 : " + b.getName());
        b.start();
    }
}
