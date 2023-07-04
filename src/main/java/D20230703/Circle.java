package D20230703;

public class Circle {
    private double radius;

    public Circle() {
        this.radius = 1;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public double findArea() {
        return getRadius() * getRadius() * Math.PI;
    }
}
