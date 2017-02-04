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
        final int prime = 37;
        int result = 1;
        result = prime * result + (int) width;
        result = prime * result + (int) height;
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
        Rectangle other = (Rectangle) obj;

        return !(width != other.width) && !(height != other.height);
    }
}
