package me.whiteship.java8to11;

public interface Bar extends Foo {

    default void printNameUpperCase() {
        System.out.println("BAR");
    }

}
