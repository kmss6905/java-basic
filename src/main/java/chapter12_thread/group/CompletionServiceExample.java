package chapter12_thread.group;

import java.util.concurrent.*;

/**
 * 작업 완류 순으로 통보받기
 * take()메소드가 리턴하는 완료된 작업은 submit()으로 처리 요청한 작업의 순서가 아님을 명심해야한다.
 */
public class CompletionServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        // CompletionService 생성
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);

        System.out.println("[작업 처리 요청]");

        for (int i = 0; i < 3; i++) {
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for (int i = 1; i <= 10; i++) {
                        sum += i;
                    }
                    System.out.println("Thread Name = " + Thread.currentThread().getName() + " / sum = " + sum);
                    return sum;
                }
            });
        }
        System.out.println("[처리 완료된 작업 확인]");
        // 스레드풀의 스레드에서 실행하도록 함. (while 문은 애플리케이션이 종료될 때까지 반복 실행해야 하므로 스레드 풀의 스레드에서 실행하는 것이 좋음)
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Future<Integer> future = completionService.take();
                        int value = future.get();
                        System.out.println("[처리 결과] " + value);
                    } catch (Exception e) {
                        break;
                    }
                }
            }
        });

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdownNow();
    }
}
