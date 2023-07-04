package D20230607;

public class Student {
    String name;
    int age;
    String xuehao;
    dog[] count;

    public void show() {
        System.out.println("学生=" + name + " 年龄=" + age + " 学号=" + xuehao);
        System.out.println("该学生有" + count.length + "只狗");
        for (int i = 0; i < count.length; i++) {
            count[i].dogshow();
        }
        System.out.println();
    }
}
