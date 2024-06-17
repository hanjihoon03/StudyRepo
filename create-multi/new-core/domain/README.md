# domain
Java Class로 표현된 도메인 Class이다. 특정 모듈을 의존하지 않으며 Entity를 구성하기 위한 jpa와 QueryDsl을 사용하기 위해 Qfile이 필요하기 때문에 jpa와 querydsl의 의존성을 가진다.

이외 별도의 의존을 가지지 않는 것이 규칙이다.

# 구성
```
│   ├── domain
│   │   ├── build.gradle
│   │   └── src
│   │       ├── main
│   │       │   ├── java
│   │       │   │   └── com
│   │       │   │       └── project
│   │       │   │           ├── Delivery.java
│   │       │   │           ├── Market.java
│   │       │   │           ├── Purchase.java
│   │       │   │           ├── UploadFile.java
│   │       │   │           ├── User.java
│   │       │   │           ├── item
│   │       │   │           │   ├── Book.java
│   │       │   │           │   ├── Clothes.java
│   │       │   │           │   ├── ClothesType.java
│   │       │   │           │   ├── Electronics.java
│   │       │   │           │   ├── Food.java
│   │       │   │           │   └── Item.java
│   │       │   │           └── subdomain
│   │       │   │               ├── Address.java
│   │       │   │               ├── DeliveryStatus.java
│   │       │   │               └── Tier.java
│   │       │   └── resources
│   │       └── test
│   │           ├── java
│   │           └── resources