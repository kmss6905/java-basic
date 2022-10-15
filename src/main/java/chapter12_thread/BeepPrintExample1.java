package chapter12_thread;

import java.awt.*;

//  메인스레드만 이용한 경우
public class BeepPrintExample1 {
    public static void main(String[] args) {
//        BeepTask beepTask = new BeepTask();
//        Thread thread = new Thread(beepTask);
//        thread.start();

        // Runnable 익명객체 이용
//       Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Toolkit toolkit = Toolkit.getDefaultToolkit();
//                for (int i = 0; i < 10; i++) {
//                    toolkit.beep();
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        thread.start();

        new Thread(() -> {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            for (int i = 0; i < 10; i++) {
                toolkit.beep();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
