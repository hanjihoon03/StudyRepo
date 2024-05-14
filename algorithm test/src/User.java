public class User {
    private String email;
    private String password;
    private String name;

    public User(String email, String name) {
        this(email, name, null);//파라미터를 많이 받아들이는 생성자를 this생성자로 받아주면 코딩이 편하다
        //this는 맨 첫 줄에 있어야 한다.
//        this.email = email;
//        this.name = name;
    }

    //생성자 오버로딩
    public User(String email, String name, String password) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
