package D20230704;

import org.junit.jupiter.api.Test;

import java.util.Random;


class PersonTest {
    @Test
    void test1(){
        System.out.println("test");
        Random random = new Random();
        int randomNumber = random.nextInt(90000)+10000;
        String a = Integer.toString(randomNumber);
        System.out.println(randomNumber);
        System.out.println(a);
    }
}