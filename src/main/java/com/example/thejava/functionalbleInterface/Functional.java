package com.example.thejava.functionalbleInterface;

@FunctionalInterface // 함수형 인터페이스 임을 나타냄(규칙 위반시 컴파일 오류)
public interface Functional {

    /**
     * abstract 즉 추상 메서드가 하나일 경우 함수형 인터페이스 라고 할 수 있음.
     * 별도의 static 메서드들이 있어도 abstract 하나만 있다면 함수형 인터페이스라고 함.
     */

    void doIt();

    static void printName() {
        System.out.println("엄태권");
    }

    default void printAge() {
        System.out.println(29);
    }


}
