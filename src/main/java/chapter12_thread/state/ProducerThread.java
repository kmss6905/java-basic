package chapter12_thread.state;

public class ProducerThread extends Thread{
    private DataBox dataBox;

    public ProducerThread(DataBox dataBox) {
        this.dataBox = dataBox;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            String data = "Data-" + i;
            dataBox.setData(data);
        }
    }
}
