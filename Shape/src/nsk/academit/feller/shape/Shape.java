package nsk.academit.feller.shape;

import java.util.Arrays;

public class Shape {

    public double getMaxSquare(Shape... shapes) {
        double maxArea = 0;
        for (Shape x : shapes) {
            if (x.getArea() > maxArea) {
                maxArea = x.getArea();
            }
        }
        return maxArea;
    }

    public double getSecondPerimeter(Shape... shapes) {
        double[] array = new double[shapes.length];
        for (int i = 0; i < shapes.length; i++) {
            array[i] = shapes[i].getPerimeter();
        }
        Arrays.sort(array);
        return array[shapes.length - 2];
    }

    public double getWidth() {

        return 0;
    }

    public double getHeight() {

        return 0;
    }

    public double getArea() {
        return 0;
    }

    public double getPerimeter() {
        return 0;
    }
}
