public class Book {
    private  String title;
    private int price;// field price
    //필드 값을 수정하고 얻기 위한 메소드 setter, getter를 만든다.
// setter,getter 메소드는 프로퍼티 (property)라 한다 - price 프로퍼티

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public int getPrice() {
        return this.price; // this는 내 자신 인스턴스를 참조하는 예약어
    }

    public void setPrice(int price) { // 지역변수 price
        this.price = price;
    }

    @Override
    public String toString() {
        return "자동차";
    }
}
