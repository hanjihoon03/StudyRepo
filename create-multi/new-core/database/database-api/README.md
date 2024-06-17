# database-api
별도의 데이터베이스 기술을 사용하지 않고 web과 같은 mysql을 사용하지만 서비스를 나눈 상황에서 별도의 아키텍처를 갖기 위해 별도의 데이터베이스 모듈을 가진다.

규칙은 mysql 모듈과 같은 규칙을 가진다.

# 구성
│   │   ├── database-api
│   │   │   ├── build.gradle
│   │   │   └── src
│   │   │       ├── main
│   │   │       │   ├── java
│   │   │       │   │   └── com
│   │   │       │   │       └── project
│   │   │       │   │           ├── custom
│   │   │       │   │           │   ├── ItemApiRepositoryCustom.java
│   │   │       │   │           │   ├── MarketApiRepositoryCustom.java
│   │   │       │   │           │   ├── PurchaseApiRepositoryCustom.java
│   │   │       │   │           │   ├── UploadApiRepositoryCustom.java
│   │   │       │   │           │   └── UserApiRepositoryCustom.java
│   │   │       │   │           ├── impl
│   │   │       │   │           │   ├── ItemApiRepositoryImpl.java
│   │   │       │   │           │   ├── MarketApiRepositoryImpl.java
│   │   │       │   │           │   ├── PurchaseApiRepositoryImpl.java
│   │   │       │   │           │   ├── UploadApiRepositoryImpl.java
│   │   │       │   │           │   └── UserApiRepositoryImpl.java
│   │   │       │   │           └── repository
│   │   │       │   │               ├── ItemApiRepository.java
│   │   │       │   │               ├── MarketApiRepository.java
│   │   │       │   │               ├── PurchaseApiRepository.java
│   │   │       │   │               ├── UploadApiRepository.java
│   │   │       │   │               └── UserApiRepository.java
│   │   │       │   └── resources
│   │   │       │       
│   │   │       └── test
│   │   │           ├── java
│   │   │           └── resources