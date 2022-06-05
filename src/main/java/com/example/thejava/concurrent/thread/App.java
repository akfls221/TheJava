package com.example.thejava.concurrent.thread;

import java.util.Arrays;

public class App {

    /**
     * Concurrent 소프트웨어
     * 동시에 여러 작업을 할 수 있는 소프트웨어
     * JAVA 에서 지원하는 concurrent 프로그래밍 : 멀티프로세싱, 멀티쓰레드
     * JAVA 멀티쓰레드 프로그래밍 : Thread / Runnable
     */

    /**
     * 스레드와 프로세스의 차이(https://velog.io/@raejoonee/%ED%94%84%EB%A1%9C%EC%84%B8%EC%8A%A4%EC%99%80-%EC%8A%A4%EB%A0%88%EB%93%9C%EC%9D%98-%EC%B0%A8%EC%9D%B4)
     * 프로세스 : OS로부터 자원을 할당받는 작업의 단위
     * 스레드 : 프로세스가 할당받은 자원을 이용하는 실행의 단위
     */

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("Hello");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread : " + Thread.currentThread().getName());
            }
        });
        thread.start();

        Thread threadRamda = new Thread(() -> System.out.println("Thread : " + Thread.currentThread().getName()));
        threadRamda.start();

        /**
         * 스레드의 대표기능
         * 1) sleep
         * sleep을 한경우 다른 스레드에 우선권이 감.
         */
        Thread sleepThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) { //InterruptedException sleep인 스레드를 누군가 깨웠을때 발생
                    throw new RuntimeException(e);
                }
                System.out.println("Thread : " + Thread.currentThread().getName());
            }
        });

        /**
         * 스레드의 대표기능
         * 2) interrupt
         * 다른 스레드를 꺠우는 기능
         */
        Thread loop = new Thread(() -> {
            while (true) {
                System.out.println("Thread : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    System.out.println("exit!!");
                    return; //종료
                }
            }
        });
        loop.start();

        Thread.sleep(3000L);
        loop.interrupt(); // 깨움 > InterruptedException 발생

        /**
         * 스레드의 대표기능
         * 3) join
         * 다른 스레드를 기다리는 기능
         * 즉 아래의 restThread는 3초간 쉬는 thread임. join을 통해 위의 스레드가 끝날때 까지 기다렸다 다음 system.out을 출력
         */
        Thread rest = new Thread(() -> {
            while (true) {
                System.out.println("Thread : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        });
        rest.start();

        System.out.println("Hello : = " + Thread.currentThread().getName());
        rest.join();
        System.out.println(rest + "is finished");


    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread : " + Thread.currentThread().getName());
        }
    }

}
