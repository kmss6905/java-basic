### 스레드 이름
메인 스레드는 main 이라는 이름을 가지고 있고
우리가 직접 생겅한 스레드는 자동적으로 Thread-n 이라는 이름으로 설정된다.
n은 스레드 번호를 말한다.
Thread-n 대신 다른 이름으로 설정 하고 싶다면 Thread 클래스의 setName() 메서드로 변경하면 된다.

단, setName() 과 getName()은 Thread 의 인스턴스 메소드 이므로 스래드 객체의 참조가 필요하다.
만약 스레드 객체의 참조를 가지고 있지 않다면, Thread 의 정적 메소드인 currentThread()로 코드를 실행하는 현재 스레드의 참조를 얻을 수 있다.


### 동기화 메소드와 동기화 블록
#### 공유 객체를 사용할 때는 조심해야한다.
멀티 스레드 프로그램에서는 스레드들이 객체를 공유해서 작업해야하는 경우가 있는데, 이 경우 
스레드 A를 사용하던 객체가 스레드 B에 의해 상태가 변경될 수 있기 때문에, 스레드 A가 의도했던 결과와 다른 결과를 산출할 수 있음

그렇기 때문에 스레드가 사용 중인 객체를 다른 스레드가 변경할 수 없도록 하려면 스레드 작업이 끝날 때 까지 객체에
잠금을 걸어서 다른 스레드가 사용할 수 없도록 해야한다. 멀티 스레드 프로그램에서 단 하나의 스레드만만 
실행할 수 있는 코드 영역을 임계 영역 이라고 한다. 자바는 임계영역을 지정하기 위해 동기화(synchronized)메소드와
동기화 블록을 제공한다.
스레드가 객체 내부의 동기화 메소드 또는 블록에 들어가면 즉시 객체에 잠근을 걸어 다른 스레드가 임계 영역 코드를 실행하지 
못하도록 한다. 동기화 메소드를 만드는 방법은 메소드 선언에 synchronized 키워드를 붙이면 된다. 
해당 키워드는 인스턴스와 정적 메소드 어디든 붙일 수 있다. 

가령 각 유저(스레드)가 하나의 계산기를 공유한다고 가정해보자. 실제로 User1가 100을 입력했을 때 
User2가 50을 입력하는 상황이 일어날 수 있다. 즉 User1가 기대하는 결과와 다른 결과물을 받게 될 것이다. 
```java
public class MainThreadExample {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        User1 user1 = new User1(calculator);
        User2 user2 = new User2(calculator);


        user1.start(); // calculator set value 100
        user2.start(); // calculator set value 50

        /**
         * 결과
         * user1 : 50
         * user2 : 50
         */
    }
}
```

