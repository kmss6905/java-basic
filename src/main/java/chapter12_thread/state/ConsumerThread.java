package chapter12_thread.state;

public class ConsumerThread extends Thread{
    private DataBox dataBox;

    public ConsumerThread(DataBox dataBox) {
        this.dataBox = dataBox;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            dataBox.getData();
        }
    }
}
