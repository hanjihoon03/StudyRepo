# Dto
web과 api에서 공동으로 사용하는 도메인에 대해서 응답과 요청을 주고 받는 계층에서 사용자가 필요한 정보에 따라 실제 엔티티는 숨기고 변환한 데이터를 담을 dto와 form 데이터를 담을 객체를 가진 모듈

도메인과 연관이 있기 때문에 도메인 의존성을 가지고 있으며 form 데이터에 대해 검증이 필요하므로 validation과 api에서 swagger를 사용할 때 명세에 dto가 필요하기 때문에 swagger 의존성을 가졌다.
# 구성
│   ├── dto
│   │   ├── build.gradle
│   │   └── src
│   │       ├── main
│   │       │   ├── java
│   │       │   │   └── com
│   │       │   │       └── project
│   │       │   │           ├── apidto
│   │       │   │           │   ├── BookApiDto.java
│   │       │   │           │   ├── ClothesApiDto.java
│   │       │   │           │   ├── ElectronicsApiDto.java
│   │       │   │           │   ├── FoodApiDto.java
│   │       │   │           │   ├── ItemApiDto.java
│   │       │   │           │   ├── ItemCond.java
│   │       │   │           │   ├── ItemSearchDto.java
│   │       │   │           │   ├── UserDto.java
│   │       │   │           │   ├── UserLoginIdPwDto.java
│   │       │   │           │   ├── UserPurchaseDto.java
│   │       │   │           │   ├── save
│   │       │   │           │   │   ├── BookSaveApiDto.java
│   │       │   │           │   │   ├── ClothesSaveApiDto.java
│   │       │   │           │   │   ├── ElectronicsSaveApiDto.java
│   │       │   │           │   │   ├── FoodSaveApiDto.java
│   │       │   │           │   │   └── UserSaveDto.java
│   │       │   │           │   └── update
│   │       │   │           │       ├── UpdateBookDto.java
│   │       │   │           │       ├── UpdateClothesDto.java
│   │       │   │           │       ├── UpdateElectronicsDto.java
│   │       │   │           │       ├── UpdateFoodDto.java
│   │       │   │           │       └── UpdateItemDto.java
│   │       │   │           ├── dto
│   │       │   │           │   ├── BookAndFileDto.java
│   │       │   │           │   ├── ClothesAndFileDto.java
│   │       │   │           │   ├── ElectronicsAndFileDto.java
│   │       │   │           │   ├── FoodAndFileDto.java
│   │       │   │           │   ├── ItemDto.java
│   │       │   │           │   ├── MarketPayDto.java
│   │       │   │           │   ├── MarketPayDtoV2.java
│   │       │   │           │   └── PurchasePayDto.java
│   │       │   │           └── form
│   │       │   │               ├── LoginForm.java
│   │       │   │               ├── UserForm.java
│   │       │   │               └── itemform
│   │       │   │                   ├── BookForm.java
│   │       │   │                   ├── ClothesForm.java
│   │       │   │                   ├── ElectronicsForm.java
│   │       │   │                   └── FoodForm.java
│   │       │   └── resources
│   │       └── test
│   │           ├── java
│   │           └── resources