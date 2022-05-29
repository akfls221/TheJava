package com.example.thejava.functionalbleInterface;

public class Foo {

    public static void main(String[] args) {

        /**
         * 아래의 functional 코드를 toLambda, toLambdas 와 같이 람다식을 통해 줄일 수 있음.
         */

        Functional functional = new Functional() {
            @Override
            public void doIt() {
                System.out.println("엄태권");
            }
        };

        Functional toLambda = () -> System.out.println("엄태권");

        Functional toLambdas = () -> {
            System.out.println("엄태권");
            System.out.println("엄태권2");
        };

        /**
         * 값을 받아 return 하는 경우
         */
        Functional2 functional2 = new Functional2() {
            @Override
            public int doIt(int number) {
                return number + 10;
            }
        };

        Functional2 functional2Lambda = number -> number + 10;

        Functional2 functional2Lambda2 = number -> {
            return number + 10;
        };
    }
}
