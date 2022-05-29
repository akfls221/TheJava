package com.example.thejava.functionalbleInterface.functionalbe;

import java.util.function.Function;

/**
 * Interface를 만들지 않고 JAVA의 제공 Function<입력타입, Return 타입>을 활용하여 작성 가능
 */
public class Plus10 implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer integer) {
        return integer + 10;
    }
}
