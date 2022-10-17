package chapter12_thread.group;

public class ThreadGroupExample {
    public static void main(String[] args) {
        ThreadGroup myGroup = new ThreadGroup("myGroup");
        WorkThread workThreadA = new WorkThread(myGroup, "workThreadA");
        WorkThread workThreadB = new WorkThread(myGroup, "workThreadB");
        workThreadA.start();
        workThreadB.start();

        System.out.println("[ main 스레드 그룹의 list() 메소드 출력 내용 ]");
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup(); // 현재 스래드가 속해있는 스레드 그룹을 가져옴
        mainGroup.list(); // 현재 그룹에 포함된 스레드와 아위 그룹에 대한 정보를 출력함.
        System.out.println();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myGroup.interrupt();
    }
}
