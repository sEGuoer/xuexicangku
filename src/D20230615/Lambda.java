package D20230615;

import java.util.Arrays;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {
        Test test = (name,age) -> {
            System.out.println(name+age+"岁了");
            return age+1;
        };
    int age = test.test("小明",18);
        System.out.println(age);

        //List numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);numbers.stream().filter( i -> i == 0).distinct().forEach(System.out::println);
    }
}

interface Test {
    public int test(String name, int age);
}