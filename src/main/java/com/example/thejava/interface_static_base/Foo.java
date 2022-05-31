package com.example.thejava.interface_static_base;

public interface Foo {

    void printName();

    /**
     * 인터페이스에 대한 구현체 구현후 추가 추상 메서드를 작성시 해당 인터페이스를 상속한 모든 Class에서 컴파일 error가 발생함.
     * 이에, default 키워드를 통해 해당 문제를 일으키지 않고 특정한 기능을 제공할 수 있음.
     * 즉 해당 기능은 모든 구현체들이 가질 수 있음. > app 참조
     * 해당 기능은 null 이들어올 수 도 있기 때문에, 최소한의 노력으로 문서화해야 함.(ex @ImplSpec
     * 또한 해당 기능은 구현체에서 Override하여 재구현 할 수 있다.
     */

    /**
     * @ImplSpec 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.(moust hover 시 출력)
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    String getName();

    /**
     * 유틸리티 혹은 , 헬퍼 메서드를 제공하고 싶을 때에는 static 메서드 제공이 가능함.
     */
    static void printAnyThing() {
        System.out.println("anyThing");
    }
}
