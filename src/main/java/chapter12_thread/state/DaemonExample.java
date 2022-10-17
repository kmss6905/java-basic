package chapter12_thread.state;

/**
 * 데몬 스레드는 주 스레드의 작업을 도는 보조적인 역할을 수행하는 스레드이다.
 * 주 스레드가 종료되면 데몬 스레드는 강제적으로 자동 종료된다. 그 이유는 주 스레드의 보조 역할을 수행하므로 주 스레드가 종료되면 데몬 스레드의 존재의미가 없어지기 때문!
 * 적용 예
 * 워드프로세서의 자동 저장, 미디어 플레이어의 동영상 및 음악 재생, 가빚 ㅣ컬렉터 등! 이 기능들은 주 스레드(워드 프로세스, 미디어 플레이어, JVM) 가 종료되면 같이 종료됨
 *
 */
public class DaemonExample {
    public static void main(String[] args) {
        AutoSaveThread autoSaveThread = new AutoSaveThread();
        autoSaveThread.setDaemon(true);
        autoSaveThread.start(); // autoSaveThread 를 데몬스레드로 만듭니다.

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("메인 스레드 종료");
    }
}
