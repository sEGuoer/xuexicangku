package D20230704;

public class Main {
    public static void main (String[] args) {
        Person person1 = Person.getPerson("1",2,"1");
        Person person2 = Person.getPerson("1",2,"1");
        Person person3 = Person.getPerson("1",2,"1");
        System.out.println(person1 == person2);
        System.out.println(person3 == person2);
        System.out.println(person1 == person3);
    }
}
