package nsk.academit.feller.vector.nsk.academit.feller.vector.main;

import nsk.academit.feller.vector.Vector;

import static nsk.academit.feller.vector.Vector.getDifference;
import static nsk.academit.feller.vector.Vector.getScalarMultiplication;
import static nsk.academit.feller.vector.Vector.getSum;

public class Main {
    public static void main(String[] args) {
        Vector vector = new Vector(5);
        double[] array = new double[]{1, 2, 3, 4};
        double[] array2 = new double[]{1, 2, 3, 4};
        Vector vector1 = new Vector(array);
        Vector vector2 = new Vector(array2);
        Vector vector3 = new Vector(2, array2);
        Vector vector4 = new Vector(vector1);


        System.out.println(vector1);
        System.out.println(vector1.reverse());
        System.out.println(vector3);
        System.out.println(vector4);
        System.out.println(vector4.getSize());
        System.out.println(vector4.getLength());

        System.out.println(vector1.getDifference(vector2));
        System.out.println(vector2);
        System.out.println(getScalarMultiplication(vector1, vector2));
        System.out.println(vector1.equals(vector2));
        System.out.println(getDifference(vector1, vector2));
        System.out.println(getSum(vector1, vector2));
        System.out.println(vector3);
        vector1.setElement(4, 4);
        System.out.println(vector1);
    }
}
