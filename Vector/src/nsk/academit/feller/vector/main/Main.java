package nsk.academit.feller.vector.main;


import nsk.academit.feller.vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[] array = new double[]{1, 2, 3, 4};
        double[] array2 = new double[]{1, 2, 3};
        Vector vector = new Vector(10, array);
        Vector vector1 = new Vector(array);
        Vector vector2 = new Vector(array2);
        System.out.println(vector);
        System.out.println(vector1.equals(vector2));
    }
}
