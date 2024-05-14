public class PersonTest {
    public static void main(String[] args){
        Person p1 =  new Person();
        Person p2 = new Person();

        p1.name = "한지훈";
        p1.address ="평택";
        p2.name = "장소희";

        System.out.println(p1.name);
        System.out.println(p1.name.length());
        System.out.println(p1.address.length());
        System.out.println(p1.address);
        System.out.println(p1.isVip);

        System.out.println(p2.name);
        System.out.println(p2.name.length());
        System.out.println(p2.address);
        System.out.println(p2.isVip);
    }

}
