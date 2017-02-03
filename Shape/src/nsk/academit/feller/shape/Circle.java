package nsk.academit.feller.shape;


public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }


    public double getWidth() {
        return radius * 2;
    }

    public double getHeight() {

        return radius * 2;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {

        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object x) {
        return false;
    }
}
