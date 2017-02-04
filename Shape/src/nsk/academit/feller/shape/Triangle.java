package nsk.academit.feller.shape;

public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public double getSegment(double coorX1, double coorX2, double coorY1, double coorY2) {

        return Math.sqrt(Math.pow(coorX2 - coorX1, 2) + Math.pow(coorY2 - coorY1, 2));
    }

    public double getWidth() {

        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    public double getArea() {
        return 0.5 * Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1));
    }

    public double getPerimeter() {

        return getSegment(x1, x2, y1, y2) + getSegment(x1, x3, y1, y3) + getSegment(x2, x3, y2, y3);
    }

    @Override
    public String toString() {
        return "Triangle " + "coordinates: x1 = " + x1 + " y1 = " + y1
                + " x2 = " + x2 + " y2 = " + y2 + " x3 = " + x3 +
                " y3 = " + y3 + " Area = " + getArea() + " Perimeter = " + getPerimeter();
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
