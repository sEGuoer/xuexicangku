package D20230703;

public class Cylinder extends Circle {
    private double length;

    public Cylinder() {
        this.length = 1;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return this.length;
    }

    public double findVolume() {
        return findArea() * getLength();
    }
}
