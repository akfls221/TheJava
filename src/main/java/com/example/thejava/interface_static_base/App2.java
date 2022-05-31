package com.example.thejava.interface_static_base;

import java.util.*;

public class App2 {

    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("taekwan");
        name.add("aaaa");
        name.add("bbbb");
        name.add("toby");

        //foreach 로 s 를 받아 람다식으로 처리가 가능하며, 아래의 경우 메서드 레퍼런스가 가능함.
        name.forEach((s) -> {
            System.out.println(s);
        });

        //메서드 레퍼런스
        name.forEach(System.out::println);

        /**
         * spliterator()
         * iterator와 비슷하며, 쪼갤수 있는 기능을 가진 iterator 임.
         * 순서 상관없이 나누어 처리할 때 좋을듯.
         */
        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> stringSpliterator = spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println(" ===================================== ");
        while (stringSpliterator.tryAdvance(System.out::println));

        //이후에 배울 stream 예시
        long t = name.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("T"))
                .count();
        System.out.println("t = " + t);

        /**
         * removeIf
         */
        name.removeIf(s -> s.startsWith("t"));

        /**
         * Comparator 보통 sort 할때 사용됨.
         * functinal interface임.
         * nullsFirst(), nullsLast() 등이 있음
         */
        //대문자 소문자 상관없이 정렬
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase);
        name.sort(compareToIgnoreCase.reversed());

        
    }
}
