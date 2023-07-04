package D20230609;

public class Student {

    String name;
    int age;
    String school;
    String major;

    public void person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void person(String name, int age, String school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }

    public void person(String name, int age, String school, String major) {
        this.name = name;
        this.age = age;
        this.school = school;
        this.major=major;
    }
}

