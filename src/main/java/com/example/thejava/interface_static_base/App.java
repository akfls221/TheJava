package com.example.thejava.interface_static_base;

public class App {

    public static void main(String[] args) {
        DefaultFoo foo = new DefaultFoo("taekwan");
        foo.printName();
        foo.printNameUpperCase(); // override 하지 않았지만 사용 가능
        Foo.printAnyThing(); // static 메서드 사용(다만 인스턴스에서 사용하는 것이아님)
    }
}
