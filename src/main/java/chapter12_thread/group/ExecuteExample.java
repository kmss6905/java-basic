package chapter12_thread.group;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 실제로 스레드풀의 스레드 최대 개수 2는 변함이 없지만, 실행 스레드의 이름을 보면 모두 다른 스레드가 작업을 처리하고 있다.
 *
 * [총 스레드 개수: 2] 작업 스레드 이름: pool-1-thread-2
 * [총 스레드 개수: 1] 작업 스레드 이름: pool-1-thread-1
 * [총 스레드 개수: 2] 작업 스레드 이름: pool-1-thread-3
 * [총 스레드 개수: 2] 작업 스레드 이름: pool-1-thread-4
 * [총 스레드 개수: 2] 작업 스레드 이름: pool-1-thread-5
 * [총 스레드 개수: 2] 작업 스레드 이름: pool-1-thread-6
 * [총 스레드 개수: 2] 작업 스레드 이름: pool-1-thread-7
 * [총 스레드 개수: 2] 작업 스레드 이름: pool-1-thread-8
 * [총 스레드 개수: 2] 작업 스레드 이름: pool-1-thread-9
 * [총 스레드 개수: 2] 작업 스레드 이름: pool-1-thread-10
 *
 * 이는 작업 처리 도중 예외가 발생했기 때문에 해당 스레드는 제거되고 새 스레드가 계속 생성되기 때문이다.
 *
 * submit() 메소드로 작업 처리를 요청한 경우, 예외가 발생하더라고 스레드가 종료되지 않고 계속 재사용되어 다른 작업을 처리하고 있는 것을 볼 수 있다.
 * [총 스레드 개수: 1] 작업 스레드 이름: pool-1-thread-1
 * [총 스레드 개수: 2] 작업 스레드 이름: pool-1-thread-2
 * [총 스레드 개수: 2] 작업 스레드 이름: pool-1-thread-2
 * [총 스레드 개수: 2] 작업 스레드 이름: pool-1-thread-1
 * [총 스레드 개수: 2] 작업 스레드 이름: pool-1-thread-2
 * [총 스레드 개수: 2] 작업 스레드 이름: pool-1-thread-1
 * [총 스레드 개수: 2] 작업 스레드 이름: pool-1-thread-2
 * [총 스레드 개수: 2] 작업 스레드 이름: pool-1-thread-1
 * [총 스레드 개수: 2] 작업 스레드 이름: pool-1-thread-2
 * [총 스레드 개수: 2] 작업 스레드 이름: pool-1-thread-1
 */
public class ExecuteExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);// 최대 스레드 개수가 2인 스레드풀 생성
        for (int i = 0; i < 10; i++) {
            Runnable runnable = () -> {
                // 스레드 총 개수 및 작업 스레드 이름 출력
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
                int poolSize = threadPoolExecutor.getPoolSize();
                String threadName = Thread.currentThread().getName();
                System.out.println("[총 스레드 개수: " + poolSize + "] 작업 스레드 이름: " + threadName);

                // 의도적으로 예외를 발생시킴.
                int value = Integer.parseInt("삼");
            };
//            executorService.execute(runnable);  // 작업 처리 요청
             executorService.submit(runnable);
            Thread.sleep(10);
        }
        executorService.shutdown(); //   스레드풀 종료
    }
}
