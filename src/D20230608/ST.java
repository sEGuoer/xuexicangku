package D20230608;

public class ST {
    public static void main(String[] args) {
        stundet setstudent1 = stundet.setstudent();
        stundet setstudent2 = stundet.setstudent();
        System.out.println(setstudent1);
        System.out.println(setstudent2);
    }
}

class stundet {
    String id;
    String name;
    int age;
    static stundet stundet;

    private stundet() {
    }

    public static stundet setstudent() {
        if (stundet == null) {
            stundet = new stundet();
        } else {
        }
        return stundet;
    }
/*
    @Override
    public String toString() {
        return "stundet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }*/
}