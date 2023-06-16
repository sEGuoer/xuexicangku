package D20230615;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Person {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("黄药师","冯蘅","黄蓉","郭芙","郭襄","郭靖","郭破虏");
        //List 后的<>里面的表示限制，在没有限制情况下什么都可以，就调用不了对应的工具类
        List name =  list.stream().filter(o -> o.charAt(0) == ('郭') ).collect(Collectors.toList());
        name.stream().forEach( s -> {
            System.out.println(s);
        });
        List<String> person = new ArrayList<>();
        person.add("黄药师");
        person.add("冯蘅");
        person.add("黄蓉");
        person.add("郭aa");
        person.add("郭bb");
        person.add("郭cc");
        person.add("郭dd");
        ArrayList<String> guo = (ArrayList<String>)person.stream()
                .filter(o -> o.charAt(0) == '郭')
                .collect(Collectors.toList());
        guo.forEach(o -> {System.out.println(o);});
        System.out.println("————————————————————————————————————");

        List<String> person1 = new ArrayList<>();
        person1.add("陈玄风");
        person1.add("梅超风");
        person1.add("陆乘风");
        person1.add("曲灵风");
        person1.add("武眠风");
        person1.add("冯默风");
        person1.add("罗玉凤");
        List<String> qianer = (ArrayList<String>)person1.stream().limit(2).collect(Collectors.toList());
        List<String> houwu = (ArrayList<String>)person1.stream().skip(5).collect(Collectors.toList());
        qianer.forEach(s -> {
            System.out.println(s);
        });
        System.out.println("————————————————————————————————————");
        houwu.forEach(s -> {
            System.out.println(s);
        });
        System.out.println("————————————————————————————————————");

        Stream.of(1,-2,-3,4,-5).map(o -> Math.abs(o)).forEach(o -> {
            System.out.println(o);
        });
        System.out.println("————————————————————————————————————");

        Stream.of(1,2,3,4,5).map(o -> o*o).forEach(o -> {
            System.out.println(o);
        });
        System.out.println("————————————————————————————————————");
    }

}
