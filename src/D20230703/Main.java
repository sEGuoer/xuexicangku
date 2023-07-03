package D20230703;

public class Main {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        cylinder.setRadius(2);
        cylinder.setLength(2);
        System.out.println(cylinder.findVolume());
    }
}
