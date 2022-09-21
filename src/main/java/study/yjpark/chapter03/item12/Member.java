package study.yjpark.chapter03.item12;


public class Member {

    long id;
    String name;
    int age;

    @Override
    public String toString() {
        return name + " " + age;
    }

    public Member(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

}