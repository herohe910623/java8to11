## The Java 8

LTS 버전의 차이 - 업데이트가 되는 유무 즉, 지원의 차이이다.   
지원하지 않는 버전은 서버에서 사용하기 힘들것이다. 
11, 8 을 사용하는것이 좋다.   

주요 기능    
* 람다 표현식   
* 메소드 레퍼런스   
* 스트림 API   
* Optional<T>   
....    

### 함수형 인터페이스와 람다 표현식   
추상메소드가 딱 하나만 있는 인터페이스이면 함수형 인터페이스이다.   

public , abstract 생략가능    
static 메소드 정의 가능    
default 메소드 정의 할수 있는 형태가 다양해 짐   

@FuntionalInterface 로 정의 가능   

익명내부 클래스로( @Override 메소드 ) 작성하던 것을 함수형 인터페이스에서는 람다로 바꿔줄수 있다.   
RunSomething runSomething = () -> System.out.println("Hello"); 형식으로 변경 가능   
runSomthing.doIt();   

람다는 특수한 형태의 오브젝트 이다. 함수형 인터페이스를 인라인으로 구현한 오브젝트라고 볼 수 있다. 
사실상 객체지향 언어이기 때문에 변수에 할당하고 그것을 메소드 파라미터로 전달하거나 리턴타입으로 리턴할 수 있다.

함수형 인터페이스(Functional Interface)   
* 추상 메소드를 딱 하나만 가지고 있는 인터페이스   
* SAM(Single Abstract Method) 인터페이스   
* @FunctionInterface 애노테이션을 가지고 있는 인터페이스   

람다 표현식(Lambda Expressions)   
* 함수형 인터페이스의 인스턴스를 만드는 방법으로 쓰일 수 있다.   
* 코드를 줄일 수 있다.   
* 메소드 매개변수, 리턴타입, 변수로 만들어 사용할 수도 있다.   

자바에서 함수형 프로그래밍   
* 함수를 First class object 로 사용할 수 있다.   
* 순수 함수(Pure function)   
    - 사이드 이펙트가 없다.(함수 밖에 있는 값을 변경하지 않는다.)
    - 상태가 없다. (함수 밖에 있는 값을 사용하지 않는다. )   
* 고차 함수 (Higher-Order Function)   
    - 함수가 함수를 매개변수로 받을 수 있고 함수를 리턴할 수도 있다.   
* 불변성    

```java
public static void main(String[] args) {
    int baseNumber = 10;    // 함수 밖에 있는 값을 참조해서 쓰는 경우 Pure 하다고 할수 없다.

    RunSomething runSomthing = new RunSomething() {
        int baseNumber2 = 10;   // 함수 밖에 있는 값을 참조해서 쓰는 경우 Pure 하다고 할수 없다.
        @Override 
        public int doIt(int number) {
            return number + baseNumber;
        }
    }
}
```
순수함수 를 달성하기 위해서는 주의하 필요하다. 함수 밖에있는 값을 참조하거나 변경하려고 하면 안된다.    
함수내부에서 쓰는 값 함수가 전달받은 파라미터를 가지고 써야한다.   

자바에서 기본으로 제공하는 함수 인터페이스들이 있다.    
java.util.Function 인터페이스    
Function<T,R>   
T 타입을 받아서 R 타입을 리턴하는 함수 인터페이스   
R apply(T t)   
```java
plus10.compose(multiply2).apply(i);  // multiply2 를 먼저하고 그 값을 plus10 함수를 수행
plus10.andThen(multiply2).apply(i);  // 입력값이 들어오면 plus10 을 수행하고 그 결과값을 multiply2 수행
```

BiFunction<T,U,R>    
두 개의 (T,U) 를 받아서 R 타입을 리턴하는 함수 인터페이스   
R apply (T t, U u)   

```java 

```

Consumer<T>   
T 타입을 받아서 아무값도 리턴하지 않는 함수 인터페이스    
void Accept(T t)   
```java
Consumer<Integer> consumer = (i) -> System.out.println(i);
consumer.accept(7);
```

Supplier<T> 
T 타입의 값을 제공하는 함수 인터페이스 뭔가를 가져오는 인터페이스이다.       
T get()    
```java
Supplier<Integer> supplier = () -> 7;       // 입력해줄 필요가 없어서 () 인자를 넣어줄 필요가 없다.
supplier.get();     //항상 7을 받는다. 
```

Predicate<T>    
T타입을 받아서 boolean 을 리턴하는 함수 인터페이스   
boolean test(T t)    
함수 종합용 메소드    
And , Or , Negate    
```java
Predicate<Integer> predicate = integer -> integer != 7;
System.out.println(predicate.test(5));
```

UnaryOperator<T>   
Function<T,R> 의 특수한 형태로, 입력핪 하나를 받아서 동일한 타입을 리턴하는 함수 인터페이스   
```java 
UnaryOperator<Integer> unaryOperator = i -> i + 4;
System.out.println(unaryOperator.apply(3));
```

BinaryOperator<T>   
BiFunction<T,U,R> 의 특수한 형태로, 동일한 타입의 입력값 두개를 받아 리턴하는 함수 인터페이스   
```java 
BinaryOperator<Integer> binaryOperator = (a, b) -> a + b;
System.out.println(binaryOperator.apply(3, 4));
```

### 람다 표현식   
(인자 리스트) -> {바디}   

인자리스트   
* 인자가 없을 때 : ()    
* 인자가 한개일 때 : (one) , one   
* 인자가 여러개 일 때 : (one,two)    
* 인자의 타입은 생략 가능, 컴파일러가 추론(infer) 하지만 명시할 수도 있다. (integer one, integer two)   

바디   
* 화상표 오른쪽에 함수 본문을 정의한다.   
* 여러 줄인 경우에 {} 를 사용해서 묶는다.   
* 한 줄인 경우에 생략 가능, return 도 생략 가능.   

변수 캡처 (Variable Capture)   
* 로컬 변수 캡처   
    - final 이거나 effective final 인 경우에만 참조할 수 있다.   
    - 그렇지 않을 경우 concurrency 문제가 생길 수 있어서 컴파일러가 방지한다.   

```java 
    HelloWorld helloWorld = new HelloWorld();
    helloWorld.run();
	}
	private void run() {
		final int baseNumber = 4;   // Local variable

		// 로컬 클래스
		class LocalClass {
			void printBaseNumber() {
				System.out.println(baseNumber);     // 1.Local Class 에서 Local variable 참조
			}
		}

		// 익명 클래스
		Consumer<Integer> consumer = new Consumer<Integer>() {
			@Override
			public void accept(Integer integer) {
				System.out.println(integer + baseNumber);   // 2.익명 클래스에서 Local variable 참조
			}
		};
		consumer.accept(8 + baseNumber);

		//람다
		Consumer<Integer> consumer2 = (i) -> {
			System.out.println(i);
		};
		consumer2.accept(8 + baseNumber);   // 3. 람다에서 Local variable 참조
    }

```

* effective final    
    - 이것도 역시 자바 8 부터 지원하는 기능으로 "사실상" final 인 변수.   
    - final 키워드 사용하지 않은 변수를 익명 클래스 구현체 또는 람다에서 참조할 수 있다. // 1,2,3 모두 참조 가능

* 람다는 익명 클래스 구현체와 달리 '쉐도윙' 하지 않는다.   
    - 익명 클래스는 새로 스콥을 만들지만, 람다는 람다를 감싸고 있는 스콥과 같다.   
    - Nested Class 도 가려진다.    
    - 람다는 run() 스콥이랑 같은것으로 간주한다.   
```java 
private void run() {
    final int baseNumber = 10;
    //람다   
    Consumer<Integer> consumber3 = (baseNumber) -> {
        System.out.println(baseNumber + baseNumber);    // 에러 같은 변수명
    }
}
```

### 메소드 레퍼런스   
람다가 하는 일이 기존 메소드 또는 생성자를 호출하는 거라면, 메소드 레퍼런스를 사용해서 매우 간결하게 표현할 수 있다.   
메소드 참조하는 방법   
|스태팃 메소드 참조|타입::스태틱 메소드|
|-------|-------|
|특정 객체의 인스턴스 메소드 참조|객체 레퍼런스::인스턴스 메소드|
|임의 객체의 인스턴스 메소드 참조|타입::인스턴스 메소드|
|생성자 참조|타입::new|

* 메소드 또는 생성자의 매개변수로 람다의 입력값을 받는다.   
* 리턴값 또는 생성한 객체는 람다의 리턴값이다.   

```java
class Greeting {
    private Integer a;

    // 접근 확인 메소드
    public void itOk() {
        System.out.println("생성자로 접근 성공");
    }

    // 3. 생성자
    public Greeting() {
    }
    // 4. 입력값이 있는 생성자 참조
    public Greeting(Integer a) {
        this.a = a;
    }
    // 1. 스태틱 메소드
    public static Integer methodReference(Integer a) {
        return a + 4;
    }
    // 2. 인스턴스 메소드
    public Integer methodReference2(Integer a) {
        return a + 4;
    }

}
```
가 있고    

1. 스태틱 메소드 참조 방법   
```java 
class HelloWorld { 
    public static void main(String[] args) {
        Function<Integer,Integer> function1 = (a) -> a + 4;
		System.out.println(function1.apply(3));
		System.out.println("이런 람다를 메소드 레퍼런스로 고치자면 ");

		Function<Integer,Integer> function2 = Greeting::methodReference;
		System.out.println(function2.apply(3));
		System.out.println("Greeting 에 있는 methodReference 메소드 사용");
    }
}
```
2. 인스턴스 메소드 참조 방법
```java 
class HelloWorld {
    public static void main(String[] args) {
        Greeting greeting = new Greeting();
		Function<Integer,Integer> function3 = greeting::methodReference2;
		System.out.println(function3.apply(3));
		System.out.println("greeting 인스턴스 메소드를 사용할 수 있다.");
    }
}
```
3. 기본 생성자 참조. 
기본 생성자를 참조하려면 Greeting 타입을 참조하면 되는데, 기본생성자에서는 입력값이 없기 때문에 입력값은 없고 결과값만 가져오는 Supplier<T> 가 적합하다.   
```java 
class HelloWorld {
    public static void main(String[] args) {
        Supplier<Greeting> constructorReference = Greeting::new;
		Greeting greetingSupplier = constructorReference.get();
		greetingSupplier.methodReference2(3);
    }
}
```
4. 입력 값이 있는 생성자 참조.
입력 값이 있는 생성자를 참조하려면 입력값이 Integer 이고, 반환값이 Greeting 타입 이어야 하는데, 이럴때는 Function<Integer,Greeting> 가 적합하다.
```java 
class HelloWorld {
    public static void main(String[] args) {
        Function<Integer,Greeting> constructorReference2 = Greeting::new;
		Greeting greetingFunction = constructorReference2.apply(3);
		greetingFunction.itOk();
    }
}
```
5.임의 객체의 인스턴스 메소드 참조.   
불특정 다수의 인스턴스의 메소드 참조하는 방법.   
```java 
class HelloWorld {
    public static void main(String[] args) {
        String
    }
}
```

Comparator 가 Functional Interface 로 바뀌어서 추상메소드는 하나지만, 여러개의 메소드들이 있다.   
람다를 넣을수 있다. -> 메소드 레퍼런스를 쓸수 있다.   
기존의 문자열과 다른 문자열을 비교해서 인트값을 넘겨주는 그런 메소드를 참조할수 있다. = String 클래스에 compareToIgnoreCase 라는 메소드가 있다.    
```java 
class HelloWorld {
    public static void main(String[] args) {
        
        String[] names = {"abc","ghi","def"};
//		1단계 배열을 정렬해주고 싶다.
//		Arrays.sort(names, new Comparator<String>() {		// 앞의 String, 뒤의 String 을 비교해서 int 값을 넘겨준다.
//			@Override
//			public int compare(String o1, String o2) {
//				return 0;
//			}
//		});

//		2단계  // java8 부터 Comparator 가 Functional Inteface 로 변경되었다.
//		Arrays.sort(names, (o1, o2) -> 0);	// String, String 을 비교해서 int 값을 넘겨준다.

//		3단계 람다가 된다는 것은 메소드 래퍼런스를 쓸수 있는데, 임의의 객체의 메소드를 참조하여 사용할수 있다.
		Arrays.sort(names, String::compareToIgnoreCase);	//String::compareToIgnoreCase 는 String 에 있는 메소드로 기존의 문자열과 다른 문자열을 비교해서 인트 값으로 넘겨준다.
		System.out.println(Arrays.toString(names));
    }
}
```

