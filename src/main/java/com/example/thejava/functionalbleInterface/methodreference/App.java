package com.example.thejava.functionalbleInterface.methodreference;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

    public static void main(String[] args) {
        /**
         * 메서드 레퍼런스
         * 이미 해당 기능을 하는 메서드가 있을경우 해당 메서드를 참조한다.
         * 생성자 또한 메서드 레퍼런스 참조가 가능함.
         */
        //아래의 "hi " + s 는 Greeting.Class 에 hi로 동일한 기능을 하는 메서드가 있음.
        // 아래와 같이 :: 를사용하여 메서드레퍼런스가 사용가능 > Greeting의 hi를 사용하겠다.
        UnaryOperator<String> hi = (s) -> "hi " + s;
        UnaryOperator<String> hiGreeting = (s) -> Greeting.hi(s);
        UnaryOperator<String> hiGreetingMethodReference = Greeting::hi;
        System.out.println("hiGreetingMethodReference.apply() = " + hiGreetingMethodReference.apply("엄태권"));


        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = (s) -> greeting.hello(s);
        UnaryOperator<String> helloMethodReference = greeting::hello;

        //생성자 메서드 레퍼런스 참조
        Supplier<Greeting> newGreeting = Greeting::new;
        Greeting greeting1 = newGreeting.get();
        
        //입력값을 받는 생성자 메서드 레퍼런스 참조
        // 위와 같지만, 다른 생성자를 씀(String을 주입받는 생성자)
        // new를 클릭하여 따라가면 생성자가 다름을 알 수 있음.
        Function<String, Greeting> newGreeting2 = Greeting::new;
        Greeting 엄태권 = newGreeting2.apply("엄태권");

        //임의 객체의 인스턴스 메소드 참조
        //불특정 다수의 인스턴스 메서드를 참조함.
        String[] names = {"tset", "test2", "toby"};
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        Arrays.sort(names, (o1, o2) -> 0);

        Arrays.sort(names, String::compareToIgnoreCase);
        //아래처럼 변경도 가능
        Function<Integer, String> ex = (i) -> i.toString();
        Function<Integer, String> exMethodReference = Objects::toString;



    }
}
