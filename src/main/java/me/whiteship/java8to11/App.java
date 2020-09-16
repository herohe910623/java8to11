package me.whiteship.java8to11;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {

//        //인스턴스 메소드 참조
//        Greeting greeting = new Greeting();
//        UnaryOperator<String> instance1 = greeting::hello;
//        System.out.println(instance1.apply("Gijin"));
//
//        //스태틱 메소드 참조
//        UnaryOperator<String> static1 = (s) -> "hi "+ s;
//        UnaryOperator<String> static2 = Greeting::hi;
//
//        //기본샏성자
//        Supplier<Greeting> newGreeting = Greeting::new;
//        newGreeting.get();
//
//        //name 반환 생성자 참조
//        Function<String, Greeting> GijinGreeting = Greeting::new;
//        Greeting gijin = GijinGreeting.apply("Gijin2");
//        System.out.println(gijin.getName());
//
//
//
//        //특정타입의 불특정 다수 인스턴스 메소드 참조하는 방법
//        String[] names = {"aaa", "bbb", "ccc"};
//        Arrays.sort(names, String::compareToIgnoreCase);
//        System.out.println(Arrays.toString(names));
//
//        Foo foo = new DefaultFoo("gijin");
//        foo.printName();
//        foo.printNameUpperCase();
//
//        Foo.printAnything();

//        System.out.println("*****API 의 기본 메소드와 스태틱 메소드******");
//        List<String> name = new ArrayList<>();
//        name.add("gijin");
//        name.add("whiteship");
//        name.add("toby");
//        name.add("foo");

//        //결과값은 같다
//        name.forEach(System.out::println);
//        //결과값은 같다
//        for(String n : name) {
//            System.out.println(n);
//        }

//        Spliterator<String> spliterator = name.spliterator();
//        Spliterator<String> spliterator1 = spliterator.trySplit();
//        while (spliterator.tryAdvance(System.out::println));
//        System.out.println("===================");
//        while (spliterator1.tryAdvance(System.out::println));
//
//        System.out.println("===g가 들어간 것이 있다면 제거하고 출력하라====");
//        name.removeIf(s -> s.startsWith("g"));
//        name.forEach(System.out::println);
//
//        System.out.println("***Comparator***");
//        //문자열로 정렬이 된것
//        //역순으로 하는방법은
//        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
//        name.sort(compareToIgnoreCase.reversed());

//        System.out.println("***** Stream 소개 ******");
//        List<String> name = new ArrayList<>();
//        name.add("gijin");
//        name.add("whiteship");
//        name.add("toby");
//        name.add("foo");
//
//        List<String> collect = name.stream().map((s) -> {
//            System.out.println(s + " " + Thread.currentThread().getName());
//            return s.toUpperCase();
//        }).collect(Collectors.toList());
//        collect.forEach(System.out::println);

        //9.Stream Api
        System.out.println("*****9.Stream API******");
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        System.out.println("Spring 으로 시작하는 수업");
        // TODO
        springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring") )
                .forEach(oc -> System.out.println(oc.getTitle()));

        System.out.println("close 되지 않은 수업");
        //TODO
        springClasses.stream()
                .filter(Predicate.not(OnlineClass::isClosed))
                .forEach(oc -> System.out.println(oc.getTitle()));

        System.out.println("수업 이름만 모아서 스트림 만들기");
        //TODO
        springClasses.stream()
                .map(OnlineClass::getTitle)
                .forEach(s -> System.out.println(s));


        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6,"The Java, Test", true));
        javaClasses.add(new OnlineClass(7,"The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8,"The Java, 8 to 11", false));

        List<List<OnlineClass>> gijinEvents = new ArrayList<>();
        gijinEvents.add(springClasses);
        gijinEvents.add(javaClasses);


        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        // TODO
        gijinEvents.stream()
                .flatMap(list -> list.stream())
                .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        // TODO
        //??? 무슨 소리 하는거냐 대체,,, 모르겠으니 패스
        Stream.iterate(10, i -> i+1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        // TODO
        boolean testCheck = javaClasses.stream()
                .anyMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println(testCheck);


        System.out.println("자바 수업 중에 Test가 들어있는 수업 출력");
        List<String> test = javaClasses.stream()
                .filter(oc -> oc.getTitle().contains("Test"))
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());
        test.forEach(System.out::println);


        System.out.println("스프링 수업 중에 제목에 spring이 들어간 제목만 모아서 List로 만들기");
        // TODO
        List<String> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().contains("spring"))
                .map(oc -> oc.getTitle())
                .collect(Collectors.toList());
        spring.forEach(System.out::println);

    }
}
