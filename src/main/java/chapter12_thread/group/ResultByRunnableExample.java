package chapter12_thread.group;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 작업 처리 결과를 외부 객체에 저장
 * 상황데 따라서 스레드가 작업한 결과를 외부 객체에 저장해야 할 경우도 있다. 예를 들어 스레드가 작업 처리를 완료하고 외부 Result 객체에 작업 결과를 저장하면,
 * 애플리케이션이 Result 객체를 사용해서 어떤 작업을 진행할 수 있다. 대개 Result 객체는 공유 객체가 되어, 두 개 이상의 스레드 작업을 취합할 목적으로 이용된다.
 */
public class ResultByRunnableExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


        System.out.println("[작업 처리 요청]");

        class Task implements Runnable {
            Result result;

            public Task(Result result) {
                this.result = result;
            }

            // 작업 정의
            @Override
            public void run() {
                int sum = 0;
                for (int i = 0; i <= 10; i++) {
                    sum += i;
                }
                result.addValue(sum); // result 객체에 작업결과 저장
            }
        }


        // 두가지 작업 처리를 요청
        Result result = new Result();
        Runnable task1 = new Task(result);
        Runnable task2 = new Task(result);

        // submit 은 작업처리결과를 받을 수 있도록 Future을 리턴한다.
        Future<Result> future1 = executorService.submit(task1, result);
        Future<Result> future2 = executorService.submit(task2, result);

        try {
            result = future1.get();
            result = future2.get();
            System.out.println("[처리결과] " + result.accumValue);
            System.out.println("[작업 처리 완료]");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            System.out.println("[실행 예외 발생함] " + e.getMessage());
        }

        executorService.shutdown();
    }


    // 처리 결과를 저장하는 Result 클래스
}

class Result {
    int accumValue;
    synchronized void addValue(int value) {
        accumValue += value;
    }
}
