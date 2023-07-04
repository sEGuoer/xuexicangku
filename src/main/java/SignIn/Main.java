package SignIn;

public class Main {
    public static void main(String[] args) {
        GetInformation getInformation = new GetInformation();
        getInformation.register("sda","asd","asd");
        getInformation.register("123","asd","asd");
        getInformation.register("1234","asd","asd");
        getInformation.register("1234","asd","asd");
        System.out.println(getInformation);
    }
}
