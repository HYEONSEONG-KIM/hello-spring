# hello-spring
Inflearn-Spring입문(김영한)강의 공부 레퍼지토리✏  
사용 tool : Java 11, InteliJ

## 왜 Spring을 사용하는가?
- Spring은 애플리케이션을 구축하기위한 경량화된 솔루션을 제공하여 효율적인 개발 환경을 제공한다.
- Spring은 MVC 패턴, AOP, 잘 구조화된 예외계층구조를 제공한다.
- Spring은 많은 기능들을 제공 하지만 모듈화되어 있어 필요한 모듈들을 선택적으로 사용 할 수 있다.

## 스프링 웹 개발 기초
### 정적컨텐츠
- 서버에서 별도의 작업을 하지 않고, 파일에서 그대로 웹 브라우저에 내려주는 형식
### MVC와 템플릿 엔진
- 과거의 jsp,php(템플릿엔진-서버에서 프로그래밍하여 HTML을 동적으로 바꾸어 적용)
- MVC(Model View Controller)
- 정적컨텐츠와의 차이는 서버에서 변형후에 내려주냐 아니야의 차이
- 이전에는 View 파일에 모든 기능을 작성->유지 보수에 어려움, 현재는 MVC를 이용 View(화면과 관련된 일만 처리) Controller(서버에 관련된 일 모두 처리)로 나누어 지면서 독립성이 높아짐
### API
- JSON 데이터 구조 포멧으로 클라이언트로 전달 하는 방식(HTML방식이 아님)
- @ResponseBody를 사용하면 viewResolver를 사용하지 않음(HTTP의 BODY에 문자 내용을 직접 반환)
- HttpMessageConvertoer가 동작하여 기본 문자처리는 'StringHttpMessageConverter'가 동작, 객체는 'MappingJackson2HttpMessageConverter'가 동작

## 회원 관리 예제
- 데이터 : 회원 ID, 이름
- 기능 : 회원 등록,조회
- 아직 DB가 선정되지 않았음을 가정
- 일반적인 웹 애플리케이션 계층 구조  
![image](https://user-images.githubusercontent.com/70748105/104979979-e91bf200-5a48-11eb-9b9c-491fc3d2f73e.png)
  * 컨트롤러 : 웹MVC의 컨트롤러 역할
  * 서비스 : 핵심 비즈니스 로직 구현
  * 리포지토리 : DB에 접근, 도메인 객체를 DB에 저장하고 관리
  * 도메인 : 비즈니스 도메인 객체 ex)회원, 주문, 쿠폰 등등 주로 DB에 저장하고 관리

## TEST casew작성
- 개발한 기능을 실행해서 테스트 할 때 자바의 main 메서드를 통해서 실행하거나, 웹 애플리케이션의 컨트롤러를 통해서 해당 기능을 실행
- 이러한 방법은 준비하고 실행하는데 오래 걸리고, 반복 실행하기 어렵고 여러 테스트를 한번에 실행하기 어렵다는 단점
- 자바는 JUnit이라는 프레임워크로 테스트를 실행해서 이러한 문제를 해결
- @AfterEach : 각 테스트가 종료될 때 마다 해당 기능에 적용되는 메서드 실행
- 실제로 로직을 구현할 때 보다 test코드를 작성하는 시간이 더 오래걸림

## 스프링 빈과 의존관계
### 컴포넌트 스캔과 자동 의존관계 설정
- 생성자에 @Autowired가 있으면 스프링이 연관된 객체를 스프링 컨테이너에서 찾아 넣어줌->객체의 의존관계를 외부에서 넣어주는 것을 DI(Dependency Injection)이라 함
- @Component 애노테이션이 있으면 스프링 빈으로 자동 등록
- @Controller 컨트롤러가 스프링 빈으로 자동 등록된 이유도 컴포넌트 스캔 때문

## 스프링 DB접근 기술
- 순수 JDBC => 직접 자바 코드를 이용하여 DB에 저장,조회,수정,삭제(CRUD)
- 스프링 JDBCTemplet => 기존의 JDBC보다 코드가 간결, 여전히 sql문을 직접 작성해야함
- JPA => 기존 JDBC보다 편리하지만 원리부터 차근차근 공부하지 않으면 의미없음
- 스프링 데이터 JPA => 인터페이스만으로 DB접근 가능

## AOP(관점 지향 프로그래밍)
### AOP가 필요한 상황
- 모든 메소드의 호출 시간을 측정할 때
- 공통 관심 사항(cross-cutting concern) vs 핵심 관심 사항(core concern)
- 회원 가입 시간, 회원 조회 시간을 측정할 때  
![image](https://user-images.githubusercontent.com/70748105/104981335-c4754980-5a4b-11eb-96e0-7fe061614fb6.png)





