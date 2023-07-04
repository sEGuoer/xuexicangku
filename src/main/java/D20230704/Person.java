package D20230704;

import lombok.*;

public class Person {
    private static Person person = new Person();
    private String name;
    private int age;
    private String content;

    private Person() {
    }

    public static Person setPerson(String name, int age, String content) {
        person.age = age;
        person.name= name;
        person.content=content;
        return person;
    }
}
