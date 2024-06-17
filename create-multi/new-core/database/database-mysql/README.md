# database-mysql
mysql을 사용하는 데이터베이스 모듈로 리포지토리 계층을 담당한다. CRUD를 제외한 별도의 쿼리 로직도 담겨져 있다.

데이터베이스 관련 기술을 제외한 기술을 의존해선 안된다.

ORM 데이터베이스인 Mysql을 사용하기 때문에 JPA를 사용하며 쿼리는 QueryDsl을 사용했으므로 의존을 갖는다.

# 구성
```
│   │   ├── database-mysql
│   │   │   ├── build.gradle
│   │   │   └── src
│   │   │       ├── main
│   │   │       │   ├── java
│   │   │       │   │   └── com
│   │   │       │   │       └── project
│   │   │       │   │           ├── custom
│   │   │       │   │           │   ├── DeliveryRepositoryCustom.java
│   │   │       │   │           │   ├── FileRepositoryCustom.java
│   │   │       │   │           │   ├── ItemRepositoryCustom.java
│   │   │       │   │           │   └── MarketRepositoryCustom.java
│   │   │       │   │           ├── impl
│   │   │       │   │           │   ├── DeliveryRepositoryImpl.java
│   │   │       │   │           │   ├── FileRepositoryImpl.java
│   │   │       │   │           │   ├── ItemRepositoryImpl.java
│   │   │       │   │           │   └── MarketRepositoryImpl.java
│   │   │       │   │           └── repository
│   │   │       │   │               ├── DeliveryRepository.java
│   │   │       │   │               ├── FileRepository.java
│   │   │       │   │               ├── ItemRepository.java
│   │   │       │   │               ├── MarketRepository.java
│   │   │       │   │               ├── PurchaseRepository.java
│   │   │       │   │               └── UserRepository.java
│   │   │       │   └── resources
│   │   │       └── test
│   │   │           ├── java
│   │   │           └── resources
│   │   └── src
│   │       ├── main
│   │       │   ├── java
│   │       │   │   └── com
│   │       │   └── resources
│   │       └── test
│   │           ├── java
│   │           └── resources