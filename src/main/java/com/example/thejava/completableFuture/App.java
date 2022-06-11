package com.example.thejava.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 자바에서 비동기 프로그래밍을 가능케하는 인터페이스
         * Future를 사용해서도 어느정도 가능했지만 힘들 일들이 많았음.
         *
         */
        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("taekwan");

        System.out.println("future.get() = " + future.get());

        CompletableFuture<String> future2 = CompletableFuture.completedFuture("taekwon");
        System.out.println("future2 = " + future2);


        /**
         * 비동기로 작업 실행하기
         * 리턴값이 없는경우 : runAsync()
         * 리턴값이 있는 경우 : supplyAsync()
         */
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
            System.out.println("hellow taekwan");
        });

        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println("hellow taekwan");
            return "taekwan";
        });

        System.out.println("supplyAsync = " + supplyAsync.get());

        /**
         * 콜백 제공하기
         */
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync = " + Thread.currentThread().getName());
            return "taekwon!";
        }).thenApply((s) -> {
            return s.toUpperCase();
        });

        System.out.println("future4 = " + future4.get());

        //리턴이 없고 받아서 쓰기만 하는 경우
        CompletableFuture<Void> future5 = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync = " + Thread.currentThread().getName());
            return "taekwon!";
        }).thenAccept((s) -> {
            System.out.println("s = " + s.toUpperCase());
        });

        future5.get();

    }
}
