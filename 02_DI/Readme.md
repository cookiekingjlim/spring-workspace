# DI(Dependency Injection)

### IoC(Inversion of Control)

- 프로그램을 구동하는데 필요한 객체에 대한 생성, 변경 등의 관리를 개발자가 아닌 컨테이너에서 직접 관리하는 것을 말한다.
- 스프링은 IoC 구조를 통해 구동 시 필요한 객체의 생성부터 소멸까지 해당 객체에 대한 관리를 직접 수행한다.

<img src="https://user-images.githubusercontent.com/26870393/182604427-d5e9f400-cc8c-410e-b583-df5de4e50bbc.png">

### 스프링 IoC 컨테이너

- 스프링에서 관리하는 객체를 `빈(Bean)`이라고 하고, 해당 빈들을 관리한다는 의미로 컨테이너를 `빈 팩토리(Bean Factory)`라고 한다.

### IoC 컨테이너의 역할

- 객체(Bean)의 생명주기와 의존성을 관리한다.
- 객체(Bean)의 생성, 초기화, 소멸 등의 처리를 담당한다.
- 개발자가 직접 객체를 생성할 수 있지만 해당 권한을 컨테이너에 맡김으로써 소스 코드 구현의 시간을 단축할 수 있다.

<img src="https://user-images.githubusercontent.com/26870393/182604584-41a1d804-b021-4443-b8e1-6e72885460e7.png">

## DI

- DI(Dependency Injection)란 하나의 객체가 사용하는(의존하는) 다른 객체를 외부에서 생성하고 주입받아 사용하는 것을 말한다.
- 객체를 주입하는 방법으로는 메소드를 통한 의존성 주입 방법과 생성자를 통한 의존성 주입 방법이 있다.

### DI 설정 방법 - xml 방식

- 스프링 컨테이너 구동 시 생성해야 하는 객체(Bean)들과 의존 관계를 XML 파일로 작성하는 방식이다.
- `<beans>` 요소는 최상위 요소로 하위 요소들로 다양한 스프링 설정할 수 있다.
- `<bean>` 요소는 스프링 컨테이너가 관리할 빈을 선언하는 요소이다.

```xml
<beans>
    <bean id="student"  class="com.kh.model.vo.Student" />
</beans>
```

- Setter 메소드를 통해 의존 관계가 있는 빈을 주입하려면 `<property>` 요소를 사용한다. (단, 일치하는 setter 메소드가 있어야 한다.)

```xml
<beans>
    <bean id="student"  class="com.kh.model.vo.Student">
        <property name="name" value="김아무" />
        <property name="age" value="20" />
        <property name="wallet" ref="money" />
    </bean>

    <bean id="money" class="com.kh.model.vo.Wallet" />
</beans>
```

- 생성자를 통해 의존 관계가 있는 빈을 주입하려면 `<constructor-arg>` 요소를 사용한다. (단, 일치하는 매개변수가 있는 생성자가 있어야 된다.)

```xml
<beans>
    <bean id="student" class="com.kh.model.vo.Student">
        <constructor-arg name="name" value="김아무" />
        <constructor-arg name="wallet" ref="money" />
    </bean>

    <bean id="money" class="com.kh.model.vo.Wallet" /> 
</beans>
```