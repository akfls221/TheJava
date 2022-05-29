package com.example.thejava.functionalbleInterface;

import com.example.thejava.functionalbleInterface.functionalbe.Plus10;

import java.util.function.*;

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

        /**
         * 함수형으로 내부생성  FUnction(BiFunction 의 경우 입력값이 2개임)
         */
        Function<Integer, Integer> plus10 = (number) -> number + 10;
        plus10.apply(1);

        /**
         * 함수형의 조합(compose) 즉 특정 함수 실행전에 미리 다른 함수를 실행
         */
        Function<Integer, Integer> plus = (number) -> number + 10;
        Function<Integer, Integer> multiply2 = (number) -> number * 2;

        Function<Integer, Integer> multiply2AndPlus10 = plus.compose(multiply2);
        System.out.println("multiply2AndPlus10 = " + multiply2AndPlus10.apply(2));

        /**
         *  함수형의 조함(andThen) 특정 함수 이후(뒤에) 실행
         */
        Function<Integer, Integer> plus10andThenMultiply2 = plus.andThen(multiply2);
        System.out.println("plus10andThenMultiply2 = " + plus10andThenMultiply2.apply(2));

        /**
         * Cunsumer<T> 입력값만 받는 함수 (void 형)
         */
        Consumer<Integer> consumer = (number) -> System.out.println("number = " + number);
        consumer.accept(10);

        /**
         * Supplier<R> 입력값을 받지 않고 받아올 값의 타입을 입력
         */
        Supplier<Integer> get10 = () -> 10;
        System.out.println("Supplier = " + get10.get());

        /**
         * Predicate<T> 입력값을 받아 Truce, False를 return함.
         * or and 등의 조합이 가능함.
         */
        Predicate<String> startWithOwen = (name) -> name.startsWith("Owen");
        Predicate<Integer> isEven = (number) -> number % 2 == 0;

        /**
         * UnaryOperator 입력값의 타입과 리턴값의 타입이 같은 경우 사용가능
         * 아래처럼 Function을 Unary로 사용 가능
         * Function을 상속받은 메서드임.
         */
        Function<Integer, Integer> function = (number) -> number + 10;
        UnaryOperator<Integer> functionToUnary = (number) -> number + 10;

        /**
         * BinaryOperator > BiFunction의 타입이 모두 같은경우 사용 가능
         * BiFunction의 경우 입력값이 2개, retunr 값이 1 개인데 이 3개가 모두 같을경우 BinaryOperator 사용 가능
         */
    }
}

