package D20230705;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void test() {
        new Thread(()->{
            Person person1 = null;
            try {
                person1 = Person.getPerson("1", 2, "1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("1"+person1.hashCode());
        }).start();
        new Thread(()->{
            Person person2 = null;
            try {
                person2 = Person.getPerson("1", 2, "1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("2"+person2.hashCode());
        }).start();
        new Thread(()->{
            Person person3 = null;
            try {
                person3 = Person.getPerson("1", 2, "1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("3"+person3.hashCode());

        }).start();
    }
}