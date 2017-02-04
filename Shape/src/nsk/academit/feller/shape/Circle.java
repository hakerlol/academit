package nsk.academit.feller.shape;

public class Circle implements Shape {
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
        return "Circle " + "radius = " +
                radius + " Area = " + getArea() + " Perimeter = " + getPerimeter();
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 1;
        result = prime * result + (int) radius;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Circle other = (Circle) obj;

        return !(radius != other.radius);
    }
}
