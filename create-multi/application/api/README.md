# api
REST API 제공을 위한 별도의 서비스 모듈이다.

WEB과 같은 데이터베이스를 공유하고 Swagger를 통해서 명세해 http 메서드에 맞는 자원을 통한 서비스를 제공하는 모듈

# 구성
│   ├── api
│   │   ├── build.gradle
│   │   └── src
│   │       ├── main
│   │       │   ├── java
│   │       │   │   └── com
│   │       │   │       └── project
│   │       │   │           ├── MainApiApplication.java
│   │       │   │           ├── aop
│   │       │   │           │   ├── LogTraceAspect.java
│   │       │   │           │   └── pointcut
│   │       │   │           │       └── Pointcuts.java
│   │       │   │           ├── apiresponse
│   │       │   │           │   └── CustomErrorResponse.java
│   │       │   │           ├── config
│   │       │   │           │   └── SwaggerConfig.java
│   │       │   │           ├── controller
│   │       │   │           │   ├── ItemApiController.java
│   │       │   │           │   ├── MarketApiController.java
│   │       │   │           │   ├── PurchaseApiController.java
│   │       │   │           │   └── UserApiController.java
│   │       │   │           ├── service
│   │       │   │           │   ├── ItemApiService.java
│   │       │   │           │   ├── MarketApiService.java
│   │       │   │           │   ├── PurchaseApiService.java
│   │       │   │           │   ├── UploadApiService.java
│   │       │   │           │   └── UserApiService.java
│   │       │   │           └── trace
│   │       │   │               ├── LogTrace.java
│   │       │   │               ├── ThreadLocalLogTrace.java
│   │       │   │               ├── TraceId.java
│   │       │   │               └── TraceStatus.java
│   │       │   └── resources
│   │       │       ├── application-dev.yml
│   │       │       ├── application-prod.yml
│   │       │       └── application.yml
│   │       └── test
│   │           ├── java
│   │           └── resources
