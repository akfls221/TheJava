package com.example.thejava.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    /**
     * STREAM
     * 데이터를 담고 있는 저장소가 아님.
     * 스트림이 처리하는 데이터 소스를 변경하지 않는다.
     * 데이터는 오직 한번만 처리한다.
     * 무제한일 수 있다.(short Circuit 메소드를 사용해서 제한할 수 있다.)
     *
     */

    /**
     * 중개 오퍼레이션
     * stream을 리턴한다.
     * filter, map, limit, skip, sorted
     * 중개형 오퍼레이션은 Lazy 하다.
     * 중개형 오퍼레이터들은 터미널 오퍼레이터가 오기전까지 실행되지 않음.
     *
     * 종료 오퍼레이션
     * Stream을 리턴하지 않는다.
     * collect, allMatch, count, forEach, min, max
     */
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("taekwan");
        name.add("aaaa");
        name.add("bbbb");
        name.add("toby");

        //여기서도 map은 중개형 오퍼레이션 이기때문에 collect(종료 오퍼레이션)가 실행되기 전까진 실행되지 않는다(lazy 함)
        List<String> collect = name.stream().map(String::toUpperCase).collect(Collectors.toList());
        for (String s : collect) {
            System.out.println("'s' = " + s);
        }



    }
}
