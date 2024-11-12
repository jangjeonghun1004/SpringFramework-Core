# @Configuration & @Bean

    1. 구성 클래스임을 IoC 컨테이너에게 알린다.
    2. @Bean 메소드를 검색한다.

# @Resource & @Inject

    자바 표준 주입 어노테이션
    @Resource = 주입시 타입과 이름을 동시에 체크합니다.
    @Inject = 주입시 타입 체크합니다.

# @Autowired

    스프링 프레임워크 주입 어노테이션
    기본적으로 타입을 기준으로 주입을 합니다.
    @Quarifier를 통해 주입시 이름까지 체크 가능합니다.

    추가 학습 사항
    @Primary

# @Scope

    @Scope("prototype")
    옵션: singleton, prototype, request, session, globalSession

# @Value

    appplication.properties 데이터 가져오기
    @Value("${spring.application.name:defaultValue}")

    추가 학습 사항
    @PropertySource

# Resource

    외부 리소스 파일 데이터 가져오기
    @Value("classpath:banner.txt")
    @Value("file:c:/shop/banner.txt")
    @Value("http://shop/banner.txt")

# MessageSource

    다국어 메세지 처리를 합니다.
    
    1. messages.properties, messages_kr.properties, messages_en.properties 등 다국어 파일을 생성합니다.
    2. 다국어 처리를 위한 @Configuration 을 설정합니다.(config -> LocaleConfig 을 참고하세요.)
    3. messageSource.getMessage() 을 사용하여 호출합니다.(controller -> LocaleController 을 참고하세요.)
    intellij 에서 settings -> file encoding -> utf-8 로 설정되어 있는지 확인합니다.

# @PostConstruct & @PreDestroy

    Spring Framework는 @PostConstruct & @PreDestroy 어노테이션을 각각 초기화 및 폐기 콜백 메소드로 인지합니다.

    생성자와 @PostConstruct의 차이점은 
    생성자가 먼저 호출이 되고 이후에 @PostConstruct가 호출이 됩니다.

    @PreDestroy의 경우 Bean에서 종료되는 시점에 호출이 됩니다.
    테스트를 위해 강제로 context.close()를 호출했습니다.(constroller -> PreDestroyController 을 참고하세요.)

# @Lazy & @DependsOn
    
    @Lazy 는 빈이 처음으로 요청되는 시점에 초기화를 진행합니다.
    예를 들어 "ShoppingCart"의 경우 호출되기 전에 미리 인스터스를 생성하거나 초기화 작업을 진행할 필요가 없다.
    그렇기 때문에 @Lazy를 적용하는 것도 나쁘지 않다.

    @DependsOn 은 빈을 초기화 하기전에 해당 빈보다 먼저 초기화가 진행되어야할 빈을 설정할 수 있다.
    예를 들어 @DependsOn("somebean")을 설정하면 "somebean"이 먼저 초기화가 진행이 되고
    그 후 @DependsOn 을 설정한 대상이 초기화가 진행된다.

# BeanPostProcessor(후처리)

    모든 빈 인스턴스 또는 특정 빈 인스턴스에 대한 후처리기를 생성합니다.


# @Required

    Spring Framework는 @Required 를 감지해서 값의 존재 여부를 조사합니다.
    값이 없을 경우 BeanInitializationException 예외를 발생합니다.

# @Profile

    개발, 테스트, 운영 환경에 따라 DB 설정을 다르게 구성하기
    1. @Profile 어노테이션을 사용해서 "DataSourceConfig" 를 구성합니다.
    2. "application.properties" 를 설정합니다.

    # "DataSourceConfig.java, application.properties" 를 참고하세요.
    # MySql 의존성
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jdbc</artifactId>
    </dependency>

    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.33</version>
    </dependency>

# @Aspect

    AOP(애스펙트 지향 프로그래밍, Aspect Orientied Programming)
    관점 주의 프로그래밍, log 및 트랙잭션 설정

    AspectJ 는 다양한 종류의 포인트를 매치할 수 있는 강력한 표현식 언어를 제공합니다.
    Spring Framework AOP 는 IoC 컨테이너 안에 선언된 빈에 국한됩니다.

    1. @EnableAspectJAutoProxy 선언("AspectConfig" 파일 참고)
    2. Aspect 관점 설정("AspectLog" 파일 참고)
    @Before, @AfterReturning, @After, @AfterThrowing, @Around

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-aop</artifactId>
        <version>3.3.3</version>
    </dependency>

    추가 사항
    @DeclareParents

    
    

    
    

