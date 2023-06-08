package D20230608;

public class Person {
    public static void main(String[] args) {
        human person1 = new human();
        person1.name="2b";
        person1.setAge(12);
        person1.setPerson();
        System.out.println(person1.getAge());
    }
}
class human {
    private int age;
    String name;
    human person;
    public void setAge(int age) {
        this.age = age;
    }

    public void setPerson() {
        if (age>0){
            System.out.print("姓名"+name);
            System.out.print(age);
            System.out.println();
        }
        else{
            System.out.println("非法参数");
            age=0;
            System.exit(1);
        }
    }

    public int getAge(){
        return age;
    }
}