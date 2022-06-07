package com.example.thejava.callable;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App2 {
    /**
     * Callable
     * 여러개의 callable을 한번에 전달
     */

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "java";
        };

        Callable<String> taekwon = () -> {
            Thread.sleep(1000L);
            return "taekwon";
        };

        //모든 작업이 끝날때 까지 기다렸다가 값을 가져옴.
        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, taekwon));
        for (Future<String> future : futures) {
            System.out.println("future = " + future.get());
        }

        //작업이 끝나는 대로 가장 빨리 끝난 것을 받아오려면(동일한 파일을 여러 서버에서 가져온다 가정할때), invokeAny를 사용
        String s = executorService.invokeAny(Arrays.asList(hello, java, taekwon));
        System.out.println("invokeAny = " + s); //taekwon이 나옴.
        executorService.shutdown();


    }
}
