package D20230615;

public class Actor {
    public Object name;
    private int age;

    private String content;

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", content='" + content + '\'' +
                '}';
    }
}
