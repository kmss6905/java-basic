package chapter12_thread.group;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ResultByRunnableExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        System.out.println("[작업 처리 요청]");
        
    }
}
