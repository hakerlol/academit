package nsk.academit.feller.shape;

public class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getWidth() {
        return side;
    }

    public double getHeight() {

        return side;
    }

    public double getArea() {
        return side * side;
    }

    public double getPerimeter() {
        return side * 4;
    }

    @Override
    public String toString() {
        return "Square " + "side = " + side + "Area = " + getArea() + " Perimeter = " + getPerimeter();
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
