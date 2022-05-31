package com.example.thejava.interface_static_base;

public class DefaultFoo implements Foo{

    String name;

    public DefaultFoo(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println("DefaultFoo" + this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
