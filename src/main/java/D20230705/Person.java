package D20230705;

public class Person  {
    private static Person person;
    private String name;
    private int age;
    private String content;

   public static Integer i = 1;

    private Person() {
    }

    public static Person getPerson(String name, int age, String content) throws InterruptedException {
        if (person == null) {
            synchronized (i) {
                Thread.sleep(1);
                if (person == null){
                person = new Person();
                }
            }
        }
        return person;
    }



}
