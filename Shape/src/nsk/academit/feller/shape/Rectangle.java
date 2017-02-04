package nsk.academit.feller.shape;

public class Rectangle implements Shape {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getWidth() {

        return width;
    }

    public double getHeight() {

        return height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {

        return (width + height) * 2;
    }

    @Override
    public String toString() {

        return "Rectangle" + "height = " + height + ", width = " +
                width + " Area = " + getArea() + " Perimeter = " + getPerimeter();
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
