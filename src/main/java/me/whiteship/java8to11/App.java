package me.whiteship.java8to11;

import org.springframework.core.task.support.ExecutorServiceAdapter;

import javax.swing.text.html.Option;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//19.Annotation
@Chicken("양념")
@Chicken("마늘간장")
public class App {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

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

//        //9.Stream Api
//        System.out.println("*****9.Stream API******");
//        List<OnlineClass> springClasses = new ArrayList<>();
//        springClasses.add(new OnlineClass(1, "spring boot", true));
//        springClasses.add(new OnlineClass(2, "spring data jpa", true));
//        springClasses.add(new OnlineClass(3, "spring mvc", false));
//        springClasses.add(new OnlineClass(4, "spring core", false));
//        springClasses.add(new OnlineClass(5, "rest api development", false));
//
//        System.out.println("Spring 으로 시작하는 수업");
//        // TODO
//        springClasses.stream()
//                .filter(oc -> oc.getTitle().startsWith("spring") )
//                .forEach(oc -> System.out.println(oc.getTitle()));
//
//        System.out.println("close 되지 않은 수업");
//        //TODO
//        springClasses.stream()
//                .filter(Predicate.not(OnlineClass::isClosed))
//                .forEach(oc -> System.out.println(oc.getTitle()));
//
//        System.out.println("수업 이름만 모아서 스트림 만들기");
//        //TODO
//        springClasses.stream()
//                .map(OnlineClass::getTitle)
//                .forEach(s -> System.out.println(s));
//
//
//        List<OnlineClass> javaClasses = new ArrayList<>();
//        javaClasses.add(new OnlineClass(6,"The Java, Test", true));
//        javaClasses.add(new OnlineClass(7,"The Java, Code manipulation", true));
//        javaClasses.add(new OnlineClass(8,"The Java, 8 to 11", false));
//
//        List<List<OnlineClass>> gijinEvents = new ArrayList<>();
//        gijinEvents.add(springClasses);
//        gijinEvents.add(javaClasses);
//
//
//        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
//        // TODO
//        gijinEvents.stream()
//                .flatMap(list -> list.stream())
//                .forEach(oc -> System.out.println(oc.getId()));
//
//        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
//        // TODO
//        Stream.iterate(10, i -> i+1)
//                .skip(10)
//                .limit(10)
//                .forEach(System.out::println);
//

//        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
//        // TODO
//        boolean testCheck = javaClasses.stream()
//                .anyMatch(oc -> oc.getTitle().contains("Test"));
//        System.out.println(testCheck);
//
//        System.out.println("자바 수업 중에 Test가 들어있는 수업 출력");
//        // 내가 테스트 해보기
//        List<String> test = javaClasses.stream()
//                .filter(oc -> oc.getTitle().contains("Test"))
//                .map(OnlineClass::getTitle)
//                .collect(Collectors.toList());
//        test.forEach(System.out::println);
//
//        System.out.println("스프링 수업 중에 제목에 spring이 들어간 제목만 모아서 List로 만들기");
//        // TODO
//        List<String> spring = springClasses.stream()
//                .filter(oc -> oc.getTitle().contains("spring"))
//                .map(oc -> oc.getTitle())
//                .collect(Collectors.toList());
//        spring.forEach(System.out::println);

//        System.out.println("***** 10.Optional 소개 *****");
//
//        List<OnlineClass> springClasses = new ArrayList<>();
//        springClasses.add(new OnlineClass(1, "spring boot", true));
//        springClasses.add(new OnlineClass(2, "spring data jpa", true));
//        springClasses.add(new OnlineClass(3, "spring mvc", false));
//        springClasses.add(new OnlineClass(4, "spring core", false));
//        springClasses.add(new OnlineClass(5, "rest api development", false));
//
//        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
//        //아래와 같은방법으로 nullPointException을 코딩해왔는데, 에러를 만들기 좋은 코드이다. null 체크하는것을 깜빡할수 있기 떄문이다.
//        //2.null을 리턴한는것 자체가 문제였다. 두가지 선택밖에 없엇다. 에러를 던지거나, stack trace를 찍는데, 이 자체로 리소스를 쓰게되기 때문이다.
////        Progress progress = spring_boot.getProgress();
////        if (progress != null) {
////            System.out.println(progress.getStudyDuration());
////        }
//        //자바8 부터 명시적으로 표시가 가능하게 되었다.
//        Optional<Progress> progress = spring_boot.getProgress();
//        progress.ifPresent(p -> System.out.println(p.getStudyDuration()));
//
//
//        System.out.println("***** 12. Date와 Time API 소개 *****");
//
//        Calendar gijinBirthDay = new GregorianCalendar(1991, Calendar.JULY, 23);
//        System.out.println(gijinBirthDay.getTime());
//        gijinBirthDay.add(Calendar.DAY_OF_YEAR,1);
//        System.out.println(gijinBirthDay.getTime());
//
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime gijinBirthDay2 = LocalDateTime.of(1991, 6, 23, 0, 0);
//        Duration duration = Duration.between(now, gijinBirthDay2);
//        System.out.println(duration + " Duration");
//
//        LocalDate now2 = LocalDate.now();
//        LocalDate gijinBirthDay3 = LocalDate.of(1991, 6, 23);
//        Period period = Period.between(now2, gijinBirthDay3);
//        System.out.println(period + " Period");
//
//        ZonedDateTime zonedDateTime = ZonedDateTime.now();
//        System.out.println(zonedDateTime);
//
//        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("MMddyyyy");
//        System.out.println(zonedDateTime.format(timeFormatter));
//
//        Instant instant = Instant.now();
//        System.out.println(instant.atZone(ZoneId.of("Asia/Seoul")));
//
//        Calendar gisungBirthDay = new GregorianCalendar(1988, Calendar.NOVEMBER, 8);
//        System.out.println(gisungBirthDay.getTime());

//        System.out.println("******14. CompletableFuture");
//        MyThread myThread = new MyThread();
//        myThread.start();
//
//        System.out.println("Hello" + Thread.currentThread().getName());
//
//        Thread thread = new Thread(() -> {
////            try {
////                Thread.sleep(1000L); //재웠기때문에 믿에 main 스레드인 Hello가 먼저 찍힌다.
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
//
//            //다른 스레드 깨우기
////            while(true) {
////                System.out.println("Thread : " + Thread.currentThread().getName());
////                try {
////                    Thread.sleep(1000L);
////                } catch (InterruptedException e) {
////                    System.out.println("exit!");
////                    return;
////                }
////            }
////        });
//            //Thread.sleep(3000L);
//            //thread.interrupt();
//
//            System.out.println("Thread : " + Thread.currentThread().getName());
//            try {
//                Thread.sleep(3000L);
//            } catch (InterruptedException e) {
//                //
//                throw new IllegalStateException(e);
//            }
//        });
//        thread.start();
//
//        System.out.println("Hello: "+ Thread.currentThread().getName());
//        thread.join(); //3초 스레드가 끝날때까지 기다린다.
//        System.out.println(thread + " is finished");
//    }

//        System.out.println("**** 15: Executors *****");
//
//        ExecutorService executorService = Executors.newSingleThreadExecutor(); //1
//        ExecutorService executorService = Executors.newFixedThreadPool(2); //2
//        executorService.submit(getRunnable("Hello"));
//        executorService.submit(getRunnable("World"));
//        executorService.submit(getRunnable("Thread"));
//        executorService.submit(getRunnable("Pool"));
//        executorService.shutdown();

//        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(); //3
////        scheduledExecutorService.schedule(getRunnable("Hello"),3, TimeUnit.SECONDS);
//        scheduledExecutorService.scheduleAtFixedRate(getRunnable("World"),1,3,TimeUnit.SECONDS);
//    }
//
//    private static Runnable getRunnable(String message) {
//        return () -> {
//            System.out.println(message + Thread.currentThread().getName());
//        };
//        System.out.println("***** 16: Callable과 Future *****");
//
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//
//        //Callable을 한꺼번에 던질수 있다.
//        Callable<String> hello = () -> {
//            Thread.sleep(2000L);
//            return "Hello";
//        };
//        Callable<String> java = () -> {
//            Thread.sleep(3000L);
//            return "Java";
//        };
//        Callable<String> gijin = () -> {
//            Thread.sleep(1000L);
//            return "GiJin";
//        };
//        //invokeAll 은 3개의 시간이 다 끝날때 전부 가져온다. 2
////        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, gijin));
////        for(Future<String> f : futures) {
////            System.out.println(f.get());
////        }
//        //invokeAny 는 3개의 시간 중 빨리 끝난것을 가져온다. 3
//        // Executors.newSingleThreadExecutor(); 는 쓰레드가 하나라서 hello가 출력되버림
//        String s = executorService.invokeAny(Arrays.asList(hello, java, gijin));
//        System.out.println(s); //가장 짧은게 출력된다.
//
//        executorService.shutdown();
////        //1
////        ExecutorService executorService = Executors.newSingleThreadExecutor();
////
////        Callable<String> hello = () -> {
////            Thread.sleep(2000L);
////           return "Hello";
////        };
////        Future<String> helloFuture = executorService.submit(hello);
////        System.out.println(helloFuture.isDone());
////        System.out.println("Started !! ");
////        helloFuture.get(); //이곳에서 결과값을 기다리기 때문에 Blocking Call 이라 한다.
//////        helloFuture.cancel(false); //중단시킨다. Done은 True가 된다. 아래에서 get을 한다면 에러가 뜬다.
////        System.out.println(helloFuture.isDone());
////        System.out.println("End !! ");
//
////        executorService.shutdown();
//        System.out.println("**** 17: CompleTableFuture 1 *****");
////////////        ExecutorService executorService = Executors.newFixedThreadPool(5); //1
////////////        Future<String> future = executorService.submit(() -> "hello");
////////////        //get이 블락킹콜 이기 때문에 이전에서 TODO를 하곤 하는데,
////////////        future.get();
//////////
//////////        //CompleTalbeFuture 를 사용하여 Executor를 명시하지 않고도 사용할수 있다.
//////////        CompletableFuture<String> future = new CompletableFuture<>();
//////////        future.complete("gijin");
//////////        System.out.println(future.get()); //get은 써야한다.
////////        //==위에거와 같다.
////////        CompletableFuture<String> future = CompletableFuture.completedFuture("hello");
////////        System.out.println(future.get());
//////
//////        //리턴이 없는 작업시에는 runAsync 사용 2
//////        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
//////            System.out.println("runAsync : " + Thread.currentThread().getName());
//////        });
//////        runAsync.get();
//////        //리턴값이 있는 작업시에는 supplyAsync 사용
//////        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
//////            System.out.println("supplyAsync : " + Thread.currentThread().getName());
//////            return "Thread";
//////        }).thenApply((s) -> { //callback 콜백이 가능하다 리턴값이 있는 콜백 3
//////            System.out.println(Thread.currentThread().getName());
//////            return s.toUpperCase();
//////        });
//////        System.out.println(supplyAsync.get());
////
////        CompletableFuture<Void> supplyAsync = CompletableFuture.supplyAsync(() -> {
////            System.out.println("Hello :" + Thread.currentThread().getName());
////            return "Hello";
////        }).thenAccept((s) -> { //thenAccept 는 리턴없이 없는 콜백 4
////            System.out.println(Thread.currentThread().getName());
////            System.out.println(s.toUpperCase());
////        });
////        supplyAsync.get();
//
//        CompletableFuture<Void> callBackThenRun = CompletableFuture.supplyAsync(() -> {
//            System.out.println("Hello :" + Thread.currentThread().getName());
//            return "Hello";
//        }).thenRun(() -> { //thenRun 는 그냥 하기만 하면 된다. 결과값에 상관하지 않는다. 5
//            System.out.println(Thread.currentThread().getName());
//        });
//        callBackThenRun.get();
//        // 자바7부터 별다른 Executor 를 사용하여 ThreadPool을 생성하지 않아도 내부적으로 ForkJoinPool에 있는 commonPool을 쓰게 된다.
//        //원한다면 만들어서 줄수도 있다. CompletableFuture.supplyAsync(() -> { },excutorService); 같은 형식 executionService.shutdown 필요
//        //CallBack도 마찬가지로 thenRunAsync(() -> { },executorService); 와 같은 형식으로 쓰레드를 사용할수 있다. executionService.shutdown 필요
//        System.out.println("*****18.CompltableFuture 2 *****");
//
//////1        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
//////            System.out.println("Hello" + Thread.currentThread().getName());
//////            return "Hello";
//////        });
////////        hello.get();
////////        world.get(); 원래는 순서대로 해야되는데
//////        //hello.thenCompose(hello 의 결과를 받아서  world를 반영하게 만들수 있다) == hello.thenCompose(App::getWorld);
//////
//////        CompletableFuture<String> future = hello.thenCompose(App::getWorld);
//////        System.out.println(future.get());
//////    }
//////
//////    //hello 와 동일한 world를 메소드로 만들어주었다.
//////    private static CompletableFuture<String> getWorld(String message) {
//////        return CompletableFuture.supplyAsync(() -> {
//////            System.out.println("World" + Thread.currentThread().getName());
//////            return message + " World";
//////        });
//////1//    }
////
////2        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
////            System.out.println("Hello" + Thread.currentThread().getName());
////            return "Hello";
////        });
////
////        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
////            System.out.println("World" + Thread.currentThread().getName());
////            return "World";
////        });
////
////        //hello와 world를 둘다 따로 보내고 결과를 둘다 하고 싶은경우에 이렇게 BiFunction 에 해당하는 람다가 get 된다.
////        CompletableFuture<String> future = hello.thenCombine(world, (h, w) -> h + " " + w);
////        System.out.println(future.get());
////
////        //모든 서브테스트를 합처서 실행하는방법
////        //모슨 테스크 들의 동일한 타입이라는 보장도 없고 그중에 어떤값은 에러가낫을수도 있기때문에 결과가 무의미하다
////        //결과가 null 값이 떨어진다
////        CompletableFuture<Void> future2 = CompletableFuture.allOf(hello, world);
////        future2
////                .thenAccept((result) -> {
////                    System.out.println(result);
////                });
////        System.out.println(future2.get());
////        //이걸 제대로 받으려면 콜렉션으로 모아서 할수 있긴 하다
////        List<CompletableFuture<String>> futures = Arrays.asList(hello,world);
////        CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);
////
////        CompletableFuture<List<String>> future3 = CompletableFuture.allOf(futuresArray)
////                .thenApply(v -> {
////                    return futures.stream()
////                            .map(CompletableFuture::join)
////                            .collect(Collectors.toList());
////                });
////        future3.get().forEach(System.out::println);
////        //이번엔 아무거나 하나 빨리 끝나는거 결과값 받아서 뭔가 하는과정 지금 같은 경우에는 랜덤하게 온다.
////        //ThenAccept가 Return 타입이 없다
////        CompletableFuture<Void> future4 = CompletableFuture.anyOf(hello, world).thenAccept((s) -> {
////            System.out.println(s);
////        });
////        future4.get();
////2
//        //에러처리 시
//        boolean throwError = true;
//
//        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
//            if (throwError) {
//                throw new IllegalArgumentException();
//            }
//            System.out.println("Hello " + Thread.currentThread().getName());
//            return "Hello";
////  3-1    }).exceptionally( ex -> {
////            System.out.println(ex);
////            return "Error!";
////        });
////  3-1/   System.out.println(hello.get());
//            //handle(정상적인경우 결과값 , exception 발생 에러)
//            }).handle((result, ex) -> { //3-2
//                if (ex != null) {
//                    System.out.println(ex);
//                    return "ERROR !";
//                }
//                return result;
//        }); //3-2/

        System.out.println("*****19.Annotation *****");
        //2
//        Chicken[] chickens = App.class.getAnnotationsByType(Chicken.class);
//        Arrays.stream(chickens).forEach( c-> {
//            System.out.println(c.value());
//      2/  });
        ChickenContainer chickenContainer = App.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(c -> {
            System.out.println(c.value());
        });


//    static class MyThread extends Thread { //Hello 가 실행된다음에 Thread가 실행된다. Thread의 순서는 보장못한다.
//        @Override
//        public void run() {
//            System.out.println("Thread: " + Thread.currentThread().getName());
//        }
//    }

//    private static OnlineClass createNewClass() {
//        System.out.println("creating new online class");
//        return new OnlineClass(10, "New Class", false);
//    }
    }
//1
//    static class FeelsLikeChicken<@Chicken T> {
//        //@Target을 파라미터로 지정하였기 때문에 가능 TYPE_USE로 사용하면 모든곳에 사용 가능하다
//        public static <@Chicken C> void print(C c) {
//            System.out.println(c);
//        }
// 1/   }

}
