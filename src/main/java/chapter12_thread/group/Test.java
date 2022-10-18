package chapter12_thread.group;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // create thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 100; i++) {
            // callable
            Callable<String> callable = new Callable<>() {
                @Override
                public String call() throws Exception {
                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
                    int poolSize = threadPoolExecutor.getPoolSize();
                    String threadName = Thread.currentThread().getName();
                    System.out.println("[총 스레드 개수: " + poolSize + "] 작업 스레드 이름: " + threadName);
                    return threadName;
                }
            };

            // task 요청
            Future<String> submit = executorService.submit(() -> {
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
                int poolSize = threadPoolExecutor.getPoolSize();
                String threadName = Thread.currentThread().getName();
                System.out.println("[총 스레드 개수: " + poolSize + "] 작업 스레드 이름: " + threadName);
                return threadName;
            });

            // block
            String s = submit.get();
            System.out.println("name : " + s);
        }
    }
}
