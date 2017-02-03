package nsk.academit.feller.shape;

public class TestShape {
    public static void main(String[] args) {
        Shape shape = new Shape();
        Shape square1 = new Square(7);
        Shape square2 = new Square(4);
        Shape rectangle1 = new Rectangle(7, 3);
        Shape rectangle2 = new Rectangle(3.5, 8);
        Shape circle1 = new Circle(9);
        Shape circle2 = new Circle(5.9);
        Shape triangle1 = new Triangle(-3, -6, 4, -1, 5, -2);
        Shape triangle2 = new Triangle(2, -1, 5, 3, 5, -2);

        System.out.printf("Max area is %f%n", shape.getMaxSquare(square1, square2, rectangle1, rectangle2, circle1, circle2, triangle1, triangle2));
        System.out.printf("Second perimeter is %f%n", shape.getSecondPerimeter(square1, square2, rectangle1, rectangle2, circle1, circle2, triangle1, triangle2));

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
