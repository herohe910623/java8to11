package me.whiteship.java8to11;

public interface Bar  {

    /**
     * @implSpec
     * "BAR 로 printNameUpperCase 하여 출력해준다.
     */
    default void printNameUpperCase() {
        System.out.println("BAR");
    }

}
