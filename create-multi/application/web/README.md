# web
웹 애플리케이션 서비스를 제공하기 위한 모듈로 필자의 쇼핑몰을 제공하는 모듈이다. 

요청과 응답에 따른 엔드포인트와 서비스 로직이 포함된다.

# 구성
```
│   └── web
│       ├── build.gradle
│       └── src
│           ├── main
│           │   ├── java
│           │   │   └── com
│           │   │       └── project
│           │   │           ├── MainWebApplication.java
│           │   │           ├── aop
│           │   │           │   ├── LogTraceAspect.java
│           │   │           │   └── pointcut
│           │   │           │       └── Pointcuts.java
│           │   │           ├── controller
│           │   │           │   ├── HomeController.java
│           │   │           │   ├── ItemController.java
│           │   │           │   ├── KakaoPayController.java
│           │   │           │   ├── LogController.java
│           │   │           │   ├── MarketController.java
│           │   │           │   └── loginController.java
│           │   │           ├── exception
│           │   │           │   ├── FileStorageException.java
│           │   │           │   └── MyDbException.java
│           │   │           ├── pay
│           │   │           │   ├── KaKaoPayReadyV0.java
│           │   │           │   ├── KakaoPayApprovalV0.java
│           │   │           │   └── response
│           │   │           │       ├── AmountV0.java
│           │   │           │       └── CardV0.java
│           │   │           ├── service
│           │   │           │   ├── DeliveryService.java
│           │   │           │   ├── FileService.java
│           │   │           │   ├── ItemService.java
│           │   │           │   ├── KakaoService.java
│           │   │           │   ├── MarketService.java
│           │   │           │   ├── PurchaseService.java
│           │   │           │   └── UserService.java
│           │   │           └── trace
│           │   │               ├── LogTrace.java
│           │   │               ├── ThreadLocalLogTrace.java
│           │   │               ├── TraceId.java
│           │   │               └── TraceStatus.java
│           │   └── resources
│           │       ├── application-dev.yml
│           │       ├── application-prod.yml
│           │       ├── application.yml
│           │       ├── static
│           │       │   ├── css
│           │       │   │   ├── blog.css
│           │       │   │   ├── blog.rtl.css
│           │       │   │   ├── bootstrap-grid.css
│           │       │   │   ├── bootstrap-grid.css.map
│           │       │   │   ├── bootstrap-grid.min.css
│           │       │   │   ├── bootstrap-grid.min.css.map
│           │       │   │   ├── bootstrap-grid.rtl.css
│           │       │   │   ├── bootstrap-grid.rtl.css.map
│           │       │   │   ├── bootstrap-grid.rtl.min.css
│           │       │   │   ├── bootstrap-grid.rtl.min.css.map
│           │       │   │   ├── bootstrap-reboot.css
│           │       │   │   ├── bootstrap-reboot.css.map
│           │       │   │   ├── bootstrap-reboot.min.css
│           │       │   │   ├── bootstrap-reboot.min.css.map
│           │       │   │   ├── bootstrap-reboot.rtl.css
│           │       │   │   ├── bootstrap-reboot.rtl.css.map
│           │       │   │   ├── bootstrap-reboot.rtl.min.css
│           │       │   │   ├── bootstrap-reboot.rtl.min.css.map
│           │       │   │   ├── bootstrap-utilities.css
│           │       │   │   ├── bootstrap-utilities.css.map
│           │       │   │   ├── bootstrap-utilities.min.css
│           │       │   │   ├── bootstrap-utilities.min.css.map
│           │       │   │   ├── bootstrap-utilities.rtl.css
│           │       │   │   ├── bootstrap-utilities.rtl.css.map
│           │       │   │   ├── bootstrap-utilities.rtl.min.css
│           │       │   │   ├── bootstrap-utilities.rtl.min.css.map
│           │       │   │   ├── bootstrap.css
│           │       │   │   ├── bootstrap.css.map
│           │       │   │   ├── bootstrap.min.css
│           │       │   │   ├── bootstrap.min.css.map
│           │       │   │   ├── bootstrap.rtl.css
│           │       │   │   ├── bootstrap.rtl.css.map
│           │       │   │   ├── bootstrap.rtl.min.css
│           │       │   │   ├── bootstrap.rtl.min.css.map
│           │       │   │   ├── checkout.css
│           │       │   │   ├── cover.css
│           │       │   │   ├── kakao.png
│           │       │   │   └── product.css
│           │       │   ├── error
│           │       │   │   ├── 4xx.html
│           │       │   │   └── 5xx.html
│           │       │   └── js
│           │       │       ├── bootstrap.bundle.js
│           │       │       ├── bootstrap.bundle.js.map
│           │       │       ├── bootstrap.bundle.min.js
│           │       │       ├── bootstrap.bundle.min.js.map
│           │       │       ├── bootstrap.esm.js
│           │       │       ├── bootstrap.esm.js.map
│           │       │       ├── bootstrap.esm.min.js
│           │       │       ├── bootstrap.esm.min.js.map
│           │       │       ├── bootstrap.js
│           │       │       ├── bootstrap.js.map
│           │       │       ├── bootstrap.min.js
│           │       │       ├── bootstrap.min.js.map
│           │       │       ├── checkout.js
│           │       │       └── color-modes.js
│           │       └── templates
│           │           ├── admin
│           │           │   ├── adminPage.html
│           │           │   ├── modifyBook.html
│           │           │   ├── modifyClothes.html
│           │           │   ├── modifyElectronics.html
│           │           │   ├── modifyFood.html
│           │           │   ├── updateItemBook.html
│           │           │   ├── updateItemClothes.html
│           │           │   ├── updateItemElectronics.html
│           │           │   └── updateItemFood.html
│           │           ├── error
│           │           │   ├── cartError.html
│           │           │   ├── ioError.html
│           │           │   └── uploadFileError.html
│           │           ├── fragments
│           │           │   ├── bodyHeader.html
│           │           │   ├── footer.html
│           │           │   └── header.html
│           │           ├── home.html
│           │           ├── items
│           │           │   ├── createItemBook.html
│           │           │   ├── createItemClothes.html
│           │           │   ├── createItemElectronics.html
│           │           │   └── createItemFood.html
│           │           ├── list
│           │           │   ├── bookList.html
│           │           │   ├── clothesList.html
│           │           │   ├── electronicsList.html
│           │           │   └── foodList.html
│           │           ├── login
│           │           │   ├── login.html
│           │           │   └── sign-up.html
│           │           ├── loginHome.html
│           │           └── order
│           │               ├── buyItem.html
│           │               ├── cancel.html
│           │               ├── fail.html
│           │               ├── kakaopay.html
│           │               ├── purchase.html
│           │               └── purchaseV2.html
│           └── test
│               ├── java
│               │   └── com
│               │       └── test
│               │           └── TestApplication.java
│               └── resources