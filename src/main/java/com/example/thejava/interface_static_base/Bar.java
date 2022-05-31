package com.example.thejava.interface_static_base;

public interface Bar /* extends Foo*/ {

    /**
     * Foo를 상속받지만, Foo의 default 기본 구현체를 제공하고 싶지 않을 경우 추상메서드로 선언을 해주면 됨.
     * 대신 BAR를 구현하는 구현체는 해당 메서드를 구현해야만 함.(재정의)
     */
    //void printNameUpperCase();

    /**
     * Foo에도 default가 있고, Bar에도 default 가 있을경우
     * DefaultFoo에서 둘다를 implements 한다면(동일한 default 메서드) 컴파일 에러가 발생함.
     * 메세지 : com.example.thejava.interface_static_base.DefaultFoo이(가) 타입 com.example.thejava.interface_static_base.Foo 및 com.example.thejava.interface_static_base.Bar의 printNameUpperCase()에 대해 관련 없는 디폴트를 상속합니다
     * 그래서 충돌하는 경우 직접 Override를 해줘야 함.
     *
     */
    default void printNameUpperCase() {
        System.out.println("BAR");
    }
}
