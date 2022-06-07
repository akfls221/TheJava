package com.example.thejava.callable;

import java.util.Arrays;
import java.util.concurrent.*;

public class App {
    /**
     * Callable
     * Runnable 과 다르게 return 값이 있다.
     */

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Future<String> submit = executorService.submit(hello);
        System.out.println(submit.isDone()); //상태값 확인 끝났으면 true, 안끝났으면 false return
        System.out.println("Started!");

        submit.get(); //get을 만난순간 멈춰서 기다림. 블록킹

        // 현재 진행중인 작업을 인터럽트 하면서 종료, false는 일단 기다리지만 get으로 가져오진 못함. 이때 아래의 done은 cancle을 했기 때문에 true 임.
        // false 인경우 get을하면 cancellationException이 발생함.
        submit.cancel(true);

        System.out.println(submit.isDone()); //여기선 true
        System.out.println("End!");

        executorService.shutdown();
    }
}
