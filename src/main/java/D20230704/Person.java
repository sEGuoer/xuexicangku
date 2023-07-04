package D20230704;

public class Person {
    private static Person person;
    private String name;
    private int age;
    private String content;

    private Person() {
    }

    public static Person getPerson(String name, int age, String content) {
        if (person == null){
            person = new Person();
        }
        return person;
    }
}
