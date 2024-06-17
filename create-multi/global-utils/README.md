# global-utils
독립 모듈 계층으로 어느 기능에도 종속되어선 안된다. 순수한 자바 코드로 이루어진 변경이 가장 적은 모듈에 해당한다.

상수 정의나 Type, Util등을 정의하고 모든 모듈에서 사용할 수 있는 것들을 정의했다.

# 구성
```
├── global-utils
│   ├── build.gradle
│   └── src
│       ├── main
│       │   ├── java
│       │   │   └── com
│       │   │       └── project //공통으로 사용될 로직
│       │   └── resources
│       └── test
│           ├── java
│           └── resources