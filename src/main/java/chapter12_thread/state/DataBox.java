package chapter12_thread.state;



/**
 * 두 스레드 작업 내용을 동기화 메소드로 작성한 공유 객체
 * 두 스래드 간의 공유 과정을 wait 메서드와 notify 메서드를 통해 구현함.
 * 핵심은 공유 객체에 있음
 */
public class DataBox {
    private String data;

    public synchronized String getData() {
        // data 필드가 null 이면 소비자 스레드를 일시 정지 상태로 만듦
        if (this.data == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String returnValue = data;
        System.out.println("ConsumerThread 가 읽은 데이터: " + returnValue);
        // data 필드를 null 로 만들고 생산자 스레드를 실행 대기 상태로 만듦
        data = null;
        notify();
        return returnValue;
    }

    public synchronized void setData(String data) {
        // 아직 소비자 스레드가 데이터를 읽지 않았으면 생산자 스레드는 잠시 일시정시 상태로 만든다.
        if (this.data != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // data 필드에 값을 저장하고 소비자 스레드를 실행 대기 상태로 만듦

        this.data = data;
        System.out.println("ProducerThread 가 생성한 데이터 : " + data);
        notify();
    }
}
