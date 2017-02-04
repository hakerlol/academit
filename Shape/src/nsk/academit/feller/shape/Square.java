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

        final int prime = 37;
        int result = 1;
        result = prime * result + (int) side;
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
        Square other = (Square) obj;
        if (side != other.side) {
            return false;
        }
        return true;
    }
}
