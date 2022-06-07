package com.example.thejava.excutors;

import java.util.concurrent.*;

public class App {

    public static void main(String[] args) {
        /**
         * excutors
         * 쓰레드 만들기 : 애플리케이션이 사용할 쓰레드 풀을 만들어 관리한다.
         * 쓰레드 관리 : 쓰레드 생명 주기를 관리한다.
         * 작업 처리 및 실행 : 쓰레드로 실행할 작업을 제공할 수 있는 API를 제공한다.
         * ExecutorService
         */
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> System.out.println("Thread " + Thread.currentThread().getName()));
        executorService.shutdown(); //명시적으로 shutdown을 해줘야 함.(graceful로 지금 실행하고 있는 작업을 마무리후 shutdown
        //executorService.shutdownNow(); // 그런거 상관없이 바로 종료


        //ThreadPool 사용
        //Thread 2개를 가지고 돌아가며 사용
        ExecutorService executorServices = Executors.newFixedThreadPool(2);
        executorServices.submit(getRunnable("Hello"));
        executorServices.submit(getRunnable("taekwon"));
        executorServices.submit(getRunnable("java"));
        executorServices.submit(getRunnable("spring"));

        /**
         * ScheduledExecutorService
         */
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(getRunnable("schedule"), 5, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(getRunnable("scheduleAtFixedRate"), 1,5, TimeUnit.SECONDS); //1초있다 출력후 5초마다 출력
    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}
