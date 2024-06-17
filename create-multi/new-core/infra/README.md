# infra
설정과 외부 설정 파일을 담당하는 모듈이다. 이 모듈에서는 원하는 기능의 의존성을 추가하고 사용할 수 있게끔 한다.

만약 필요한 설정이 각기 다르다면 infra의 하위 모듈을 구성해서 지원하는 방식으로 지원하는 것을 규칙으로 정했다.

해당 기술에 대한 config와 해당 기술에 대한 의존만 가져야 한다.

# 구성
```
│   ├── infra
│   │   ├── build.gradle
│   │   └── src
│   │       ├── main
│   │       │   ├── java
│   │       │   │   └── com
│   │       │   │       └── project
│   │       │   │           └── config
│   │       │   │               └── MetricConfig.java
│   │       │   └── resources
│   │       │       ├── application-actuator.yml
│   │       │       ├── application-file.yml
│   │       │       ├── application-logging.yml
│   │       │       ├── application-mysql.yml
│   │       │       ├── application-pay.yml
│   │       │       └── application-swagger.yml
│   │       └── test
│   │           ├── java
│   │           └── resources