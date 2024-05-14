public class UserExam {
    public static void main(String[] args) {
        User user = new User("gkswlgns7653@naver.com", "한지훈");
//        System.out.println(user.getName());
//        System.out.println(user.getEmail());
        System.out.println(user);

        User user2 = new User("gkswlgns7653@gmail.com", "지훈", "1234");//커맨드 + p 하면 파라미터가 보임
//        System.out.println(user2.getName());
//        System.out.println(user2.getEmail());
//        System.out.println(user2.getPassword());

        System.out.println(user2);
    }
}
