package nsk.academit.feller.shape;

import java.util.Arrays;

public class TestShape {
    public static Shape getMaxSquare(Shape... shapes) {
        double maxArea = 0;
        Shape shape = null;
        for (Shape x : shapes) {
            if (x.getArea() > maxArea) {
                maxArea = x.getArea();
                shape = x;
            }
        }
        return shape;
    }

    public static Shape getSecondPerimeter(Shape... shapes) {
        double[] array = new double[shapes.length];

        for (int i = 0; i < shapes.length; i++) {
            array[i] = shapes[i].getPerimeter();
        }
        Arrays.sort(array);
        Shape shape = null;
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i].getPerimeter() == array[shapes.length - 2]) {
                shape = shapes[i];
            }
        }
        return shape;
    }

    public static void main(String[] args) {
        Shape square1 = new Square(7);
        Shape square2 = new Square(4);
        Shape rectangle1 = new Rectangle(7, 3);
        Shape rectangle2 = new Rectangle(3.5, 8);
        Shape circle1 = new Circle(9);
        Shape circle2 = new Circle(5.9);
        Shape triangle1 = new Triangle(-3, -6, 4, -1, 5, -2);
        Shape triangle2 = new Triangle(2, -1, 5, 3, 5, -2);
        
        System.out.println("Max area  " + getMaxSquare(square1, square2, rectangle1, rectangle2, circle1, circle2, triangle1, triangle2));
        System.out.println("Second perimeter is " + getSecondPerimeter(square1, square2, rectangle1, rectangle2, circle1, circle2, triangle1, triangle2));

        System.out.println(square1.getPerimeter());
        System.out.println(square2.getPerimeter());
        System.out.println(rectangle1.getPerimeter());
        System.out.println(rectangle2.getPerimeter());
        System.out.println(circle1.getPerimeter());
        System.out.println(circle2.getPerimeter());
        System.out.println(triangle1.getPerimeter());
        System.out.println(triangle2.getPerimeter());
    }
}
