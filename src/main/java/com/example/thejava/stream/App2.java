package com.example.thejava.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App2 {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));


        System.out.println("spring 으로 시작하는 수업");
        springClasses.stream().filter(onlineClass -> onlineClass.getTitle().startsWith("spring"))
                        .forEach(c -> System.out.println("c = " + c.getId()));

        System.out.println("close 되지 않은 수업");
        springClasses.stream().filter(oc -> !oc.isClosed())
                        .forEach(oc -> System.out.println("oc = " + oc.getId()));

        springClasses.stream().filter(Predicate.not(OnlineClass::isClosed))
                .forEach(oc -> System.out.println("oc = " + oc.getId()));

        System.out.println("수업 이름만 모아서 스트림 만들기");
        springClasses.stream().map(OnlineClass::getTitle)
                        .forEach(oc -> System.out.println("oc = " + oc));


        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> taekwanEvents = new ArrayList<>();
        taekwanEvents.add(springClasses);
        taekwanEvents.add(javaClasses);



        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        //List 두개를 가지고 있는 리스트를 flatMap() 시켜, 쭉 나열하여 처리한다는 의미
        //Collection::stream = list -> list.stream()
        taekwanEvents.stream().flatMap(Collection::stream)
                        .forEach(oc -> System.out.println("oc.getId() = " + oc.getId()));


        //Stream에 잇는 iterate(중개형 오퍼레이터)를 사용하여 10 부터 1씩증가하는 stream을 만들어줌(skip : 말그대로 skip , limit : 말그대로 제한)
        System.out.println("10 부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);


        //list 에서 가졌는지 확인하는 contains
        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        javaClasses.stream().anyMatch(onlineClass -> onlineClass.getTitle().contains("Test"));


        //중개형 오페레이터 map의 경우 string 타입으로 리턴되기 때문에 순서에 따라 쓰여지는게 다름.
        System.out.println("스프링 수업 중에 제목에 spring이 들어간 제목만 모아서 List로 만들기");
        springClasses.stream().filter(oc -> oc.getTitle().contains("spring"))
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList())
                .forEach(System.out::println);


        springClasses.stream().map(oc -> oc.getTitle())
                .filter(c -> c.contains("spring"))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
