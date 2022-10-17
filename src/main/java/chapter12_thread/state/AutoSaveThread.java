package chapter12_thread.state;

public class AutoSaveThread extends Thread{

    public void save() {
        System.out.println("작업 내용을 저장합니다.");
    }

    public void quit() {
        System.out.println("저장스레드를 종료합니다.");
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                quit();
                break;
            }
            save();
        }
    }
}
