# interceptor
보안에 해당하는 부분이다. 별도의 시큐리티를 사용하지 않고 접근 제한을 인터셉터로 적용했다. 물론 보안적으로 부족한 것을 알지만 프로젝트 진행당시 직접 보안 요소를 넣어보고 싶어서 구성했다. 차후 필자 깃허브 리포지토리 브랜치에는 스프링 시큐리티를 적용한 코드도 있다. 물론 바꿀 수 있지만 허점이 커진다. 이미 도메인으로 만든 USER 도메인이나 mvc 패턴 사이사이 바꿔야할 것이 너무 많기에 사이드 이펙트도 많이 생기고 인터셉터로 진행하겠지만 차후 프로젝트 진행시에는 필수로 시큐리티와 JWT를 사용한 보안을 적용하도록 하겠다.

이 모듈의 규칙은 접근 제한을 담당하는 모듈로 웹과 관련된 설정과 domain, global-utils만 가지고 있다.

접근 제한을 늘리는 것은 허용하나 다른 기술의 의존하는 것은 허용하지 않는다.

# 구성
│   ├── interceptor
│   │   ├── build.gradle
│   │   └── src
│   │       ├── main
│   │       │   ├── java
│   │       │   │   └── com
│   │       │   │       └── project
│   │       │   │           ├── annotation
│   │       │   │           │   └── Login.java
│   │       │   │           ├── argumentResolver
│   │       │   │           │   └── LoginUserArgumentResolver.java
│   │       │   │           ├── config
│   │       │   │           │   └── WebConfig.java
│   │       │   │           └── interceptor
│   │       │   │               ├── AdminInterceptor.java
│   │       │   │               ├── LogInterceptor.java
│   │       │   │               └── LoginCheckInterceptor.java
│   │       │   └── resources
│   │       └── test
│   │           ├── java
│   │           └── resources
│   └── src
│       ├── main
│       │   ├── java
│       │   └── resources
│       └── test
│           ├── java
│           └── resources